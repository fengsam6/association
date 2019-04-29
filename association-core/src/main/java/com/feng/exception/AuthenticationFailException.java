package com.feng.exception;

import com.feng.enums.ErroEnum;
import com.feng.error.CommonError;

/**
 * Created by rf on 2019/4/23.
 */
public class AuthenticationFailException extends RuntimeException implements CommonError {
    private int code;
    private String msg;
    public AuthenticationFailException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public AuthenticationFailException(ErroEnum erroEnum) {
        this(erroEnum.getCode(), erroEnum.getMsg());
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
