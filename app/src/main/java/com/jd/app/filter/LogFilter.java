package com.jd.app.filter;




import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "LogFilter", urlPatterns = "/*")
@Slf4j
public class LogFilter implements Filter {

    String NO_LOGIN = "您还未登录";

    public void destroy() {

    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain arg2) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) arg0;
        HttpServletResponse res = (HttpServletResponse) arg1;
        String uri = req.getServletPath();
        HttpSession session = req.getSession(false);
        log.info("请求地址:" + uri);
        arg2.doFilter(arg0, arg1);//
    }

    /**
     * 获取链接的后缀名
     * @return
     */
    private static String parseSuffix(String url) {
        int index =  url.lastIndexOf(".");
        if (index >= 0) {
            String suffix = url.substring(index);
            return suffix;
        }
        return "/";
    }

    public void init(FilterConfig arg0) throws ServletException {

    }

}