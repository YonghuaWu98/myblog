package com.wuyonghua.wyhblog.admin.service.impl;

import com.wuyonghua.wyhblog.admin.model.vo.user.FindUserInfoRspVO;
import com.wuyonghua.wyhblog.admin.model.vo.user.UpdateAdminUserPasswordReqVO;
import com.wuyonghua.wyhblog.admin.service.AdminUserService;
import com.wuyonghua.wyhblog.common.domain.mapper.UserMapper;
import com.wuyonghua.wyhblog.common.enums.ResponseCodeEnum;
import com.wuyonghua.wyhblog.common.utils.Response;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author 吴勇华
 * @description: TODO
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private PasswordEncoder passwordEncoder;


    /*
     * 修改用户密码
     * @return: Response
     **/
    public Response updatePassword(UpdateAdminUserPasswordReqVO updateAdminUserPasswordReqVO) {
        String username = updateAdminUserPasswordReqVO.getUsername();
        String password = updateAdminUserPasswordReqVO.getPassword();
        // 加密密码
        String encodePassword = passwordEncoder.encode(password);
        int count = userMapper.updatePasswordByUsername(username, encodePassword);

        return count == 1 ? Response.success() : Response.fail(ResponseCodeEnum.USERNAME_NOT_FOUND);
    }

    /*
     * 获取当前用户信息
     * @return: Response
     **/
    public Response queryUserInfo() {
        // 获取存储在 ThreadLocal 中的用户信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // 拿到用户名
        String username = authentication.getName();

        return Response.success(FindUserInfoRspVO.builder().username(username).build());
    }
}
