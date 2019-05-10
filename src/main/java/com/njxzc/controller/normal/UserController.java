package com.njxzc.controller.normal;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.njxzc.po.Buser;
import com.njxzc.service.normal.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
//    @RequestMapping(value = {"/newUser"}, method = RequestMethod.GET)
//    public String save(HttpServletResponse response, ModelMap model) {
//        Buser buser = new Buser();
//        model.addAttribute("buser", buser);
//        return "buseradd";
//    }
//    public ModelAndView handler() {
//        return new ModelAndView("buseradd").addObject(new Buser());
//    }
    @RequestMapping("/register.do")
    public String register(@ModelAttribute("buser") Buser buser, Model model, HttpSession session, String code) {
        return userService.register(buser, model, session, code);
    }
    @RequestMapping("/login.do")
    public String login(@ModelAttribute("buser") Buser buser, Model model, HttpSession session, String code) {
        return userService.login(buser, model, session, code);
    }
    @RequestMapping("/exit.do")
    public String exit(HttpSession session) {
        session.invalidate();
        return "forward:/before.do";
    }

}