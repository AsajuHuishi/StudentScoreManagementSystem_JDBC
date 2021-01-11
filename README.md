# 学生成绩管理系统

本文是**MySQL+java: [实现学生成绩管理系统（2.0版本）](https://blog.csdn.net/qq_36937684/article/details/112502793)，是基于[MySQL+java: 实现学生成绩管理系统（1.0版本）](https://blog.csdn.net/qq_36937684/article/details/108757156)进行修改优化的版本** 

## 任务
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200923171232277.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzM2OTM3Njg0,size_16,color_FFFFFF,t_70#pic_center)
## 代码功能介绍
代码     | 功能
-------- | -----
StuScore.java  | 建立和stu_score表相同的字段
JDBCUtils.java  | 封装数据库的连接与关闭
CRUDUtils.java | 封装增删改查SQL语句
StuScoreOperation.java| 实现对数据库具体业务操作
StuMenu.java| 实现学生成绩管理系统菜单
Main.java|主函数

## 环境
 - JDK 1.8
 - MySQL 5.5.15
 - JDBC 5.1.
 
## 使用
使用MySQL生成表
包括 学号，姓名，成绩，班级四个字段。
```sql
USE students;

DROP TABLE IF EXISTS stu_score;
CREATE TABLE IF NOT EXISTS stu_score(
	NO VARCHAR(10),
	NAME VARCHAR(20),
	score FLOAT,
	className INT
);

DESC stu_score;
``` 

## 样例
见[实现学生成绩管理系统（2.0版本）](https://blog.csdn.net/qq_36937684/article/details/112502793)
