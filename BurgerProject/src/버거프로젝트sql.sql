create table memberInfo(
id varchar2(30)
constraint memberInfo_id_pk primary key
constraint memberInfo_id_nn not null,
password varchar2(30)
constraint memberInfo_password_nn not null,
nickname varchar2(30)
constraint memberInfo_nickname_uk unique
constraint memberInfo_nickname_nn not null,
score number(20)
constraint memberInfo_score_uk unique
constraint memberInfo_score_nn not null);

create table Ranking(
nickname varchar2(30)
constraint Ranking_nickname_fk references memberInfo(nickname)
constraint Ranking_nickname_nn not null,
score number(30)
constraint Ranking_score_fk references memberInfo(score)
constraint Ranking_score_nn not null);

select * from memberInfo;
