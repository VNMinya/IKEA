package com.njxzc.controller.admin;

import com.njxzc.service.admin.AdminTypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/adminType")
public class AdminTypeController {
    @Autowired
    AdminTypeServiceImp adminTypeService;

    /**
     * 添加类型页面
     */

    @RequestMapping("/toAddType")
    public String toAddType(Model model){
        return "admin/addType";
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
