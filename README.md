# association

#### 介绍
大学毕业论文项目。基于前后端分离，使用Spring Boot、vue等技术开发社团管理系统，觉得写得不错，可以收藏该项目。系统功能如下图所示。![](系统说明/系统功能.png)

#### 软件架构
软件架构说明

1. 后端使用Spring boot、mybatis、redis、mybatisPlus，系统架构如下图所示

![](系统说明/系统架构.png)

### 后端简介

1. 系统后端多模块开发，后端码云地址：<https://gitee.com/fengsam618/association>

* 模块Association-generation支持代码生成，基于MyBatis、MyBatis-Plus代码生成，运行该模块，能够生成Dao层、service层通用代码。
* 模块Association-API调用模块Association-service，提供前台访问RESTful接口。
* 模块Association-admin调用模块Association-service，提供后台访问RESTful接口。

 后端使用idea开发，maven多模块如下图。

![](系统说明/后端多模块开发.png)

### 前端简介

* 前台页面单独开发一个工程vue-club，所有前台页面代码都写在vue-club中.

  ![](系统说明/club前台项目目录结构.png)

* 后台页面单独开发一个工程club-admin，所有前台页面代码都写在club-admin中.

![](系统说明/后台clu-admin.png)

### 系统运行效果

![](运行效果图/club.gif)

* 系统登录页面

![](运行效果图/登录页面.png)

* 前台活动列表页面

![](运行效果图/活动列表.png)

+ 前台社团检索页面页面

![](运行效果图/社团检索页面.png)

* 后台新闻列表页面

![](运行效果图/新闻列表.gif)

* 后台社团列表页面

![](运行效果图/社团列表.png)



### 项目运行准备工作

assosiation-clubt提供后台访问的restful接口。

1. 启动nginx服务器，系统使用nginx作为文件服务器。
2. 启动MySQL、Redis数据库
3. 打开idea，启动assosiation-rest、assosiation-admin两个模块，assosiation-rest提供前台访问的restful接口， assosiation-admin提供后台访问的restful接口。
4. 打开HbuilderX，使用npm run dev运行前台两个项目vue-club、club-admin。（编译很慢，需要提前编译）

### 项目运行展示

1. http://127.0.0.1:80/>   本地运行，系统前台访问页面
2. http://127.0.0.1:8080/>   本地运行，系统后台访问页面
3. http://127.0.0.1:8081/club/api/swagger-ui.html>   前台接口访问文档
4. http://127.0.0.1:8082/club/admin/swagger-ui.html>  后台接口访问文档，需要先登录





### 项目创新

1. 论文采用的技术都是目前很流行技术，企业中常用的技术。

   > 后端使用maven构建五个模块模块，使用Spring Boot 、springMVC、mybatis、mybatisPlus、pageHelper、Redis等技术开发。使用 swagger UI生成后端接口API文档，可以直接在浏览器浏览。
   >
   > 前端使用Vue、Vue router、vue Axios、Element UI等技术开发。

2. 开发方式前后端分离。

   > 前后代码端耦合度低，可以单独部署测试，有利于后期维护。

3. 数据库持久层，使用MySQL存储数据，采用Redis缓存数据。

   > Redis基于内存非关系数据库，读写速度非常快，提高系统数据读写速速。

4. 系统登录，采用动态token验证身份，后端所有操作，必须提供token才能访问。

   > 用户输入正确的用户名、密码，请求登录接口，后端会返回一个随机的token（64位uuid），同时系统后端将uuid最为key，值为用户ID，存储Redis数据库中，同时设置键数据库有效时间40分钟。后端有一个拦截器拦截用户所有请求，会根据前台传入token去redis数据库查找，只有token正确，才能在redis查找到用户id，系统才放行。

5. 使用nginx作为文件服务器

   > 配置nginx，将一个请求url（比喻：localhost：8013/fileSever）与指定文件夹映射，系统后端将文件上传该文件夹目录下,前端浏览localhost：8013/fileSever/filePath就可以访问该文件夹。



### 本地nginx部署测试

1. maven将后端接口打包成jar，java -jar可以运行后端springBoot jar包，打包后端部署测试，提供前台访问页面接口。

2. 本地nginx部署，启动测试，http://127.0.0.1:8011/>   前台访问页面，页面目前只适配电脑，

   http://127.0.0.1:8012/>   后台访问页面，页面目前只适配电脑

### 服务器测试版   (系统代码已经部署个人私有linux服务器上)

1. <http://118.89.228.250:8011/>   前台访问页面，页面目前只适配电脑
2. <http://118.89.228.250:8012/ >   后台访问页面，页面目前只适配电脑，系统登录账号test@163.com 对应密码123456 ；admin@163.com  对应密码123456 
3. <http://118.89.228.250:8081/club/api/swagger-ui.html>   前台接口访问文档
4. <http://118.89.228.250:8082/club/admin/swagger-ui.html>  后台接口访问文档，需要先登录

