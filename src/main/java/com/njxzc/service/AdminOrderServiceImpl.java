package com.njxzc.service;

import com.njxzc.dao.AdminOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

public class AdminOrderServiceImpl implements AdminOrderService{
    @Autowired
    private AdminOrderDao adminOrderDao;
    @Override
    public String orderInfo(Model model){
        List<Map<String,Object>> list=adminOrderDao.orderInfo();
        model.addAttribute("orderList",list);
        return "admin/orderManager";
    }
    @Override
    public String deleteorderManager(Integer id){
        adminOrderDao.deleteOrderDetail(id);
        adminOrderDao.deleteOrderBase(id);
        return "forward:/adminOrder/orderInfo";
    }
}