package com.salary.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间格式转换工具类
 * @author Zylong
 */
public class DateFormatUtil {

    //定义java自带的转换类
    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 将日期格式转换为字符串格式
     * @param date 要转换的date
     * @return 转换后的字符串
     */
    public static String format(Date date){
        return f.format(date);
    }

    /**
     * 将字符串转换为日期格式
     * @param data 要转换的字符串
     * @return 日期格式
     */
    public static long parse(String data) {
        try {
            return f.parse(data).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            return 0;
        }
    }
}
