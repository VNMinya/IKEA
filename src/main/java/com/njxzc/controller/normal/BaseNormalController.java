package com.njxzc.controller.normal;

import com.njxzc.exception.UserLoginNoException;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseNormalController {
    /**
     * 前台用户登录权限控制，在处理方法执行前执行该方法
     * @throw UserLoginNoException
     */

    @ModelAttribute
    public void isLogin(HttpSession httpSession, HttpServletRequest httpServletRequest) throws UserLoginNoException {
        if(httpSession.getAttribute("bruser") == null){
            throw new UserLoginNoException("没有登陆");
        }
    }
}
