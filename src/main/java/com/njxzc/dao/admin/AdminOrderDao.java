package com.njxzc.dao.admin;

import com.njxzc.po.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("orderdao")
@Mapper
public interface AdminOrderDao {
    public int deleteOrderDetail(Integer id);
    public int deleteOrderBase(Integer id);

    public List<Map<String,Object>> orderInfo();
}
