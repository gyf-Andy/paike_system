package com.gyf.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gyf.pojo.*;
import com.gyf.result.ResultObject;
import com.gyf.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Slf4j
@Controller
@RequestMapping("test")
public class TestController {

    @Resource
    private AdminService adminService;

    @RequestMapping("toLoginPage.action")
    public String toLoginPage(){
        return "login.html";
    }
//    管理用户相关的代码
//    @RequestMapping("getVerificationCode.action")
//    public void getVerificationCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        System.out.println("1");
//        Object[] verifyCode= VerificationCode.createImage();
//        System.out.println("验证码"+verifyCode[0]);
//        request.getSession().setAttribute("verifyCode",verifyCode[0]);
//        ImageIO.write((RenderedImage) verifyCode[1], "JPG", response.getOutputStream());
//    }

    @RequestMapping("toLogin.action")
    @ResponseBody
    public ResultObject toLogin(HttpServletRequest request,String account,String password,String identity){
        System.out.println(identity);
        //获取当前用户
        Subject subject= SecurityUtils.getSubject();
        subject.getSession().setAttribute("identity",identity);
        //封装用户的登陆数据
        UsernamePasswordToken token=new UsernamePasswordToken(account,password);

        try{
            subject.login(token);
            return new ResultObject(200,"登陆成功",identity);
        }catch (UnknownAccountException e){
            return new ResultObject(201,"账号错误");
        }catch (IncorrectCredentialsException e){
            return new ResultObject(202,"密码错误");
        }catch (AuthenticationException e){
            return new ResultObject(203,"用户不存在");
        }
    }

    @RequestMapping("toHomePage.action")
    public String toHomePage(){
        return "home.html";
    }

    @RequestMapping("getAdminInfo.action")
    public String getAdminInfo(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNumber){
        PageHelper.startPage(pageNumber,6);
        List<Admin> adminList=adminService.allAdmin();
        System.out.println(adminList.toString());
        PageInfo<Admin> pageInfo=new PageInfo<Admin>(adminList);
        model.addAttribute("pageInfo",pageInfo);
        return "subpage/user.html";
    }

    @RequestMapping("addAdmin.action")
    @ResponseBody
    public ResultObject addAdmin(Admin admin){
         String isHad=adminService.isHad(admin.getAccount());
         System.out.println(isHad);
        if (isHad!=null){
            return new ResultObject(300,"添加失败，用户已存在！");
        }else{
            admin.setIdentity("normal");
            ResultObject resultObject=adminService.addAdmin(admin);
            return resultObject;
        }
    }

    @RequestMapping("deleteAdmin.action")
    @ResponseBody
    public ResultObject deleteAdmin(int id){
        ResultObject resultObject=adminService.deleteAdmin(id);
        return resultObject;
    }

    @RequestMapping("selectOneAdmin.action")
    @ResponseBody
    public ResultObject selectOneAdmin(int id){
        ResultObject resultObject=adminService.selectOneAdmin(id);
        return resultObject;
    }

//    学生管理相关的代码
    @RequestMapping("getStudent.action")
    public String getStudent(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNumber){
        PageHelper.startPage(pageNumber,6);
        List<Student> studentList=adminService.getStudent();
        PageInfo<Student> pageInfo=new PageInfo<Student>(studentList);
        System.out.println(pageInfo.toString());
        model.addAttribute("pageInfo",pageInfo);
        List<String> professionNameList=adminService.getProfessionName();
        model.addAttribute("professionNameList",professionNameList);
        return "subpage/student.html";
    }

    @PostMapping("addStudent.action")
    @ResponseBody
    public ResultObject addStudent(Student student){
        System.out.println(123);
        ResultObject resultObject=adminService.addStudent(student);
        return resultObject;
    }

    @PostMapping("delectStudent.action")
    @ResponseBody
    public ResultObject delectStudent(int id){
        ResultObject resultObject=adminService.deleteStudent(id);
        return resultObject;
    }

