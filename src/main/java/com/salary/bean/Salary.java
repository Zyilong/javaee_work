package com.salary.bean;

import java.util.Date;
import java.util.Objects;

/**
 * 薪酬实体类
 */
public class Salary {

    private long id;//薪酬id
    private long userId;//用户id
    private Date time;//薪酬发布时间
    private float post;//岗位工资
    private float performance;//绩效工资
    private float workYearSalary;//工龄工资
    private float allowance;//津贴补助
    private boolean flag=false;//发放标记

    /**
     * 无参构造函数
     */
    public Salary(){

    }

    /**
     * 有参构造函数
     */
    public Salary(long userId, Date time, float post, float performance, float workYearSalary, float allowance, boolean flag) {
        this(0L,userId,time,post,performance,workYearSalary,allowance,flag);
    }

    /**
     * 带id的有参构造函数
     */
    public Salary(long id, long userId, Date time, float post, float performance, float workYearSalary, float allowance, boolean flag) {
        this.id = id;
        this.userId = userId;
        this.time = time;
        this.post = post;
        this.performance = performance;
        this.workYearSalary = workYearSalary;
        this.allowance = allowance;
        this.flag = flag;
    }

    /**
     * 获得薪酬id
     */
    public long getId() {
        return id;
    }

    /**
     * 修改薪酬id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 获得用户id
     */
    public long getUserId() {
        return userId;
    }

    /**
     * 修改用户id
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /**
     * 获得发放时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 修改发放时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获得岗位工资
     */
    public float getPost() {
        return post;
    }

    /**
     * 修改岗位工资
     */
    public void setPost(float post) {
        this.post = post;
    }

    /**
     * 获得绩效工资
     */
    public float getPerformance() {
        return performance;
    }

    /**
     * 修改绩效工资
     */
    public void setPerformance(float performance) {
        this.performance = performance;
    }

    /**
     * 获得工龄工资
     */
    public float getWorkYearSalary() {
        return workYearSalary;
    }

    /**
     * 修改工龄工资
     */
    public void setWorkYearSalary(float workYearSalary) {
        this.workYearSalary = workYearSalary;
    }

    /**
     * 获得津贴补助
     */
    public float getAllowance() {
        return allowance;
    }

    /**
     * 修改津贴补助
     */
    public void setAllowance(float allowance) {
        this.allowance = allowance;
    }

    /**
     * 获得发放标记
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * 修改发放标记
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * 覆写的equals方法
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salary salary = (Salary) o;
        return id == salary.id &&
                userId == salary.userId &&
                Float.compare(salary.post, post) == 0 &&
                Float.compare(salary.performance, performance) == 0 &&
                Float.compare(salary.workYearSalary, workYearSalary) == 0 &&
                Float.compare(salary.allowance, allowance) == 0 &&
                flag == salary.flag &&
                Objects.equals(time, salary.time);
    }

    /**
     * 覆写的toString方法
     */
    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", userId=" + userId +
                ", time=" + time +
                ", post=" + post +
                ", performance=" + performance +
                ", workYearSalary=" + workYearSalary +
                ", allowance=" + allowance +
                ", flag=" + flag +
                '}';
    }
}
