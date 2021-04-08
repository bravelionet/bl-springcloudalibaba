package com.bravelionet.domain.ucenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author Lionet
 * @Date 2021/4/8 21:40
 * @Description 用户账户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Balance {
    private Long id;

    private String name;

    private Long money;

    private Long userId;
}
