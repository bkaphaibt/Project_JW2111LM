create table Category(
    CateId varchar2(10) not null primary key,
    CateName nvarchar2(200))

create table Product(
    ProId int generated by default as identity primary key,
    ProName nvarchar2(200),
    CateId varchar2(10),
    Producer nvarchar2(200),
    YearMaking int,
    ExpireDate date,
    Price float, 
    constraint FK_CateId foreign key(CateId)  references Category(CateId))

insert into Category values ('C01',N'?i?n t?');
insert into Category values ('C02',N'?i?n l?nh');
insert into Category values ('C03',N'?i?n d�n d?ng');
insert into Category values ('C04',N'Th?i trang nam');
insert into Category values ('C05',N'Th?i trang n?');

select * from Category;
select * from Product;

insert into Product(ProName,CateId,Producer,YearMaking,ExpireDate,Price) values (N'M�y t�nh Dell core i7','C01','Dell',2021,to_Date('2021-12-31','yyyy-MM-dd'),15000000);
