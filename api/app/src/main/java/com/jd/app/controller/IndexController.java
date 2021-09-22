package com.jd.app.controller;
import com.jd.app.service.ICategoryService;
import com.jd.app.service.IGoodsService;
import com.jd.app.service.IRecommendService;
import com.jd.core.annotation.NotLogin;
import com.jd.core.annotation.UserId;
import com.jd.dao.beans.Category;
import com.jd.dao.beans.Recommend;
import com.jd.dao.beans.User;
import com.jd.core.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
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

    @Resource
    IRecommendService recommendService;
    @Resource
    IGoodsService goodsService;
    @Resource
    ICategoryService categoryService;

    //列表
    @RequestMapping(value = "/list")
    @ResponseBody
    @NotLogin
    public Map list(@NotNull Integer user_id) throws Exception {
        List<Recommend> list = recommendService.queryRecommend(user_id);
        List<Category> categoryList = categoryService.queryL1Category();
        Map map = new HashMap();
        map.put("recommends",list);
        map.put("categorys",categoryList);
        return ResponseUtil.ok(map);
    }

    @RequestMapping(value = "/hello")
    public ModelAndView allLog(HttpServletRequest request) {
        List userList = new ArrayList();
        User user1 = new User();
        user1.setUser_id(10);
        user1.setUser_name("JD1");
        User user2 = new User();
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
