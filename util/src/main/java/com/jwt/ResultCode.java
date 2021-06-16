package com.jwt;

import lombok.Getter;

/** */
@Getter
public enum ResultCode {

  USER_NOT_LOGGED_IN(20001, "用户未登录");
  private Integer code;

  private String message;

  ResultCode(Integer code, String message) {
    this.code = code;
    this.message = message;
  }
}
