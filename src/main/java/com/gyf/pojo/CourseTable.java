package com.gyf.pojo;

/**
 * @author 郭云飞
 * @date 2021/4/23-16:24
 * @Description TODO
 */
public class CourseTable {

    private int id;
    private String classroomName;
    private String courseName;
    private String teacherName;
    private String faculty;
    private int day;
    private int whichSection;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getWhichSection() {
        return whichSection;
    }

    public void setWhichSection(int whichSection) {
        this.whichSection = whichSection;
    }

    @Override
    public String toString() {
        return "CourseTable{" +
                "id=" + id +
                ", classroomName='" + classroomName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", day=" + day +
                ", whichSection=" + whichSection +
                '}';
    }

}
