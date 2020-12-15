package com.salary.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {
    private static SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String format(Date date){
        return f.format(date);
    }

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
