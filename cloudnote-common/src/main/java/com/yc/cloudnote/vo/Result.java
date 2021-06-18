package com.yc.cloudnote.vo;

import lombok.Data;

@Data
public class Result {
    private int code; //结果码
    private String msg; //返回消息
    private Object data;

    public Result(){}

    public Result(int code, String msg, Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    public static Result success(String msg,Object data){
        return new Result(1,msg,data);
    }
    public static Result failure(String msg,Object data){
        return new Result(0,msg,data);
    }

}
