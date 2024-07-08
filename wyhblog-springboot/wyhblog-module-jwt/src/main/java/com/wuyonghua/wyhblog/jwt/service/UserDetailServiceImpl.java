package com.wuyonghua.wyhblog.jwt.service;

import com.wuyonghua.wyhblog.common.constant.MessageConstant;
import com.wuyonghua.wyhblog.common.domain.doc.UserDO;
import com.wuyonghua.wyhblog.common.domain.doc.UserRoleDO;
import com.wuyonghua.wyhblog.common.domain.mapper.UserMapper;
import com.wuyonghua.wyhblog.common.domain.mapper.UserRoleMapper;
import com.wuyonghua.wyhblog.jwt.exception.UsernameOrPasswordNullException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author 吴勇华
 * @description: TODO
 */
@Service
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 从数据库中查询
        UserDO userDO = userMapper.findByUsername(username);
        // 判断用户是否存在
        if (Objects.isNull(userDO)) {
            throw new UsernameOrPasswordNullException(MessageConstant.USER_IS_NULL);
        }

        // 查询用户juese
        List<UserRoleDO> userRoleDOS = userRoleMapper.selectByUsername(username);
        String[] roleAll = null;
        if (!CollectionUtils.isEmpty(userRoleDOS)) {
            List<String> roles = userRoleDOS.stream().map(e -> e.getRole()).collect(Collectors.toList());
            roleAll = roles.toArray(new String[roles.size()]);
        }
        // authorities 用于指定角色
        return User.withUsername(userDO.getUsername())
                .password(userDO.getPassword())
                .authorities(roleAll)
                .build();

    }
}
