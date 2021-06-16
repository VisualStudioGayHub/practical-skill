package com.jwt;

/**
 * @Author: zsg
 * @Date: 2020/12/23
 */
public class LogicException extends ResException {
    public LogicException() {
        super();
    }

    public LogicException(String code, String msg) {
        super(code,msg);
    }

    public LogicException(String msg) {
        super("400",msg);
    }

}
