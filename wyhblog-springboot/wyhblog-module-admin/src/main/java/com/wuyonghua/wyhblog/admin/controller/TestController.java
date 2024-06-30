package com.wuyonghua.wyhblog.admin.controller;

import com.wuyonghua.wyhblog.common.aspect.ApiOperationLog;
import com.wuyonghua.wyhblog.common.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("adminTestController")
@Slf4j
@Api(tags = "后台模块")
public class TestController {
    @PostMapping("/login")
    @ApiOperationLog(description = "用户登录")
    @ApiOperation(value = "用户登录")
    public Response test(@RequestBody @Validated User user) {
        return Response.success();
    }
}
