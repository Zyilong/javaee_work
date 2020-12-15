package com.salary.dao;

import com.salary.bean.Salary;

import java.util.List;

public interface SalaryDao {

    List<Salary> findSalaryByUserId(Long userId);

    void remove(Long id);

    void update(Salary salary);

    void add(Salary salary);

    void paySalary(Long id);


}
