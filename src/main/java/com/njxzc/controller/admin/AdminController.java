package com.njxzc.controller.admin;

import javax.servlet.http.HttpSession;

import com.njxzc.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.njxzc.po.Auser;
import com.njxzc.service.admin.AdminServiceImp;

/**
 * 管理员登陆
 */
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/admin.do")
    public String toLogin(@ModelAttribute Auser auser) {
        return "admin/login";
    }

    @RequestMapping("/admin/login.do")
    public String login(@ModelAttribute Auser auser, Model model, HttpSession session) {
        return adminService.login(auser, model, session);
    }

    @RequestMapping("/exit.do")
    public String exit(@ModelAttribute Auser auser,HttpSession session) {
        session.invalidate();
        return "admin/login";
    }
}
