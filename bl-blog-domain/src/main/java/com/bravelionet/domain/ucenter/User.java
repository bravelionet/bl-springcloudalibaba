package com.bravelionet.domain.ucenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String userName;

    private Integer age;

    private Integer sex;

    private String address;

    private String phoneNum;


}

