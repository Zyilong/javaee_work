package com.salary.controller;


import com.salary.bean.*;
import com.salary.dao.SalaryDao;
import com.salary.dao.UserDao;
import com.salary.util.EncryptUtil;
import com.salary.util.JsonUtil;
import com.salary.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/api/user")
public class UserController {


    private String finalAccessToken;
    private Message message;


    /**
     * 将byte数组转化为十六进制字符串，用于加密
     *
     * @param bytes
     * @return
     */
    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        SqlSessionUtil.closeSession();
        return stringBuffer.toString();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody LoginBody loginBody) {
        System.out.println(loginBody);
        SqlSession session = SqlSessionUtil.getSesion();
        UserDao userDao = session.getMapper(UserDao.class);
        String password = userDao.getPassword(loginBody.getUsername());

        if (password != null && password != "" && password.equals(loginBody.getPassword())) {
            String token = loginBody.getUsername() + new Timestamp(System.currentTimeMillis()).toString();
            String accessToken = "";
            //sha256加密
            try {
                accessToken = EncryptUtil.messageDigest(password);
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

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    @ResponseBody
    public String register(@RequestBody UserRegisterBody userRegisterBody){
        User user;
        String hasNull;
        String username = userRegisterBody.getUsername();
        String password = userRegisterBody.getPassword();
        String email = userRegisterBody.getEmail();
        String verifyCode = userRegisterBody.getVerifyCode();
        SqlSession session = SqlSessionUtil.getSesion();
        UserDao userDao = session.getMapper(UserDao.class);
        user = userDao.findUserByUsername(userRegisterBody.getUsername());
        if(user==null){
            if((hasNull = checkNUll(username,password,email,verifyCode))==null){
                //TODO
                user = new User();
                userDao.addUser(user);
                message = new Message(1,"ok");
            }else{
                message = new Message(0,hasNull);
            }
        }else{
            message = new Message(0,"该用户名已被使用，请使用新的用户名");
        }
        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);
        return json;
    }

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    @ResponseBody
    public String getUserInfo(@RequestHeader("accessToken") String accessToken,
                              @RequestParam("userId") long userId){

        if(!accessToken.equals(finalAccessToken)){
            message = new Message(0, "accessToken错误");
        }else{
            SqlSession session = SqlSessionUtil.getSesion();
            UserDao userDao = session.getMapper(UserDao.class);
            User user = userDao.findUserById(userId);
            if(user==null){
                message = new Message(0,"用户不存在");
            }else{
                message = new Message(1,"ok",user);
            }
        }
        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);
        return json;
    }


    @RequestMapping(value = "/info",method = RequestMethod.POST)
    @ResponseBody
    public String updateUserInfo(@RequestHeader("accessToken") String accessToken,
                         @RequestParam("userId") long userId,
                         @RequestBody User user){
        if(!accessToken.equals(finalAccessToken)){
            message = new Message(0, "accessToken错误");
        }else{
            SqlSession session = SqlSessionUtil.getSesion();
            UserDao userDao = session.getMapper(UserDao.class);
            user.setId(userId);
            System.out.println("要更新的用户信息->" + user);

            if (userDao.updateUser(user) != 0) {
                message = new Message(1, "ok");
            } else {
                message = new Message(0, "修改员工信息失败");
            }
        }
        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);
        return json;
    }

    @RequestMapping(value = "/salary", method = RequestMethod.GET)
    @ResponseBody
    public String getUserSalary(@RequestHeader("accessToken") String accessToken,
                                @RequestParam("userId") long userId){

        SqlSession session = SqlSessionUtil.getSesion();
        UserDao userDao = session.getMapper(UserDao.class);
        SalaryDao salaryDao = session.getMapper(SalaryDao.class);

        if(!accessToken.equals(finalAccessToken)){
            message = new Message(0, "accessToken错误");
        }else{

            if(userDao.findUserById(userId)==null){
                message = new Message(0,"用户不存在");
            }else{
                List<Salary> salaryList = salaryDao.findSalaryByUserId(userId);
                List<SalaryListItem> items = new ArrayList<>();
                for(Salary salary:salaryList){
                    items.add(new SalaryListItem(salary.getPost(),salary.getPerformance(),salary.getWorkYearSalary(),salary.getAllowance(),
                            salary.isFlag(),salary.getTime()));
                }
                if(salaryList.size()!=0){
                    message = new Message(1,"ok",items);
                }else{
                    message = new Message(0,"不存在该员工信息");
                }
            }
        }
        SqlSessionUtil.closeSession();
        String json = JsonUtil.toJSON(message);
        return json;
    }

    private String checkNUll(String username,String password,String email,String verifyCode){
       if(username==null||username==""){
           return "请输入用户名";
       }
       else if(password==null||password==""){
           return "请输入密码";
       }
       else if (email==null||email==""){
           return "请输入邮箱";
       }else if (verifyCode==null||verifyCode==""){
           return "请输入邮箱验证码";
       }else{
           return null;
       }
    }
}
