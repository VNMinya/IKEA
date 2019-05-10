package com.njxzc.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.njxzc.service.admin.AdminUserService;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController extends BaseController {

    @Autowired
    private AdminUserService adminUserService;

    @RequestMapping("/userInfo.do")
    public String userInfo(Model model) {
        return adminUserService.userInfo(model);
    }

    @RequestMapping("/deleteuserManager.do")
    public String deleteuserManager(Integer id, Model model) {
        return adminUserService.deleteuserManager(id, model);
    }
}
