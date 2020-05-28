# 

## 项目技术选型

| 技术              | 说明                                                         | 官网                                                 |
| ----------------- | ------------------------------------------------------------ | ---------------------------------------------------- |
| SpringBoot        | 容器+MVC框架                                                 | https://spring.io/projects/spring-boot               |
| SpringSecurity    | 认证和授权框架                                               | https://spring.io/projects/spring-security           |
| MyBatis           | ORM框架                                                      | http://www.mybatis.org/mybatis-3/zh/index.html       |
| Spring MVC        | *Spring* mvc 框架提供了构建 Web 应用程序的全功能 *MVC* 模块  | https://spring.io/                                   |
| MyBatisCodeHelper | 数据层代码生成                                               | https://github.com/gejun123456/MyBatisCodeHelper-Pro |
| PageHelper        | MyBatis物理分页插件                                          | http://git.oschina.net/free/Mybatis_PageHelper       |
| Spring            | Spring是一个轻量级控制反转(IoC)和面向切面(AOP)的容器框架     | https://spring.io/                                   |
| Redis             | 缓存                                                         | https://redis.io/                                    |
| hikari            | 数据库连接池                                                 | http://www.m-hikari.com/                             |
| Lombok            | 简化对象封装工具                                             | https://github.com/rzwitserloot/lombok               |
| layui             | 经典模块化前端框架                                           | https://www.layui.com/                               |
| layui mini        | 基于Layui编写的一套最简洁、易用的后台框架模板                | http://layuimini.99php.cn/                           |
| jQuery            | jQuery是一个快速、简洁的JavaScript框架，是继Prototype之后又一个优秀的JavaScript代码库（*或JavaScript框架*） | https://jquery.com/                                  |



## 后端项目结构

