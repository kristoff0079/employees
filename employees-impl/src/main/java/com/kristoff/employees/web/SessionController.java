package com.kristoff.employees.web;

import com.kristoff.common.vo.BasicResponseVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * 测试Spring Session与Redis功能
 * @author Kristoff
 */
@RestController
@RequestMapping("/session")
public class SessionController {

    @ResponseBody
    @GetMapping(path = "/sessionInfo",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BasicResponseVO sessionInfo(HttpSession session) {
        UUID uuid = (UUID) session.getAttribute("uid");
        if(uuid == null) {
            uuid = UUID.randomUUID();
            session.setAttribute("uid", uuid);
        }
        String sessionId = session.getId();
        return BasicResponseVO.ok(sessionId);
    }

}
