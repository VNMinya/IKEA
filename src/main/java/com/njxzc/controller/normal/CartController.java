package com.njxzc.controller.normal;

import javax.servlet.http.HttpSession;

import com.njxzc.service.normal.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartController extends BaseNormalController{
	@Autowired
	private CartService cartService;
	/**
	 * ��ע��Ʒ
	 */
	@RequestMapping("/focus.do")
	public String focus(Model model,Integer id, HttpSession session) {
		return cartService.focus(model, id, session);
	}
	/**
	 * ��ӹ��ﳵ
	 */
	@RequestMapping("/putCart.do")
	public String putCart(Model model,Integer shoppingnum, Integer id, HttpSession session) {
		return cartService.putCart(model, shoppingnum, id, session);
	}
	/**
	 * ��ѯ���ﳵ
	 */
	@RequestMapping("/selectCart.do")
	public String selectCart(Model model, HttpSession session) {
		return cartService.selectCart(model, session);
	}
	/**
	 * ɾ�����ﳵ
	 */
	@RequestMapping("/deleteAgoods.do")
	public String deleteAgoods(Integer id,HttpSession session) {
		return cartService.deleteAgoods(id, session);
	}
	/**
	 * ��չ��ﳵ
	 */
	@RequestMapping("/clear.do")
	public String clear(HttpSession session) {
		return cartService.clear(session);
	}
	/**
	 * ȥ����
	 */
	@RequestMapping("/orderConfirm.do")
	public String orderConfirm(Model model, HttpSession session) {
		return cartService.orderConfirm(model, session);
	}
}
