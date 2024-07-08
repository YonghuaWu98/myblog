package com.wuyonghua.wyhblog.web.controller;

import com.wuyonghua.wyhblog.common.aspect.ApiOperationLog;
import com.wuyonghua.wyhblog.common.utils.JsonUtil;
import com.wuyonghua.wyhblog.common.utils.Response;
import com.wuyonghua.wyhblog.web.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@RestController
@Slf4j
@Api(tags = "首页模块")
public class TestController {


    @PostMapping("/admin/update")
    @ApiOperationLog(description = "测试更新接口")
    @ApiOperation(value = "测试更新接口")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Response testUpdate() {
        log.info("更新成功...");
        return Response.success();
    }

}
