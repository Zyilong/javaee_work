package com.salary.controller;

import com.salary.bean.*;
import com.salary.dao.AdminDao;
import com.salary.dao.DepartmentDao;
import com.salary.dao.SalaryDao;
import com.salary.dao.UserDao;
import com.salary.util.DateFormatUtil;
import com.salary.util.EncryptUtil;
import com.salary.util.JsonUtil;
import com.salary.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.*;

@Controller
@RequestMapping("/api/admin")
public class AdminController {

    private String finalAccessToken;
    private Message message;


    /**
     * 管理员登录
     *
     * @param loginBody 封装好的管理员登录实体类
     * @return json
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody LoginBody loginBody) {
        SqlSession session = SqlSessionUtil.getSesion();
        AdminDao adminDao = session.getMapper(AdminDao.class);
        String password1 = adminDao.getPassword(loginBody.getUsername());
        System.out.println(loginBody.getPassword());

        if (password1 != null && password1 != "" && password1.equals(loginBody.getPassword())) {
            String token = loginBody.getUsername() + new Timestamp(System.currentTimeMillis()).toString();
            String accessToken = "";
            //sha256加密
            try {
                accessToken = EncryptUtil.messageDigest(token);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println("生成的accessToken->" + accessToken);
            message = new Message(1, "ok", accessToken);
            finalAccessToken = accessToken;
        } else {
            message = new Message(0, "登录失败，请检查用户名和密码是否正确");
        }
        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);
        return json;
    }

    /**
     * 修改员工信息
     *
     * @param accessToken 头部信息，用于校验
     * @param id          要修改的员工id
     * @param user        新的员工信息封装为user对象
     * @return json
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(@RequestHeader("accessToken") String accessToken,
                             @RequestParam("userId") long id,
                             @RequestBody User user) {
        if (!accessToken.equals(finalAccessToken)) {
            message = new Message(0, "accessToken错误");
            String json = JsonUtil.toJSON(message);
            return json;
        }
        SqlSession session = SqlSessionUtil.getSesion();
        UserDao userDao = session.getMapper(UserDao.class);
        user.setId(id);
        System.out.println("要更新的用户信息->" + user);
        int i = userDao.updateUser(user);

        if (i != 0) {
            message = new Message(1, "ok");
        } else {
            message = new Message(0, "修改员工信息失败");
        }
        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);
        return json;
    }

    /**
     * 删除员工信息
     *
     * @param accessToken 头部信息，用于校验
     * @param id          要删除的员工id
     * @return json
     */
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    @ResponseBody
    public String removeUser(@RequestHeader("accessToken") String accessToken,
                             @RequestParam("userId") long id) {
        if (!accessToken.equals(finalAccessToken)) {
            message = new Message(0, "accessToken错误");
            String json = JsonUtil.toJSON(message);
            return json;
        }
        SqlSession session = SqlSessionUtil.getSesion();
        UserDao userDao = session.getMapper(UserDao.class);
        System.out.println("要删除的id->" + id);
        int i = userDao.removeUser(id);

        if (i != 0) {
            message = new Message(1, "ok");
        } else {
            message = new Message(0, "删除员工失败");
        }
        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);
        return json;
    }

    /**
     * 获取所有员工列表
     *
     * @param accessToken 头部信息，用于校验
     * @return json
     */
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    @ResponseBody
    public String getAllUser(@RequestHeader("accessToken") String accessToken) {
        if (!accessToken.equals(finalAccessToken)) {
            message = new Message(0, "accessToken错误");
            String json = JsonUtil.toJSON(message);
            return json;
        }
        SqlSession session = SqlSessionUtil.getSesion();
        UserDao userDao = session.getMapper(UserDao.class);
        DepartmentDao departmentDao = session.getMapper(DepartmentDao.class);
        List<User> list = userDao.getAll();
        List<UserListItem> list1 = new ArrayList<>();

        boolean flag = false;
        for (User user : list) {
            String department = departmentDao.findDepartmentById(user.getDepartmentId()).getName();
            String registerTime = DateFormatUtil.format(user.getRegisterTime());
            UserListItem u1 = new UserListItem(user.getId(), user.getUsername(), user.getName(), user.getAge(), user.getGender(), user.getPhone(), department, user.getDepartmentId(), user.getDel(), registerTime, user.getEmail());
            list1.add(u1);
            flag = true;
        }
        if (flag) {
            message = new Message(1, "ok", list1);
        } else {
            message = new Message(0, "未查找到员工信息");
        }
        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);
        return json;
    }

    /**
     * 获取所有部门
     *
     * @param accessToken 头部信息，用于校验
     * @return json
     */
    @RequestMapping(value = "/department/all", method = RequestMethod.POST)
    @ResponseBody
    public String getAllDepartment(@RequestHeader("accessToken") String accessToken) {
        if (!accessToken.equals(finalAccessToken)) {
            message = new Message(0, "accessToken错误");
            String json = JsonUtil.toJSON(message);
            return json;
        }
        SqlSession session = SqlSessionUtil.getSesion();
        DepartmentDao departmentDao = session.getMapper(DepartmentDao.class);
        List<Department> list = departmentDao.findAll();
        List<Map> list1 = new ArrayList<>();

        boolean flag = false;

        for (Department d : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("departmentId", d.getId());
            map.put("name", d.getName());
            map.put("phone", d.getPhone());
            map.put("place", d.getPlace());
            map.put("parentId", d.getParentId());
            String date = DateFormatUtil.format(d.getTime());
            map.put("time", date);
            list1.add(map);
            flag = true;
        }


        if (flag) {
            message = new Message(1, "ok", list1);
        } else {
            message = new Message(0, "当前无部门");
        }
        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);

        return json;
    }

    /**
     * 根据id查询部门信息
     *
     * @param accessToken 头部信息，用于校验
     * @param id          要查询的部门id
     * @return json
     */
    @RequestMapping(value = "/department", method = RequestMethod.GET)
    @ResponseBody
    public String findDepartment(@RequestHeader("accessToken") String accessToken,
                                 @RequestParam("departmentId") long id) {

        if (!accessToken.equals(finalAccessToken)) {
            message = new Message(0, "accessToken错误");
            String json = JsonUtil.toJSON(message);
            return json;
        }
        SqlSession session = SqlSessionUtil.getSesion();
        DepartmentDao departmentDao = session.getMapper(DepartmentDao.class);
        System.out.println("要查找的部门id->" + id);
        Department department = departmentDao.findDepartmentById(id);
        Map<String, Object> map = new HashMap<>();
        if (department != null && department.getName() != "") {
            map.put("name", department.getName());
            map.put("phone", department.getPhone());
            map.put("place", department.getPlace());
            String time = DateFormatUtil.format(department.getTime());
            map.put("time", time);
            message = new Message(1, "ok", map);
        } else {
            message = new Message(0, "没有查到这个部门");
        }
        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);
        return json;
    }

    /**
     * 更新部门信息
     *
     * @param accessToken 头部信息，用于校验
     * @param department  要更新的部门信息
     * @return json
     */
    @RequestMapping(value = "/department", method = RequestMethod.PUT)
    @ResponseBody
    public String updateDepartment(@RequestHeader("accessToken") String accessToken,
                                   @RequestBody Department department) {
        if (!accessToken.equals(finalAccessToken)) {
            message = new Message(0, "accessToken错误");
            String json = JsonUtil.toJSON(message);
            return json;
        }
        SqlSession session = SqlSessionUtil.getSesion();
        DepartmentDao departmentDao = session.getMapper(DepartmentDao.class);
        System.out.println("要更新的部门信息->" + department);
        int i = departmentDao.update(department);
        if (i != 0) {
            message = new Message(1, "ok");
        } else {
            message = new Message(0, "修改部门信息失败");
        }
        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);
        return json;
    }

    /**
     * 删除部门信息
     *
     * @param accessToken 头部信息，用于校验
     * @param id          要删除的部门id
     * @return json
     */
    @RequestMapping(value = "/department", method = RequestMethod.DELETE)
    @ResponseBody
    public String removeDepartment(@RequestHeader("accessToken") String accessToken,
                                   @RequestParam("departmentId") long id) {
        if (!accessToken.equals(finalAccessToken)) {
            message = new Message(0, "accessToken错误");
            String json = JsonUtil.toJSON(message);
            return json;
        }
        SqlSession session = SqlSessionUtil.getSesion();
        DepartmentDao departmentDao = session.getMapper(DepartmentDao.class);
        System.out.println("要删除的部门id->" + id);
        Department department = departmentDao.findDepartmentById(id);
        Map<String, Object> map = new HashMap<>();
        if (department != null && department.getName() != "") {
            map.put("departmentId", id);
            map.put("name", department.getName());
            map.put("phone", department.getPhone());
            map.put("place", department.getPlace());
            map.put("parentId", department.getParentId());
            int i = departmentDao.remove(id);
            if (i != 0) {
                message = new Message(1, "ok", map);
            } else {
                message = new Message(0, "删除部门失败");
            }
        } else {
            message = new Message(0, "删除部门失败");
        }
        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);
        return json;
    }

    /**
     * 新增部门
     *
     * @param accessToken 头部信息，用于校验
     * @param department  要新增的部门信息
     * @return json
     */
    @RequestMapping(value = "/department", method = RequestMethod.POST)
    @ResponseBody
    public String insertDepartment(@RequestHeader("accessToken") String accessToken,
                                   @RequestBody Department department) {
        if (!finalAccessToken.equals(accessToken)) {
            message = new Message(0, "accessToken错误");
            String json = JsonUtil.toJSON(message);
            return json;
        }
        try {
            SqlSession session = SqlSessionUtil.getSesion();
            DepartmentDao departmentDao = session.getMapper(DepartmentDao.class);
            int i = departmentDao.add(department);
            System.out.println("新增的部门信息->" + department);
            if (i != 0) {
                message = new Message(1, "ok", department.getId());
            } else {
                message = new Message(0, "新增部门失败");
            }
        } catch (Exception e) {
            if (e.getMessage().endsWith("for key 'name'")) {
                message = new Message(0, "部门名重复，请重新提交");
            }
        }
        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);
        return json;
    }

    /**
     * 获取部门的子部门
     *
     * @param accessToken 头部信息，用于校验
     * @param id
     * @return
     */
    @RequestMapping(value = "/department/list", method = RequestMethod.GET)
    @ResponseBody
    public String getChildDepartment(@RequestHeader("accessToken") String accessToken,
                                     @RequestParam("departmentId") long id) {
        if (!finalAccessToken.equals(accessToken)) {
            message = new Message(0, "accessToken错误");
            String json = JsonUtil.toJSON(message);
            return json;
        }
        SqlSession session = SqlSessionUtil.getSesion();
        DepartmentDao departmentDao = session.getMapper(DepartmentDao.class);
        List<Department> list = departmentDao.findChild(id);
        List<DepartmentListItem> list1 = new ArrayList<>();
        boolean flag = false;
        for (Department d : list) {
            String parentName = departmentDao.findDepartmentById(id).getName();
            String time = DateFormatUtil.format(d.getTime());
            DepartmentListItem d1 = new DepartmentListItem(d.getId(), d.getName(), d.getPhone(), d.getPlace(), d.getParentId(), parentName, time);
            list1.add(d1);
            flag = true;
        }
        if (flag) {
            message = new Message(1, "ok", list1);
        } else {
            message = new Message(0, "此部门没有子部门");
        }
        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);
        return json;
    }

    /**
     * 删除指定ID的薪酬记录
     *
     * @param accessToken
     * @param salaryId
     * @return
     */
    @RequestMapping(value = "/salary", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteSpecifiedIDSarlary(@RequestHeader("accessToken") String accessToken,
                                           @RequestParam String salaryId) {
        if (!finalAccessToken.equals(accessToken)) {
            message = new Message(0, "accessToken错误");
            String json = JsonUtil.toJSON(message);
            return json;
        }

        System.out.println("要删除的salaryId->" + salaryId);
        long id = Long.parseLong(salaryId);
        //获取数据访问支持
        SqlSession session = SqlSessionUtil.getSesion();
        SalaryDao salaryDao = session.getMapper(SalaryDao.class);//对应的薪酬管理增加的薪酬数据访问层

        int i = salaryDao.remove(id);
        if (i != 0) {
            message = new Message(1, "ok");
        } else {
            message = new Message(0, "删除薪酬记录失败");
        }
        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);
        return json;
    }

    /**
     * 更新指定员工的薪酬信息
     *
     * @param accessToken
     * @param userId
     * @param updateSalary
     * @return
     */
    @RequestMapping(value = "/salary", method = RequestMethod.PUT)
    @ResponseBody
    public String updateSpecifiedUserIDSarlary(@RequestHeader("accessToken") String accessToken,
                                               @RequestParam("userId") long userId,
                                               @RequestBody UpdateSalary updateSalary) {
        if (!finalAccessToken.equals(accessToken)) {
            message = new Message(0, "accessToken错误");
            String json = JsonUtil.toJSON(message);
            return json;
        }

        System.out.println(updateSalary);

        Salary salary = new Salary(updateSalary.getSalaryId(), userId, new Date(), updateSalary.getPostSalary(),
                updateSalary.getPerformanceSalary(), updateSalary.getWorkYearSalary(),
                updateSalary.getAllowanceSalary(), updateSalary.isFlag());

        //获取数据访问支持
        SqlSession session = SqlSessionUtil.getSesion();
        SalaryDao salaryDao = session.getMapper(SalaryDao.class);//对应的薪酬管理增加的薪酬数据访问层

        int i = salaryDao.update(salary);

        if (i != 0) {
            message = new Message(1, "ok");
        } else {
            message = new Message(0, "更新员工薪酬信息失败");
        }

        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);
        return json;
    }

    /**
     * 给指定员工添加员工薪酬
     *
     * @param accessToken
     * @param userId
     * @param updateSalary
     * @return
     */
    @RequestMapping(value = "/salary", method = RequestMethod.POST)
    @ResponseBody
    public String addEmployeeCompensationToSpecifiedUserID(@RequestHeader("accessToken") String accessToken,
                                                           @RequestParam("userId") long userId,
                                                           @RequestBody UpdateSalary updateSalary){
        if (!finalAccessToken.equals(accessToken)) {
            message = new Message(0, "accessToken错误");
            String json = JsonUtil.toJSON(message);
            return json;
        }

        System.out.println(updateSalary.toString());

        Salary salary = new Salary(userId, new Date(), updateSalary.getPostSalary(),
                updateSalary.getPerformanceSalary(), updateSalary.getWorkYearSalary(),
                updateSalary.getAllowanceSalary(), updateSalary.isFlag());

        //获取数据访问支持
        SqlSession session = SqlSessionUtil.getSesion();
        SalaryDao salaryDao = session.getMapper(SalaryDao.class);//对应的薪酬管理增加的薪酬数据访问层

        int i = salaryDao.add(salary);

        if (i != 0) {
            message = new Message(1, "ok");
        } else {
            message = new Message(0, "给指定员工添加员工薪酬失败");
        }

        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);
        return json;
    }

    /**
     * 获取指定员工薪酬记录列表
     *
     * @param accessToken
     * @param userId
     * @return
     */
    @RequestMapping(value = "/salary", method = RequestMethod.GET)
    @ResponseBody
    public String GetListOfSalaryRecordsOfSpecifiedUserID(@RequestHeader("accessToken") String accessToken, @RequestParam("userId") long userId){
        if (!accessToken.equals(finalAccessToken)) {
            message = new Message(0, "accessToken错误");
            String json = JsonUtil.toJSON(message);
            return json;
        }

        //获取数据访问支持
        SqlSession session = SqlSessionUtil.getSesion();
        SalaryDao salaryDao = session.getMapper(SalaryDao.class);//对应的薪酬管理增加的薪酬数据访问层
        UserDao userDao = session.getMapper(UserDao.class);

        List<Salary> salaryList = salaryDao.findSalaryByUserId(userId);
        List<Map> returnList = new ArrayList<Map>();


        boolean flag = false;

        for (Salary salary : salaryList) {
            Map<String, Object> map = new HashMap<>();
            map.put("salaryId", salary.getId());

            User user = userDao.findUserById(salary.getUserId());

            map.put("username", user.getUsername());
            map.put("userId", salary.getUserId());
            map.put("name", user.getName());
            map.put("postSalary", salary.getPost());
            map.put("workYearSalary", salary.getWorkYearSalary());
            map.put("performanceSalary",salary.getPerformance());
            map.put("allowanceSalary", salary.getAllowance());
            map.put("flag", salary.isFlag());
            String date = DateFormatUtil.format(salary.getTime());
            map.put("time", date);
            returnList.add(map);
            flag = true;
        }


        if (flag) {
            message = new Message(1, "ok", returnList);
        } else {
            message = new Message(0, "当前员工没有薪酬记录");
        }

        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);

        return json;
    }

}
