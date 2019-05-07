package com.njxzc.service.admin;

import com.njxzc.po.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface AdminGoodsService{
    public String addOrUpdateGoods(Goods goods, HttpServletRequest request, String updateAct);
    public String selectGoods(Model model, Integer pageCur, String act);
    public String selectAGoods(Model model, Integer id, String act);
    public String deleteGoods(Integer ids[], Model model);
    public String deleteAGoods(Integer id, Model model);
}
