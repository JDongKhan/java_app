package com.jd.app.config;

import com.alibaba.fastjson.JSON;
import com.jd.app.annotation.NotLogin;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();

        //默认都是需要登录的
        NotLogin notLogin = method.getAnnotation(NotLogin.class);
        if (notLogin != null) {
            return true;
        }

        if (method.getName().equals("error") && method.getDeclaringClass() == BasicErrorController.class) {
            sendToResponse(response,"401","方法不存在");
            return  false;
        }

        //单台机器
        Object user = request.getSession().getAttribute("user");
        //分布式机器
//        String sessionID = readCookieValue(request,"session_id");
//        HttpSession session = SessionContext.getInstance().getSession(sessionID);
//        Object user = session.getAttribute("user");
        if (user == null) {
//            request.setAttribute("msg", "无权限请先登录");
//            request.getRequestDispatcher("/index.html").forward(request, response);
            sendToResponse(response,"403.1","未登录");
//            response.sendRedirect(request.getContextPath()+"index.html");
            //如果设置为false时，被请求时，拦截器执行到此处将不会继续操作
            //如果设置为true时，请求将会继续执行后面的操作
            return false;
        } else {
            return true;
        }
    }
    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }
    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }

    void sendToResponse(HttpServletResponse response,String code, String message) throws IOException {
        response.setHeader("Access-Control-Allow-Credentials","true");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        Map map = new HashMap();
        map.put("code",code);
        map.put("message",message);
        String json = JSON.toJSONString(map);
        response.getWriter().print(json);
    }

    String readCookieValue(HttpServletRequest request,String key){
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie cookie : cookies){
            if (cookie.getName().equals(key)) {
                return  cookie.getValue();
            }
        }
        return null;
    }
}
