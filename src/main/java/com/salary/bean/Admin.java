package com.salary.bean;

public class Admin {
    private long id;
    private String username;
    private String password;

    public Admin(){

    }

    public Admin(String username, String password){
        this(0,username,password);
    }

    public Admin(long id,String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        this.password = password;
    }

}
