package com.mall.order.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface OrderDao {
    //1 新建订单
    void create(@Param("userId") Long userId,@Param("productId") Long productId,
                @Param("count")Integer count,@Param("money") BigDecimal money,@Param("status") Integer status);

    //2 修改订单状态
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
