package com.mall.order.service.serviceImpl;

import com.mall.order.dao.OrderDao;
import com.mall.order.service.OrderService;
import com.mall.order.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Long userId, Long productId,
                       Integer count, BigDecimal money, Integer status) {
        orderDao.create(userId,productId,count,money,status);
        storageService.decrease(productId,count);
    }
}
