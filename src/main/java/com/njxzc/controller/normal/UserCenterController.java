package com.njxzc.controller.normal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.njxzc.service.normal.UserCenterService;

@Controller
public class UserCenterController extends BaseNormalController {

    @Autowired
    private UserCenterService userCenterService;

    @RequestMapping("/userCenter")
    public String userCenter(HttpSession session, Model model) {
        return userCenterService.userCenter(session, model);
    }

    @RequestMapping("/orderDetail")
    public String orderDetail(Model model, Integer ordersn) {
        return userCenterService.orderDetail(model, ordersn);
    }
}