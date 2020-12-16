package com.salary.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 * 使用java自带的类进行加密，采用sha-256加密方法
 * @author 黎东朗
 */
public class EncryptUtil {

    /**
     * 加密
     * @param password 要加密的密码
     * @return 加密后的字符串
     * @throws NoSuchAlgorithmException 没有可用的算法异常
     */
    public static String messageDigest(String password) throws NoSuchAlgorithmException {
        //MessageDigest对象
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(password.getBytes(StandardCharsets.UTF_8));
        return byte2Hex(messageDigest.digest());
    }

    /**
     * 比特数组转为十六进制
     * @param bytes 比特数组
     * @return 字符串
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        String temp;
        for (byte aByte : bytes) {
            temp = Integer.toHexString(aByte & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuilder.append("0");
            }
            stringBuilder.append(temp);
        }
        SqlSessionUtil.closeSession();
        return stringBuilder.toString();
    }
}
