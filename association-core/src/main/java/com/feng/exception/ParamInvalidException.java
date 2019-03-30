package com.feng.exception;

import com.feng.enums.ExceptionEnum;
import com.feng.error.CommonError;

/**
 * Created by rf on 2019/3/10.
 */
public class ParamInvalidException extends RuntimeException implements CommonError{
    private String msg;
    private int code;

    public ParamInvalidException(ExceptionEnum exceptionEnum) {
        this.code = exceptionEnum.getCode();
        this.msg= exceptionEnum.getMsg();
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
