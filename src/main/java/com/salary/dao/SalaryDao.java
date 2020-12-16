package com.salary.dao;

import com.salary.bean.Salary;

import java.util.List;

public interface SalaryDao {

    List<Salary> findSalaryByUserId(Long userId);

    int remove(Long id);

    int update(Salary salary);

    int add(Salary salary);

    void paySalary(Long id);


}
