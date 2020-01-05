#! /bin/bash
echo ">>>>>>> 准备启动服务  club-admin .........>>>>>>>>>>>>>>>" ;
cd ..
appFilePath=./lib/club-1.0.0.jar
configFilePath=./config/application.properties
rm -rf log/log.out
serviceIsExist=`ps -aux | grep $appFilePath | grep -v grep | wc -l`

if [ $serviceIsExist -gt 0 ]; then
   echo " 服务器已经启动，不需要再启动"
   echo  " 服务器已经启动，不需要再启动" > log/log.out
   exit 2
fi

java -jar ${appFilePath}  --spring.config.location=$configFilePath  > log/log.out &
if [ $? -eq 0 ]; then
   echo ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>服务启动成功!>>>>>>>>>>>>>>>>>>>>>"
   echo "服务启动日志路劲： ../ log/log.out"
   exit 0
else
   echo ">>>>>>>>>>>>>>>>>>>服务启动失败,可以去../log/log.out 查看日志>>>>>>>>>>>>>>>>>>>>>>>"
   exit 2
fi
