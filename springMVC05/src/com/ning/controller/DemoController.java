package com.ning.controller;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/*
*   在web.xml中配置前端控制器DispatcherServlet
* */
@Controller
public class DemoController {
 /*
 *  文件上传 基于apache的commons-fileupload.jar完成文件上传
 *  MultipartResovler作用：把客户端上传的文件转换成MultipartFile封装类
 *  通过MultipartFile封装类获取到文件流
 *  表单数据类型封装 在<from>的enctype属性控制表单类型
 *  默认值application/x-www-form-urlencoded,普通表单数据(少量文字信息)
 *  text/plain 大量文字时使用的类型，邮件，论文
 *  multipart/form-data表单中包含二进制文件内容
 *
 *  入口：dispatcherServlet
 *  解析请求：HandlerMapping
 *  调用 HandlerAdapter
 *  视图解析器：viewResolver
 *  文件上传解析器：MultipartResolver
 *  异常解析器：ExceptionResolver
 * */
 @RequestMapping("upload")
    public String upload(MultipartFile file,String name) throws IOException {
     System.out.println("name:"+name);
     String filename = file.getOriginalFilename();
     String suffix = filename.substring(filename.lastIndexOf("."));
     if (suffix.equalsIgnoreCase(".png")) {
         String uuid = UUID.randomUUID().toString();
         FileUtils.copyInputStreamToFile(file.getInputStream(),new File("F:/"+uuid+suffix));
         return "forward:/index.jsp";
     }else {
         return "forward:/error.jsp";
     }
    }
}
