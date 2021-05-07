package com.gyf.service;

import com.gyf.pojo.*;
import com.gyf.result.ResultObject;

import java.util.List;
import java.util.Map;

public interface AdminService {

    //管理用户相关的代码
    ResultObject toLogin(String account, String password);

    Map<String,Object> Login(String account);
    Teacher teacherLogin(String account);
    Student studentLogin(String account);

    List<Admin> allAdmin();

    ResultObject addAdmin(Admin admin);

    String isHad(String account);

    int updateByAccount(Admin admin);

    ResultObject deleteAdmin(int id);

    int count();

    ResultObject selectOneAdmin(int id);

    //学生管理相关的代码
    List<Student> getStudent();

    ResultObject addStudent(Student student);

    int studentCount();

    ResultObject deleteStudent(int id);

    //教师管理相关的代码
    List<Teacher> getTeacherInfo();

    ResultObject addTeacher(Teacher teacher);

    ResultObject deleteTeacher(int id);

    //教室管理相关的代码
    List<Classroom> getClassroomInfo();

    ResultObject addClassroom(Classroom classroom);

    ResultObject deleteClassroom(int id);

    //课程管理相关的代码
    List<Course> getCourseInfo();

    ResultObject addCourse(Course course);

    ResultObject deleteCourse(int id);

    //课程表管理
    List<Profession> getProfession(String keyWord);

    List<CourseTable> toTable(String faculty);

    List<String> getCourseNameList();
    List<String> getClassroomNameList();
    List<String> getTeacherNameList();

    ResultObject addCourseToTable(CourseTable courseTable);

    //获取所有的系别
    List<String> getProfessionName();

}
