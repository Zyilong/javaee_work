package com.salary.object;

public class UserListItem {
    private long userId;//用户id
    private String username;//用户名
    private String name;//姓名
    private int age;//年龄
    private int gender;//性别
    private String phone;//电话
    private String department;//所在部门
    private long departmentId;//bumenid
    private int del;//删除标记，1为删除
    private String registerTime;//注册时间
    private String email;//邮箱

    /**
     * 无参构造函数
     */
    public UserListItem() {
    }

    /**
     * 带参构造函数
     */
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

    /**
     * 获得删除标记
     */
    public int getDel() {
        return del;
    }

    /**
     * 修改删除标记
     */
    public void setDel(int del) {
        this.del = del;
    }

    /**
     * 获得注册时间
     */
    public String getRegisterTime() {
        return registerTime;
    }

    /**
     * 修改注册时间
     */
    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
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
     * 获得用户id
     */
    public long getUserId() {
        return userId;
    }

    /**
     * 修改用户id
     * @param userId
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * 获得所在部门
     * @return
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 修改所在部门
     * @param department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获得用户名
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * 修改用户名
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
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
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获得姓名
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 修改姓名
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获得年龄
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * 修改年龄
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获得性别
     * @return
     */
    public int getGender() {
        return gender;
    }

    /**
     * 修改性别
     * @param gender
     */
    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * 获得电话
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 修改电话
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 覆写的toString方法
     * @return
     */
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
