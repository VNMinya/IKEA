package com.NJXZ_Tourist.service;


import com.NJXZ_Tourist.po.MyUser;
import com.NJXZ_Tourist.po.UserForm;

import java.util.List;

public interface UserService {
	boolean login(MyUser user);
	boolean register(MyUser user);

	List<MyUser> listAllUsers();
}
