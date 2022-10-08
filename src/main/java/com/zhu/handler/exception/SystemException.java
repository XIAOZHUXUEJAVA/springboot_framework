package com.zhu.handler.exception;

import com.zhu.enums.AppHttpCodeEnum;

/**
 * 全局异常
 * @author xiaozhu
 * @date 2022年10月03日 23:40                          $
 */
public class SystemException extends RuntimeException{

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public SystemException(AppHttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum.getMsg());
        this.code = httpCodeEnum.getCode();
        this.msg = httpCodeEnum.getMsg();
    }

}
