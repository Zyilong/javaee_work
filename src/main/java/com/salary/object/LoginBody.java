package com.salary.object;

import com.salary.util.EncryptUtil;


public class LoginBody {
    private String username;//用户名
    private String password;//密码

    /**
     * 获得用户名
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * 修改用户名
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获得密码
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 修改密码
     * @param password
     */
    public void setPassword(String password) {
        try{
            this.password = EncryptUtil.messageDigest(password);
        }catch (Exception e){
            e.printStackTrace();
            this.password = null;
        }
    }

    /**
     *
     * 无参构造函数
     */
    public LoginBody() {
    }

    /**
     * 覆写的toString方法
     * @return
     */
    @Override
    public String toString() {
        return "LoginBody{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
