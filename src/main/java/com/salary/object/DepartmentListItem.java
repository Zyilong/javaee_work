package com.salary.object;


public class DepartmentListItem {
    private long id;//部门id
    private String name;//部门名称
    private String phone;//部门电话
    private String place;//部门地址
    private long parentId;//父部门id
    private String parentName;//父部门名称
    private String time;//成立时间

    /**
     * 无参构造函数
     */
    public DepartmentListItem() {
    }

    /**
     * 有参构造函数
     * @param id
     * @param name
     * @param phone
     * @param place
     * @param parentId
     * @param parentName
     * @param time
     */
    public DepartmentListItem(long id, String name, String phone, String place, long parentId, String parentName, String time) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.place = place;
        this.parentId = parentId;
        this.parentName = parentName;
        this.time = time;
    }

    /**
     * 获得id
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * 修改id
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * 获得部门名
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 修改部门名
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获得部门电话
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 修改部门电话
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获得部门地址
     * @return
     */
    public String getPlace() {
        return place;
    }

    /**
     * 修改部门地址
     * @param place
     */
    public void setPlace(String place) {
        this.place = place;
    }

    /**
     * 获得父部门id
     * @return
     */
    public long getParentId() {
        return parentId;
    }

    /**
     * 修改父部门id
     * @param parentId
     */
    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获得父部门名
     * @return
     */
    public String getParentName() {
        return parentName;
    }

    /**
     * 修改父部门名
     * @param parentName
     */
    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    /**
     * 获得成立时间
     * @return
     */
    public String getTime() {
        return time;
    }

    /**
     * 修改成立时间
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }

}
