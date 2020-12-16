package com.salary.bean;

/**
 * 管理员的实体类
 */
public class Admin {

    private long id;//管理员id
    private String username;//管理员账号姓名
    private String password;//管理员账号密码

    /**
     * 无参构造函数
     */
    public Admin(){

    }

    /**
     * 有参构造函数
     * @param username
     * @param password
     */
    public Admin(String username, String password){
        this(0,username,password);
    }

    /**
     * 带id的有参构造函数
     * @param id
     * @param username
     * @param password
     */
    public Admin(long id,String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    /**
     * 获得管理员id
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * 修改管理员id
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 获得管理员名称
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * 修改管理员名称
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获得管理员密码
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 修改管理员密码
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
