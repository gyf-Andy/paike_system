package com.gyf.controller;

import com.gyf.result.ResultObject;
import com.gyf.service.AdminService;
import com.gyf.service.StudentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author 郭云飞
 * @date 2021/5/7-15:18
 * @Description TODO
 */
@RequestMapping("student")
@Controller
public class StudentController {

    @Resource
    private AdminService adminService;

    @Resource
    private StudentService studentService;

    @RequestMapping("toStudentHomePage.action")
    public String toStudentHomePage(){
        return "student/home";
    }

    @RequestMapping("getCourseTable.action")
    @ResponseBody
    public ResultObject getCourseTable(){
        //获取用户的账号
        Subject subject= SecurityUtils.getSubject();
        String account= (String) subject.getPrincipal();
        System.out.println(account);
        //获取用户信息
        Map<String,Object> studentMap=adminService.Login(account);
        ResultObject resultObject=studentService.getCourseTable((String) studentMap.get("department"));
        return resultObject;
    }
}
