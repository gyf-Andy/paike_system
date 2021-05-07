package com.gyf.pojo;

/**
 * @author 22413
 * @date 2021/4/21-14:24
 * @Description 教室实体
 */
public class Classroom {
    private int id;
    private String classroomName;
    private int seating;
    private int projector;
    private int allocation;

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

    public int getSeating() {
        return seating;
    }

    public void setSeating(int seating) {
        this.seating = seating;
    }

    public int getProjector() {
        return projector;
    }

    public void setProjector(int projector) {
        this.projector = projector;
    }

    public int getAllocation() {
        return allocation;
    }

    public void setAllocation(int allocation) {
        this.allocation = allocation;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", classroomName='" + classroomName + '\'' +
                ", seating=" + seating +
                ", projector=" + projector +
                ", allocation=" + allocation +
                '}';
    }
}
