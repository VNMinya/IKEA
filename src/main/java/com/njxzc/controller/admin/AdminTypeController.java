package com.njxzc.controller.admin;

import com.njxzc.service.admin.AdminTypeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 商品类型管理
 */
@Controller
@RequestMapping("/adminType")
public class AdminTypeController extends BaseController {
    @Autowired
    AdminTypeServiceImp adminTypeService;

    /**
     * 添加类型页面
     */

    @RequestMapping("/toAddType.do")
    public String toAddType(Model model){
        return "admin/addType.do";
    }

    /**
     * 添加类型
     */
    @RequestMapping("/addType.do")
    public String addType(String typename, Model model, HttpSession session){
        return adminTypeService.addType(typename, model, session);
    }

    /**
     * 到删除页面
     */
    @RequestMapping("/toDeleteType.do")
    public String toDeleteType(Model model){
        return adminTypeService.toDeleteType(model);
    }

    /**
     * 删除类型
     */
    @RequestMapping("/deleteType.do")
    public String deleteType(Integer id, Model model){
        return adminTypeService.deleteType(id, model);
    }
}
