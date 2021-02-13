package com.bravelionet.ucenter.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Author : Lionet
 * @Date : 2021/2/7  15:18
 * @Description : 将mysql实现配置中心化
 */
@Configuration
public class DataSourceProperties {

    /**
     * 将 mysql 实现配置中心化
     * todo 不建议动态刷线   @RefreshScope  mysql配置, 测试发现 nacos 存在长轮训错误
     *
     * spring:
     *     datasource:
     *         url: jdbc:mysql://localhost:3306/lionet_blog?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true&useSSL=false
     *         username: blroot
     *         password: root123
     *         driverClassName: com.mysql.cj.jdbc.Driver
     * @param
     * @return
     * @author : Lionet
     * @date : 2021/2/7  15:17
     */
    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource(){
        return new DruidDataSource();

    }
}
