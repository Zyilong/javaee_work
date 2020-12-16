package com.salary.object;

import java.util.Objects;

/**
 * @Description: 用来接受更新员工薪酬信息中的body信息
 * @Author shenmanjie
 * @Date 2020/12/16 14:57
 */
public class UpdateSalary {

    private Long salaryId;
    private float postSalary;
    private float performanceSalary;
    private float workYearSalary;
    private float allowanceSalary;
    private boolean flag=false;

    public UpdateSalary() {
    }

    public UpdateSalary(Long salaryId, float postSalary, float performanceSalary, float workYearSalary, float allowanceSalary, boolean flag) {
        this.salaryId = salaryId;
        this.postSalary = postSalary;
        this.performanceSalary = performanceSalary;
        this.workYearSalary = workYearSalary;
        this.allowanceSalary = allowanceSalary;
        this.flag = flag;
    }

    public Long getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
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

    public float getWorkYearSalary() {
        return workYearSalary;
    }

    public void setWorkYearSalary(float workYearSalary) {
        this.workYearSalary = workYearSalary;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateSalary that = (UpdateSalary) o;
        return Float.compare(that.postSalary, postSalary) == 0 && Float.compare(that.performanceSalary, performanceSalary) == 0 && Float.compare(that.workYearSalary, workYearSalary) == 0 && Float.compare(that.allowanceSalary, allowanceSalary) == 0 && flag == that.flag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postSalary, performanceSalary, workYearSalary, allowanceSalary, flag);
    }
}
