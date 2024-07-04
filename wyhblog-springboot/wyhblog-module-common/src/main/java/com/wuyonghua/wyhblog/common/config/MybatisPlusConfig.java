package com.wuyonghua.wyhblog.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.wuyonghua.wyhblog.common.domain.mapper")
public class MybatisPlusConfig {
}
