package com.njxzc.dao;

import com.njxzc.po.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("userCenterDao")
@Mapper
/*使用Spring自动扫描MyBatis的接口并装配
（Spring将指定包中所有被@Mapper注解标注的接口自动装配为MyBatis的映射接口*/
public interface UserCenterDao {
    /**
     * 接口方法对应SQL映射文件UCM.xml中的id
     */
    public List<Map<String, Object>> myOrder(Integer bid);
    public List<Map<String, Object>> myFocus(Integer bid);
    public List<Map<String, Object>> orderDetail(Integer ordersn);
}
