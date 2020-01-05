package com.feng.exception;

import com.feng.enums.ErrorEnum;
import com.feng.error.CommonError;

/**
 * Created by rf on 2019/3/10.
 */
public class ParamInvalidException extends RuntimeException implements CommonError{
    private String msg;
    private int code;

    public ParamInvalidException(ErrorEnum errorEnum) {
        this.code = errorEnum.getCode();
        this.msg= errorEnum.getMsg();
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
