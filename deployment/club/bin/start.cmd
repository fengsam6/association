@echo off
cd ../
echo 正准备启动club
set jarPath = ./lib/club-1.0.0.jar
echo %jarPath%
java -jar ./lib/club-1.0.0.jar --spring.config.location=./config/application.properties
pause