package com.bravelionet.common.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;


/**
 * @Author : Lionet
 * @Date : 2021/2/7  15:46
 * @Description : 数据返回格式
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TypicalRep<T> implements Serializable {

    private Integer code;
    private String msg;
    private T data;

}
