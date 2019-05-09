package com.njxzc.service.normal;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.njxzc.dao.UserCenterDao;
import com.njxzc.utils.MyUtil;

@Service("userCenterService")
@Transactional
public class UserCenterServiceImp implements UserCenterService{
    @Autowired
    private UserCenterDao userCenterDao;

    @Override
    public String userCenter(HttpSession httpSession, Model model) {
        model.addAttribute("myOrder", userCenterDao.myOrder(MyUtil.getUserId(httpSession)));
        model.addAttribute("myFocus", userCenterDao.myFocus(MyUtil.getUserId(httpSession)));
        return "before/userCenter";
    }
    @Override
    public String orderDetail(Model model, Integer integer) {
        model.addAttribute("myOrderDetail", userCenterDao.orderDetail(integer));
        return "before/userOrderDetail";
    }

}

