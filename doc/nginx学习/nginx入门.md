## nginx入门

### 一、 nginx简介

nginx是一款高性能web服务器，主要用途有三种，反向代理、负载均衡、动静分离。可以参考博客：https://blog.csdn.net/b9x__/article/details/80400697

### 二、windows 环境nginx安装

nginx 官网下载地址 http://nginx.org/en/download.html，下载完成，解压压缩包，即可使用。

### 三、 ngixn常用命令使用

* windows nginx启动。进入nginx根目录，点击nginx.exe,启动nginx，也可以在nginx更目录执行start nginx启动nginx。
* nginx -s realod,重新加载nginx配置文件，快速启动。
* 停止ngixn服务。 ngixn  -s  stop，快速停止；nginx -s quit,正常停止。

### 四、 nginx配置文件学习

* nginx配置文件在conf目录下，nginx启动后，配置文件修改了，加载配置文件，可以使用nginx  -s reoald.
* 可以参考博客学习：https://blog.csdn.net/weixin_33698823/article/details/92325723



### 五、 简单使用

* 使用ngixn搭建文件服务器

```
# 使用ngixn搭建文件服务器
#user  nobody;
worker_processes  2;

#pid        logs/nginx.pid;

events {
    worker_connections  1024;
}


http {
    include       mime.types;
    default_type  application/octet-stream;

    #access_log  logs/access.log  main;

    sendfile        on;
    #tcp_nopush     on;

    #keepalive_timeout  0;
    keepalive_timeout  65;

   # gzip  on;

    #文件服务器 （使用nginx作为文件服务器）
     server{
        listen       8013 ;
		server_name  localhost;
		# 只映射 请求/fileServer，会在F:/fileServer/寻找文件
		 location /fileServer/ {
		 # 指定文件位置（和后端上传文件位置保持一致）
		   alias F:/fileServer/ ;
		   autoindex on;
		 }
    }
}

```



