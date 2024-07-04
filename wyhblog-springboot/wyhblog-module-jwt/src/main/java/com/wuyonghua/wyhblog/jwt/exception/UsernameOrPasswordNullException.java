package com.wuyonghua.wyhblog.jwt.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * @author 吴勇华
 * @description: TODO
 */
public class UsernameOrPasswordNullException extends AuthenticationException {


    public UsernameOrPasswordNullException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public UsernameOrPasswordNullException(String msg) {
        super(msg);
    }
}
