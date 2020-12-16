package com.salary.dao;

import com.salary.bean.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapper接口，执行薪酬相关操作
 */
public interface SalaryDao {
    /**
     * 通过用户id获得薪酬列表
     * @param userId
     * @return
     */
    List<Salary> findSalaryByUserId(Long userId);

    /**
     * 删除薪酬信息
     * @param id
     * @return
     */
    int remove(Long id);

    /**
     * 更新薪酬信息
     * @param salary
     * @return
     */
    int update(Salary salary);

    /**
     * 添加薪酬信息
     * @param salary
     * @return
     */
    int add(Salary salary);

    /**
     * 支付薪酬
     * @param id
     */
    void paySalary(Long id);


}
