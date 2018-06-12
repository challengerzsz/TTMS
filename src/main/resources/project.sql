create table user_table (
  id int unique key auto_increment,
  username varchar(20) primary key not null,
  password varchar(50) not null,
  type int(1) not null default 0,
  realName varchar(10) not null,
  email varchar(50),
  phone varchar(11) not null,
  address varchar(50) not null,
  create_time timestamp default now(),
  update_time timestamp default now(),
)engine = InnoDB charset = utf8;

create table movies_table(
  countid int unique key auto_increment,
  sn int default 0,
  cnms int default 0,
  late int(1) default 0,
  showInfo varchar(50),
  nm varchar(50) not null ,
  dir varchar(50) ,
  star varchar(50),
  cat varchar(50),
  wish varchar(50),
  3d int(1) default 0,
  pn varchar(50),
  img varchar(300),
  preSale int,
  vd varchar(50),
  scm varchar(30),
  sc varchar(50),
  ver varchar(50),
  rt varchar(50),
  dur int,
  src varchar(50),
  showDate varchar(50),
  imax int(1),
  snum varchar(50),
  time varchar(50),
  price double default 0,
  id varchar(10) primary key,
  status int(1) default 0)
  engine = InnoDB charset = utf8;


create table hall_table(
  id int unique key auto_increment,
  hall_name varchar(10) not null,
  seatCount int not null,
  describ varchar(100),
  status int(1) default 1
)engine = InnoDB charset = utf8;



create table schedule_table (
  id int unique key auto_increment,
  movieId varchar(10) not null,
  hallId int not null,
  price double default 0,
  startTime timestamp not null,
  endTime timestamp not null,
  foreign key (movieId) references movies_table (id),
  foreign key (hallId) references hall_table (id)
)engine = InnoDB charset = utf8;



create table ticket_table(
  id int unique key auto_increment,
  movieId varchar(10) not null,
  hallId int not null,
  startTime timestamp not null,
  seatRow int not null,
  seatColumn int not null,
  ticketPrice double not null,
--   type为1时是指该票是由售票员售出
  type int(1) default 0,
  userId int default 0,
  createTime timestamp default now(),
  sellerId int not null default 0,
  foreign key (movieId) references movies_table (id),
  foreign key (hallId) references hall_table (id),
  index (movieId)
)engine = InnoDB charset = utf8;


create table analysis_table (
  id int unique key auto_increment,
  userId int primary key not null,
  sold double not null default 0,
  foreign key (userId) references user_table (id)
)engine = InnoDB charset = utf8;

delimiter $$
create trigger init_analysis_trigger after insert
on user_table for each row begin
if new.type = 1
insert into analysis_table values (null, new.id, 0);
end if;
end;
$$
delimiter ;


delimiter $$
create trigger update_analysis_trigger after insert
on ticket_table for each row begin
if new.type = 1
then
update analysis_table set sold = sold + new.ticketPrice;
end if;
end;
$$
delimiter ;


delimiter $$
create trigger delete_movie_trigger after delete
on movies_table for each row begin
delete from schedule_table where movieId = old.id;
delete from ticket_table where movieId = old.id;
end;
$$
delimiter ;


delimiter $$
create trigger delete_schedue_trigger after delete
on movies_table for each row begin
delete from schedule_table where movieId = old.id;
delete from ticket_table where movieId = old.id;
end;
$$
delimiter ;


-- 打开事件线程
SET GLOBAL event_scheduler=1;
-- 关闭safe-updates
SET SQL_SAFE_UPDATES = 0;



drop event if exists delete_afternow_event;
delimiter $$
create event delete_afternow_event
on schedule every 10 MINUTE do
begin
delete from ticket_table where startTime < current_timestamp;
delete from schedule_table where startTime < current_timestamp;
end;
$$
delimiter ;



create view analysis_view as
SELECT user.id, user.username, user.realName, user.email, user.phone,
user.address, an.sold FROM user_table user, analysis_table an WHERE user.id = an.userId;
