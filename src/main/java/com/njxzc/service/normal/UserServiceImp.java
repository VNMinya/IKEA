package com.njxzc.service.normal;

import java.util.List;
import javax.servlet.http.HttpSession;
import com.njxzc.service.normal.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import com.njxzc.dao.UserDao;
import com.njxzc.po.Buser;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service("userService")
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public String register(@ModelAttribute("buser") Buser buser, Model model, HttpSession session, String code) {
        if(!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
            model.addAttribute("codeError", "验证码错误！");
            return "before/register";
        }
        int n = userDao.register(buser);
        if(n > 0) {
            return "before/login";
        }else {
            model.addAttribute("msg", "注册失败！");
            return "before/register";
        }
    }
    @Override
    public String login(Buser buser, Model model, HttpSession session, String code) {
        if(!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
            model.addAttribute("msg", "验证码错误！");
            return "before/login";
        }
        Buser ruser = null;
        List<Buser> list = userDao.login(buser);
        if(list.size() > 0) {
            ruser = list.get(0);
        }
        if(ruser != null) {
            session.setAttribute("bruser", ruser);
            return "forward:/before";
        }else {
            model.addAttribute("msg", "用户名或密码错误！");
            return "before/login";
        }
    }
}