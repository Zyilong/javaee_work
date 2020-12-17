package com.salary.bean;

import java.util.Date;

/**
 * 用户实体类
 */
public class User {

    private long id;//用户id
    private String username;//用户名称
    private String password;//用户密码
    private String email;//用户邮箱
    private String name;//姓名
    private int age;//用户年龄
    private int gender;//性别
    private String phone;//电话
    private long departmentId;//部门id
    private int del=0;//delete标记
    private Date registerTime;//注册时间

    /**
     * 无参构造函数
     */
    public User(){

    }

    /**
     * 简单的带参构造函数
     */
    public User(String username,String password,String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }


    /**
     * 带参构造函数
     */
    public User(String username, String password, String email, String name, int age, int gender, String phone, long departmentId) {
        this(0L,username,password,email,name,age,gender,phone,departmentId,0);
    }

    /**
     * 带id的带参构造函数
     */
    public User(long id, String username, String password, String email, String name, int age, int gender, String phone, long departmentId, int del) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.departmentId = departmentId;
        this.del = del;
    }

    /**
     * 获得用户id
     */
    public long getId() {
        return id;
    }

    /**
     * 修改用户id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 获得用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 修改用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获得密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 修改密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获得邮箱
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * 修改邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获得姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 修改姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获得年龄
     */
    public int getAge() {
        return age;
    }

    /**
     * 修改年龄
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获得性别
     */
    public int getGender() {
        return gender;
    }

    /**
     * 修改性别
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * 获得电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 修改电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获得部门id
     */
    public long getDepartmentId() {
        return departmentId;
    }

    /**
     * 修改部门id
     */
    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 获得delete标记
     */
    public int getDel() {
        return del;
    }

    /**
     * 修改delete标记
     */
    public void setDel(int del) {
        this.del = del;
    }

    /**
     * 获得注册时间
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 修改注册时间
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * 覆写的toString方法
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", departmentId=" + departmentId +
                ", del=" + del +
                ", registerTime=" + registerTime +
                '}';
    }
}
