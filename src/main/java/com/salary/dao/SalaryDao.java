package com.salary.dao;

import com.salary.bean.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryDao {

    List<Salary> findSalaryByUserId(Long userId);

    int remove(Long id);

    int update(Salary salary);

    int add(Salary salary);

    void paySalary(Long id);


}
