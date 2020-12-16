package com.salary.data;

/**
 * 封装消息的实体类
 * @author Zylong
 */
public class Message {

    //状态码：1成功，0表示失败
    private int code;
    //消息内容
    private String msg;
    //消息所携带的一组数据
    private Object data;

    /**
     * 无参构造函数
     */
    public Message() {
    }

    /**
     * 有参构造函数
     * @param code
     * @param msg
     * @param data
     */
    public Message(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 有参构造函数
     * @param code
     * @param msg
     */
    public Message(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 有参构造函数
     * @param code
     */
    public Message(int code) {
        this.code = code;
    }

    /**
     * 获得code
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     * 修改code
     * @param code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * 获得msg
     * @return
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 修改msg
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获得data
     * @return
     */
    public Object getData() {
        return data;
    }

    /**
     * 修改data
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }
}
