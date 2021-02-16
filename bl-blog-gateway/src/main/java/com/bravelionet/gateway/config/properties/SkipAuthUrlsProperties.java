package com.bravelionet.gateway.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(SkipAuthUrlsProperties.PREFIX)
@Configuration
public class SkipAuthUrlsProperties {

    public static final String PREFIX = "application.authorization";

    public List<String> skipAuthUrls = new ArrayList<>();

    public static String getPrefix() {
        return PREFIX;
    }

    public List<String> getSkipAuthUrls() {
        return skipAuthUrls;
    }


    public void setSkipAuthUrls(List<String> skipAuthUrls) {
        this.skipAuthUrls = skipAuthUrls;
    }


}
