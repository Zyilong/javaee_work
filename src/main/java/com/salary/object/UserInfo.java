package com.salary.object;

import com.salary.bean.User;
import com.salary.util.DateFormatUtil;

import java.util.Date;

public class UserInfo {
    private String username;
    private String password;
    private String email;
    private String name;
    private int age;
    private int gender;
    private String phone;
    private String departmentName;
    private String registerTime;

    public UserInfo(){

    }

    public UserInfo(User user,String departmentName) {
        this(user.getUsername(),user.getPassword(),user.getEmail(),user.getName(),user.getAge(),
                user.getGender(),user.getPhone(),departmentName,DateFormatUtil.format(user.getRegisterTime()));
    }

    public UserInfo(String username, String password, String email, String name, int age, int gender, String phone, String departmentName, String registerTime) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.departmentName = departmentName;
        this.registerTime = registerTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", registerTime='" + registerTime + '\'' +
                '}';
    }
}
