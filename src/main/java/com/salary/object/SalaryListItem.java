package com.salary.object;

import java.util.Date;

public class SalaryListItem {
    private float postSalary;//岗位工资
    private float performanceSalary;//绩效工资
    private float workYearSalarySalary;//工龄工资
    private float allowanceSalary;//津贴补助
    private boolean flag=false;//发放标记
    private Date time;//发放时间

    /**
     * 构造函数
     * @param postSalary
     * @param performanceSalary
     * @param workYearSalarySalary
     * @param allowanceSalary
     * @param flag
     * @param time
     */
    public SalaryListItem(float postSalary, float performanceSalary, float workYearSalarySalary, float allowanceSalary, boolean flag, Date time) {
        this.postSalary = postSalary;
        this.performanceSalary = performanceSalary;
        this.workYearSalarySalary = workYearSalarySalary;
        this.allowanceSalary = allowanceSalary;
        this.flag = flag;
        this.time = time;
    }

    /**
     * 获得岗位工资
     * @return
     */
    public float getPostSalary() {
        return postSalary;
    }

    /**
     * 修改岗位工资
     * @param postSalary
     */
    public void setPostSalary(float postSalary) {
        this.postSalary = postSalary;
    }

    /**
     * 获得绩效工资
     * @return
     */
    public float getPerformanceSalary() {
        return performanceSalary;
    }

    /**
     * 修改绩效工资
     * @param performanceSalary
     */
    public void setPerformanceSalary(float performanceSalary) {
        this.performanceSalary = performanceSalary;
    }

    /**
     * 获得工龄工资
     * @return
     */
    public float getWorkYearSalarySalary() {
        return workYearSalarySalary;
    }

    /**
     * 修改工龄工资
     * @param workYearSalarySalary
     */
    public void setWorkYearSalarySalary(float workYearSalarySalary) {
        this.workYearSalarySalary = workYearSalarySalary;
    }

    /**
     * 获得津贴补助
     * @return
     */
    public float getAllowanceSalary() {
        return allowanceSalary;
    }

    /**
     * 修改津贴补助
     * @param allowanceSalary
     */
    public void setAllowanceSalary(float allowanceSalary) {
        this.allowanceSalary = allowanceSalary;
    }

    /**
     * 获得发放标记
     * @return
     */
    public boolean isFlag() {
        return flag;
    }

    /**
     * 修改发放标记
     * @param flag
     */
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    /**
     * 获得成立时间
     * @return
     */
    public Date getTime() {
        return time;
    }

    /**
     * 修改成立时间
     * @param time
     */
    public void setTime(Date time) {
        this.time = time;
    }
}
