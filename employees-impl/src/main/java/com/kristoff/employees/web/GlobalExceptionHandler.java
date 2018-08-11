package com.kristoff.employees.web;

import com.kristoff.common.vo.BasicResponseVO;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public BasicResponseVO exceptionHandler(HttpServletRequest request, Exception e) {
        String uuid = UUID.randomUUID().toString();
        if(e == null) {
            return BasicResponseVO.error("system error", "未知错误");
        }
        LOGGER.error(uuid, e);
        return BasicResponseVO.error(uuid,"system error", e);
    }
}
