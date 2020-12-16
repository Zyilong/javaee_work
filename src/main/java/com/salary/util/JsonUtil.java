package com.salary.util;

import com.google.gson.Gson;

/**
 * Json工具类，将字符串转换为json格式
 * 采用 Google 的 Gson
 * @author Zylong
 */
public class JsonUtil {

    //获取Gson对象
    private static Gson g = new Gson();

    /**
     * 转换Json
     * @param obj 对象
     * @return json
     */
    public static String toJSON(Object obj){
        return g.toJson(obj);
    }

}
