package com.tpy.controller;


import com.tpy.entity.DeleteExample;
import com.tpy.entity.DetailsTutorial;
import com.tpy.entity.ExampleTutorial;
import com.tpy.entity.User;
import com.tpy.service.*;
import com.tpy.service.Impl.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class moduleController {

    private ModifyDetailstutorialService modifyDetailstutorialImpl;
    @Autowired
    public void setModifyDetailstutorialImpl(ModifyDetailstutorialServiceImpl impl){
        this.modifyDetailstutorialImpl = impl;
    }

    //删除实例对象
    private UpdateDetailstutorialService dDetailstutorialService;
    @Autowired
    public void setdDetailstutorialService(UpdateDetailstutorialServiceImpl impl){
        this.dDetailstutorialService = impl;
    }

    private QtitleForDetailsByDtNumService qtitleForDetailsByDtNumService;
    @Autowired
    public void setQtitleForDetailsByDtNumService(QtitleForDetailsByDtNumService service){
        this.qtitleForDetailsByDtNumService = service;
    }


    private QueryUserAllExampleService queryUserAllExampleService;
    @Autowired
    public void setQueryUserAllExampleService(QueryUserAllExampleServiceImpl impl){
        this.queryUserAllExampleService = impl;
    }


    private userService userImpl;
    @Autowired
    public void setUserServiceImpl(userServiceImpl impl){
        this.userImpl = impl;
    }


    private AddExampleTutorialServiceImpl addDetailsTutorialService;
    @Autowired
    public void setAddExampleTutorialService(AddExampleTutorialServiceImpl impl){
        this.addDetailsTutorialService = impl;
    }

    private exampleService service;
    @Autowired
    public void setExampleService(exampleServiceImpl impl){
        this.service = impl;
    }

    private AddDetailsTutorialServiceImpl addDetailsTutorialServiceImpl;
    @Autowired
    public void setAddDetailsTutorialServiceImpl(AddDetailsTutorialServiceImpl impl){
        this.addDetailsTutorialServiceImpl = impl;
    }



    @RequestMapping(value = "resourcesModule", method = RequestMethod.GET)
    public String switchingModule(HttpServletRequest request) {

        HttpSession session = request.getSession();

        List<DetailsTutorial> detailsTutorials = service.queryExampleServiceImpl();
        //java基础目录
        List<String> list = new ArrayList<String>();
        for (DetailsTutorial d : detailsTutorials) {
            if ("Java基础".equals(d.getSpecialSubject())) {
                list.add(d.getExampleType());
            }
            System.out.println(d.getExampleType() + "," + d.getSpecialSubject());
        }
        session.setAttribute("Java基础", list);

        list = new ArrayList<String>();
        for (DetailsTutorial d : detailsTutorials) {
            if ("Java面向对象".equals(d.getSpecialSubject())) {
                list.add(d.getExampleType());
            }
        }
        session.setAttribute("Java面向对象", list);

        list = new ArrayList<String>();
        for (DetailsTutorial d : detailsTutorials) {
            if ("Java高级教程".equals(d.getSpecialSubject())) {
                list.add(d.getExampleType());
            }
        }
        session.setAttribute("Java高级教程", list);

        return "exampleModel/instanceModuleHome";
    }


    //显示实例
    @RequestMapping(value = "queryTutorial", method = RequestMethod.GET)
    public String queryTutorial(HttpServletRequest request) {
        String specialSubject = request.getParameter("specialSubject");
        String exampleType = request.getParameter("exampleType");
        request.setAttribute("specialSubject",specialSubject);
        request.setAttribute("exampleType",exampleType);

        DetailsTutorial detailsTutorial = service.queryTutorialServiceImpl(specialSubject, exampleType);
        request.setAttribute("detailsTutorial", detailsTutorial);

        //查询实例
        ExampleTutorial exampleTutorial = service.queryExampleTutorial(detailsTutorial.getDtNum());
        System.out.println(exampleTutorial.getUserId());
        request.setAttribute("exampleTutorial", exampleTutorial);
        System.out.println(detailsTutorial.getFilePath());


        //查询用户
        User user = userImpl.queryUserByUserNum(exampleTutorial.getUserId());
        request.setAttribute("user", user);
        return "exampleModel/instanceModule";
    }


    /**
     * 实例
     * @return
     */
    @RequestMapping(value = "addExample", method = RequestMethod.GET)
    public String addExample() {

        return "exampleModel/addExamples";
    }


    //增加实例
    @RequestMapping(value = "addExamples", method = RequestMethod.POST)
    public void addExample(@RequestParam("file") MultipartFile file,
                             HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");


        String title = request.getParameter("title");
        String code = request.getParameter("code");
        String explainContext = request.getParameter("explain");
        String runnResult = request.getParameter("runResult");
        String specialSubject = request.getParameter("selectValue");
        String exampleType = request.getParameter("textType");
        String dtNum = request.getParameter("dtNum");
        request.setAttribute("dtNum",dtNum);
        //存储路径
        String originalFilename = file.getOriginalFilename();
//        String path = "D:\\apache-tomcat-8.5.47\\Upload\\" + originalFilename;
        String path = request.getSession().getServletContext().getRealPath("upload") + "\\" + originalFilename;
        File isfile = new File(request.getSession().getServletContext().getRealPath("upload"));
        if(!isfile.exists()){
            isfile.mkdir();
        }

        User user = (User) request.getSession().getAttribute("user");

        DetailsTutorial detailsTutorial = new DetailsTutorial();
        detailsTutorial.setSpecialSubject(specialSubject);
        detailsTutorial.setExampleType(exampleType);
        detailsTutorial.setTitle(title);
        detailsTutorial.setContext(code);
        detailsTutorial.setExplainContext(explainContext);
        detailsTutorial.setRunResult(runnResult);
        detailsTutorial.setFilePath(originalFilename);
        detailsTutorial.setIsDelete(0);


        int i = addDetailsTutorialServiceImpl.addDetailsTutorialService(detailsTutorial,path,file,user,addDetailsTutorialService);
        if(i == 0){
            System.out.println("插入详情实例失败");
        }else {
            System.out.println("插入成功！");
            response.getWriter().write("上传文件成功！");
        }





//        return "uploadLoadFile";
//        return "instanceModule";
    }



    /**
     * 上传文件
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "uploadFile", method = RequestMethod.POST)
    public String uploadFile(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");


        //判断是普通表单还是文件表单
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {// 判断前台是否有Multipart属性

            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload load = new ServletFileUpload(factory);

            //设置缓冲区文件大小为10KB
            factory.setSizeThreshold(1024 * 10);
            //设置缓冲区文件路径
            factory.setRepository(new File("D:\\apache-tomcat-8.5.47\\Updload缓冲区"));
            //限制上传单个文件大小1000KB
            load.setSizeMax(1024 * 1000);


            try {
                // 通过parseRequest解析form表单中的所有字段，并保存到items集合中，（前端传递的参数）
                List<FileItem> items = load.parseRequest(request);
                Iterator<FileItem> iterator = items.iterator();


                int sno = -1;
                String sName = null;
                while (iterator.hasNext()) {
                    FileItem item = iterator.next();
                    //判断item获取的是普通字段还是文件字段
                    if (item.isFormField()) {
                        System.out.println("===============");
                    } else {
                        //文件上传
                        String fileName = item.getName();//获取文件名


                        String ext = fileName.substring(fileName.indexOf(".") + 1);

                        //动态获取Tomcat文件路径、
                        String realPath = request.getSession().getServletContext().getRealPath("upload");
                        System.out.println(realPath);
                        String path = "D:\\apache-tomcat-8.5.47\\Upload";
                        //定义文件路径
                        File file = new File(path, fileName);
                        item.write(file);
                        System.out.println("D:\\apache-tomcat-8.5.47\\Upload" + "\\" + fileName);
                        System.out.println("上传成功!");

                        String filePath = "D:\\apache-tomcat-8.5.47\\Upload" + "\\" + fileName;

                        response.getWriter().write(filePath);
                    }
                }

            } catch (FileUploadBase.SizeLimitExceededException e) {
                System.out.println("上传文件超过30KB");
            } catch (FileUploadException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        } else {
            System.out.println("isMultipart is null");
        }


        return "";
    }


    /**
     * 删除实例
     *
     * @return
     */
    @RequestMapping(value = "deleteExample", method = RequestMethod.GET)
    public String deleteExample(HttpServletRequest request,HttpServletResponse response) {

        User user =(User) request.getSession().getAttribute("user");
        int userId = user.getUserId();
        List<ExampleTutorial> exampleTutorials = queryUserAllExampleService.queryUserAllExample(userId);

        List<DeleteExample> deleteExamples = new ArrayList<>();

        for(ExampleTutorial exampleTutorial : exampleTutorials){
            DeleteExample deleteExample = new DeleteExample();
            deleteExample.setUploadTime(exampleTutorial.getUploadTime());
            deleteExample.setTutorialNum(exampleTutorial.getTutorialNum());
            deleteExample.setDtNum(exampleTutorial.getDtNum());

            String title = qtitleForDetailsByDtNumService.queryTitleForDetailsByDtNumService(exampleTutorial.getDtNum());
            System.out.println(title);
            deleteExample.setTitle(title);

            String userName = userImpl.queryUserByUserNum(exampleTutorial.getUserId()).getUserName();
            deleteExample.setUserName(userName);

            deleteExamples.add(deleteExample);
        }

        request.getSession().setAttribute("deleteExamples",deleteExamples);

        return "exampleModel/deleteExample";
    }



    @RequestMapping(value = "deleteOneExample",method = RequestMethod.GET)
    public String deleteOneExample(HttpServletRequest request,HttpServletResponse response) throws IOException {

        String dtNum1 = request.getParameter("dtNum");
        int dtNum = Integer.parseInt(dtNum1);
        String tutorialNum1 = request.getParameter("tutorialNum");
        int tutorialNum = Integer.parseInt(tutorialNum1);
        System.out.println(dtNum);
        System.out.println(tutorialNum);
        boolean isDelete = dDetailstutorialService.deleteExampleTutorialService(dtNum, tutorialNum);
        if(isDelete == false){
            response.getWriter().write("删除失败");
            return "redirect:/deleteExample";
        }

        response.getWriter().write("删除成功");

        return "redirect:/deleteExample";
    }

    /**
     * 修改实例
     *
     * @return
     */
    @RequestMapping(value = "modifyExample", method = RequestMethod.GET)
    public String modifyExample(HttpServletRequest request) {

        String specialSubject = request.getParameter("specialSubject");
        String exampleType = request.getParameter("exampleType");
        String dtNum = request.getParameter("dtNum");
        request.setAttribute("dtNum",dtNum);

        DetailsTutorial detailsTutorial = service.queryTutorialServiceImpl(specialSubject, exampleType);
        request.setAttribute("detailsTutorial", detailsTutorial);

        //查询实例
        ExampleTutorial exampleTutorial = service.queryExampleTutorial(detailsTutorial.getDtNum());
        request.setAttribute("exampleTutorial", exampleTutorial);

        //查询用户
        User user = userImpl.queryUserByUserNum(exampleTutorial.getUserId());
        request.setAttribute("user", user);

        return "exampleModel/modifyExample";
    }



    @RequestMapping(value = "submitModifyExample",method = RequestMethod.POST)
    public String SubmitModifyExample(@RequestParam("file") MultipartFile file,
                                      HttpServletRequest request,HttpServletResponse response) throws IOException {


        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");


        String title = request.getParameter("title");
        String dtNum1 = request.getParameter("dtNum");
        int dtNum = Integer.parseInt(dtNum1);
        String code = request.getParameter("code");
        String explainContext = request.getParameter("explain");
        String runnResult = request.getParameter("runResult");
        //存储路径
        String originalFilename = file.getOriginalFilename();
//        String path = "D:\\apache-tomcat-8.5.47\\Upload\\" + originalFilename;
        String path = request.getSession().getServletContext().getRealPath("upload") + "\\" + originalFilename;
        File isfile = new File(request.getSession().getServletContext().getRealPath("upload"));
        if(!isfile.exists()){
            isfile.mkdir();
        }

        DetailsTutorial detailsTutorial = new DetailsTutorial();
        detailsTutorial.setTitle(title);
        detailsTutorial.setContext(code);
        detailsTutorial.setExplainContext(explainContext);
        detailsTutorial.setRunResult(runnResult);
        if(originalFilename != null){
            detailsTutorial.setFilePath(originalFilename);
        }
        detailsTutorial.setIsDelete(0);
        detailsTutorial.setDtNum(dtNum);
        int count = modifyDetailstutorialImpl.modifyDetailstutorial(detailsTutorial);

        if(count == 0){
            System.out.println("修改失败");
            response.getWriter().write("修改失败！");
        }else {
            System.out.println("插入成功！");
            response.getWriter().write("修改成功！");
        }

        return "exampleModel/instanceModule";
    }
}



