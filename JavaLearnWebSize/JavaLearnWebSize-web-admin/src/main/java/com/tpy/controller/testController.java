package com.tpy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

import static org.apache.logging.log4j.message.MapMessage.MapFormat.JSON;

@Controller
public class testController {




    @RequestMapping(value = "downloadFile",method = RequestMethod.GET)
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        String fileName =(String) request.getParameter("id");
        System.out.println(request.getAttribute("id"));
        response.setHeader("content-Type", "application/octet-stream");
        response.setHeader("content-Disposition", "attachment; filename="+fileName);

        //第一个/表示根目录
        InputStream in = request.getServletContext().getResourceAsStream("/upload/"+fileName) ;

        ServletOutputStream out = response.getOutputStream() ;


        byte[] ch = new byte[1024];
        int len = -1;
        while((len = in.read(ch)) != -1 ) {
            out.write(ch, 0, len);
        }

        out.close();
        in.close();
    }



    @RequestMapping(value = "test", method = RequestMethod.POST)
    public String test(HttpServletRequest request) {

        String editor1 = request.getParameter("editor1");
        String context = request.getParameter("context");

        System.out.println("代码" + ":" + editor1);
        System.out.println("讲解" + ":" + context);

        return "uploadLoadFile";
    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test() {

        return "test";
    }



    @RequestMapping(value = "uploadLoadFile", method = RequestMethod.GET)
    public String uploadLoadFile() {

        return "uploadLoadFile";
    }


    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String upLoadFile(@RequestParam("file") MultipartFile file,
                             HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");


        String area = request.getParameter("area");
        System.out.println(area);
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);

//        String path = "D:\\apache-tomcat-8.5.47\\Upload\\" + originalFilename;

        //动态获取Tomcat文件路径、
        String path = request.getSession().getServletContext().getRealPath("upload") + "\\" + originalFilename ;
        System.out.println(path);
        File isfile = new File(request.getSession().getServletContext().getRealPath("upload"));
        if(!isfile.exists()){
            isfile.mkdir();
        }

        file.transferTo(new File(path));
        System.out.println("成功");
        return "test";
    }


//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    @ResponseBody
//    public String upload(@RequestParam("file") MultipartFile file,
//                         HttpServletRequest request) {
//        Map<String, String> modelMap = new HashMap<>();
//        if (!file.isEmpty()) {
//            String storePath = "E://images";
//            Random r = new Random();
//            String fileName = file.getOriginalFilename();
//
//            System.out.println(fileName);
//
//            String[] split = fileName.split(".jpg");
//            fileName = split[0] + r.nextInt(1000);
//            fileName = fileName + ".jpg";
//            File filePath = new File(storePath, fileName);
//            if (!filePath.getParentFile().exists()) {
//                filePath.getParentFile().mkdirs();// 如果目录不存在，则创建目录
//            }
//            try {
//                file.transferTo(new File(storePath + File.separator + fileName));// 把文件写入目标文件地址
//            } catch (Exception e) {
//                e.printStackTrace();
//                modelMap.put("back", "error");
//                String json = JSON.toString();
//                return json;
//            }
//            modelMap.put("back", "success");
//
//        } else {
//            modelMap.put("back", "error");
//        }
////        String json = JSON.toJSONString(modelMap);
//        return "json";
//
//    }


    @RequestMapping(value = "uploadAjax", method = RequestMethod.POST)
    public String upLoadAjax(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws
            IOException {


        return "test";
    }
}
