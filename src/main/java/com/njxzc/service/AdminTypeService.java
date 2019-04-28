package com.njxzc.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

public interface AdminTypeService {
    public void toAddType(Model model);
    public String addType(String typename, Model model, HttpSession session);
    //toDeleteType
    public String toDeleteType(Model model);
    //deleteType
    public String deleteType(Integer id, Model model);
}
