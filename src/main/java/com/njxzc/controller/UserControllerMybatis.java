package com.njxzc.controller;

import java.util.List;

import com.njxzc.po.Auser;
import com.njxzc.po.Buser;
import org.springframework.stereotype.Controller;
import com.njxzc.dao.UserDao;
import com.njxzc.po.MyUser;
import javax.annotation.Resource;

@Controller(value = "UserControllerMybatis")
/**
 *
 */
public class UserControllerMybatis {
	@Resource
	private UserDao userDao;
	public void test() {
		/**
		 * 根据id查询人员
		 */
		Auser auser = userDao. selectUserByName("1");
		System.out.println(auser);
		System.out.println("================");
		/**
		 * 根据name查询人员
		 */
//		List<MyUser> li = userDao.selectUserByName("陈恒");
//		for (MyUser myUser : li) {
//			System.out.println(myUser);
//		}
		// 添加一个用户
		Auser addmu = new Auser();
		addmu.setAname("陈恒");
		addmu.setApwd("111111");
		int add = userDao.addUser(addmu);
		System.out.println("添加了" + add + "条记录");
		System.out.println("================");
		// 修改一个用户
		Auser updateUser = new Auser();
		updateUser.setAname("张三");
		updateUser.setApwd("123456");
		int up = userDao.updateUser(updateUser);
		System.out.println("修改了" + up + "条记录");
		System.out.println("================");
		// 删除一个用户
		int dl = userDao.deleteAUser(9);
		System.out.println("删除了" + dl + "条记录");
		System.out.println("================");
		// 查询所有用户
		List<Auser> list = userDao.selectAllAUser();
		for (Auser Auser : list) {
			System.out.println(Auser);
		}
	}


	
}
