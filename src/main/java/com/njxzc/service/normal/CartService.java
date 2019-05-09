package com.njxzc.service.normal;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface CartService {
    public String focus(Model model, Integer id, HttpSession session);
    public String putCart(Model model,Integer shoppingnum, Integer id, HttpSession session);
    public String selectCart(Model model, HttpSession session);
    public String deleteAgoods(Integer id,HttpSession session);
    public String clear(HttpSession session);
    public String orderConfirm(Model model, HttpSession session);
}