package com.njxzc.controller.normal;

import com.njxzc.po.Buser;
import com.njxzc.po.Goods;
import com.njxzc.service.normal.IndexService;
import com.njxzc.service.normal.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("")
public class IndexController {
    @Autowired
    private IndexService indexService;
    @Autowired
    private UserService userService;

    /**
     * 首页
     */
    @RequestMapping("/before.do")
    public String before(Model model, HttpSession httpSession, Goods goods){
        return indexService.before(model, httpSession, goods);
    }

    /**
     * 首页搜索
     */
    @RequestMapping("/search.do")
    public String search(Model model, String mykey){
        return indexService.search(model, mykey);
    }

    /**
     * 转到注册界面
     */
    @RequestMapping("/toRegister.do")
    public String toRegister(Model model){
//        model.addAttribute("buser", new Buser());
        return indexService.toRegister(model);
    }

    /**
     * 转到登录页面
     */
    @RequestMapping("/toLogin.do")
    public String toLogin(Model model) {
//        model.addAttribute("buser", new Buser());
        return indexService.toLogin(model);
    }

    /**
     * 转到公告页面
     */
    @RequestMapping("/selectANotice.do")
    public String selectANotice(Model model,Integer id) {
        return indexService.selectANotice(model, id);
    }

    /**
     * 转到商品详情页
     */
    @RequestMapping("/goodsDetail.do")
    public String goodsDetail(Model model, Integer integer){
        return indexService.goodsDetail(model, integer);
    }
}
