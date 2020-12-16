package com.salary.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 管理SqlSession的工具类
 * 采用threadLocal来包装SqlSession
 * 确保多线程的安全问题
 *
 * @author Zylong
 */
public class SqlSessionUtil {

    /*
     * ThreadLocal叫做线程变量，意思是ThreadLocal中填充的变量属于当前线程，
     * 该变量对其他线程而言是隔离的。ThreadLocal为变量在每个线程中都创建了一个
     * 副本，那么每个线程可以访问自己内部的副本变量。
     *
     * ThreadLocal一个常用的作用就是：数据库连接，Session会话管理。
     */
    private static ThreadLocal<SqlSession>threadLocal = new ThreadLocal<>();
    //SqlSession工厂类对象
    private static SqlSessionFactory sqlSessionFactory;
    /*
     * 静态代码块，类加载时执行一次，读取mybatis的配置文件
     */
    static {
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取SqlSession
     * @return SqlSession对象
     */
    public static SqlSession getSession(){
        SqlSession session = threadLocal.get();
        if(session == null){
            session = sqlSessionFactory.openSession(true);
            threadLocal.set(session);
        }
        return session;
    }

    /**
     * 关闭SqlSession
     */
    public static void closeSession(){
        SqlSession session = threadLocal.get();
        System.out.println("没有销毁session");
        if(session != null){
            System.out.println("销毁了session");
            session.close();
            threadLocal.remove();
        }
    }
}

