package com.controller.before;

import javax.servlet.http.HttpSession;

import com.njxzc.controller.normal.BaseNormalController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.njxzc.service.normal.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseNormalController{
    @Autowired
    private OrderService orderService;

    @RequestMapping("/orderSubmit.do")
    public String orderSubmit(Model model, HttpSession session,Double amount) {
        return orderService.orderSubmit(model, session, amount);
    }

    @RequestMapping("/pay.do")
    public String pay(Integer ordersn) {
        return orderService.pay(ordersn);
    }
}