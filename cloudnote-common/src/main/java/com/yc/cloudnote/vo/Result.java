package com.yc.cloudnote.vo;

import lombok.Data;

/**
 * @description:
 * @author:
 * @create: 2021-05-19 18:42
 */
@Data
public class Result {
    private int code;   //结果码： 1 成功、0 失败
    private String msg;
    private Object data;

    public Result() { }

    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(String msg, Object data){
        return new Result(1,msg,data);
    }

    public static Result failure(String msg, Object data){
        return new Result(0,msg,data);
    }
}
