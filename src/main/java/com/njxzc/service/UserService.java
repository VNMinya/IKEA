package com.njxzc.service;


import com.njxzc.po.Auser;
import com.njxzc.po.Buser;
import com.njxzc.po.MyUser;
import com.njxzc.po.UserForm;
import org.springframework.ui.Model;

import java.util.List;

public interface UserService {
	boolean login(Auser user);
	boolean register(Auser user);

	//List<MyUser> listAllUsers();

	public String deleteuserManager(Integer id, Model model);


	public int addUser(Auser user);
	public List<Auser> listAllAUsers();

	boolean login(Buser user);
	boolean register(Buser user);

	public int addUser(Buser user);
	public List<Buser> listAllBUsers();
}
