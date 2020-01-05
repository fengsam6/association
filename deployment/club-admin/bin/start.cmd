@echo off
cd ../
echo 正在准备启动club-admin
set jarPath = ./lib/club-admin-1.0.0.jar
echo %jarPath%
java -jar ./lib/club-admin-1.0.0.jar --spring.config.location=./config/application.properties
pause