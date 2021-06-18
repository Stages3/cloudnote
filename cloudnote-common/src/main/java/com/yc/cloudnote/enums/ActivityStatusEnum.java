package com.yc.cloudnote.enums;

import lombok.Getter;

@Getter
public enum ActivityStatusEnum {
    NEW(0,"未开始"),FINISHED(1,"进行中"),CANCEL(2,"已结束");
    private Integer code;
    private String message;

    ActivityStatusEnum(Integer code, String message){
        this.code=code;
        this.message=message;
    }
}
