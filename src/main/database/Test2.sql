--member2 테이블

CREATE TABLE Member(
	M_INDEX NUMBER NOT NULL PRIMARY KEY,    
	M_ID VARCHAR(16) NOT NULL,
	M_NAME VARCHAR(15) NOT NULL,
	M_PASSWORD VARCHAR(16) NOT NULL,
	M_EMAIL VARCHAR(50) NOT NULL,
	M_TEL VARCHAR(200) NOT NULL,
	M_ADDRESS VARCHAR(200),
	M_GENDER VARCHAR(2) NOT NULL,
	M_INTRODUCE VARCHAR(200) NOT NULL
);

drop table member;

INSERT INTO MEMBER VALUES(member_index.nextval,'snow','곽승민', '1234', 'snowdrop0207@naver.com', '010-5066-7016','경기도 의정부시','M','하여');

alter table member modify(M_TEL varchar(50));


select * from study
select * from member;
select * from studymember;



update study set s_name = '43번테이블' where s_index = 43 


delete member where M_ID = 'ndw8524'



drop table member
delete from member;

delete member where M_id = 'ndw8524';

select * from tab;

select * from member;
select * from studymember


﻿-- Member테이블 INDEX의 시퀀스
CREATE SEQUENCE member_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

-- Study 테이블 생성
CREATE TABLE Study(
	S_INDEX NUMBER NOT NULL PRIMARY KEY,      -- study_index 시퀀스 처리
	S_NAME VARCHAR(50) NOT NULL,				
	S_C_ID NUMBER NOT NULL,              -- CATEGORY.C_ID 외래키 지정 해줘야 함.
	S_START DATE NOT NULL,							--시작날짜
	S_END DATE NOT NULL,							--끝날짜
	S_MAXMEMBER NUMBER NOT NULL,					--인원
	S_DAY varchar(3) not null,						--요일
	S_time varchar(10) not null,							--활동시간
	S_explain varchar(100) not NULL,				--개요
	S_material	varchar(100) not null,				--프로젝트 준비
	S_effect VARCHAR(100) NOT NULL,				--목표로 바꿔야될듯
	S_PLACE VARCHAR(50) NOT NULL,				--프로젝트 장소
	constraint FK_s_c_id_study  FOREIGN KEY(S_C_ID) references Category(C_ID)	
);

select * from study
select * from category

drop table study


alter table study
rename column s_plopienum to s_peoplenum


delete study

CREATE TABLE Category(
	C_ID NUMBER NOT NULL PRIMARY KEY,        -- Study테이블에 외래키로 사용됨.
	C_GROUP VARCHAR(20) NOT NULL,            -- 대분류
	C_SUB VARCHAR(20) NOT NULL               -- 소분류
)


select * from category					--1번에 번호들어가고 2번에 대분류 3번에 소분류 들어가도록한다.


insert into CATEGORY values (1,'프로그래밍','자바');
insert into CATEGORY values (2,'프로그래밍','c언어');
insert into CATEGORY values (3,'프로그래밍','파이썬');
insert into CATEGORY values (4,'프로그래밍','c++');
insert into CATEGORY values (5,'프로그래밍','c#');

insert into CATEGORY values (6,'언어','영어');
insert into CATEGORY values (7,'언어','불어');
insert into CATEGORY values (8,'언어','중국어');
insert into CATEGORY values (9,'언어','일본어');
insert into CATEGORY values (10,'언어','한국어');

insert into CATEGORY values (11,'자격증','정보처리기사');
insert into CATEGORY values (12,'자격증','컴활');
insert into CATEGORY values (13,'자격증','ccna');
insert into CATEGORY values (14,'자격증','ccnp');
insert into CATEGORY values (15,'자격증','네트워크관리사');

delete from category
select * from category order by c_id asc
select * from study



CREATE SEQUENCE study_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;


-- StudyList 테이블 생성(스터디의 명단 정보)

select * from studyList where sl_m_index = 65;


-- 수정완료 
CREATE TABLE StudyMember(
	SM_S_INDEX NUMBER NOT NULL,
	SM_M_INDEX NUMBER NOT NULL,
	PRIMARY KEY(SL_S_INDEX, SL_M_INDEX)
)

ALTER TABLE StudyMEMBER ADD FOREIGN KEY(SM_S_INDEX) REFERENCES Study(S_INDEX); 
ALTER TABLE StudyMEMBER ADD FOREIGN KEY(SM_M_INDEX) REFERENCES Member(M_INDEX); 

SELECT SL_S_INDEX, SL_M_INDEX FROM StudyList;
INSERT INTO StudyList(SL_S_INDEX, SL_M_INDEX) VALUES (?, ?);
UPDATE StudyList SET SL_S_INDEX=?, SL_M_INDEX=? WHERE SL_S_INDEX=? AND SL_M_INDEX=?;
DELETE FROM StudyList WHERE SL_S_INDEX=? AND SL_M_INDEX=?;



insert into StudyList values(20,66)
insert into StudyList values(21,67)
insert into StudyList values(19,67)



insert into StudyList values(87,65)
insert into StudyList values(88,65)
insert into StudyList values(89,65)
insert into StudyList values(90,65)
insert into StudyList values(91,65)
insert into StudyList values(92,65)
insert into StudyList values(93,65)
insert into StudyList values(94,65)
insert into StudyList values(86,65)
insert into StudyList values(43,65)
insert into StudyList values(41,65)
insert into StudyList values(42,65)
insert into StudyList values(31,65)
insert into StudyList values(32,65)

update study set s_name = '32번 테이블' where s_index = 32;


