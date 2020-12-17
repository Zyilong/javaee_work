package com.salary.bean;

import java.util.Date;

/**
 * 部门实体类
 */
public class Department {

    private long id;//部门id
    private String name;//部门名称
    private String phone;//部门电话
    private String place;//部门地址
    private long parentId;//父部门id
    private Date time;//成立时间
    private int Del=0;//delete标记

    /**
     * 无参构造函数
     */
    public Department(){

    }

    /**
     * 带参构造函数
     */
    public Department(String name, String phone, String place, long parentId, Date time) {
        this(0,name,phone,place,parentId,time,0);
    }

    /**
     * 带id的带参构造函数
     */
    public Department(long id, String name, String phone, String place, long parentId, Date time, int del) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.place = place;
        this.parentId = parentId;
        this.time = time;
        Del = del;
    }

    /**
     * 获得部门id
     */
    public long getId() {
        return id;
    }

    /**
     * 修改部门id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 获得部门名称
     */
    public String getName() {
        return name;
    }

    /**
     * 修改部门名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获得部门电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 修改部门电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获得部门地址
     */
    public String getPlace() {
        return place;
    }

    /**
     * 修改部门地址
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * 获得父部门id
     */
    public long getParentId() {
        return parentId;
    }

    /**
     * 修改父部门id
     */
    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获得部门成立时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 修改部门成立时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获得delete标记
     */
    public int getDel() {
        return Del;
    }

    /**
     * 修改delete标记
     */
    public void setDel(int del) {
        Del = del;
    }

    /**
     * 覆写的toString方法
     */
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
