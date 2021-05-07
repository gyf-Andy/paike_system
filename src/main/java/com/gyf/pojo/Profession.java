package com.gyf.pojo;

/**
 * @author 22413
 * @date 2021/4/23-11:40
 * @Description TODO
 */
public class Profession {
    private int id;
    private String professionCode;
    private String professionName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfessionCode() {
        return professionCode;
    }

    public void setProfessionCode(String professionCode) {
        this.professionCode = professionCode;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", professionCode='" + professionCode + '\'' +
                ", professionName='" + professionName + '\'' +
                '}';
    }
}
