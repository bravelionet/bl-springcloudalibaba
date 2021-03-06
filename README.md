
# 相关技术栈 
|     技术栈       |                       版本                 |  日期          |  整合模块                     |     
| -------------- | ---------------------------- | ----------------------------- |    ---------------------------       |   
| **Springboot**           |      2.3.2.RELEASE              |    2021-02-13    |    all                               |   
| **SpringCloud**          |        Hoxton.SR9               |    2021-02-13    |    all                               |   
| **SpringCloudAlibaba**   |      2.2.4.RELEASE              |    2021-02-13    |    all                               |   
| **nacos-config**         |      2.2.4.RELEASE              |    2021-02-13    |    all                               |   
| **nacos-discovery**      |      2.2.4.RELEASE              |    2021-02-13    |    all                               |   
| **sentinel**             |      2.2.4.RELEASE              |    2021-02-16    |    all                               |   
| **seata**                |         1.4.0                   |    2021-04-11    |   bl-blog-dispatch / bl-blog-ucenter |    
| **ApplicationEventPublisher**           |                  |    2021-04-21    |    ucenter                           |   
 

### 相关技术说在下方公众号文章发布


#说明
-  实例 包  *.config.properties 及 *Properties Configuration 可省略
-  Naocs yml 格式严格, DataId yml 支持元数据多配置 (不建议省略,整合插件查询直观性)
-  注意 : 该案例使用任何中间件 ip,使用 nginx 代理 或 nacos 中心化配置
-  譬如 : nacos 地址,使用 nginx代理 或 本地 nacos port 8848 修改为 1111


####  datasource
```yaml
 spring:
     datasource: 
        url: jdbc:mysql://IP:3306/lionet_blog?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true&useSSL=false
        username: root
        password: root
        driverClassName: com.mysql.cj.jdbc.Driver
 
    
```

#### sentinel
```yaml
spring: 
    cloud: 
        sentinel: 
            transport: 
                port: 8719
                dashboard: IP:port
```

#### redis 
```yaml
spring: 
    redis:
        host: IP
        port: 6379
        password: lionet
        database: 10
    
```

#### Gateway Skip Urls
```yaml
application:
  authorization:
      skip-auth-urls:
        - /json/*

```



# 作者公众号 
![公众号](https://img-blog.csdnimg.cn/20201003010039237.png#pic_center)

### CSDN :  https://blog.csdn.net/braverlionet 


### E-Mail
```$xslt
BraveLionet@163.com
```