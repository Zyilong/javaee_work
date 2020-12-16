package com.salary.bean;

import java.util.Date;
import java.util.Objects;

/**
 * 薪酬实体类
 */
public class Salary {

    private long id;
    private long userId;
    private Date time;
    private float post;
    private float performance;
    private float workYearSalary;
    private float allowance;
    private boolean flag=false;

    public Salary(){

    }

    public Salary(long userId, Date time, float post, float performance, float workYearSalary, float allowance, boolean flag) {
        this(0L,userId,time,post,performance,workYearSalary,allowance,flag);
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public float getPost() {
        return post;
    }

    public void setPost(float post) {
        this.post = post;
    }

    public float getPerformance() {
        return performance;
    }

    public void setPerformance(float performance) {
        this.performance = performance;
    }

    public float getWorkYearSalary() {
        return workYearSalary;
    }

    public void setWorkYearSalary(float workYearSalary) {
        this.workYearSalary = workYearSalary;
    }

    public float getAllowance() {
        return allowance;
    }

    public void setAllowance(float allowance) {
        this.allowance = allowance;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

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
