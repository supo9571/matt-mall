package com.mall.order.controller;

import com.mall.common.entity.RestResult;
import com.mall.order.service.OrderService;
import com.mall.order.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/order/creatOrder")
    public RestResult creatOrder(Long userId, Long productId,
                             Integer count, BigDecimal money,Integer status){
        orderService.create(userId,productId,count,money,status);
        redisTemplate.opsForValue().set(String.valueOf(userId),String.valueOf(productId),5, TimeUnit.MINUTES);
        return RestResult.success();
    }

    @GetMapping("/order/get")
    public RestResult getOrder(Long id){
        return RestResult.success(id);
    }


}
