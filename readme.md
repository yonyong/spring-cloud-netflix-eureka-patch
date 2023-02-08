spring-cloud-netflix-eureka eureka 补丁
===============================  
### maven依赖
执行 mvn clean install命令后 , 在项目中引入本组件
```xml
<dependency>
    <groupId>top.yonyong</groupId>
    <artifactId>spring-cloud-netflix-eureka-patch</artifactId>
    <version>1.0.0</version>
</dependency>
```
### 1、修复功能 
```
修复 refreshScope使用不当导致eureka下线问题
```
### 2、补丁原理 
```
1. 魔改eureka config类，禁用eureka 刷新
2. 关闭eureka的默认开启刷新 配置项
```
### 3、适用版本 
```
org.springframework.cloud:spring-cloud-netflix-eureka-client:2.2.6.RELEASE
```
### 4、注意事项
```
1）补丁包需要位于pom文件依赖最顶端
2）配置文件端点暴露eureka-register，供特殊情况下手动发起eureka注册
management.endpoints.web.exposure.include = eureka-register
```
### 特别说明
低于spring boot 2.3版本以下的项目不建议引用此组件。  
由于springboot在2.3版本以后才支持限定jar包加载顺序，因此版本较低时，本组件无法保证在linux系统上加载顺序优先于scg eureka组件。  
因此低版本建议参考代码自行实现。