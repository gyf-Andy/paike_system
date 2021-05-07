package com.gyf.pojo;

/**
 * @author 22413
 * @date 2021/4/21-17:09
 * @Description 课程实体类
 */
public class Course {
    private int id;
    private String courseCode;
    private String courseName;
    private String faculty;
    private int classHours;

    public int getId() {
        return id;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getClassHours() {
        return classHours;
    }

    public void setClassHours(int classHours) {
        this.classHours = classHours;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", classHours=" + classHours +
                '}';
    }
}
