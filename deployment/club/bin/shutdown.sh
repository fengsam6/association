#! /bin/bash
echo "正在停止服务 club-admin ........." ;
cd ..
appName=club-1.0.0.jar
PID=`ps -aux | grep "${appName}" | grep -v grep | awk '{print $2}'`

# 查看进程是否存在，存在则杀死进程，否则返回提示信息
if [ -z $PID ]; then
   echo "该进程没有启动，不用停止"
else
   sudo kill -9 $PID ;
   echo "成功停止服务"
fi
