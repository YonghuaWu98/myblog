package com.wuyonghua.wyhblog;

import com.wuyonghua.wyhblog.common.domain.doc.UserDO;
import com.wuyonghua.wyhblog.common.domain.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@Slf4j
@SpringBootTest
class WyhblogWebApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
    }

    @Test
    void insertTest() {
        UserDO userDO = UserDO.builder()
                .username("wuyonghua")
                .password("123456")
                .createTime(new Date())
                .updateTime(new Date())
                .isDeleted(false)
                .build();
        userMapper.insert(userDO);
    }

}
