package com.mall.order.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mall.common.entity.RestResult;


public class CustomerBlockHandler {
    public static RestResult handlerException(BlockException exception)
    {
        return new RestResult(4444,"按客戶自定义,global handlerException----1");
    }
    public static RestResult handlerException2(BlockException exception)
    {
        return new RestResult(4444,"按客戶自定义,global handlerException----2");
    }
}
