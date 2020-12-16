package com.salary.dao;

import com.salary.bean.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryDao {

    List<Salary> findSalaryByUserId(Long userId);

    void remove(Long id);

    void update(Salary salary);

    void add(Salary salary);

    void paySalary(Long id);


}
