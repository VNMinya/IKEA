package com.njxzc.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.njxzc.dao.UserDao;
import com.njxzc.po.Auser;
import com.njxzc.po.Buser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.njxzc.po.MyUser;
import com.njxzc.service.UserService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class UserController {
    @Autowired
    private UserService UserService;
    @RequestMapping("/deleteuserManager")
    public String deleteuserManager(Integer id,Model model) {
        return UserService.deleteuserManager(id, model);
    }
}
