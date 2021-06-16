package com.jwt;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: zsg
 * @Date: 2020/12/23
 */
@Getter
@Setter
public class ResException extends RuntimeException {
    protected String code = "400";
    private String msg = "系统处理异常，请稍后重试！";
    public ResException() {
        super();
    }

    public ResException(String msg) {
        super(msg);
    }

    public ResException(String code, String msg ) {
        super(msg);
        this.code = code;
        this.msg = msg;

    }

}
