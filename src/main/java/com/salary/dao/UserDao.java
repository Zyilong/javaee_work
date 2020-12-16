package com.salary.dao;

import com.salary.bean.User;
import com.salary.bean.UserListItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<User> getAll();

    int addUser(User user);

    int removeUser(Long id);

    int updateUser(User user);

    String getPassword(String password);

    User findUserById(long userId);

    User findUserByUsername(String username);

}
