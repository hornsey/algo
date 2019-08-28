
# xsync同步脚本的使用 

## 1.简介
在集群机器配置时，经常需要将一个文件或目录copy到同样的多台集群上，如果一个一个机器去复制，比较麻烦。如果有一个办法，通过一条命令就可以实现这个目的，就简单多了。xsync就是这样一个同步脚本。xsync其实是对rsync脚本的二次封装，脚本内容可以根据自己需要进行修改。

## 2.配置集群hostname

### 2.1 配置hostname文件
在每台机器执行命令 
>echo **hostname1** > /etc/hostname
>hostname **hostname1**

备注：hostname1 为主机名，最好能标识主机用途，例如：kafkaos1、kafkaos2。

### 2.2 配置hosts文件
修改完hostname后，将集群集群名称都加入到/etc/hosts文件中，以后登录不同机器，直接使用hostname而不用IP。
示例：
>10.8.10.101 zkos1 
>10.8.10.102 zkos2
>10.8.10.103 zkos3
>10.8.10.104 zkos4
>10.8.10.111 kafkaos1
>10.8.10.112 kafkaos2
>10.8.10.113 kafkaos3

## 3.配置免密登录 

### 3.1 生成rsa密钥
使用命令`ssh-keygen` 生成rsa密钥，配置信息直接回车即可, 生成的密钥默认在当前用户主目录的.ssh目录下。
密钥文件有两个：
* id_rsa 存放着私钥
* id_rsa.pub 存放着公钥

命令执行结果如下：
>[root@zkos1 ~]# ssh-keygen
Generating public/private rsa key pair.
Enter file in which to save the key (/root/.ssh/id_rsa): 
Enter passphrase (empty for no passphrase): 
Enter same passphrase again: 
Your identification has been saved in /root/.ssh/id_rsa.
Your public key has been saved in /root/.ssh/id_rsa.pub.
The key fingerprint is:
SHA256:kXclvgbcNBCbW9Z88eP1brP1TtPOc+YAuWTw0xi4QrU root@zkos1
The key's randomart image is:
+---[RSA 2048]----+
|          +o+ .. |
|         + O *  o|
|        + E B o.+|
|       . o X *..+|
|        S o @ ...|
|         . + + ..|
|            . .o*|
|               BO|
|               =O|
+----[SHA256]-----+


### 3.2 copy机器自身公钥到目标机器
#### 方法一
1) 在目标机器的用户主目录创建.ssh目录
>mkdir -p ~/.ssh

2) 在本地执行远程拷贝命令
>cd /root/.ssh
>scp id_rsa.pub  root@kafkaos1:/root/.ssh/authorized_keys


#### 方法二
1) 在本地先将`id_rsa_pub` 一份名为 `authorized_keys`
> cp id_rsa.pub authorized_keys

2) 使用rsync 命令同步到对方目录
>rsync authorized_keys root@kafkaos1:/root/.ssh/

备注：该方法需要本地暂时没有`authorized_keys`，有的话先改名也可以，并且本地机器安装有rsync脚本。操作完记得删除本地的`authorized_keys`。

### 3.3 远程登录测试
输入命令
>ssh root@kafkaos1

此时不再需要输入命令，可直接登录成功（若第一次连接，需保持对方公钥，提升时输入`yes`即可）。

## 4.xsync脚本使用

### 4.1 安装rsync脚本
xsync是对rsync脚本的二次封装，所以需要先下载rsync命令。
使用以下命令即可安装
>yum install -y rsync

### 4.2 添加xsync脚本
在用户主目录的bin目录下添加脚本，脚本内容如下
```shell
#!/bin/sh

# 获取输入参数个数，如果没有参数，直接退出
pcount=$#
if((pcount!=4)); then
    echo Usage: $0 filename servername startno endno
    exit;
fi


# 获取文件名称
p1=$1
fname=`basename $p1`
echo fname=$fname

# 获取上级目录到绝对路径
pdir=`cd -P $(dirname $p1); pwd`
echo pdir=$pdir
# 获取当前用户名称
user=`whoami`
# 获取hostname及起止号
slave=$2
startline=$3
endline=$4

# 循环
for((host=$startline; host<=$endline; host++)); do
    echo $pdir/$fname $user@$slave$host:$pdir
    echo ==================$slave$host==================
    rsync -rvl $pdir/$fname $user@$slave$host:$pdir
done

```
该脚本经过修改，需要携带4个参数，分别是
* filename  待发送的文件或目录名
* servername 服务器前缀名
* startno 服务器编号起始编号
* endno 服务器编号终止编号

### 4.3 测试
例如我要将当前目录下的a.t文件同步到服务器kafkaos2、kafkaos3上，使用命令
>xsync a.t kafkaos 2 3

执行结果如下
>fname=a.t
pdir=/root
/root/a.t root@kafkaos2:/root
==================kafkaos2==================
sending incremental file list
a.t
>sent 470 bytes  received 35 bytes  1,010.00 bytes/sec
total size is 383  speedup is 0.76
/root/a.t root@kafkaos3:/root
==================kafkaos3==================
sending incremental file list
a.t
>sent 470 bytes  received 35 bytes  336.67 bytes/sec
total size is 383  speedup is 0.76




