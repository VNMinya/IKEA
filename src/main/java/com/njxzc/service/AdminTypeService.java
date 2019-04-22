package com.njxzc.service;

import com.njxzc.dao.AdminTypeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public class AdminTypeService {

    @Autowired
    AdminTypeDao adminTypeDao;

    public String toAddType(Model model){
        model.addAttribute("allTypes", adminTypeDao.selectGoodsType());
        return "admin/addType";
    }

    public String addType(String typename, Model model, HttpSession session){
        adminTypeDao.addType(typename);
        //添加商品与修改商品页面使用

        session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
        return "forward:/adminType/toAddType";
    }

    //toDeleteType
    public String toDeleteType(Model model){
        model.addAttribute("allTypes", adminTypeDao.selectGoodsType());
        return "admin/deleteType";
    }

    //deleteType
    public String deleteType(Integer id, Model model){
        //类型有关联
        if(adminTypeDao.selectGoodsByType(id).size()>0){
            model.addAttribute("msg", "类型有关联，不允许删除！");
            return "forward:/adminType/toDeleteType";
        }
        if(adminTypeDao.deleteType(id)>0){
            model.addAttribute("msg", "类型成功删除！");
            //返回删除界面
            return "forward:/adminType/toDeleteType";
        }
        //啥都不干 返回删除界面
        model.addAttribute("msg", "没有删除操作！");
        return "forward:/adminType/toDeleteType";
    }
}
