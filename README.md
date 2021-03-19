# business-starter

## 介绍

基于 SpringBoot + MyBatis + Redis 搭建的后端单体项目业务启动器，可以为项目初始化节省时间。



## 特点

- 接口均为 RESTful 风格，支持前后端分离
- 封装统一响应结果以及统一响应码
- 使用 JWT 生成 token 以及验证 token
- 使用注解的方式来拦截需要拦截的请求
- 封装 RedisUtil 工具类来实现缓存
- 使用 smart-doc 通过 javadoc 自动生成 API 文档



## 代码结构

```
src
├─ main
│  ├─ java
│  │  └─ com
│  │     └─ qyl
│  │        ├─ BusinessStarterApplication.java  项目主启动类
│  │        ├─ cache  	   Redis缓存
│  │        ├─ config      配置类
│  │        ├─ controller  controller层
│  │        ├─ enums       响应信息枚举类
│  │        ├─ exception   异常处理类
│  │        ├─ mapper      DAO层
│  │        ├─ pojo        实体类
│  │        ├─ service     service层
│  │        │  └─ impl     service层实现类
│  │        └─ utils	   工具类
│  └─ resources
│     ├─ application.yml   通用配置文件
│     ├─ mapper            mybatis XML文件
│     └─ static
│        └─ doc            API文档
└─ test                    用于生成API文档
```

