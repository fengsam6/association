# association

#### 介绍
毕业论文项目，使用Spring Boot社团管理系统，系统功能如下图所示。![](系统说明\系统功能.png)

#### 软件架构
软件架构说明

1. 后端使用Spring boot、mybatis、redis、mybatisPlus，系统架构如下图所示

![](系统说明\系统架构.png)

2. 系统后端多模块开发

      后端使用idea开发，maven多模块如下图。

   * 模块Association-generation支持代码生成，基于MyBatis、MyBatis-Plus代码生成，运行该模块，能够生成Dao层、service层通用代码。
   * 模块Association-API调用模块Association-service，提供前台访问RESTful接口。
   * 模块Association-admin调用模块Association-service，提供后台访问RESTful接口。

   

   ![](系统说明\后端多模块开发.png)

   系统运行效果

   前台页面单独开发一个工程vue-club，所有前台页面代码都写在vue-club中

#### 使用说明

1. 安装git、idea等开发工具
2. mysql、tomcat等运行环境
3. 克隆项目，导入idea部署、运行



