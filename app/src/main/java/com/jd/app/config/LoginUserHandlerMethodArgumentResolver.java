package com.jd.app.config;

import com.jd.app.annotation.UserId;
import com.jd.app.beans.UserBean;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(Integer.class)
                && parameter.hasParameterAnnotation(UserId.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container, NativeWebRequest request,
                                  WebDataBinderFactory factory) throws Exception {
        HttpServletRequest rq = (HttpServletRequest)request.getNativeRequest(HttpServletRequest.class);
        Object user = rq.getSession().getAttribute("user");
        if (user == null) {
            return 0;
        }
        UserBean userBean = (UserBean)user;
        return userBean.getUser_id();
    }
}
