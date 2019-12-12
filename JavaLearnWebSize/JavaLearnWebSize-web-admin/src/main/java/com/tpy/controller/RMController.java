package com.tpy.controller;

import com.tpy.entity.ResourceModel;
import com.tpy.service.Impl.ResourceModelServiceImpl;
import com.tpy.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class RMController {

    private ResourceService resourceServiceImpl;
    @Autowired
    public void setResourceServiceImpl(ResourceModelServiceImpl impl){
        this.resourceServiceImpl = impl;
    }

    @RequestMapping(value = "resourceIndex",method = RequestMethod.GET)
    public String indexPage(HttpServletRequest request){
        request.setAttribute("filetype","软件");
        return "resourceModel/rmIndex";
    }


    @RequestMapping(value = "mainResource",method = RequestMethod.GET)
    public String mainResource(){
        return "resourceModel/mainResource";
    }


    @RequestMapping(value = "rmIndex",method = RequestMethod.GET)
    public String index(HttpServletRequest request){

        List<ResourceModel> resourceModels = resourceServiceImpl.indexQueryResourceService("软件");

        request.getSession().setAttribute("resourceModels",resourceModels);
        request.setAttribute("filetype","软件");
        return "resourceModel/rmIndex";
    }

    @RequestMapping(value = "jarResource",method = RequestMethod.GET)
    public String jarResource(HttpServletRequest request){

        List<ResourceModel> resourceModels = resourceServiceImpl.indexQueryResourceService("jar");

        request.getSession().setAttribute("resourceModels",resourceModels);
        request.setAttribute("filetype","jar");
        return "resourceModel/jarResource";
    }


    @RequestMapping(value = "addResourcePage",method = RequestMethod.GET)
    public String addResoucePage(HttpServletRequest request){
        String filetype = request.getParameter("filetype");
        request.setAttribute("filetype",filetype);
        return "resourceModel/addResource";
    }

    @RequestMapping(value = "deleteResourcePage",method = RequestMethod.GET)
    public String deleteResoucePage(HttpServletRequest request){

        String filetype = request.getParameter("filetype");
        List<ResourceModel> resourceModels = resourceServiceImpl.indexQueryResourceService(filetype);
        request.setAttribute("filetype",filetype);
        request.setAttribute("resourceModels",resourceModels);

        return "resourceModel/deleteResource";
    }


    //添加资源
    @RequestMapping(value = "addResource",method = RequestMethod.POST)
    public void addResource(@RequestParam("file") MultipartFile file,
                            HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        String originalFilename = file.getOriginalFilename();
        String resourceName = request.getParameter("resourceName");

        ResourceModel resourceModel = new ResourceModel();
        resourceModel.setPath(originalFilename);
        resourceModel.setResourceName(resourceName);
        resourceModel.setFiletype(request.getParameter("filetype"));
        resourceModel.setFilesize((double) file.getSize()/1024);
        resourceModel.setUploadcount(0);
        boolean b = resourceServiceImpl.addResourceModel(resourceModel);


        //动态获取Tomcat文件路径、
        String path = request.getSession().getServletContext().getRealPath("upload") + "\\" + originalFilename ;
        System.out.println(path);
        File isfile = new File(request.getSession().getServletContext().getRealPath("upload"));
        if(!isfile.exists()){
            isfile.mkdir();
        }

        file.transferTo(new File(path));


        if(b == false){
            response.getWriter().write("新增资源失败");
        }
        response.getWriter().write("新增成功");

    }


    @RequestMapping(value = "searchResource",method = RequestMethod.GET)
    public String searchResource(HttpServletRequest request,HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        String searchContext = request.getParameter("searchContext");

        List<ResourceModel> resourceModels = resourceServiceImpl.queryResourceByName(searchContext);
        session.setAttribute("resourceModels",resourceModels);

        request.setAttribute("filetype","软件");
        return "resourceModel/rmIndex";
    }


    @RequestMapping(value = "uploadResourceFile",method = RequestMethod.GET)
    public void uploadResourceFile(HttpServletResponse response,HttpServletRequest request) throws IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        String pathName =(String) request.getParameter("pathName");
        Integer num =Integer.parseInt(request.getParameter("num"));
        response.setHeader("content-Type", "application/octet-stream");
        response.setHeader("content-Disposition", "attachment; filename="+pathName);

        //修改下载次数
        boolean b = resourceServiceImpl.modifyByFileLoadCount(num);

        //第一个/表示根目录
        InputStream in = request.getServletContext().getResourceAsStream("/upload/"+pathName) ;

        ServletOutputStream out = response.getOutputStream() ;


        byte[] ch = new byte[1024];
        int len = -1;
        while((len = in.read(ch)) != -1 ) {
            out.write(ch, 0, len);
        }

        out.close();
        in.close();

    }


    @RequestMapping(value = "deleteResource",method = RequestMethod.GET)
    public void deleteResource(HttpServletRequest request,HttpServletResponse response) throws IOException {

        String num = request.getParameter("num");
        boolean b = resourceServiceImpl.deleteResourceByNum(Integer.parseInt(num));
        request.setAttribute("filetype","软件");
        if(b == false){
            response.getWriter().write("删除失败");
        }
        response.getWriter().write("删除成功");

    }


}
