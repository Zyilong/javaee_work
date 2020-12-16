package com.salary.dao;

import com.salary.bean.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapper接口，执行部门相关操作
 */
public interface DepartmentDao {
    /**
     * 通过部门id获得部门
     * @param id
     * @return
     */
    Department findDepartmentById(Long id);

    /**
     * 通过部门名获得部门
     * @param name
     * @return
     */
    Department findDepartmentByName(String name);

    /**
     * 获得部门列表
     * @return
     */
    List<Department> findAll();

    /**
     * 删除部门
     * @param id
     * @return
     */
    int remove(long id);

    /**
     * 添加部门
     * @param department
     * @return
     */
    int add(Department department);

    /**
     * 更新部门信息
     * @param department
     * @return
     */
    int update(Department department);

    /**
     * 获得部门的子部门列表
     * @param id
     * @return
     */
    List<Department> findChild(long id);
}
