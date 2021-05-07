package com.gyf.mapper;

import com.gyf.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMapper {

    String toLogin(@Param("account") String account, @Param("password") String password);

    Map<String,Object> Login(@Param("account") String account, @Param("identity") String identity);

//    用户管理相关的代码
    List<Admin> allAdmin();

    int addAdmin(Admin admin);

    String isHad(String account);

    int updateByAccount(Admin admin);

    int deleteAdmin(int id);

    int count();

    Admin selectOneAdmin(int id);

//    学生管理相关的代码
    List<Student> getStudent();

    int addStudent(Student student);

    int studentCount();

    int deleteStudent(int id);

    //教师管理相关的代码
    List<Teacher> getTeacherInfo();

    int addTeacher(Teacher teacher);

    Teacher selectOneTeacher(String account);

    int deleteTeacher(int id);

    //教室管理相关模块
    List<Classroom> getClassroomInfo();

    int addClassroom(Classroom classroom);

    Classroom selectOneClassroom(String classroomName);

    int deleteClassroom(int id);

    //课程管理相关模块
    List<Course> getCourseInfo();

    int addCourse(Course course);

    Course selectOneCourse(String courseCode);

    int deleteCourse(int id);

    //课表管理
    List<Profession> getProfession(String keyWord);

    List<CourseTable> toTable(String faculty);

    List<String> getCourseNameList();
    List<String> getClassroomNameList();
    List<String> getTeacherNameList();

    int addCourseToTable(CourseTable courseTable);

    //获取所有的系别
    List<String> getProfessionName();
}
