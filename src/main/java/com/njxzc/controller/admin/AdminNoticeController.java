package com.njxzc.controller.admin;

import com.njxzc.po.Notice;
import com.njxzc.service.admin.AdminNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminNotice")
public class AdminNoticeController extends BaseController{
	@Autowired
	private AdminNoticeService adminNoticeService;
	@RequestMapping("/toAddNotice.do")
	public String toAddNotice(Model model) {
		model.addAttribute("notice", new Notice());
		return "admin/addNotice";
	}
	@RequestMapping("/addNotice.do")
	public String addNotice(@ModelAttribute Notice notice) {
		return adminNoticeService.addNotice(notice);
	}
	@RequestMapping("/deleteNoticeSelect.do")
	public String deleteNoticeSelect(Model model) {
		return adminNoticeService.deleteNoticeSelect(model);
	}
	@RequestMapping("/selectANotice.do")
	public String selectANotice(Model model, Integer id) {
		return adminNoticeService.selectANotice(model, id);
	}
	@RequestMapping("/deleteNotice.do")
	public String deleteNotice(Integer id) {
		return adminNoticeService.deleteNotice(id);
	}
}
