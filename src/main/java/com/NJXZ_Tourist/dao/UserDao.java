package com.NJXZ_Tourist.dao;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.NJXZ_Tourist.po.MyUser;
@Repository("userDao")
@Mapper
/*使用Spring自动扫描MyBatis的接口并装配
（Spring将指定包中所有被@Mapper注解标注的接口自动装配为MyBatis的映射接口*/
public interface UserDao {
	/**
	 * 接口方法对应SQL映射文件UserMapper.xml中的id
	 */
	public MyUser selectUserById(Integer uid);
	public MyUser selectUserByName(String uname);
	public List<MyUser> selectUserByUname(MyUser user);
	public List<MyUser> selectAllUser();
	public int addUser(MyUser user);
	public int updateUser(MyUser user);
	public int deleteUser(Integer uid);
}
