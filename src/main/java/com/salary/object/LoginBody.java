package com.salary.object;

import com.salary.util.EncryptUtil;


public class LoginBody {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try{
            this.password = EncryptUtil.messageDigest(password);
        }catch (Exception e){
            e.printStackTrace();
            this.password = null;
        }
    }

    public LoginBody() {
    }

    @Override
    public String toString() {
        return "LoginBody{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}