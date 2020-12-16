package com.salary.object;

import com.salary.util.EncryptUtil;
import com.salary.util.SqlSessionUtil;

import java.security.MessageDigest;

public class UserRegisterBody {
    private String email;//邮箱
    private String username;//用户名
    private String password;//密码
    private String verifyCode;//验证码

    /**
     * 获得邮箱
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * 修改邮箱
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

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
     * 获得验证码
     * @return
     */
    public String getVerifyCode() {
        return verifyCode;
    }

    /**
     * 修改验证码
     * @param verifyCode
     */
    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    /**
     * 覆写的toString方法
     * @return
     */
    @Override
    public String toString() {
        return "UserRegisterBody{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
}
