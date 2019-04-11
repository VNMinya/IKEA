package com.njxzc.service;


import com.njxzc.po.MyUser;
import com.njxzc.po.UserForm;

import java.util.List;

public interface UserService {
	boolean login(MyUser user);
	boolean register(MyUser user);

	List<MyUser> listAllUsers();
}
