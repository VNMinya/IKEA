package com.njxzc.service.normal;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
@Service("orderservice")
public interface OrderService {
	public String orderConfirm(Model model,HttpSession httpSession);
	public String orderSubmit(Model model, HttpSession session, Double amount);
	public String pay(Integer ordersn);
}
