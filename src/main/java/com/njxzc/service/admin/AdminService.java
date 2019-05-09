package com.njxzc.service.admin;

import com.njxzc.po.Auser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

public interface AdminService {
    public String login(Auser auser, Model model, HttpSession session);
}
