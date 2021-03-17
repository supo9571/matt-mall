package com.mall.storage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.mall.storage.dao"})
public class MybatisConfig {
}
