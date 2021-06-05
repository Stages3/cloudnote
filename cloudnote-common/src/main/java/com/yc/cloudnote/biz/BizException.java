package com.yc.cloudnote.biz;

/**
 * @description: 自定义的业务异常
 * @author:
 * @create: 2021-05-19 18:50
 */
public class BizException extends Exception{
    public BizException() {
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    public BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
