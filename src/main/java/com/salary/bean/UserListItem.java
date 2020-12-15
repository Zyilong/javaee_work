package com.salary.bean;

public class UserListItem {
    private long userId;
    private String username;
    private String name;
    private int age;
    private int gender;
    private String phone;
    private String department;
    private long departmentId;
    private int del;
    private String registerTime;
    private String email;

    public UserListItem() {
    }

    public UserListItem(long userId, String username, String name, int age, int gender, String phone, String department, long departmentId, int del, String registerTime, String email) {
        this.userId = userId;
        this.username = username;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.department = department;
        this.departmentId = departmentId;
        this.del = del;
        this.registerTime = registerTime;
        this.email = email;
    }

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "UserListItem{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", department='" + department + '\'' +
                ", departmentId=" + departmentId +
                ", email='" + email + '\'' +
                '}';
    }
}
