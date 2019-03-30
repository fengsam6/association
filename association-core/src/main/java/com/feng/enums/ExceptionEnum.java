package com.feng.enums;

import com.feng.error.CommonError;
import com.feng.exception.BusinessException;

/**
 * Created by rf on 2019/3/10.
 */
public enum ExceptionEnum implements CommonError {
    UN_KNOW_EXCEPTION(1001, "未知异常！"),
    INVALIDATE_EXCEPTION(2001, "参数异常！"),
    BUSINESS_EXCEPTION(3001,"业务异常");

    private int code;
    private String msg;

    ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ExceptionEnum setMsg(String msg) {
        this.msg = msg;
        return this;
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

