package com.njxzc.controller;

import java.util.List;

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
		MyUser auser = userDao.selectUserById(1);
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
		MyUser addmu = new MyUser();
		addmu.setUname("陈恒");
		addmu.setUserage(34);
		addmu.setUsex("男");
		int add = userDao.addUser(addmu);
		System.out.println("添加了" + add + "条记录");
		System.out.println("================");
		// 修改一个用户
		MyUser updatemu = new MyUser();
		updatemu.setUid(1);
		updatemu.setUname("张三");
		updatemu.setUsex("女");
		int up = userDao.updateUser(updatemu);
		System.out.println("修改了" + up + "条记录");
		System.out.println("================");
		// 删除一个用户
		int dl = userDao.deleteUser(9);
		System.out.println("删除了" + dl + "条记录");
		System.out.println("================");
		// 查询所有用户
		List<MyUser> list = userDao.selectAllUser();
		for (MyUser myUser : list) {
			System.out.println(myUser);
		}
	}

	
}
