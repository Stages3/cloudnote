package com.yc.cloudnote.enums;

import lombok.Getter;

@Getter
public enum ActivityDetailEnum {
    NEW(0,"审核中"),FINISHED(1,"通过"),CANCEL(2,"未通过"),DELETE(3,"删除");
    private Integer code;
    private String message;

    ActivityDetailEnum(Integer code, String message){
        this.code=code;
        this.message=message;
    }
}
