--member2 테이블
	 s_place LIKE ? and s_name LIKE ? and category.C_SUB LIKE ? 
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
public static final String QUERY_GET3 = select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where s_place LIKE ? and s_name LIKE ? and category.C_SUB LIKE ? ;
	
select * from studylist

select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE ,C_SUB
from (
select *
from (
select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where c_sub LIKE '%자바%' order by s_index)
 where s_place LIKE '%서울%' or s_place LIKE '%인천%' or s_place LIKE '%세종%' or s_place LIKE '%부산%')
 where s_name LIKE '%자바%') where rnum >= 1 and rnum <= 5 

select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID 
where s_name LIKE '%토익%' AND s_place LIKE '%서울%' or s_place LIKE '%부천%' or s_place LIKE '%인천%' or s_place LIKE '%춘천%' AND c_sub LIKE '%영어%' order by s_index where rnum >= 1 and rnum <= 5

drop table member;

select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE from (select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE from (select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID   order by s_index))) where rnum >= 1 and rnum <= 5


select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE from (select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE from (select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID  where s_name LIKE 자바 order by s_index))) where rnum >= 1 and rnum <= 5


select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE from (select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE from 
(select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where   order by s_index))) where rnum >= 1 and rnum <= 5


select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE from (select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE from (select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID  order by s_index))) where rnum >= 1 and rnum <= 5

select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE from (select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE from (select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID  where s_name LIKE '%자바%' or s_place LIKE '%서울%' or s_place LIKE '%부천%' or s_place LIKE '%인천%' or s_place LIKE '%춘천%'  order by s_index))) where rnum >= 1 and rnum <= 5

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

select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE, C_SUB from (select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE, C_SUB from (select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID  order by s_index))) 


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

select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE from (select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE
 from (select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID  where s_name LIKE '%토익%' order by s_index)WHERE  s_place LIKE '%서울%' or s_place LIKE '%부천%' or s_place LIKE '%인천%'  )) where rnum >= 1 and rnum <= 5

select * from
(select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE, c_sub 
from (select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE, c_sub from 
(select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID  where s_name LIKE '%토익%'  order by s_index))) 
where rnum >= 1 and rnum <= 5 and s_place LIKE '%서울%' or s_place LIKE '%부천%' or s_place LIKE '%인천%' and c_sub LIKE '%영어%' 


select * from 
(select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE from 
(select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE from 
(select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID  where s_name LIKE '%토익%' and c_sub LIKE '%영어%' 
order by s_index))) where rnum >= 1 and rnum <= 5 and s_place LIKE '%서울%' or s_place LIKE '%부천%' or s_place LIKE '%인천%' or s_place LIKE '%춘천%'

select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE, C_SUB from (select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE from (select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID  where s_name LIKE '%자바%' and c_sub LIKE '%자바%' order by s_index))) where rnum >= 1 and rnum <= 5

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
			 
select * from study;
select * from studymember;
			 








--문의 사항 게시판
create table inquiryBoard(
	i_index number not null primary key,	--게시판 인덱스
	i_m_index number not null,						--멤버테이블의 인덱스 참조
	i_subject varchar(50) not null,			--게시판 글 의 제목
	i_file varchar2(50), 					--게시판에 올릴 사진
	i_content varchar(300) not null,			--게시글 내용
	i_date date not null,					--게시글 작성 날짜
	constraint FK_i_m_index_member foreign key(i_m_index) references member(m_index))	--멤버의 인덱스 번호를 참조함
	
	
	
	--drop table inquiryBoard
	
	
	
	
	drop table i_comment
-- 댓글 테이블
	create table i_comment(
	comment_index number not null primary key, 				-- 댓글 테이블의 번호
	comment_m_index number not null,						-- 댓글을 누가썻는지 아이디를 받아올인덱스 번호
	comment_ib_index number not null,						-- 댓글이 어떤게시판에 달렸는지 게시판에 인덱스 번호를 가져옴
	comment_content varchar(50) not null,					-- 댓글의 내용
  	comment_re_ref number not null,							-- 어떤 댓글을 참조 할 글의 번호
	comment_re_lev number not null,							-- 대댓글을 레벨에 위치에 따라서 밀린다, 글의 깊이
	comment_re_seq number not null,							--답변 글의 순서
	comment_date date not null)								--댓글이 달린 날짜
	drop table i_comment
	
	alter table i_comment add constraint fk_c_m_index foreign key(comment_m_index)
	references member(m_index)		-- 멤버의 인덱스 번호참조
	alter table i_comment add constraint fk_ib_index foreign key(comment_ib_index)
	references inquiryBoard(i_index) 		-- 게시판에 인덱스 번호 참조
	
	



select * from i_comment;

insert into i_comment
values (1,12,1,'이게 댓글이다',0,0,0,sysdate)


select * from member;
select * from inquiryBoard

delete inquiryboard
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요질문있습니다','파일','이게뭔가요?',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요질문또있습니다','파일','이건뭔가요?',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요질문또또있습니다','파일','이건또뭔가요?',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트입니다','파일','하나둘셋',sysdate)

insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트1','파일','하나둘셋',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트2','파일','하나둘셋',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트3','파일','하나둘셋',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트4','파일','하나둘셋',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트5','파일','하나둘셋',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트6','파일','하나둘셋',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트7','파일','하나둘셋',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트8','파일','하나둘셋',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트9','파일','하나둘셋',sysdate)

insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트10','파일','하나둘셋',sysdate)


insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트11','파일','하나둘셋',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트12','파일','하나둘셋',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트13','파일','하나둘셋',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트14','파일','하나둘셋',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트15','파일','하나둘셋',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트16','파일','하나둘셋',sysdate)
insert into inquiryBoard values(inquiry_index.nextval,11,'안녕하세요테스트17','파일','하나둘셋',sysdate)






select * from member;


CREATE SEQUENCE inquiry_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;




desc i_comment


select * from inquiryBoard



	select * from study
	select * from member
	
	
	select * from (select rownum rnum,i_subject,i_date, m_id from (select m.m_id,rownum rnum, ib.i_subject, ib.i_date
       from inquiryboard ib, member m where m.m_index = ib.i_m_index and ib.i_m_index = 35
order by ib.i_index desc))
where rnum >= 1 and rnum <= 2

update study set s_start = '2018-05-09'
update study set s_end = '2018-05-30'

select * from study



----------------------------------------------------------------------- 2018 06 11 수정------------------------------------------------------------------------------------------------

--	primary key(comment_m_index,comment_ib_index)
drop table i_comment

create table i_comment(
	comment_index number not null ,
	comment_m_index number not null,
	comment_ib_index number not null,
	comment_content varchar(300) not null,
	comment_date date,
	primary key (comment_index)
	)
	alter table i_comment add foreign key(comment_m_index) references member(m_index);
	alter table i_comment add foreign key(comment_ib_index) references inquiryboard(i_index);
	
	
	select c.comment_content, m.m_id, c.comment_date from i_comment c , member m 
			 where c.comment_m_index = m.m_index and comment_ib_index = 23
	
	select * from i_comment
	select * from member
	select * from inquiryboard 
	

	
	CREATE SEQUENCE comment_seq
START WITH 1
INCREMENT BY 1
NOMAXVALUE;



select * from member;
select * from study where s_m_index =12;


update study set s_start = '2018-05-23', s_end ='2018-06-13' where s_name = 'ddd'
