
package com.bravelionet.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
/**
 * @Author : Lionet
 * @Date : 2021/2/8  16:26
 * @Description : jackson 序列化工具箱
 */
public class ObjectMapperUtils {


    private static ObjectMapper objectMapper;



/**
     * 将对象序列化为json格式字符串
     *
     * @param obj
     * @return
     */


    public static String jsonEncode(Object obj) {
        try {
            if (objectMapper == null) {
                objectMapper = JsonMapper.builder()
                        .enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS)
                        .enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)
                        .build();
            }
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
    }



/**
     * 将json格式字符串反序列化
     *
     * @param json
     * @param valueType
     * @return
     */


    public static <T> T jsonDecode(String json, Class<T> valueType) {
        try {
            return getObjectMapper().readValue(json, valueType);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



/**
     * 将json格式字符串反序列化
     *
     * @param json
     * @param valueTypeRef
     * @return
     */


    public static <T> T jsonDecode(String json, TypeReference<T> valueTypeRef) {
        try {
            return getObjectMapper().readValue(json, valueTypeRef);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }






/**
     * 获取一个ObjectMapper对象
     *
     * @return ObjectMapper
     */


    public static ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = JsonMapper.builder()
                    .enable(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS)
                    .enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)
                    .enable(JsonReadFeature.ALLOW_LEADING_ZEROS_FOR_NUMBERS)
                    .enable(JsonReadFeature.ALLOW_TRAILING_COMMA)
                    .build();
            // 打开ignore properties
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }
        return objectMapper;
    }
}


