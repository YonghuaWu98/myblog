package com.wuyonghua.wyhblog.jwt.handler;

import com.wuyonghua.wyhblog.common.utils.Response;
import com.wuyonghua.wyhblog.jwt.model.LoginRspVO;
import com.wuyonghua.wyhblog.jwt.util.JwtTokenHelper;
import com.wuyonghua.wyhblog.jwt.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 吴勇华
 * @description: 自定义认证成功处理器
 */
@Component
@Slf4j
public class RestAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private JwtTokenHelper jwtTokenHelper;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 从 authentication 对象中获取用户的 UserDetails 实例，这里是获取用户的用户名
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        // 通过用户名生成 token
        String username = userDetails.getUsername();
        String token = jwtTokenHelper.generateToken(username);
        // 返回 Token
        LoginRspVO loginRspVO = LoginRspVO.builder().token(token).build();

        ResultUtil.ok(response, Response.success(loginRspVO));
    }
}
