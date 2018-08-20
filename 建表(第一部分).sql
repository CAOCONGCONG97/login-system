/*
课程设计数据库建立
1.第一步  
创建数据库 park
查询数据库
*/

SHOW DATABASES 

CREATE DATABASE  park;

/*
2.第二步
选中park数据库
*/

USE park
/*
1.第三步  
创建表
*/
CREATE TABLE users
(
    NAME VARCHAR(10) PRIMARY KEY,
    PASSWORD VARCHAR(11) NOT NULL
);


/*
第四步骤  
添加一个用户名和密码
*/
INSERT INTO users (NAME,PASSWORD)
VALUES ('cao','123');
/*查询是否添加成功*/
SELECT *
FROM users
