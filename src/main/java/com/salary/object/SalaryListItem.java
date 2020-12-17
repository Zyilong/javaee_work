package com.salary.object;

public class SalaryListItem {
    private float postSalary;//岗位工资
    private float performanceSalary;//绩效工资
    private float workYearSalary;//工龄工资
    private float allowanceSalary;//津贴补助
    private boolean flag=false;//发放标记
    private String time;//发放时间

    /**
     * 构造函数
     * @param postSalary
     * @param performanceSalary
     * @param workYearSalary
     * @param allowanceSalary
     * @param flag
     * @param time
     */
    public SalaryListItem(float postSalary, float performanceSalary, float workYearSalary, float allowanceSalary, boolean flag, String time) {
        this.postSalary = postSalary;
        this.performanceSalary = performanceSalary;
        this.workYearSalary = workYearSalary;
        this.allowanceSalary = allowanceSalary;
        this.flag = flag;
        this.time = time;
    }

    /**
     * 获得岗位工资
     */
    public float getPostSalary() {
        return postSalary;
    }

    /**
     * 修改岗位工资
     */
    public void setPostSalary(float postSalary) {
        this.postSalary = postSalary;
    }

    /**
     * 获得绩效工资
     */
    public float getPerformanceSalary() {
        return performanceSalary;
    }

    /**
     * 修改绩效工资
     */
    public void setPerformanceSalary(float performanceSalary) {
        this.performanceSalary = performanceSalary;
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
    public float getAllowanceSalary() {
        return allowanceSalary;
    }

    /**
     * 修改津贴补助
     */
    public void setAllowanceSalary(float allowanceSalary) {
        this.allowanceSalary = allowanceSalary;
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
     * 获得成立时间
     */
    public String getTime() {
        return time;
    }

    /**
     * 修改成立时间
     */
    public void setTime(String time) {
        this.time = time;
    }
}
