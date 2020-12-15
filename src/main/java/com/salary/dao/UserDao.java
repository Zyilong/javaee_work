package com.salary.dao;

import com.salary.bean.User;
import com.salary.bean.UserListItem;

import java.util.List;

public interface UserDao {

    List<User> getAll();

    int addUser(User user);

    int removeUser(Long id);

    int updateUser(User user);

}
