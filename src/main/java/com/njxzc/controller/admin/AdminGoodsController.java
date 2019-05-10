package com.njxzc.controller.admin;

import com.njxzc.po.Goods;
import com.njxzc.service.admin.AdminGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 商品管理
 */
@Controller
@RequestMapping("/adminGoods")
public class AdminGoodsController extends BaseController {
    @Autowired
    AdminGoodsService adminGoodsService;

    /**
     * add页面初始化
     */
    @RequestMapping("/toAddGoods.do")
    public String toAddGoods(Model model){
        model.addAttribute("goods", new Goods());
        return "admin/addGoods";
    }

    /**
     * 添加与修改
     */
    @RequestMapping("/addGoods.do")
    public String addGoods(@ModelAttribute Goods goods, HttpServletRequest request, String updateAct){
        return adminGoodsService.addOrUpdateGoods(goods, request, updateAct);
    }

    /**
     * 查询商品
     */
    @RequestMapping("/selectGoods.do")
    public String selectGoods(Model model, Integer pageCur, String act){
        return adminGoodsService.selectGoods(model, pageCur, act);
    }

    /**
     * 查询一个名片
     */
    @RequestMapping("/selectAGoods.do")
    public String selectAGoods(Model model, Integer id, String act){
        return adminGoodsService.selectAGoods(model, id, act);
    }

    /**
     * 删除多个商品
     */
    @RequestMapping("/deleteGoods.do")
    public String deleteGoods(Integer id[], Model model) {
        return adminGoodsService.deleteGoods(id, model);
    }

    /**
     * 删除一个商品
     */
    @RequestMapping("/deleteAGoods.do")
    public String deleteAGoods(Integer id, Model model) {
        return adminGoodsService.deleteAGoods(id, model);
    }
}
//TODO admin界面商品详情有问题 & 删除商品有问题

//TODO normal商品关注+购买界面需要调整 + 测试上传图片