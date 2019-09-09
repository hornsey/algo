
# supervisor的使用 

## 1.简介
Supervisor是一个类Unix系统上的C/S系统，用于指定用户管理某些进程的开机启动。它在方便、准确、进程组方面进行了改进。
Supervsisor只监控非后台进程，即进程启动后需要一直在前台运行。
它包含以下4个组件：
* Supervisord。 该组件是supervisor的服务端，通过调用启动自进程，响应客户端的命令，重启崩溃和退出的子进程，记录子进程的日志，生成和处理子进程的事件响应。服务端进程使用配置文件 `/etc/supervisord.conf`。
* Supervisorctl。 该组件是supervisor的命令行客户端组件。它是由supervisord提供的类似shell的接口。通过该组件，用户可以连上supervisord,获取子进程的状态，启停子进程，已经获取子进程的列表。该命令行客户端与服务端通过unix域或tcp套接字通信，和服务端使用同样的配置文件，并在字段`[supervisorctl]`中进行配置。
* Web Server。 该组件是和supervisorctl类似的接口，可通过浏览器供web用户使用，默认URL为 `http://localhost:9001/`。该组件通过配置文件的`[inet_http_server]`字段进行配置。
* XML_RPC接口。 同样的HTTP服务器也可以通过XML-RPC接口进行控制。

## 2.安装
需要Python3.4 或者Python2.7以上版本环境。
安装命令
> pip install supervisor

或者
> yum install supervisor

安装完成，默认会生成配置文件`/etc/supervisord.conf`。
建议添加目录`/etc/supervisord.d/conf`, 进程的配置文件放入该目录，并在全局配置文件最后添加
```conf
[include]
files = supervisord.d/conf/*.conf
```

## 3.启动


### 添加进程
在配置文件添加进程字段，如下：
```conf
[program:cat]
command=/bin/cat		;指定启动程序，非后台程序
process_name=%(program_name)s
numprocs=1
directory=/tmp
umask=022
priority=999
autostart=true
autorestart=unexpected
startsecs=10				;启动10秒后没有退出就算正常启动
startretries=3				;启动失败重试次数，默认为3
exitcodes=0					;退出状态码，如果不是预期状态码，可以重新启动
stopsignal=TERM				;收到停止命令时发送的信号
stopwaitsecs=10
stopasgroup=false
killasgroup=false
user=test				;指定启动用户
redirect_stderr=false
stdout_logfile=/home/test/path		;指定log文件
stdout_logfile_maxbytes=1MB
stdout_logfile_backups=10
stdout_capture_maxbytes=1MB
stdout_events_enabled=false
stderr_logfile=/home/test/path
stderr_logfile_maxbytes=1MB
stderr_logfile_backups=10
stderr_capture_maxbytes=1MB
stderr_events_enabled=false
environment=A="1",B="2"				;设置环境变量
serverurl=AUTO
```

### Web管理
在web中输入指定的URL，即可登录管理界面。

### Supervisorctl管理
命令行输入`supervisorctl`命令，进入客户端命令行管理模式。
`start/stop/restart program`
可以查看进程
`status`
查看进程状态
`update`
根据最新的配置文件，启动新配置或有改动的进程
`avail`
查看可用程序。


```
supervisor> update
echo: stopped
echo: removed process group
cat: added process group
supervisor> status
cat                              RUNNING   pid 39277, uptime 0:12:05
supervisor> 
```
 
### 启动
supervisor安装后默认加入systemctl开机管理系统。
* 开机自启
>systemctl enable supervisord.service
* 手动启动
>systemctl start supervisord.service


## 参考文章
[Supervisor官网](http://supervisord.org/introduction.html#overview)
[csdn](https://blog.csdn.net/huwh_/article/details/80497790)