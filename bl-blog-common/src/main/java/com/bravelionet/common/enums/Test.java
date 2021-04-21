package com.bravelionet.common.enums;

public class Test {
    public static void main(String[] args) {
        EnumUserOperate[] values = EnumUserOperate.values();
        for (EnumUserOperate value : values) {
            System.out.println("desc = " + value);
        }
    }
}
