package com.mo.common.api;

/**
 * Created by mo on 2023/12/21
 * 封装API的错误码
 */
public interface IErrorCode {

    long getCode();

    String getMessage();
}
