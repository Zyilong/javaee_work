package com.salary.dao;

import com.salary.bean.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapper接口，执行薪酬相关操作
 */
public interface SalaryDao {

    List<Salary> findSalaryByUserId(Long userId);

    int remove(Long id);

    int update(Salary salary);

    int add(Salary salary);

    void paySalary(Long id);


}
