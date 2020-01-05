package com.feng.exception;

import com.feng.enums.ErrorEnum;
import com.feng.error.CommonError;

/**
 * Created by rf on 2019/3/10.
 */
public class BusinessException extends RuntimeException implements CommonError {
    private int code;
    private String msg;

    public BusinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public BusinessException(ErrorEnum errorEnum) {
       this(errorEnum.getCode(), errorEnum.getMsg());
    }
    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
