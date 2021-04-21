package com.bravelionet.common.enums;

import lombok.Getter;

import java.io.Serializable;

/**
 * @Author : Lionet
 * @Date : 2021/4/21  13:42
 * @Description : 用户监听操作句柄
 */
@Getter
public enum EnumUserOperate implements Serializable {

    ADD("add", 0, "新增"),

    UPDATE("update", 1, "修改"),

    DELETE("delete", 2, "删除");

    private String operate;

    private Integer value;

    private String desc;

    EnumUserOperate(String operate, Integer value, String desc) {
        this.operate = operate;
        this.value = value;
        this.desc = desc;
    }


    public static EnumUserOperate getByValue(String value) {

        for (EnumUserOperate e : values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        throw new RuntimeException("Miss The Mark Exception");
    }


}
