package com.salary;

import com.salary.bean.Department;
import com.salary.bean.Message;
import com.salary.bean.User;
import com.salary.controller.AdminController;
import com.salary.dao.AdminDao;
import com.salary.dao.DepartmentDao;
import com.salary.dao.UserDao;
import com.salary.exception.DuplicateException;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {
    public static void main(String[] args) throws DuplicateException {
        /*SqlSession session = SqlSessionUtil.getSesion();
        DepartmentDao dao = session.getMapper(DepartmentDao.class);
        List<Department> all = dao.findALL();
        for (Department department : all) {
            System.out.println(department.toString());
        }*/
        /*List<User> all = dao.getAll();
        for (User user : all) {
            System.out.println(user);
        }
        User u = new User("test","123","123@qq.com","admin",18,1,"19109918030",1);
        try{
            int i = dao.addUser(u);
            System.out.println(i);
            int i1 = dao.removeUser(3L);
            System.out.println(i1);
            session.commit();
        } catch (Exception e){
            if(e.getMessage().endsWith("for key 'phone'")){
                //手机号重复
                DuplicateException e1 = new DuplicateException(e.getMessage());
                Message message = new Message(0,"手机号重复");
                String json = JsonUtil.toJSON(message);
                return
            }
        } finally {
            SqlSessionUtil.closeSession();
        }*/



    }
}
