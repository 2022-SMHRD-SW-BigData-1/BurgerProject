create table Score1
(
score number(20) not null
constraint Score1_score_pk primary key
);

create table memberInfo
(
id varchar2(20) not null
constraint memberInfo_id_pk primary key,
password varchar2(20) not null,
nickname varchar2(20) not null,
score number(20) not null,
constraint fk_memberInfo_score foreign key(score) references Score1(score)
);

create table Ranking
(
id varchar2(10) not null,
score number(20) not null,
constraint Ranking_id_fk foreign key(id) references memberInfo(id),
constraint Ranking_score_fk foreign key(score) references Score1(score)
);