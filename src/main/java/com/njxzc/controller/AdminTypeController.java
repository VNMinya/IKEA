package com.njxzc.controller;

import com.njxzc.service.AdminTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AdminTypeController {
    @Autowired
    AdminTypeService adminTypeService;

    /**
     * 添加类型页面
     */

    @RequestMapping("/toAddType")
    public String toAddType(Model model){
        return adminTypeService.toAddType(model);
    }

    /**
     * 添加类型
     */
    @RequestMapping("/addType")
    public String addType(String typename, Model model, HttpSession session){
        return adminTypeService.addType(typename, model, session);
    }

    /**
     * 到删除页面
     */
    @RequestMapping("/toDeleteType")
    public String toDeleteType(Model model){
        return adminTypeService.toDeleteType(model);
    }

    /**
     * 删除类型
     */
    @RequestMapping("/deleteType")
    public String deleteType(Integer id, Model model){
        return adminTypeService.deleteType(id, model);
    }
}
