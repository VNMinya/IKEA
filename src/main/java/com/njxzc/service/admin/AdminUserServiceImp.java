package com.njxzc.service.admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.njxzc.dao.AdminUserDao;
import com.njxzc.dao.CartDao;
import com.njxzc.dao.UserCenterDao;

@Service("adminUserService")
@Transactional
public class AdminUserServiceImp implements AdminUserService{
    @Autowired
    private AdminUserDao adminUserDao;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private UserCenterDao userCenterDao;
    @Override
    public String userInfo(Model model) {
        model.addAttribute("userList", adminUserDao.userInfo());
        return "admin/userManager";
    }
    @Override
    public String deleteuserManager(Integer id, Model model) {

        //用户是否有关联
        if(cartDao.selectCart(id).size() > 0 || userCenterDao.myFocus(id).size() > 0|| userCenterDao.myOrder(id).size() > 0) {
            model.addAttribute("msg", "用户有关联，不能删除");
            return "forward:/adminUser/userInfo.do";
        }
        if(adminUserDao.deleteuserManager(id) > 0)
            model.addAttribute("msg", "删除成功！");
        return "forward:/adminUser/userInfo.do";
    }

}