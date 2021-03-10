# springboot.version  2.3.2.RELEASE

# springcloud.version Hoxton.SR9

# bl-springcloudalibaba  2.2.4.RELEASE

### springcloudalibaba技术栈

### spring-cloud-starter-alibaba-nacos-config

### spring-cloud-starter-alibaba-nacos-discovery

### spring-cloud-starter-alibaba-sentinel 

## 实例 包  com.bravelionet.*.config.properties  **Properties Configuration 可省略, Naocs yml 格式严格, DataId yml 支持元数据多配置 (不建议省略,整合插件查询直观性)

## 注意 : 该案例使用任何中间件 ip,使用 nginx 代理 或 nacos 中心化配置

### 譬如 : nacos 地址,使用 nginx代理 或 本地 nacos port 8848 修改为 1111


### mysql 配置使用 nacos config
####            spring:
#####               datasource:
#####                   url: jdbc:mysql://localhost:3306/lionet_blog?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8&allowPublicKeyRetrieval=true&useSSL=false
#####                    username: blroot
#####                    password: root123
#####                    driverClassName: com.mysql.cj.jdbc.Driver

### edit by zhaoweiqi 2021.3.10