package com.salary.bean;

import java.util.Date;

/**
 * 部门实体类
 */
public class Department {

    private long id;
    private String name;
    private String phone;
    private String place;
    private long parentId;
    private Date time;
    private int Del=0;

    public Department(){

    }

    public Department(String name, String phone, String place, long parentId, Date time) {
        this(0,name,phone,place,parentId,time,0);
    }

    public Department(long id, String name, String phone, String place, long parentId, Date time, int del) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.place = place;
        this.parentId = parentId;
        this.time = time;
        Del = del;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getDel() {
        return Del;
    }

    public void setDel(int del) {
        Del = del;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", place='" + place + '\'' +
                ", parentId=" + parentId +
                ", time=" + time +
                ", Del=" + Del +
                '}';
    }
}
