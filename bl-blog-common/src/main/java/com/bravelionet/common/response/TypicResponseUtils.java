package com.bravelionet.common.response;


import com.bravelionet.common.constant.response.TypicalRepStatus;

/**
 * @Author : Lionet
 * @Date : 2021/2/7  15:48
 * @Description : 返回一个标准结构工具箱
 */
@SuppressWarnings("unchecked")
public class TypicResponseUtils {


    public static <T> TypicalRep<T> success_t(T data) {
        return new TypicalRep<>(TypicalRepStatus.RESPONSE_STATUS_200, "", data);
    }

    public static TypicalRep<Object> success() {
        return new TypicalRep<>(TypicalRepStatus.RESPONSE_STATUS_200, "", null);
    }

    public static TypicalRep<Object> success(Object data) {
        return new TypicalRep<>(TypicalRepStatus.RESPONSE_STATUS_200, "", data);
    }

    public static TypicalRep<Object> success(String msg) {
        return new TypicalRep<>(TypicalRepStatus.RESPONSE_STATUS_200, msg, null);
    }

    public static TypicalRep<Object> success(Object data, String msg) {
        return new TypicalRep<>(TypicalRepStatus.RESPONSE_STATUS_200, msg, data);
    }

    public static TypicalRep<Object> success(Object data, Integer code, String msg) {
        return new TypicalRep<>(code, msg, data);
    }


    public static TypicalRep<Object> success(Integer code) {
        return new TypicalRep<>(code, "", "");
    }

    public static TypicalRep<Object> error(Integer code) {
        return new TypicalRep<>(code, "", "");
    }

    public static TypicalRep<Object> error() {
        return new TypicalRep<>(TypicalRepStatus.RESPONSE_STATUS_500, "", null);
    }

    public static TypicalRep<Object> error(String msg) {
        return new TypicalRep<>(TypicalRepStatus.RESPONSE_STATUS_500, msg, null);
    }


    public static TypicalRep<Object> error(Integer code, String msg) {
        return new TypicalRep<>(code, msg, null);
    }

    public static TypicalRep<Object> error(Object data) {
        return new TypicalRep<>(TypicalRepStatus.RESPONSE_STATUS_500, "", data);
    }

    public static TypicalRep<Object> error(Integer code, String msg, Object data) {
        return new TypicalRep<>(code, msg, data);
    }


}
