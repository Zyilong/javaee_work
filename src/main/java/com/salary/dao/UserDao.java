package com.salary.dao;

import com.salary.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapper接口，执行用户相关操作
 */
public interface UserDao {
    /**
     * 获取用户列表
     * @return
     */
    List<User> getAll();

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int removeUser(Long id);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User login(@Param("username")String username, @Param("password")String password);

    /**
     * 通过用户名得到用户密码
     * @param username 用户名
     * @return
     */
    String getPassword(String username);

    /**
     * 通过用户id得到用户
     * @param userId 用户id
     * @return
     */
    User findUserById(long userId);

    /**
     * 通过用户名得到用户
     * @param username 用户名
     * @return
     */
    User findUserByUsername(String username);

}
