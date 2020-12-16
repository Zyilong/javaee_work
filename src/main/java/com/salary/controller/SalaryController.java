package com.salary.controller;

import com.salary.bean.LoginBody;
import com.salary.bean.Message;
import com.salary.dao.UserDao;
import com.salary.util.JsonUtil;
import com.salary.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

@Controller
@RequestMapping("/api/salary")
public class SalaryController {


}
