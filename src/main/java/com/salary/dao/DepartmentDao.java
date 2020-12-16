package com.salary.dao;

import com.salary.bean.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapper接口，执行部门相关操作
 */
public interface DepartmentDao {

    Department findDepartmentById(Long id);

    Department findDepartmentByName(String name);

    List<Department> findAll();

    int remove(long id);

    int add(Department department);

    int update(Department department);

    List<Department> findChild(long id);
}
