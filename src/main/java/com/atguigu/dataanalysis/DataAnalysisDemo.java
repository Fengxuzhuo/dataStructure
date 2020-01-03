package com.atguigu.dataanalysis;

public class DataAnalysisDemo {

    public static void main(String[] args) {

        /**
         *
         * 数据库（DataBase）：按照数据结构来组织，存储，管理数据的仓库
         *
         * 关系数据库管理系统（Relational DataBase Management System）：
         *
         * 结构化查询语言(Structured Query Lanuage): SQL
         *
         * 表：按列（存储数据特征）和行（实际的数据条目）排列的一组数据
         *
         *
         * SQL命令分类
         * 1.数据查询语言（DQL)
         *   1）如何使用SELECT
         *   1.1如何选择多行
         *   select column_list
         *   from table_name
         *   where search_condition;
         *
         *   1.2如何选择某一列去重（重点）
         *   select distinct column_name
         *   from table_name;
         *
         *   1.3如何从第一行开始选择以共5行数据
         *   select column_name
         *   from table_name
         *   limit 5 offset 1;
         *
         *   1.4如何按照指定方向（升，降）排序选择数据
         *   select column_name1,column_name2
         *   from table_name
         *   order by column_name1 desc, column_name2 asc;
         *
         *   1.5常见的一些过滤（重点）
         *   #范围内检查
         *   select column_name
         *   from table_name
         *   where column_name between n and m;
         *   #空值检查
         *   select column_name
         *   from table_name
         *   where column_name is null;
         *   #in操作符
         *   select column_name
         *   from table_name
         *   where column_name in(....);
         *   #not操作符
         *   select column_name
         *   from table_name
         *   where not (条件)
         *   #and和or， and 的优先级高于 or
         *   select column_name
         *   from table_name
         *   where (condition1 or condition2) and condition3;
         *   #通配符过滤%/_/[]% 等
         *   select column_name
         *   from table_name
         *   where column_name like '..%..';
         *
         *   1.6分组并按条件选择数据（重点）
         *   select column_list, aggregate_function(column_name)
         *   from table_name
         *   where search_condition
         *   group by column_list;
         *
         *   注：
         *   group by 后面也可以接条件
         *   where 和 having 配合使用，where在前
         *   where过滤针对的是行，having过滤针对的是组
         *
         *   1.7分组和排序的顺序（重点）
         *   from -> on -> join -> where -> group by -> avg,sum... -> having ->
         *   select -> distinct -> order by -> limit
         *   以上每个步骤都会产生一个虚拟表，被用作下一个步骤的输入
         *
         *   1.8子查询（重点）
         *   select column_name
         *   from table_name
         *   where column_name =
         *   (select column_name
         *   from table_name
         *   where ...)
         *
         *   1.9表的连结查询（非常重点）
         *   select column_list
         *   from table1 join table2
         *   on table.col1 = table2.col1;
         *
         *   几种join:
         *   table_a             table_b
         *   id    name          id    name
         *   1     Pirate        1     Rutabaga
         *   2     Monkey        2     Pirate
         *   3     Ninja         3     Darth Vader
         *   4     Spaghetti     4     Ninja
         *
         *
         *   1）inner join:只生成同时匹配表a 和 表b 的记录集
         *   select id, name
         *   from table_a a
         *   inner join table_b b
         *   on a.name = b.name;
         *
         *   id    name       id    name
         *   1     Pirate     2     Pirate
         *   3     Ninja      4     Ninja
         *
         *   2)full outer join:生成表a 和 表b 的记录全集，包括两边都匹配的记录，如果有一边
         *   没有匹配的，缺失的这一边为null
         *   select id, name
         *   from table_a a
         *   full outer join table_b b
         *   on a.name = b.name;
         *
         *   id    name       id    name
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         * 2.数据操作语言（DML）
         *   1)如何使用INSERT
         *   insert into table_name
         *   (column_list) values (values)
         *   eg:
         *   insert into orders
         *   (firstname, lastname, orderdate)
         *   values ('join', 'smith', '10/10/2010')
         *
         *   2)如何使用UPDATE
         *   update table_name
         *   set column_name1 = value1, column_name2 = value2, ...
         *   where search_condition;
         *   eg:
         *   update order
         *   set firstname = 'tom', lastname = 'who'
         *   where lastname = 'wo';
         *
         *   3)如何使用DELETE
         *   delete from table_name
         *   where search_condition;
         *
         * 3.数据定义语言（DDL）
         *   1)CREATE
         *   create table table_name(
         *   column_name1 datatype,
         *   column_name2 datatype,
         *   ...)
         *
         *   2)ALTER
         *   create table table_name
         *   add column_name datatype;
         *
         *   create table table_name
         *   drop column column_name;
         *
         *   3)DROP
         *   drop table table_name;
         *
         * 4.数据控制语言（DCL）
         *   1)GRANT
         *   2)REVOKE
         *
         *
         *
         *
         */


        /**
         * 流量数据分析
         * 1.数据采集
         *   1）数据埋点
         *   为了收集数据
         *   2）流量采集核心底层表与字段
         *
         * 2.数据处理（ETL）
         *   1）方法
         *   2）作用
         *   3）问题（数据倾斜）
         * 3.指标统计
         *   1）网站流量统计
         *   #页面浏览数PV
         *   #独立访客数UV
         *   #日活跃用户DAU
         *   #PV,UV点击率
         *   #复购率
         *
         *   2）用户行为指标
         *   #
         *
         * 4.用户分析（绩效指标KPI）
         *   1）基础分析
         *   1.1针对新用户
         *   #拉新（渠道）
         *   #转化
         *   1.2针对老用户
         *   #活跃
         *   #留存
         *   #跳出
         *   #回购
         *
         *   2）模型策略分析
         *
         *
         */
    }
}
