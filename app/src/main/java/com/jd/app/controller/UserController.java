package com.jd.app.controller;


import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jd.app.service.IUserService;
import com.jd.app.beans.UserBean;
import com.jd.app.utils.ResponseUtil;
import com.jd.app.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@CrossOrigin
@Controller
@RequestMapping("/user")
@Slf4j
@Validated
public class UserController  {

    @Resource
    private IUserService userServiceImpl;

    //登录
    @RequestMapping(value = "/login")
    @ResponseBody
    public Map login(HttpServletRequest request, HttpServletResponse response, @NotNull String user_account, @NotNull String user_password) {
        log.info("user_account = " + user_account + "; user_password = " + user_password);
        UserBean u = null;
        try {
            u = userServiceImpl.login(user_account, user_password);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseUtil.fail(e.getMessage().toString());
        }

        if (u != null) {
            log.info(u.toString());
            Cookie cookie = new Cookie("session_id",request.getSession().getId());
            cookie.setMaxAge( 7 * 24 * 60 * 60);//7天过期
            cookie.setHttpOnly(true);
            response.addCookie(cookie);
            request.getSession().setAttribute("user", u);
            UserBean userBean = new UserBean();
            userBean.setUser_id(userBean.getUser_id());
            //更新登录时间
            userBean.setLast_login_time(LocalDateTime.now());
            try {
                userServiceImpl.updateUser(userBean);
            } catch (Exception e) {
                log.error(e.getMessage());
            }
            return ResponseUtil.ok(u);
        } else {
            return ResponseUtil.fail("账号或密码出错！");
        }
    }

    //注册
    @RequestMapping(value = "/register")
    @ResponseBody
    public Map registerAccount(@NotNull(message = "账号不能为空") String user_account,
                               @NotNull(message = "密码不能为空") String user_password,
                               @NotNull(message = "用户名不能为空") String user_name,
                               String user_phone) {
        try {

            UserBean tmp = userServiceImpl.queryUserByAccount(user_account);
            if (tmp != null) {
                return ResponseUtil.fail("您的账号已被注册！");
            }

            UserBean user = new UserBean();
            user.setUser_account(user_account);
            user.setUser_name(user_name);
            user.setUser_password(user_password);
            user.setUser_phone(user_phone);


            int result = userServiceImpl.registerAccount(user);
            if (result > 0) {
                return ResponseUtil.ok(user);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return ResponseUtil.fail("注册失败！");
    }



    //查询用户列表
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Map userList() {
        try {
            List<UserBean> users = userServiceImpl.queryAllUser();
            return ResponseUtil.ok(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseUtil.fail("查询用户列表失败");
    }


    //查询单个用户
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    @ResponseBody
    public Map userByID(@NotNull Integer user_id) {
        try {
            UserBean user = userServiceImpl.queryUserByID(user_id);
            return ResponseUtil.ok(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseUtil.fail("账号或密码出错！");
    }

    //更新单个用户信息
    @RequestMapping(value = "/update")
    @ResponseBody
    public Map updateUser(@NotNull Integer user_id,String user_password, String user_name,String user_phone) {
        try {
            if (user_name == null && user_password == null && user_phone == null) {
                return ResponseUtil.fail("更新失败！(参数缺失)");
            }
            UserBean user = new UserBean();
            user.setUser_id(Integer.valueOf(user_id));
            user.setUser_name(user_name);
            user.setUser_password(user_password);
            user.setUser_phone(user_phone);
            int result = userServiceImpl.updateUser(user);
            if (result == 0) {
                return ResponseUtil.fail("更新失败！");
            }
            return ResponseUtil.ok(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return ResponseUtil.fail("更新用户失败！");
    }

    //退出
    @RequestMapping(value = "/logout")
    @ResponseBody
    public Map logout(HttpServletRequest request) {
        try {
            request.getSession().setAttribute("user", null);
            return ResponseUtil.ok("退出成功",null);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return ResponseUtil.fail("退出失败！");
    }

    //注销
    @RequestMapping(value = "/logoff")
    @ResponseBody
    public Map logoff(HttpServletRequest request, @NotNull(message = "用户ID不能为空") Integer user_id) {
        try {
            request.getSession().setAttribute("user", null);
            int result =  userServiceImpl.deleteUser(user_id);
            if (result == 0) {
                return ResponseUtil.fail("注销失败");
            }
            return ResponseUtil.ok("注销成功",null);
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return ResponseUtil.fail("注销失败！");
    }

    ///获取ip
    private static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
           int index = ip.indexOf(",");
           if(index != -1){
               return ip.substring(0,index);
           }else{
               return ip;
           }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }

}
