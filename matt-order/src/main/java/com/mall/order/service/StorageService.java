package com.mall.order.service;

import com.mall.common.entity.RestResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "matt-storage")
public interface StorageService {

    @GetMapping(value = "/storage/decrease")
    RestResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
