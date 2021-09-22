package com.jd.core.config;

import com.jd.core.utils.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

@RestControllerAdvice
@Slf4j
@Order(value = Ordered.LOWEST_PRECEDENCE)
public class GlobalExceptionHandler {


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public Object badArgumentHandler(IllegalArgumentException e) {
        e.printStackTrace();
        Object res = ResponseUtil.badArgumentValue();
        log.info(res.toString());
        return res;
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseBody
    public Object badArgumentHandler(IllegalStateException e) {
        e.printStackTrace();
        Object res = ResponseUtil.serious();
        log.info(res.toString());
        return res;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public Object badArgumentHandler(MethodArgumentTypeMismatchException e) {
        e.printStackTrace();
        Object res = ResponseUtil.badArgumentValue();
        log.info(res.toString());
        return res;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public Object badArgumentHandler(MissingServletRequestParameterException e) {
        e.printStackTrace();
        Object res = ResponseUtil.badArgumentValue();
        log.info(res.toString());
        return res;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public Object badArgumentHandler(HttpMessageNotReadableException e) {
        e.printStackTrace();
        Object res = ResponseUtil.badArgumentValue();
        log.info(res.toString());
        return res;
    }

    @ExceptionHandler(javax.validation.ValidationException.class)
    @ResponseBody
    public Object badArgumentHandler(ValidationException e) {
//        e.printStackTrace();
        if (e instanceof ConstraintViolationException) {
            ConstraintViolationException exs = (ConstraintViolationException) e;
            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            for (ConstraintViolation<?> item : violations) {
                String message = item.getMessageTemplate();
                if (message == null || message.contains("javax.validation")) {
                    message = ((PathImpl) item.getPropertyPath()).getLeafNode().getName() +":"+ item.getMessage();
                }
                log.info(message);
                return ResponseUtil.fail(402, message);
            }
        }
        return ResponseUtil.badArgumentValue();
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object seriousHandler(Exception e) {
        e.printStackTrace();
        log.info(e.getMessage());
        return ResponseUtil.serious();
    }
}
