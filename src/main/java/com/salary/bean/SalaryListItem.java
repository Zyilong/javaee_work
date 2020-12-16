package com.salary.bean;

import java.util.Date;

public class SalaryListItem {
    private float postSalary;
    private float performanceSalary;
    private float workYearSalarySalary;
    private float allowanceSalary;
    private boolean flag=false;
    private Date time;

    public SalaryListItem(float postSalary, float performanceSalary, float workYearSalarySalary, float allowanceSalary, boolean flag, Date time) {
        this.postSalary = postSalary;
        this.performanceSalary = performanceSalary;
        this.workYearSalarySalary = workYearSalarySalary;
        this.allowanceSalary = allowanceSalary;
        this.flag = flag;
        this.time = time;
    }

    public float getPostSalary() {
        return postSalary;
    }

    public void setPostSalary(float postSalary) {
        this.postSalary = postSalary;
    }

    public float getPerformanceSalary() {
        return performanceSalary;
    }

    public void setPerformanceSalary(float performanceSalary) {
        this.performanceSalary = performanceSalary;
    }

    public float getWorkYearSalarySalary() {
        return workYearSalarySalary;
    }

    public void setWorkYearSalarySalary(float workYearSalarySalary) {
        this.workYearSalarySalary = workYearSalarySalary;
    }

    public float getAllowanceSalary() {
        return allowanceSalary;
    }

    public void setAllowanceSalary(float allowanceSalary) {
        this.allowanceSalary = allowanceSalary;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
