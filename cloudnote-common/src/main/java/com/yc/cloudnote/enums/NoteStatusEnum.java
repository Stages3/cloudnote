package com.yc.cloudnote.enums;

import lombok.Getter;

@Getter
public enum NoteStatusEnum {
    NEW(0,"未分享"),FINISHED(1,"审核中"),CANCEL(2,"已分享");
    private Integer code;
    private String message;

    NoteStatusEnum(Integer code, String message){
        this.code=code;
        this.message=message;
    }
}
