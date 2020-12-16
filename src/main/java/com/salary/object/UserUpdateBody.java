package com.salary.object;

public class UserUpdateBody {
    private String name;//姓名
    private int age;//年龄
    private int gender;//性别
    private String phone;//电话

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
        return "UserUpdateBody{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                '}';
    }
}
