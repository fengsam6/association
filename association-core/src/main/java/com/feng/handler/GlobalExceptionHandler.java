package com.feng.handler;

import com.feng.entity.ResponseResult;
import com.feng.enums.ErroEnum;
import com.feng.exception.AuthenticationFailException;
import com.feng.exception.BusinessException;
import com.feng.exception.ParamInvalidException;
import com.feng.util.ResponseResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BindException.class)
    public ResponseResult handleBindException(BindException e) {
        // ex.getFieldError():随机返回一个对象属性的异常信息。如果要一次性返回所有对象属性异常信息，则调用ex.getAllErrors()
        FieldError fieldError = e.getFieldError();
        String msg = fieldError.getDefaultMessage();
        e.printStackTrace();
        // 生成返回结果
        return ResponseResultUtil.renderError(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(e.getMessage()));
    }

    @ExceptionHandler(AuthenticationFailException.class)
    public ResponseResult handleAuthenticationFailException(AuthenticationFailException e) {
        log.error("----------{}---- ----",e.getMessage());
        e.printStackTrace();
        return ResponseResultUtil.renderError(e);
    }
    @ExceptionHandler(ParamInvalidException.class)
    public ResponseResult paramInvalidExceptionHandler(ParamInvalidException e) {
        log.error("----------{}---- ----",e.getMessage());
        e.printStackTrace();
        return ResponseResultUtil.renderError(e);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseResult IllegalArgumentExceptionHandler(IllegalArgumentException e) {
        log.error("----------{}---- ----",e.getMessage());
        e.printStackTrace();
        return ResponseResultUtil.renderError(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("----------{}---------------------------",e.getMessage());
        e.printStackTrace();
        return ResponseResultUtil.renderError(ErroEnum.INVALIDATE_PARAM_EXCEPTION.setMsg(e.getMessage()));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseResult businessExceptionHandler(BusinessException e) {
        log.error("{}",e.getMsg());
        e.printStackTrace();
        return ResponseResultUtil.renderError(e);
    }



    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(Exception e) {
        log.error("----------{}---- ----",e.getMessage());
        e.printStackTrace();
        return ResponseResultUtil.renderError(ErroEnum.UN_KNOW_EXCEPTION);
    }
}