    //教师管理相关代码
    @RequestMapping("getTeacherInfo.action")
    public String getTeacherInfo(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNumber){
        PageHelper.startPage(pageNumber,6);
        List<Teacher> teacherList=adminService.getTeacherInfo();
        PageInfo<Teacher> pageInfo=new PageInfo<Teacher>(teacherList);
        System.out.println(pageInfo.toString());
        model.addAttribute("pageInfo",pageInfo);
        return "subpage/teacher.html";
    }

    @PostMapping("addTeacher.action")
    @ResponseBody
    public ResultObject addTeacher(Teacher teacher){
        ResultObject resultObject=adminService.addTeacher(teacher);
        return resultObject;
    }

    @RequestMapping("deleteTeacher.action")
    @ResponseBody
    public ResultObject deleteTeacher(int id){
        ResultObject resultObject=adminService.deleteTeacher(id);
        return resultObject;
    }

    //教室管理
    @RequestMapping("getClassroomInfo.action")
    public String getClassroomInfo(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNumber){
        PageHelper.startPage(pageNumber,6);
        List<Classroom> classroomList=adminService.getClassroomInfo();
        PageInfo<Classroom> pageInfo=new PageInfo<Classroom>(classroomList);
        System.out.println(pageInfo.toString());
        model.addAttribute("pageInfo",pageInfo);
        return "subpage/classroom.html";
    }

    @RequestMapping("addClassroom.action")
    @ResponseBody
    public ResultObject addClassroom(Classroom classroom){
        ResultObject resultObject=adminService.addClassroom(classroom);
        return resultObject;
    }

    @RequestMapping("deleteClassroom.action")
    @ResponseBody
    public ResultObject deleteClassroom(int id){
        ResultObject resultObject=adminService.deleteClassroom(id);
        return resultObject;
    }

    //课程管理相关的代码
    @RequestMapping("getCourseInfo.action")
    public String getCourseInfo(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNumber){
        PageHelper.startPage(pageNumber,6);
        List<Course> courseList=adminService.getCourseInfo();
        PageInfo<Course> pageInfo=new PageInfo<Course>(courseList);
        System.out.println(pageInfo.toString());
        model.addAttribute("pageInfo",pageInfo);
        return "subpage/course.html";
    }

    @PostMapping("addCourse.action")
    @ResponseBody
    public ResultObject addCourse(Course course){
        ResultObject resultObject=adminService.addCourse(course);
        return resultObject;
    }

    @PostMapping("deleteCourse.action")
    @ResponseBody
    public ResultObject deleteCourse(int id){
        ResultObject resultObject=adminService.deleteCourse(id);
        return resultObject;
    }

    //课表管理
    @RequestMapping("searchProfession.action")
    public String toSearchProfession(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNumber,
                                     @RequestParam(defaultValue = "",value = "keyWord") String keyWord){
        PageHelper.startPage(pageNumber,20);
        List<Profession> professionList=adminService.getProfession(keyWord);
        PageInfo<Profession> pageInfo=new PageInfo<Profession>(professionList);
        System.out.println(pageInfo.toString());
        model.addAttribute("pageInfo",pageInfo);
        return "subpage/searchProfession.html";
    }

    @RequestMapping("toTable.action")
    public String toTable(HttpSession session, String faculty, Model model){
        System.out.println(faculty);
        session.setAttribute("faculty",faculty);

        List<String> courseNameList=adminService.getCourseNameList();
        List<String> classroomNameList=adminService.getClassroomNameList();
        List<String> teacherNameList=adminService.getTeacherNameList();

        model.addAttribute("courseNameList",courseNameList);
        model.addAttribute("classroomNameList",classroomNameList);
        model.addAttribute("teacherNameList",teacherNameList);
        return "subpage/courseTable.html";
    }

    @RequestMapping("getCourseTable.action")
    @ResponseBody
    public ResultObject getCourseTable(Model model,HttpSession session){
        String faculty= (String) session.getAttribute("faculty");
        List<CourseTable> courseTableList=adminService.toTable(faculty);
        return new ResultObject(200,"查询成功！",courseTableList);
    }

    @RequestMapping("addCourseToTable.action")
    @ResponseBody
    public ResultObject addCourseToTable(CourseTable courseTable){
        System.out.println(courseTable.toString());
        ResultObject resultObject=adminService.addCourseToTable(courseTable);
        return resultObject;
    }
}
