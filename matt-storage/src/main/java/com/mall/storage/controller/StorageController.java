package com.mall.storage.controller;

import com.mall.storage.service.StorageService;
import com.mall.common.entity.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    @GetMapping("/storage/decrease")
    public RestResult decrease(Long productId, Integer count){
        int i = 10/0;
        storageService.decrease(productId, count);
        return RestResult.success();
    }
}
