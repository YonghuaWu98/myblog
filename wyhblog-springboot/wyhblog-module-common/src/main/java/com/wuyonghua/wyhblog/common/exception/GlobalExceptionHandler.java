package com.wuyonghua.wyhblog.common.exception;
/*
 * 全局异常处理类
 *
 **/

import com.wuyonghua.wyhblog.common.enums.ResponseCodeEnum;
import com.wuyonghua.wyhblog.common.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 捕获自定义业务异常
     * @return: Response<Object>
     **/
    @ExceptionHandler({BizException.class})
    @ResponseBody
    public Response<Object> handleBizException(HttpServletRequest request, BizException e) {
        log.warn("{} request fail, errorCode: {}, errorMessage: {}", request.getRequestURI(),
                e.getErrorCode(), e.getErrorMessage());
        return Response.fail(e);
    }
    /**
     * 不属于其他自定义异常，则当作 Exception 进行处理
     * @return: Response<Object>
     **/
    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Response<Object> handleException(HttpServletRequest request, Exception ex) {
        log.warn("{} request fail", request.getRequestURI(), ex);
        return Response.fail(ResponseCodeEnum.SYSTEM_ERROR);
    }
    /**
     * 捕获参数校验异常
     * @return: Response<Object>
     **/
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Response<Object> handleMethodArgumentNotValidException(HttpServletRequest request,
                                                                  MethodArgumentNotValidException me) {


        // 参数错误异常码
        String errorCode = ResponseCodeEnum.PARAM_NOT_VALID.getErrorCode();

        // 获取 BindingResult
        BindingResult bindingResult = me.getBindingResult();

        StringBuilder sb = new StringBuilder();

        // 获取校验不通过的字段，并组合错误信息， 格式为： eamil 邮箱格式不正确， 当前值：’1669254825@qq.com'
        Optional.ofNullable(bindingResult.getFieldErrors()).ifPresent(errors -> {
            errors.forEach(
                    error -> sb.append(error.getField())
                                    .append(" ")
                                    .append(error.getDefaultMessage())
                                    .append(", 当前值： '")
                                    .append(error.getRejectedValue())
                                    .append("',")
            );
        });
        // 错误信息
        String errorMessage = sb.toString();

        log.warn("{} request error, errorCode: {}, errorMessage: {}", request.getRequestURI(), errorCode, errorMessage);

        return Response.fail(errorCode, errorMessage);
    }
}
