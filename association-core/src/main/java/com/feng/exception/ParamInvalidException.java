package com.feng.exception;

import com.feng.enums.ErroEnum;
import com.feng.error.CommonError;

/**
 * Created by rf on 2019/3/10.
 */
public class ParamInvalidException extends RuntimeException implements CommonError{
    private String msg;
    private int code;

    public ParamInvalidException(ErroEnum erroEnum) {
        this.code = erroEnum.getCode();
        this.msg= erroEnum.getMsg();
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
