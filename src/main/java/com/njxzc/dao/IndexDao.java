package com.njxzc.dao;

import com.njxzc.po.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("indexDao")
@Mapper
/*使用Spring自动扫描MyBatis的接口并装配
（Spring将指定包中所有被@Mapper注解标注的接口自动装配为MyBatis的映射接口*/
public interface IndexDao {
	/**
	 * 接口方法对应SQL映射文件IM.xml中的id
	 */
	public List<Map<String, Object>> getSaleOrder();
	public List<Map<String, Object>> getFocusOrder();
	public List<Map<String, Object>> selectNotice();
	public List<Map<String, Object>> getLastedGoods(Goods goods);
	public Goods selectGoodsById(Integer id);
	public List<Goods> search(String mykey);
}
