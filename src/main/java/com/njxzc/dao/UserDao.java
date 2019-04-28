package com.njxzc.dao;
import java.util.List;


import com.njxzc.po.Auser;
import com.njxzc.po.Buser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Repository("userDao")
@Mapper
/*使用Spring自动扫描MyBatis的接口并装配
（Spring将指定包中所有被@Mapper注解标注的接口自动装配为MyBatis的映射接口*/
public interface UserDao {
	/**
	 * 接口方法对应SQL映射文件UserMapper.xml中的id
	 */
	//public MyUser selectUserById(Integer uid);
//	public MyUser selectUserByName(String uname);

	//public List<MyUser> selectAllUser();
	public int addUser(Auser user);

	public int updateUser(Auser user);

	public int deleteAUser(Integer uid);

	public int addUser(Buser user);

	public int updateUser(Buser user);

	public int deleteBUser(Integer uid);

	public Auser selectUserByName(String uname);

	public List<Auser> selectAllAUser();

	public Buser selectUserById(Integer id);

	public Buser selectUserByMail(String bemail);

	public List<Buser> selectAllBUser();


}
