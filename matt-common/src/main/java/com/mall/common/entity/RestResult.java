package com.mall.common.entity;



import lombok.Data;

import java.util.HashMap;


/**
 * 统一返回格式
 */
@Data
public class RestResult<T> {

    private int code;
    private T data;
    private String message;

    /** 请求成功 */
    public RestResult() {
        this.code = 1;
        this.message = "SUCCESS";
    }

    public RestResult(int code, T data) {
        this.code = code;
        this.data = data;
    }

    /** 请求成功 */
    public RestResult(T data) {
        this.code = 1;
        this.data = data;
        this.message = "SUCCESS";
    }

    public RestResult(int code, String message) {
        this.code = code;
        if (code == 1) {
            this.message = "SUCCESS";
        } else if (code == 500) {
            this.message = "ERROR";
        } else {
            this.message = message;
        }
    }

    public RestResult(int code, T data, String message) {
        this.code = code;
        this.data = data;
        if (code == 1) {
            this.message = "SUCCESS";
        } else if (code == 500) {
            this.message = "ERROR";
        } else {
            this.message = message;
        }
    }

    public static RestResult success() {
        return new RestResult();
    }

    public static RestResult<HashMap> successMap() {
        return new RestResult<>(new HashMap<String, Object>());
    }

    public static <T> RestResult<T> success(T data) {
        return new RestResult(data);
    }

    public static RestResult success(int code, Object data) {
        return new RestResult(code, data);
    }

    public static RestResult success(int code, Object data, String message) {
        return new RestResult(code, data, message);
    }

    public static RestResult error(String message) {
        return new RestResult(0, message);
    }

    /** 请求失败 */
    public static RestResult serverError() {
        return new RestResult(500, "error");
    }

    public static <T> RestResult error(int code, String message) {
        return new RestResult(code, message);
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * @param key
     * @param value
     * @return
     */
    public RestResult<T> put(String key, Object value) {
        if (!(this.getData() instanceof HashMap)) {
            return this;
        }
        if (this.getData() == null) {
            ((RestResult<HashMap>) this).setData(new HashMap<String, Object>());
        }
        ((HashMap) this.getData()).put(key, value);
        return this;
    }
}
