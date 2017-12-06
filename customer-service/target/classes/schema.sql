drop table T_CUSTOMER if exists; 
 
create table T_CUSTOMER (ID bigint identity primary key, 
                         ACCOUNT_NUMBER varchar(9), NAME varchar(50) not null, unique(ACCOUNT_NUMBER));
                        
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456789', 'Keri Lee');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456001', 'Dollie R. Schnidt');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456002', 'Cornelia J. LeClerc');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456003', 'Cynthia Rau');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456004', 'Douglas R. Cobbs');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456005', 'Michael Patel');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456006', 'Suzanne Wong');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456007', 'Ivan C. Jaya');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456008', 'Ida Ketterer');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456009', 'Laina Ochoa Lucero');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456010', 'Wesley M. Montana');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456011', 'Leslie F. McCleary');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456012', 'Sayeed D. Mudra');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456013', 'Pietronella J. Domingo');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456014', 'John S. O''Leary');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456015', 'Gladys D. Smith');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456016', 'Sally O. Thygesen');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456017', 'Rachel Vogt');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456018', 'Julia DeLong');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456019', 'Mark T. Rizzoli');
insert into T_CUSTOMER (ACCOUNT_NUMBER, NAME) values ('123456020', 'Maria J. Angelo');