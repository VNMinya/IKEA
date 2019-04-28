package com.njxzc.dao;

import com.njxzc.po.Auser;
import com.njxzc.po.GoodsType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adminTypeDao")
@Mapper
/*使用Spring自动扫描MyBatis的接口并装配
（Spring将指定包中所有被@Mapper注解标注的接口自动装配为MyBatis的映射接口*/
public interface AdminTypeDao {
	/**
	 * 接口方法对应SQL映射文件ATD.xml中的id
	 */
	public List<GoodsType> selectGoodsType();
	public void addType(String type);
	public int deleteType(Integer id);
	public List<GoodsType> selectGoodsByType(Integer id);
}