select * from(  select *  from(  select rownum as rnum, s.s_index, s.s_name ,s.s_peoplenum, nvl(to_number(greatest(sysdate - s.s_start,0))/decode(to_number(s.s_end - s.s_start),0,null,to_number(s.s_end - s.s_start)),0) * 100 progress from study s, studyList sl  where s.s_index = sl.sl_s_index and sl.sl_m_index = 65  order by s_index desc ))  where rnum >= 1 and rnum <= 2 

insert into StudyList values(41,67)
insert into StudyList values(18,67)
insert into StudyList values(42,67)
insert into StudyList values(43,67)


select * from studyList where sl_m_index = 67
select * from study
select * from member;

select * from studyList where sl_m_index = 67


delete from studylist where sl_m_index = 67;
delete from studylist

select * from studyList where sl_m_index = 67;
update study set s_start = to_date('2018-04-30') where s_index = 2;
update study set s_start = to_date('2018-05-30') where s_index = 41;
update study set s_start = to_date('2018-01-30') where s_index = 43;
update study set s_start = to_date('2017-12-30') where s_index = 18;


update study set s_name = '이름좀 ㅡㅡ' where s_index = 18;





select max(s_index) from study; 
select * from studyList where sl_m_index = 65


select * from study







select s_name , round(greatest((greatest((s_end - s_start),0)) - (greatest(sysdate - s_start,0)),0)) as dday from study s , studylist sl
where sl.sl_s_index = s.s_index and sl.sl_m_index = 65







select * from study




select round(greatest((greatest((s_end - s_start),0)) - (greatest(sysdate - s_start,0)),0)) as dday 
		from study s , studylist sl 
		 where sl.sl_s_index = s.s_index and sl.sl_m_index = 65 
		 order by sl.sl_s_index desc;

		 
		 update study set s_name = '20번 테이블' where s_index = 20





select * from( 
			 select s_end, rownum as rnum, s_index,s_name,s_peoplenum,progress 
			 from( 
			 select s_end ,rownum as rnum, s.s_index, s.s_name ,s.s_peoplenum, nvl(to_number(sysdate - s.s_start)/decode(to_number(s.s_end - s.s_start),0,null,to_number(s.s_end - s.s_start)),0) * 100 progress from study s, studyList sl
			   where s.s_index = sl.sl_s_index and sl.sl_m_index = 65 order by s_index desc 
			 )where progress > 0) 
			 
			 
			 
			 
			 select * from( 
			select rownum as rnum, s_index,s_name,s_peoplenum,progress 
			 from( 
			 select rownum as rnum, s.s_index, s.s_name ,s.s_peoplenum, nvl(to_number(greatest(sysdate - s.s_start,0))/decode(to_number(s.s_end - s.s_start),0,null,to_number(s.s_end - s.s_start)),0) * 100 progress from study s, studyList sl
			   where s.s_index = sl.sl_s_index and sl.sl_m_index = 65 order by s_index desc 
			 )where progress > 0 ) 
		
select * from study

select * from member;

select * from studymember


update study set s_start = '2018-06-03' where s_name = '7'
update study set s_end = '2018-06-05' where s_name = '7'
update study set s_start = '2018-06-06' where s_index = '81'
update study set s_end = '2018-06-07' where s_index = '첫뻔째 test'


delete study where s_name ='alert 실험1'
delete study where s


delete from study
delete from studyList

insert into study


rollback;

select * from study
select * from studymember
selec

insert into studymember value(1,1)
insert into study value(0,'스터디이름','101','')

select * from category



select count(rnum) as count from( 
			 select rownum as rnum, s_index,s_name,s_maxmember,progress 
			 from( 
			 select rownum as rnum, s.s_index, s.s_name , s.s_maxmember, nvl(to_number(greatest(sysdate - s.s_start,0))/decode(to_number(s.s_end - s.s_start),0,null,to_number(s.s_end - s.s_start)),0) * 100 progress from study s, studymember sm 
			   where s.s_index = sm.sm_s_index and sm.sm_m_index = 34 order by s_start desc
			 )where progress < 100 ) 


select * from( 
			 select s_start,s_end, rownum as rnum, s_index,s_name,s_maxmember,progress 
			 from( 
			 select s.s_start,s.s_end,rownum as rnum, s.s_index, s.s_name ,s.s_maxmember, nvl(to_number(greatest(sysdate - s.s_start,0))/decode(to_number(s.s_end - s.s_start),0,null,to_number(s.s_end - s.s_start)),0) * 100 progress from study s, studymember sm 
			   where s.s_index = sm.sm_s_index and sm.sm_m_index = 34 order by s_start desc 
			 )where progress < 100) 
			 where rnum >= 1 and rnum <= 2 
			 
			 
			 
			 
select * from( 
			 select rownum as rnum, s_index, dday, progress 
			 from( 
			 select s_index, greatest((greatest((s_end - s_start),0)) - (greatest(sysdate - s_start,0)),0) as dday,nvl(to_number(greatest(sysdate - s.s_start,0))/decode(to_number(s.s_end - s.s_start),0,null,to_number(s.s_end - s.s_start)),0) * 100 progress  
			 from study s , studymember sm 
			 where sm.sm_s_index = s.s_index and sm.sm_m_index = 34 order by s_start desc ) where progress < 100 ) 
			 where rnum >= 1 and rnum <= 2 

			 
			 
			 
			 
			 
			 
			 select * from STUDYMEMBER
			 
			 select * from category
			 select * from study
			 select * from member;
			 
			delete from member where M_id = 'ndw8524'
			 
			 update study set s_start = '2018-03-14' where s_index = 21
			 update study set s_end = '2018-05-14' where s_index = 21
			 
			 
			 
			 select m_name from study s , member m 
			where m.m_index = s.s_m_index 
			 

