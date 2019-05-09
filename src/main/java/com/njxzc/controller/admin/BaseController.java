package com.njxzc.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.njxzc.exception.AdminLoginNoException;

@Controller
public class BaseController {
    /**
     * 登陆权限控制，在处理方法执行前执行该方法
     * @param session
     * @param request
     * @throws AdminLoginNoException
     */

    @ModelAttribute
    public void isLogin(HttpSession session, HttpServletRequest request) throws AdminLoginNoException {
        if(session.getAttribute("auser") == null) {
            throw new AdminLoginNoException("没有登陆");
        }
    }
}
