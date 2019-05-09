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
@RequestMapping("/index")
public class IndexController extends BaseNormalController {
    @Autowired
    private IndexService indexService;
    @Autowired
    private UserService userService;

    /**
     * 首页
     */
    @RequestMapping("/before")
    public String before(Model model, HttpSession httpSession, Goods goods){
        return indexService.before(model, httpSession, goods);
    }

    /**
     * 首页搜索
     */
    @RequestMapping("/search")
    public String search(Model model, String mykey){
        return indexService.search(model, mykey);
    }

    /**
     * 转到注册界面
     */
    //TODO 没写userService
    @RequestMapping("/toRegister")
    public String toRegister(Model model){
        return indexService.toRegister(model);
    }

    /**
     * 转到商品详情页
     */
    @RequestMapping("/goodsDetail")
    public String goodsDetail(Model model, Integer integer){
        return indexService.goodsDetail(model, integer);
    }
}
