package com.salary.dao;

/**
 * mapper接口，执行管理员相关操作
 */
public interface AdminDao {
    /**
     * 通过管理员名称获得管理员密码
     * @param username
     * @return
     */
    String getPassword(String username);
}
