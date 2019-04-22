package com.njxzc.dao;

import com.njxzc.po.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("orderdao")
@Mapper
public interface AdminOrderDao {
    public boolean deleteOrderDetail(Integer id);
    public boolean deleteOrderBase(Integer id);
    public List<Map<String,Object>> orderInfo();
}
