package com.jd.app.controller;


import com.jd.app.beans.LogBean;
import com.jd.app.service.ILogService;
import com.jd.app.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("/log")
@Slf4j
public class LogController {

    @Resource
    private ILogService logServiceImpl;
//,produces = "application/json;charset=UTF-8"
    @RequestMapping(value = "/allLog")
    @ResponseBody
    public Map allLog(HttpServletRequest request) {
        try {
            String version_name = request.getParameter("version_name");
            List<LogBean> logBeans = logServiceImpl.selectAllLog(version_name);
            return ResponseUtil.ok(logBeans);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseUtil.fail("日志查询失败");
    }



}
