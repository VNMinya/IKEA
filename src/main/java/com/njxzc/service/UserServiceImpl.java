package com.njxzc.service;

import java.util.List;
import cn.hutool.core.util.ObjectUtil;
import com.njxzc.po.Auser;
import com.njxzc.po.Buser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.njxzc.dao.UserDao;
import com.njxzc.po.MyUser;
import com.njxzc.po.UserForm;
import org.springframework.ui.Model;

//注解为一个服务
@Service
public class UserServiceImpl implements UserService {
	//@Autowired
	private UserDao userdao;

	@Override
	public boolean login(Auser user) {
		// 此处修改成dao操作
		Auser u = userdao.selectUserByName(user.getAname());
		if (ObjectUtil.isNotNull(u)) {
			System.out.println(u.getAname());
			System.out.println(user.getAname());
			System.out.println(u.getApwd());
			System.out.println(user.getApwd());
			if (user.getAname().equals(u.getAname()) && user.getApwd().equals(u.getApwd()))
				return true;
		}
		return false;
	}

	@Override
	public boolean login(Buser user) {
		// 此处修改成dao操作
		Buser u = userdao.selectUserById(user.getId());
		if (ObjectUtil.isNotNull(u)) {
			System.out.println(u.getBemail());
			System.out.println(user.getBemail());
			System.out.println(u.getBpwd());
			System.out.println(user.getBpwd());
			if (user.getId().equals(u.getId()) && user.getBpwd().equals(u.getBpwd()) && user.getBemail().equals(u.getBemail()))
				return true;
		}
		return false;
	}

	@Override
	public boolean register(Auser user) {
		Auser u = userdao.selectUserByName(user.getAname());
		if (ObjectUtil.isNotNull(u)) {
			return false;

		} else {
			userdao.addUser(user);
			return true;
		}

	}

	@Override
	public boolean register(Buser user) {
		Buser u = userdao.selectUserById(user.getId());
		if (ObjectUtil.isNotNull(u)) {
			return false;

		} else {
			userdao.addUser(user);
			return true;
		}

	}


	@Override
	public int addUser(Auser user) {
		//定义SQL数据库操作语句
		String sql= "insert into user(aname,apwd) value(?,?)";
		//定义数组来储存SQL语句中的参数
		Object obj =new Object[] {
				user.getAname(),
				user.getApwd(),
		};
		//执行添加操作，返回的是受SQL语句影响的记录条数
		int num=this.userdao.selectAllAUser().size();
//		updateUser(sql, obj);
		return num;
	}

	@Override
	public int addUser(Buser user) {
		//定义SQL数据库操作语句
		String sql= "insert into user(aname,apwd) value(?,?)";
		//定义数组来储存SQL语句中的参数
		Object obj =new Object[] {
				user.getId(),
				user.getBemail(),
				user.getBpwd(),
		};
		//执行添加操作，返回的是受SQL语句影响的记录条数
		int num=this.userdao.selectAllBUser().size();
//		updateUser(sql, obj);
		return num;
	}


	@Override
	public String deleteuserManager(Integer id, Model model) {
		//用户有关联
//		if (cartDao.selectCart(id).size() > 0 ||
//				userCenterDao.myFocus(id).size() > 0 ||
//				userCenterDao.myOrder(id).size() > 0) {
//			model.addAttribute("msg", "用户有关联，不能删除！");
//			return "forward:/adminUser/userInfo";
//		}
		if (userdao.deleteAUser(id) > 0)
			model.addAttribute("msg", "成功删除用户！");
		return "forward:/adminUser/userInfo";
	}


	@Override
	public List<Auser> listAllAUsers() {
		List<Auser> us=userdao.selectAllAUser();
		return us;
	}

	@Override
	public List<Buser> listAllBUsers() {
		List<Buser> us=userdao.selectAllBUser();
		return us;
	}

}
