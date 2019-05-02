package com.njxzc.service.before;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
@Service("orderservice")
public interface OrderService {
	public String orderSubmit(Model model, HttpSession session, Double amount);
	public String pay(Integer ordersn);
}
