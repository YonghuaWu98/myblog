package com.wuyonghua.wyhblog.common.exception;


/*
 * 通用异常类
 **/
public interface BaseExceptionInterface {
    //获取异常码
    String getErrorCode();
    //获取异常信息
    String getErrorMessage();

}
