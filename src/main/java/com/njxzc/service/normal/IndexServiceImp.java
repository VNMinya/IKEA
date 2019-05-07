package com.njxzc.service.normal;

import com.njxzc.dao.AdminGoodsDao;
import com.njxzc.dao.AdminTypeDao;
import com.njxzc.dao.IndexDao;
import com.njxzc.po.Buser;
import com.njxzc.po.Goods;
import com.njxzc.service.admin.AdminGoodsService;
import com.njxzc.utils.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IndexServiceImp implements IndexService{
    @Autowired
    private IndexDao indexDao;
    @Autowired
    private AdminTypeDao adminTypeDao;

    @Override
    public String before(Model model, HttpSession session, Goods goods) {
        session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
        model.addAttribute("salelist", indexDao.getSaleOrder());
        model.addAttribute("focuslist", indexDao.getFocusOrder());
        model.addAttribute("noticelist", indexDao.selectNotice());
        if(goods.getId() == null)
            goods.setId(0);
        model.addAttribute("lastedlist", indexDao.getLastedGoods(goods));
        return "before/index";
    }

    @Override
    public String toRegister(Model model) {
        model.addAttribute("rbuser", new Buser());
        return "before/register";
    }

    @Override
    public String toLogin(Model model) {
        model.addAttribute("lbuser", new Buser());
        return "before/login";
    }

    @Override
    public String goodsDetail(Model model, Integer id) {
        Goods goods = indexDao.selectGoodsById(id);
        model.addAttribute("goods", goods);
        return "before/goodsdetail";
    }

    @Override
    public String search(Model model, String mykey) {
        List<Goods> list = indexDao.search(mykey);
        model.addAttribute("searchlist", list);
        return "before/searchResult";
    }
}
