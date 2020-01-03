package com.atguigu.linux;

public class LinuxInfo {

    public static void main(String[] args) {

        /*
        文本命令行界面CLI： command line interface

        通过Linux控制台终端访问CLI：通常使用Ctrl+Alt组合键配合功能键（F1~F7）

        改变终端的背景色及文本颜色：
        setterm -background white,然后按回车键，接着输入
        setterm -foreground black，按回车键

        man: 查看命令手册命令
        如果不记得命令名，可以使用关键字搜索手册页，语法：man -k 关键字

        Linux文件系统：
        /          虚拟目录的根目录
        /bin       二进制目录
        /boot      启动目录
        /dev       设备目录
        /etc       系统配置文件目录
        /home      主目录，Linux在这里创建用户目录
        /lib       库目录
        /media     媒体目录
        /mnt       挂载目录
        /opt       可选目录
        /proc      进程目录
        /root      root用户的主目录
        /sbin      系统二进制目录
        /run       运行目录
        /srv       服务目录
        /sys       系统目录
        /tmp       临时目录
        /usr       用户二进制目录
        /var       可变目录

        文件系统层级标准FHS： filesystem hierarchy standard

        ls:显示当前目录下的非隐藏目录和文件（按字母顺序）
           -a:显示隐藏文件和目录
           -R:递归选项，列出当前目录下包含的子目录中的文件
           -l:显示目录中每个文件的更多相关信息（ll)

        drwxr-xr-x.   2 root root  4096 9月  23 2011 etc
        文件类型： 目录（d），文件（-）
        文件的权限
        文件的硬链接总数
        文件属组的组名和输注的用户名
        文件的大小和上次修改时间
        文件名或目录名

        ？：代表一个字符
        *：代表零个或多个字符

        touch: 创建新的空文件，改变文件的修改时间
        查看文件的访问时间： ls -l --time=atime


        cp:复制文件
        cp source destination:将原文件复制成一个新文件，以destination命名
          -i：询问是否需要覆盖已有文件
          -R：递归复制整个目录的内容

        ln -s data_file sl_data_file:创建符号链接（->表示），不加参数表示创建
        硬链接（本质上是同一个文件）
        ls -i ：查看文件inode编号

        mv: 移动目录或文件到另一个位置或重新命名
        rm: 删除文件或目录
          -r:向下进入目录，先删除其中的文件，在删除目录本身
        mkdir: 创建目录
          -p:同时创建多个目录或子目录
        rmdir: 删除目录（默认只删除空目录）

        file: 查看文件类型

        查看整个文件：
        cat:
          -n: 给所有的行添加行号
        more:
        less:
        查看部分文件：
        tail: 显示最后几行的内容，默认显示该文件的末尾10行
        tail -n 2 file: 通过加入-n 2参数只显示最后两行的内容
        head: 显示文件开头的那些行的内容，默认10行

        查看进程：
        ps -ef: 查看系统上运行的所有进程
        top: 实时监测进程

        检测磁盘空间
        df

        sort -n file： 将数字识别成数字且按值排序
        sort -M file:  识别三字符的月份，并相应地排序

        搜索数据
        grep [options] pattern [file]
          -v: 反向搜索（输出不匹配该模式的行）
          -n: 显示匹配模式的行所在的行号
          -e: 指定多个匹配模式
          eg:grep -e t -e f file

        压缩数据：
        gzip: 压缩文件
        gzcat:查看压缩过的文本文件的内容
        gunzip: 解压文件


        归档数据
        tar function [options] object1 object2 ...
          -c dir :切换到指定目录
          -f file:输出结果到文件或设备file
          -x: 从已有tar归档文件中提取文件
          -z: 将输出重定向给gzip命令来压缩内容
        tar -zxvf filename.tgz来解压

        环境变量： environment variable
          全局变量：
          局部变量：

        useradd: 添加用户
        passwd: 改变用户密码


        文件权限
        r: 代表可读
        w: 代表可写
        x: 代表可执行
        chmod: 改变文件或目录的权限


        安装软件包： yum
        yum list updates : 列出所有已安装的可用更新
        yum update package_name: 更新某个软件包



        创建脚本文件
        1. #！/bin/bash
        2.
        3.
        4.
        5.

        echo: 显示消息
        单引号不取变量值
        双引号取变量值
        双引号内部嵌套单引号，取出变量值
        单引号内部嵌套双引号，不取出变量值
        echo -n : 把文本字符串和命令行输出显示在同一行中

        |:管道
        command1 | command2








         */


    }
}
