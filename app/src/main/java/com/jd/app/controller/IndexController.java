package com.jd.app.controller;
import com.jd.app.annotation.NotLogin;
import com.jd.app.annotation.UserId;
import com.jd.app.beans.UserBean;
import com.jd.app.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/index")
@Slf4j
@Validated
public class IndexController {

    //列表
    @RequestMapping(value = "/list")
    @ResponseBody
    @NotLogin
    public Map list(@UserId Integer user_id){
        Map map = new HashMap();
        List list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add("string " + i);
        }
        map.put("items",list);
        return ResponseUtil.ok(map);
    }

    @RequestMapping(value = "/hello")
    public ModelAndView allLog(HttpServletRequest request) {
        List userList = new ArrayList();
        UserBean user1 = new UserBean();
        user1.setUser_id(10);
        user1.setUser_name("JD1");
        UserBean user2 = new UserBean();
        user2.setUser_id(20);
        user2.setUser_name("JD2");
        userList.add(user1);
        userList.add(user2);

        ModelAndView mv = new ModelAndView();
        mv.addObject("userList",userList);
        mv.addObject("msg","无权限请先登录");
        mv.setViewName("index");
        return mv;
    }
}
