package com.wuyonghua.wyhblog.common.utils;


import com.wuyonghua.wyhblog.common.exception.BaseExceptionInterface;
import com.wuyonghua.wyhblog.common.exception.BizException;
import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {

    //是否成功， 默认为 true
    private boolean success = true;
    //相应信息
    private String message;
    //异常码
    private String errorCode;
    //相应数据
    private T data;

    //========================================================= 成功响应 =================================================
    public static <T> Response<T> success() {
        Response<T> response = new Response<T>();
        return response;
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<T>();
        response.setData(data);
        return response;
    }
    //========================================================= 失败响应 =================================================
    public static <T> Response<T> fail() {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        return response;
    }
    public static <T> Response<T> fail(String message) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }

    public static <T> Response<T> fail(String message, String errorCode) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setMessage(message);
        response.setErrorCode(errorCode);
        return response;
    }

    public static <T> Response<T> fail(BizException bizException) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(bizException.getErrorCode());
        response.setMessage(bizException.getErrorMessage());
        return response;
    }

    public static <T> Response<T> fail(BaseExceptionInterface baseExceptionInterface) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(baseExceptionInterface.getErrorCode());
        response.setMessage(baseExceptionInterface.getErrorMessage());
        return response;
    }
}
