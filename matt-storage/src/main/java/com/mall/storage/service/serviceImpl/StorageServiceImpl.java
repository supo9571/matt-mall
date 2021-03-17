package com.mall.storage.service.serviceImpl;

import com.mall.storage.dao.StorageDao;
import com.mall.storage.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    /**
     * 扣减库存
     */
    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId,count);
//        int i = 10/0;
    }
}
