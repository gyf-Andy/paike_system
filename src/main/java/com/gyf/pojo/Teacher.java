package com.gyf.pojo;

/**
 * @author 22413
 * @date 2021/4/20-16:34
 * @Description 教师实体
 */

public class Teacher {

    private int id;
    private String account;
    private String password;
    private String teacherName;
    private String faculty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", faculty='" + faculty + '\'' +
                '}';
    }
}
