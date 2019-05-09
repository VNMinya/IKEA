package com.njxzc.service.normal;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface UserCenterService {
    public String userCenter(HttpSession httpSession, Model model);
    public String orderDetail(Model model, Integer integer);
}
