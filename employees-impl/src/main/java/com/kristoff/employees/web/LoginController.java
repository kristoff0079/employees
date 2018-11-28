package com.kristoff.employees.web;

import com.kristoff.common.vo.BasicResponseVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;


@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/login")
    @ResponseBody
    public BasicResponseVO login(String username, String password) {
        LOGGER.info("username = {0}, password = {1}", new Object[] {username, password});
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            Serializable sessionId = subject.getSession().getId();
            return BasicResponseVO.ok(sessionId);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            BasicResponseVO.error("登录错误", e);
        }
        return BasicResponseVO.ok();
    }

    @GetMapping("/logout")
    @ResponseBody
    public BasicResponseVO logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return BasicResponseVO.ok("logout");
    }

    @GetMapping("/unlogin")
    @ResponseBody
    public BasicResponseVO unlogin() {
        return BasicResponseVO.error("401", "未登录");
    }
}
