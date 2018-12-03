package com.kristoff.employees.web;

import com.kristoff.common.vo.BasicResponseVO;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public BasicResponseVO exceptionHandler(HttpServletRequest request, Exception e) {
        String uuid = UUID.randomUUID().toString();
        if(e == null) {
            return BasicResponseVO.error("system error", "未知错误");
        }

        if(e instanceof UnauthenticatedException) {
            return BasicResponseVO.error("403","未登录");
        }

        if(e instanceof UnauthorizedException) {
            return BasicResponseVO.error("403", "没有权限");
        }

        LOGGER.error(uuid, e);
        return BasicResponseVO.error(uuid,"system error", e);
    }
}
