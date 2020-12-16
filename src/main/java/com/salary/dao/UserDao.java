package com.salary.dao;

import com.salary.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapper接口，执行用户相关操作
 */
public interface UserDao {

    List<User> getAll();

    int addUser(User user);

    int removeUser(Long id);

    int updateUser(User user);

    User login(@Param("username")String username, @Param("password")String password);

    String getPassword(String password);

    User findUserById(long userId);

    User findUserByUsername(String username);

}
