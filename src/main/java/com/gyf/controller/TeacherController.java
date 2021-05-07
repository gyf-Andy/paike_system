package com.gyf.controller;

import com.gyf.result.ResultObject;
import com.gyf.service.AdminService;
import com.gyf.service.TeacherService;
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
@RequestMapping("teacher")
@Controller
public class TeacherController {

    @Resource
    private AdminService adminService;

    @Resource
    private TeacherService teacherService;

    @RequestMapping("toTeacherHomePage.action")
    public String toTeacherHomePage(){
        return "teacher/home";
    }

    @RequestMapping("getCourseTable.action")
    @ResponseBody
    public ResultObject getCourseTable(){
        //获取用户的账号
        Subject subject= SecurityUtils.getSubject();
        String account= (String) subject.getPrincipal();
        System.out.println(account);
        //获取用户信息
        Map<String,Object> teacherMap=adminService.Login(account);
        ResultObject resultObject=teacherService.getCourseTable((String) teacherMap.get("teacherName"));
        return resultObject;
    }
}
