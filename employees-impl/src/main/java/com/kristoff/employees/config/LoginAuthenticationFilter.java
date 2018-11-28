package com.kristoff.employees.config;

import com.alibaba.fastjson.JSONObject;
import com.kristoff.common.vo.BasicResponseVO;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginAuthenticationFilter extends FormAuthenticationFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginAuthenticationFilter.class);

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        LOGGER.info("=====================onAccessDenied===");
        HttpServletResponse resp = WebUtils.toHttp(response);
        HttpServletRequest  req = WebUtils.toHttp(request);
        Subject subject = this.getSubject(request, response);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        String messageCode = null;
        String messageText = null;
        if(subject.getPrincipal() == null) {
            messageCode = "403";
            messageText = "未登录";
        } else {
            messageCode = "403";
            messageText = "未验证";
        }
        BasicResponseVO responseVO =
                BasicResponseVO.error(messageCode, messageText);
        String json = JSONObject.toJSONString(responseVO);
        PrintWriter out = resp.getWriter();
        out.write(json);
        out.flush();
        out.close();
        return false;
    }
}
