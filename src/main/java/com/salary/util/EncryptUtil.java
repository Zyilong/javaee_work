package com.salary.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 * 使用java自带的类进行加密，采用sha-256加密方法
 * @author 黎东朗
 */
public class EncryptUtil {

    //MessageDigest对象
    private static MessageDigest messageDigest;

    /**
     * 加密
     * @param password 要加密的密码
     * @return 加密后的字符串
     * @throws NoSuchAlgorithmException 没有可用的算法异常
     * @throws UnsupportedEncodingException 不支持的编码格式异常
     */
    public static String messageDigest(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(password.getBytes("UTF-8"));
        return byte2Hex(messageDigest.digest());
    }

    /**
     * 比特数组转为十六进制
     * @param bytes 比特数组
     * @return 字符串
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
