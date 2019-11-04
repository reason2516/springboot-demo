package com.wmx.demo.springbootdemo.common;


public class ResponseDTO<T> {
    public static Integer CODE_OK = 0;
    public static Integer CODE_ERROR = 1000;

    private Integer code;
    private T data;
    private String message;

    public static ResponseDTO ok() {
        return new ResponseDTO<>(null);
    }

    public static <T> ResponseDTO<T> ok(T data) {
        return new ResponseDTO<>(data);
    }

    public static <T> ResponseDTO<T> ok(T data, String message) {
        return new ResponseDTO<>(CODE_OK, data, message);
    }



    public static <T> ResponseDTO<T> error(Integer bizCode, T data, String message) {
        return new ResponseDTO<>(bizCode, data, message);
    }


    private ResponseDTO(Integer apiCode, T data, String message) {
        this.setCode(apiCode);
        this.setData(data);
        this.setMessage(message);
    }

    private ResponseDTO(T data) {
        this.setCode(CODE_OK);
        this.setData(data);
        this.setMessage("");
    }

    private ResponseDTO(Integer apiCode, String message) {
        this.setCode(apiCode);
        this.setMessage(message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseDTO [code=" + code + ", data=" + data + ", message=" + message + "]";
    }

}
