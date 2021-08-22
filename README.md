# kuangshen-es-jd
使用es简单的实战项目  
视频学习地址： https://www.bilibili.com/video/BV1Nk4y1R7Hf?p=1  
代码是跟随视频学习，除原始前端文件外，纯跟随视频手写，遇到某些问题，有些改变。  
感谢狂神老师，视频教程一步步很清晰，不是直接复制，适合前面没有看过老师视频的新手，推荐。前提搭建好elasticsearch。  
改动处：  
一、因网站反爬虫改动，请求头需改动，需要将浏览器请求请求头信息全部带上。  
二、我的elasticsearch需要访问需要登陆，所以有访问账户和密码。  
避坑指南：  
js/css文件无法引入（访问不到）  
可以idea重启，或edit configuration中勾选如下选项  
![1629626736](https://user-images.githubusercontent.com/58561562/130353055-0ce3c1c4-3060-48bc-8ea0-06648f718ca7.png)  
