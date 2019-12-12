CREATE TABLE userifno(
	userId INT PRIMARY KEY AUTO_INCREMENT,
	userName VARCHAR(20) UNIQUE,
	userPwd VARCHAR(20),
	userCharactor INT,
	isDelete INT DEFAULT 1
)

DROP TABLE userifno	
INSERT INTO userifno VALUES(1,'zhangsan','123456',2,0)
INSERT INTO userifno VALUES(3,'wangwu','123456',0,0)
SELECT * FROM userifno
DELETE FROM userifno WHERE userId=1;
SELECT * FROM userifno WHERE userName='zhangsan' AND isDelete = 0


CREATE TABLE detailstutorial(
	dtNum INT PRIMARY KEY,
	specialSubject VARCHAR(50),
	exampleType VARCHAR(50),	
	
	title VARCHAR(20),
	context TEXT,
	
	explainContext TEXT,
	
	runResult TEXT,
	filePath TEXT,
	isDelete INT
)

DROP TABLE detailstutorial

INSERT INTO detailstutorial VALUES(1,'Java基础','Java基础语法','hello world','public class StringDemo{
   public static void main(String args[]){
      char[] helloArray = { "r", "u", "n", "o", "o", "b"};
      String helloString = new String(helloArray);  
      System.out.println( helloString );
   }
}','注意:String 类是不可改变的，所以你一旦创建了 String 对象，那它的值就无法改变了（详看笔记部分解析）。

如果需要对字符串做很多修改，那么应该选择使用 StringBuffer & StringBuilder 类。','hello world',
'1',0)

DELETE FROM detailstutorial WHERE dtNum != 1

update detailstutorial set isDelete = 1 where exampleType = '2'

update detailstutorial set exampleType = 'Java String' where dtNum = 2
select * from detailstutorial 
select count(*) from detailstutorial

select distinct(specialSubject) from detailstutorial
select specialSubject,exampleType,title,context,explainContext,runResult,filePath 
from detailstutorial 
where exampleType = 'Java基础语法' 
Java基础语法
UPDATE detailstutorial set specialSubject = "Java基础"



update exampleTutorial set isDelete = 0
create table exampleTutorial(
	
	tutorialNum int primary key,
	userId INT,
	
	uploadTime varchar(20) ,
	dtNum int,
	isDelete int,
	FOREIGN KEY (userId) REFERENCES userifno(userId),
	FOREIGN KEY (dtNum) REFERENCES detailstutorial(dtNum)
)


insert into exampleTutorial values(1,2,'2019-3-5',1,0)
select * from exampleTutorial
delete from exampleTutorial where tutorialNum != 1


update exampleTutorial set dtNum = 2 where tutorialNum = 2

select count(*) from exampleTutorial

drop table exampleTutorial
select * from exampleTutorial where dtNum = 2



create table resourcesTable(
	num int AUTO_INCREMENT primary key,
		varchar(20),
	path text,
	isDelete int 
)
drop table resourcesTable
select * from resourcesTable
select * from resourcesTable where isDelete=0 limit 0,5;
delete from resourcesTable 