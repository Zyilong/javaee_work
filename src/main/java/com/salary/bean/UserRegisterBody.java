package com.salary.bean;

import com.salary.util.SqlSessionUtil;

import java.security.MessageDigest;

public class UserRegisterBody {
    private String email;
    private String username;
    private String password;
    private String verifyCode;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
        MessageDigest messageDigest;
        try{
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes("UTF-8"));
            this.password = byte2Hex(messageDigest.digest());
        }catch (Exception e){
            e.printStackTrace();
            this.password = null;
        }

    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    /**
     * 将byte数组转化为十六进制字符串，用于加密
     *
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        SqlSessionUtil.closeSession();
        return stringBuffer.toString();
    }
}
