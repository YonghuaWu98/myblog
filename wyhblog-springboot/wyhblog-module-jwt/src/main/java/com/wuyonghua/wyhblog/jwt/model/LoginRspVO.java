package com.wuyonghua.wyhblog.jwt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 吴勇华
 * @description: 响应类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRspVO {
    /**
     * Token 值
     */
    private String token;

}
