package com.njxzc.controller.admin;


import com.njxzc.service.admin.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/adminOrder")
public class AdminOrderController extends BaseController {
    @Autowired
    private AdminOrderService adminOrderService;
    @RequestMapping("/orderInfo.do")
    public String orderInfo(Model model){
        return adminOrderService.orderInfo(model);
    }
    @RequestMapping("/deleteorderManager.do")
    public String deleteorderManager(Integer id){
        return adminOrderService.deleteorderManager(id);
    }
}
