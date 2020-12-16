package com.salary.object;

import java.util.Objects;

/**
 * @Description: 用来接受更新员工薪酬信息中的body信息
 * @Author shenmanjie
 * @Date 2020/12/16 14:57
 */
public class UpdateSalary {

    private Long salaryId;//薪酬id
    private float postSalary;//岗位工资
    private float performanceSalary;//绩效工资
    private float workYearSalary;//工龄工资
    private float allowanceSalary;//津贴补助
    private boolean flag=false;//发放标记

    /**
     * 无参构造函数
     */
    public UpdateSalary() {
    }

    /**
     * 有参构造函数
     * @param salaryId
     * @param postSalary
     * @param performanceSalary
     * @param workYearSalary
     * @param allowanceSalary
     * @param flag
     */
    public UpdateSalary(Long salaryId, float postSalary, float performanceSalary, float workYearSalary, float allowanceSalary, boolean flag) {
        this.salaryId = salaryId;
        this.postSalary = postSalary;
        this.performanceSalary = performanceSalary;
        this.workYearSalary = workYearSalary;
        this.allowanceSalary = allowanceSalary;
        this.flag = flag;
    }

    /**
     * 获得薪酬id
     * @return
     */
    public Long getSalaryId() {
        return salaryId;
    }

    /**
     * 修改薪酬id
     * @param salaryId
     */
    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
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
    public float getWorkYearSalary() {
        return workYearSalary;
    }

    /**
     * 修改工龄工资
     * @param workYearSalary
     */
    public void setWorkYearSalary(float workYearSalary) {
        this.workYearSalary = workYearSalary;
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
     * 覆写的toString方法
     * @return
     */
    @Override
    public String toString() {
        return "UpdateSalary{" +
                "postSalary=" + postSalary +
                ", performanceSalary=" + performanceSalary +
                ", workYearSalary=" + workYearSalary +
                ", allowanceSalary=" + allowanceSalary +
                ", flag=" + flag +
                '}';
    }

    /**
     * 覆写的equals方法
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateSalary that = (UpdateSalary) o;
        return Float.compare(that.postSalary, postSalary) == 0 && Float.compare(that.performanceSalary, performanceSalary) == 0 && Float.compare(that.workYearSalary, workYearSalary) == 0 && Float.compare(that.allowanceSalary, allowanceSalary) == 0 && flag == that.flag;
    }

    /**
     * 覆写的hashCode方法
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(postSalary, performanceSalary, workYearSalary, allowanceSalary, flag);
    }
}