```lua

├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─chenghui
│  │  │          └─ticket
│  │  │              │  application.java spring boot项目启动类
│  │  │              │
│  │  │              ├─config   这个包下面都是配置类
│  │  │              │      RedisConfig.java  redis的配置类 用于注入spring data redis的bean
                                               以及序列化
│  │  │              │      SecurityConfig.java   sping security 配置类
│  │  │              │      SystemLogAspect.java     日志的切面类
│  │  │              │      WebMvcConfig.java   因为是前端后端分类的 所以需要解决跨域问题 这个就                             是用来解决跨域问题吧
│  │  │              │
│  │  │              ├─controller  控制层 此层的框架主要是spring mvc 视图层（web层） 这个层调用                            service层）
│  │  │              │      backController.java   退单记录相关
│  │  │              │      LogController.java   日志相关
│  │  │              │      messageController.java  留言以及公告的的相关
│  │  │              │      orderController.java   订单相关
│  │  │              │      ticketController.java  票务相关
│  │  │              │      UserController.java  用户相关
│  │  │              │      UtilsController.java  工具相关 主要是一些跟业务不相干的 比如验证码啥
│  │  │              │ 
│  │  │              ├─handler 处理器 主要用于spring security的自定义的处理器
│  │  │              │      CommonExceptionHandler.java   总的异常处理器
│  │  │              │      CustomizeAccessDeniedHandler.java  访问未经允许资源处理器（权限不                                                                  够）
│  │  │              │      CustomizeAuthenticationEntryPoint.java  访问非共享资源处理
│  │  │              │      CustomizeAuthenticationFailureHandler.java  认证异常（登录异常）
│  │  │              │      CustomizeAuthenticationSuccessHandler.java  用户登录处理（登录成                                  功，记住账号密码）
│  │  │              │      CustomizeLogoutSuccessHandler.java 退出登录处理
│  │  │              │      CustomizeSessionInformationExpiredStrategy.java 用户登录过期
│  │  │              │      CustomizeValidateCodeFilter.java 登录的验证码的处理
│  │  │              │
│  │  │              ├─mapper 持久层 maybaits框架 注意这个是与resources对应的xml文件有着映射关系
                              每个方法对应这xml文件的一个方法 这个包是方法层，xml是sql语句层
│  │  │              │      BackMapper.java 退单相关
│  │  │              │      MenuMapper.java 菜单相关
│  │  │              │      MessageMapper.java 留言相关
│  │  │              │      OrderMapper.java 订单相关
│  │  │              │      SysUserMapper.java 用户相关 
│  │  │              │      TicketingMapper.java 票务相关
│  │  │              │      UserLogMapper.java 日志相关
│  │  │              │
│  │  │              ├─pojo  javabean （简单的java类，不知道javabean是啥去百度 具体我也不好解释）
│  │  │              │      Back.java   退单
│  │  │              │      Common.java 常规 这个用来统一的返回数据的
│  │  │              │      LayUi.java  layui框架需要的返回的数据
│  │  │              │      Menu.java 菜单
│  │  │              │      Message.java 消息
│  │  │              │      Order.java 订单
│  │  │              │      SysUser.java 用户
 │  │  │             │      Ticketing.java 票务
 │  │  │             │      UserLog.java 日志
│  │  │              │
│  │  │              ├─services 业务层 主要的处理业务 这里调用mapper层
                        以下不带impl都是接口 impl包下面都有对应的实现类来实现 这个操作叫面向接口操作
                        为啥要面向接口 百度去。。。。主要是为了方便修改
│  │  │              │  │  BackService.java  退单相关
│  │  │              │  │  MenuService.java 菜单相关
│  │  │              │  │  MessageService.java 。。。。。我不打了 你应该能看名知道意思吧
│  │  │              │  │  OrderService.java
│  │  │              │  │  TicketingService.java
│  │  │              │  │  uploadService.java
│  │  │              │  │  UserLogService.java
│  │  │              │  │  UserService.java
│  │  │              │  │
│  │  │              │  └─impl service的实现类
│  │  │              │          BackServiceImpl.java
│  │  │              │          MenuServiceImpl.java
│  │  │              │          MessageServiceImpl.java
│  │  │              │          OrderServiceImpl.java
│  │  │              │          SysUserServiceImpl.java
│  │  │              │          TicketingServiceImpl.java
│  │  │              │          uploadServiceImpl.java
│  │  │              │          UserLogServiceImpl.java
│  │  │              │
│  │  │              └─utlis 工具包 用户处理业务以外的东西
│  │  │                  │  AddressUtils.java 地址相关 比如什么用户登录的地址 
│  │  │                  │  CookieUtils.java 往浏览器写cookie 
│  │  │                  │  CreateBeanUtlis.java  创建spring的bean的工具类
│  │  │                  │  getverUtils.java  生成验证码的
│  │  │                  │  JsonWriteUtlis.java 写json的
│  │  │                  │  ThreadPoolUtil.java  线程池工具
│  │  │                  │
│  │  │                  ├─annotation 自定义的注解 主要用来spring的aop 切面 加了这两个注解就会被                          日志记录
│  │  │                  │      ControllerLog.java控制层注解  
│  │  │                  │      ServiceLog.java 服务注解
│  │  │                  │
│  │  │                  ├─exception 异常 自定义异常 用来被spring svc 的异常处理器捕获 方便返回到                         浏览器错误信息
│  │  │                  │      ExceptionEnums.java 异常的枚举
│  │  │                  │      ExceptionResult.java 异常的返回结果类
│  │  │                  │      ValidateCodeException.java  这个相当于ExceptionResult                                  XxException联系
│  │  │                  │      XxException.java 异常
│  │  │                  │
│  │  │                  └─result 这个是spring security的处理的类 上面已经定义了一个返回的处理类
                                  这里为啥还要定义呢
                                 因为spingsecurity是过滤器 而上面的定义的是在类加载完之后才有的
                                 而过滤器是在类之前进行 所以这里要再定义一个用于springsecurity框架
│  │  │                      ├─enums
│  │  │                      │      ResultCode.java 错误码
│  │  │                      │
│  │  │                      ├─pojo
│  │  │                      │      JsonResult.java json结果
│  │  │                      │
│  │  │                      └─utils
│  │  │                              ResultTool.java 快捷写入的公告
│  │  │
│  │  └─resources
│  │      │  application.yml springboot 的规定的配置类 配置相关都修改这个 springboot启动会默认读               取这个
│  │      │  rebel.xml 热加载用的 开发时候用的 删掉无所谓
│  │      │
│  │      └─com mapper层映射
│  │          └─chenghui 
│  │              └─ticket
│  │                  └─mapper
│  │                          BackMapper.xml
│  │                          MenuMapper.xml
│  │                          MessageMapper.xml
│  │                          OrderMapper.xml
│  │                          SysUserMapper.xml
│  │                          TicketingMapper.xml
│  │                          UserLogMapper.xml
│  │
│  └─test 测试类 这里我没写
 └─--------------------------------------

```



## 前端项目结构

没介绍的都是属于框架自带的

```lau
│  403.html 403 （认证失效跳转界面）
│  404.html 404 （页面未找到）
│  500.html 500 （系统异常）
│  index.html （主页）
│  login.html （登录）
│
├─css （样式）
│
├─fpages 买票的地方
│      board.html  公告页面
│      buy.html 购买页面
│      detail.html 留言详情
│      index.html 买票的界面
│      list.html 购票界面
│      message.html 买的票查询
│      password.html 修改密码界面
│      register.html 注册界面
│ 
├─images  图片
│
├─network   网络通信接口 与后端的接口
│      network.js
│
└─pages
        add_message.html 添加留言公告界面
        add_ticket.html 添加票务界面
        back.html 退票管理界面
        index.html 主页 这里框架作为ifame的主页，其他页面都是嵌套在这个界面的
        Journal.html 日志
        message.html 留言公告界面
        sale.html 车票销售的统计报表
        Sales.html 车票管理
        slog.html 日志管理
        Statistics.html 订单管理
        ticket.html 票务管理
        user-password.html 修改密码管理
        user.html 用户界面
        useradd.html 添加用户
        userinfo.html 用户详情
        welcome.html 欢迎界面
```

