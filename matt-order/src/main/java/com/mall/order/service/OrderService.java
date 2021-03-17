package com.mall.order.service;

import java.math.BigDecimal;

public interface OrderService {
    void create(Long userId, Long productId,Integer count, BigDecimal money, Integer status);
}
