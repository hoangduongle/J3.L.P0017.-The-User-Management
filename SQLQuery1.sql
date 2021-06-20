create database UserManagerment

use UserManagerment

create table tblRoles(
	RoleID int primary key,
	RoleName varchar(50)
)
go

create table tblPromotions(
	ProID	int IDENTITY(1,1) primary key,
	ProName varchar(50) not null,
)
go

create table tblUsers(
	UserID		int IDENTITY(1,1) primary key,
	UserName	varchar(50) not null,
	PassWord	varchar(10) not null,
	Email		varchar(50),
	Phone		varchar(10),
	Photo		varchar(100) not null,
	Status		bit not null,
	RoleID int foreign key references tblRoles(RoleID)
)
go

create table tblDetails(
	intRank		int,
	UserID int foreign key references tblUsers(UserID),
	ProID int foreign key references tblPromotions(ProID)
)
go

create table tblHistory(
	Adddate varchar(10),
	UserID int foreign key references tblUsers(UserID),
	ProID int foreign key references tblPromotions(ProID)
)
go

insert into tblRoles(RoleID,RoleName) values('1','Admin')
insert into tblRoles(RoleID,RoleName) values('2','Member')

select * 
from tblRoles

insert into tblUsers(UserName,PassWord,Email,Phone,Photo,Status,intRank,RoleID,ProID) 
values('admin','1','admin@gmail.com','1234567899','https://cdn.icon-icons.com/icons2/1378/PNG/512/avatardefault_92824.png','1',null,'1',null)

insert into tblUsers(UserName,PassWord,Email,Phone,Photo,Status,intRank,RoleID,ProID) 
values
('hoang','1','hoang@gmail.com','1234567899','https://cdn.icon-icons.com/icons2/1378/PNG/512/avatardefault_92824.png','1',null,'2',null),
('le','1','le@gmail.com','1234567899','https://cdn.icon-icons.com/icons2/1378/PNG/512/avatardefault_92824.png','1',null,'1',null)

insert into tblUsers(UserName,PassWord,Email,Phone,Photo,Status,intRank,RoleID,ProID) 
values
('thuc','1','thuc@gmail.com','1234567899','https://cdn.icon-icons.com/icons2/1378/PNG/512/avatardefault_92824.png','1',null,'2',null),
('dat','1','dat@gmail.com','1234567899','https://cdn.icon-icons.com/icons2/1378/PNG/512/avatardefault_92824.png','1',null,'2',null),
('hoangden','1','hoangden@gmail.com','1234567899','https://cdn.icon-icons.com/icons2/1378/PNG/512/avatardefault_92824.png','2',null,'1',null)


select UserID,UserName,PassWord,Email,Phone,Photo,Status,intRank,RoleID,ProID
from tblUsers
where UserName = 'admin' and PassWord = '1'

select UserID,UserName,RoleID
from tblUsers
where UserName = 'admin' and PassWord = '1'

select UserID,UserName,PassWord,Email,Phone,Photo,Status,RoleID
from tblUsers
where UserName = '%a%'

SELECT *
FROM tblUsers
ORDER BY UserID
OFFSET 0 ROWS
FETCH NEXT 5 ROWS ONLY

update tblUsers
set UserName = 'b',PassWord = 'a' ,Email = 'a', Phone = 'a', Photo = 'a', Status = 'false' ,RoleID = 2
where UserID = '15'


select UserID,UserName,PassWord,Email,Phone,Photo,Status,intRank,RoleID,ProID
from tblUsers



select intRank, UserID, d.ProID, p.ProName
from tblDetails d inner join tblPromotions p on d.ProID = p.ProID

select ProID, ProName
from tblPromotions

insert into tblDetails values(5,5,1)

select UserID,UserName
from tblUsers
where RoleID = 2

select intRank, u.UserID, u.UserName
from tblUsers u inner join tblDetails d on u.UserID = d.UserID