# Flowers 微服务项目

## 项目简介
这是一个基于 Spring Cloud 的微服务项目，采用模块化设计，实现了花店相关的业务功能。

源代码在main 和 master 分支下都有

## 技术栈
- Spring Boot 2.7.12   —Spring Boot 2.7.12- Spring Boot 2.7.12
- Spring Boot 2.7.12   —Spring Boot 2.7.12
- Spring Cloud   ——春云
- Maven   - - - - - - Maven
- Java 8
- Lombok
- Coze API（大模型集成）

## 项目结构
项目采用多模块设计，主要包含以下模块：

### 核心模块
- `Flower_Center`: 注册中心模块，负责服务注册与发现
  - 使用 `@EnableDiscoveryClient   启用服务发现客户端` 注解实现服务发现功能

### 业务模块
- `Flower_Login`: 登录认证模块
  - 包含用户认证、授权等功能
  - 采用标准的三层架构（Controller/Service/Mapper）
  
- `Flower_Login2`: 备用登录模块
- `Login_Customer`: 客户登录模块

### 业务功能模块
- `Flower_Products`: 商品管理模块
- `Flower_Orders`: 订单管理模块
- `Flower_Coupons`: 优惠券管理模块
- `Flower_Users`: 用户管理模块

## 项目特点
1. 采用微服务架构，各模块独立部署
2. 使用 Spring Cloud 实现服务注册与发现
3. 模块化设计，职责划分清晰
4. 集成大模型能力（Coze API）

## 开发环境要求
- JDK 8
- Maven 3.x
- IDE 推荐使用 IntelliJ IDEA

## 构建与运行
1. 克隆项目到本地
2. 在项目根目录执行 Maven 构建：
   ```bash
   mvn clean install
   ```
3. 分别启动各个模块的应用程序

## 模块说明
### Flower_Center
- 作为注册中心，负责服务的注册与发现
- 使用 Spring Cloud 的服务发现功能

### Flower_Login
- 处理用户登录认证
- 包含用户信息管理
- 实现权限控制

### 其他业务模块
- `Flower_Products`: 商品信息管理
- `Flower_Orders`: 订单处理
- `Flower_Coupons`: 优惠券管理
- `Flower_Users`: 用户信息管理

## 注意事项
1. 确保所有模块的配置文件正确
2. 启动顺序：先启动注册中心，再启动其他服务
3. 注意检查服务间的依赖关系
