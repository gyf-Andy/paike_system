package com.gyf.service.Impl;

import com.gyf.mapper.AdminMapper;
import com.gyf.pojo.*;
import com.gyf.result.ResultObject;
import com.gyf.service.AdminService;
import com.gyf.tools.MD5Encrypt;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AdminServcieImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

//    管理用户相关的代码
    @Override
    public ResultObject toLogin(String account, String password) {

        System.out.println("郭云飞");
        String name=adminMapper.toLogin(account,password);
        System.out.println(name);
        if (name==null){
            return new ResultObject(404,"账号或密码错误！",null);
        }else{
            return new ResultObject(200,"登陆成功！",name);
        }
    }

    @Override
    public Map<String,Object> Login(String account) {
        Subject subject= SecurityUtils.getSubject();
        String identity = (String) subject.getSession().getAttribute("identity");
        Map<String,Object> admin=adminMapper.Login(account,identity);
        return admin;
    }

    @Override
    public Teacher teacherLogin(String account) {
        return null;
    }

    @Override
    public Student studentLogin(String account) {
        return null;
    }

    @Override
    public List<Admin> allAdmin() {

        List<Admin> adminList=adminMapper.allAdmin();

        return adminList;
    }

    @Override
    public ResultObject addAdmin(Admin admin) {

        String encrypt= MD5Encrypt.encryptedPassword(admin.getPassword(),admin.getAccount());
        admin.setPassword(encrypt);
        int a=adminMapper.addAdmin(admin);

        if (a==1){
            return new ResultObject(200,"添加成功",null);
        }else{
            return new ResultObject(300,"添加失败", null);
        }
    }

    @Override
    public String isHad(String account) {
        String isHad=adminMapper.isHad(account);
        return isHad;
    }

    @Override
    public int updateByAccount(Admin admin) {
        int updateSuccess=adminMapper.updateByAccount(admin);
        return updateSuccess;
    }

    @Override
    public ResultObject deleteAdmin(int id) {

        int number=adminMapper.deleteAdmin(id);
        if (number>0){
            return new ResultObject(200,"删除成功！",null);
        }else{
            return new ResultObject(300,"删除失败",null);
        }
    }

    @Override
    public int count() {
        int count=adminMapper.count();
        return count;
    }

    @Override
    public ResultObject selectOneAdmin(int id) {
        Admin oneAdmin=adminMapper.selectOneAdmin(id);
        return new ResultObject(200,"getedData",oneAdmin);
    }

    //    学生管理相关的代码
    @Override
    public List<Student> getStudent() {
        List<Student> studentList=adminMapper.getStudent();
        return studentList;
    }

    @Override
    public ResultObject addStudent(Student student) {
        //密码加密
        String passwordMD5=MD5Encrypt.encryptedPassword(student.getPassword(),student.getAccount());
        student.setPassword(passwordMD5);
        int isSuccess=adminMapper.addStudent(student);
        if (isSuccess==1){
            return new ResultObject(200,"插入成功！",null);
        }else{
            return new ResultObject(300,"插入失败！",null);
        }
    }

    @Override
    public int studentCount() {
        int studentCount=adminMapper.studentCount();
        return studentCount;
    }

    @Override
    public ResultObject deleteStudent(int id) {
        int isDelete=adminMapper.deleteStudent(id);
        if (isDelete==1){
            return new ResultObject(200,"删除成功！");
        }else{
            return new ResultObject(300,"删除失败！");
        }
    }

    @Override
    public List<Teacher> getTeacherInfo() {
        List<Teacher> teacherList=adminMapper.getTeacherInfo();
        return teacherList;
    }

    @Override
    public ResultObject addTeacher(Teacher teacher) {
        Teacher isHadTeacher=adminMapper.selectOneTeacher(teacher.getAccount());
        String encrypt= MD5Encrypt.encryptedPassword(teacher.getPassword(),teacher.getAccount());
        teacher.setPassword(encrypt);
        if (isHadTeacher==null){
            int isAdd=adminMapper.addTeacher(teacher);
            if (isAdd==1){
                return new ResultObject(200,"添加成功！");
            }else{
                return new ResultObject(300,"添加失败！");
            }
        }else{
            return new ResultObject(400,"用户已存在！");
        }
    }

    @Override
    public ResultObject deleteTeacher(int id) {
        int isDelete=adminMapper.deleteTeacher(id);
        if (isDelete==1){
            return new ResultObject(200,"删除成功！");
        }else{
            return new ResultObject(300,"删除失败！");
        }
    }

    @Override
    public List<Classroom> getClassroomInfo() {
        List<Classroom> classroomList=adminMapper.getClassroomInfo();
        return classroomList;
    }

    @Override
    public ResultObject addClassroom(Classroom classroom) {
        Classroom isHadClassroom=adminMapper.selectOneClassroom(classroom.getClassroomName());
        if (isHadClassroom!=null){
            return new ResultObject(201,"添加失败，教室已存在！");
        }else{
            int isAdd=adminMapper.addClassroom(classroom);
            if (isAdd==1){
                return new ResultObject(200,"添加成功！");
            }else{
                return new ResultObject(300,"添加失败!");
            }
        }
    }

    @Override
    public ResultObject deleteClassroom(int id) {
        int isDelete=adminMapper.deleteClassroom(id);
        if (isDelete==1){
            return new ResultObject(200,"删除成功！");
        }else{
            return new ResultObject(300,"删除失败！");
        }
    }

    @Override
    public List<Course> getCourseInfo() {
        List<Course> courseList=adminMapper.getCourseInfo();
        return courseList;
    }

    @Override
    public ResultObject addCourse(Course course) {
        Course isHadCourse=adminMapper.selectOneCourse(course.getCourseCode());
        if (isHadCourse!=null){
            return new ResultObject(201,"添加失败,课程已存在!");
        }else {
            int isAdd=adminMapper.addCourse(course);
            if (isAdd==1){
                return new ResultObject(200,"添加成功!");
            }else {
                return new ResultObject(300,"添加失败!");
            }
        }
    }

    @Override
    public ResultObject deleteCourse(int id) {
        int isDelete=adminMapper.deleteCourse(id);
        if (isDelete==1){
            return new ResultObject(200,"删除成功!");
        }else {
            return new ResultObject(300, "删除失败!");
        }
    }

    @Override
    public List<Profession> getProfession(String keyWord) {
        List<Profession> professionList=adminMapper.getProfession(keyWord);
        return professionList;
    }

    @Override
    public List<CourseTable> toTable(String faculty) {
        List<CourseTable> courseTableList=adminMapper.toTable(faculty);
        return courseTableList;
    }

    @Override
    public List<String> getCourseNameList() {
        List<String> courseNameList=adminMapper.getCourseNameList();
        return courseNameList;
    }

    @Override
    public List<String> getClassroomNameList() {
        List<String> classroomNameList=adminMapper.getClassroomNameList();
        return classroomNameList;
    }

    @Override
    public List<String> getTeacherNameList() {
        List<String> teacherNameList=adminMapper.getTeacherNameList();
        return teacherNameList;
    }

    @Override
    public ResultObject addCourseToTable(CourseTable courseTable) {
        int isAdd=adminMapper.addCourseToTable(courseTable);
        if (isAdd==1){
            return new ResultObject(200,"添加课程成功！");
        }else{
            return new ResultObject(300,"插入失败！");
        }
    }

    @Override
    public List<String> getProfessionName() {
        List<String> professionNameList=adminMapper.getProfessionName();
        return professionNameList;
    }
}
