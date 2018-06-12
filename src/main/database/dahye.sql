-- Member테이블 INDEX의 시퀀스
CREATE SEQUENCE member_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

select B_NO, B_TITLE, M_NAME, B_DATE, B_FILENAME from (SELECT ROWNUM RNUM, B_NO, B_TITLE, M_NAME, B_DATE, B_S_INDEX, B_FILENAME FROM (select B_NO, B_TITLE, M_NAME, B_DATE, B_S_INDEX, B_FILENAME from BOARD b, MEMBER m where B_M_INDEX = m.M_INDEX ORDER BY B_NO DESC)) where B_S_INDEX = (select S_INDEX from STUDY where S_INDEX = 5) AND RNUM>=1 AND RNUM<=10


select * from board;

select * from study;
select count(*) from studymemberlist where S_INDEX = 3
select * from studymemberlist;
update board set B_DATE = '2018-06-05' where B_NAME='ㅂㅈㄷ'

select B_NO, B_TITLE, B_NAME, B_DATE from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b) where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = 3) AND RNUM>=11 AND RNUM<=20 ORDER BY B_NO desc

select B_NO, B_TITLE, B_NAME, B_DATE from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b) where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = 3) AND RNUM>=1 AND RNUM<=10 AND B_TITLE like '%교재%'  ORDER BY B_NO desc

select * from board order by B_NO desc;

drop table Member;
-- Member 테이블 생성
CREATE TABLE Member(



select * from board;


insert into BOARD values (board_no.nextval, 스터디번호, , sysdate, 'ㅌㅌㅌ', '5', null);



select count(*) from (select distinct C_GROUP from category);

select * from category;




	M_INDEX NUMBER NOT NULL PRIMARY KEY,      -- member_index 시퀀스 처리
	M_ID VARCHAR(16) NOT NULL,
	M_PASSWORD VARCHAR(16) NOT NULL,
	M_NAME VARCHAR(15) NOT NULL,
	M_EMAIL VARCHAR(50) NOT NULL,
	M_TEL NUMBER NOT NULL,
	M_ADDRESS VARCHAR(200),
	M_GENDER VARCHAR(2) NOT NULL,
	M_INTRODUCE VARCHAR(200) NOT NULL
)

SELECT M_NAME, M_TEL, M_EMAIL FROM MEMBER;
SELECT * FROM Member;
SELECT COUNT(*) FROM MEMBER;
ALTER SEQUENCE member_index INCREMENT BY 1;   -- 시퀀스의 값을 1로 바꿔줌.

-- Study 테이블 생성
CREATE TABLE Study(
	S_INDEX NUMBER NOT NULL PRIMARY KEY,      -- study_index 시퀀스 처리
	S_NAME VARCHAR(16) NOT NULL,         
	S_C_ID NUMBER NOT NULL,              -- CATEGORY.C_ID 외래키 지정 해줘야 함.
	S_PLACE VARCHAR(50) NOT NULL,             -- 수정 요망.
	S_TIME DATE NOT NULL,
	S_PLOPIENUM NUMBER NOT NULL,
	S_GOAL VARCHAR(100) NOT NULL,             -- 추가 조정(테이블 따로 뺄것인지?)
	S_TERM DATE NOT NULL
)

INSERT INTO Study VALUES(study_index.nextval,'JAVA&JSP',3,'부천','20180528','5','자바와 JSP 마스터', '20180528')

SELECT * FROM Study;

-- Study 테이블 INDEX의 시퀀스
CREATE SEQUENCE study_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

-- Category 테이블 생성 (스터디 분야에 대한 정보)
CREATE TABLE Category(
	C_ID NUMBER NOT NULL PRIMARY KEY,        -- Study테이블에 외래키로 사용됨.
	C_GROUP VARCHAR(20) NOT NULL,            -- 대분류
	C_SUB VARCHAR(20) NOT NULL               -- 소분류
)

SELECT * FROM Category;

ALTER TABLE Study MODIFY(S_C_ID NUMBER);
ALTER TABLE Study ADD FOREIGN KEY(S_C_ID) REFERENCES Category(C_ID); -- 외래키 지정.


ALTER TABLE PreferenceArea ADD FOREIGN KEY(P_M_INDEX) REFERENCES Member(M_INDEX); 

-- StudyList 테이블 생성(스터디의 명단 정보)
CREATE TABLE StudyList(
	SL_S_INDEX NUMBER NOT NULL,
	SL_M_INDEX NUMBER NOT NULL,
	PRIMARY KEY(SL_S_INDEX, SL_M_INDEX)
)

ALTER TABLE StudyList ADD FOREIGN KEY(SL_S_INDEX) REFERENCES Study(S_INDEX); 
ALTER TABLE StudyList ADD FOREIGN KEY(SL_M_INDEX) REFERENCES Member(M_INDEX); 

-- Board 테이블 생성(게시판 정보)
CREATE TABLE Board(
	B_NO NUMBER NOT NULL PRIMARY KEY,
	B_M_INDEX NUMBER NOT NULL,
	B_DATE VARCHAR(10) NOT NULL,
	B_CONTENT VARCHAR(300) NOT NULL               -- CLOE처리 할수도..
)

-- Board 테이블 NO의 시퀀스
CREATE SEQUENCE board_no
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

ALTER TABLE Board ADD FOREIGN KEY(B_M_INDEX) REFERENCES Member(M_INDEX); 

-- Notice 테이블 생성(스터디 내에 공지사항 정보)
CREATE TABLE Notice(
	N_S_INDEX NUMBER NOT NULL PRIMARY KEY,
	N_CONTENT VARCHAR(300) NOT NULL              -- CLOE처리 할수도
)

ALTER TABLE Notice ADD FOREIGN KEY(N_S_INDEX) REFERENCES Study(S_INDEX);

﻿CREATE TABLE Fee(
	F_ID NUMBER NOT NULL PRIMARY KEY,
	F_TITLE VARCHAR(50) NOT NULL,
	F_DATE DATE NOT NULL
)

CREATE SEQUENCE fee_id
START WITH 1
INCREMENT BY 1
NOMAXVALUE;


CREATE TABLE FeeMember(
	FM_ID NUMBER NOT NULL PRIMARY KEY,
	FM_M_INDEX NUMBER NOT NULL,
	FM_F_ID NUMBER NOT NULL,
	FM_FEE NUMBER NOT NULL,
	FM_NOTE VARCHAR(30)
)

CREATE SEQUENCE feemember_id
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

ALTER TABLE FeeMember ADD FOREIGN KEY(FM_M_INDEX) REFERENCES Member(M_INDEX);
ALTER TABLE FeeMember ADD FOREIGN KEY(FM_F_ID) REFERENCES Fee(F_ID);

CREATE TABLE FeeExpense(
	FE_ID NUMBER NOT NULL PRIMARY KEY,
	FE_F_ID NUMBER NOT NULL,
	F_EXPENSE VARCHAR(30) NOT NULL,
	F_EXPENSEFEE NUMBER NOT NULL
)

CREATE SEQUENCE feeexpense_id
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

ALTER TABLE FeeExpense ADD FOREIGN KEY(FE_F_ID) REFERENCES Fee(F_ID);

-- 테이블 전체 보기.
select * from tab;

INSERT INTO MEMBER VALUES(member_index.nextval,'js','1111','이다혜','dahye3059@naver.com',01023503059,'경기도 부천시','W','안녕하세요')
INSERT INTO MEMBER VALUES(member_index.nextval,'qwe','qwe','이다혜2','dahye3059@naver.com',0102350305,'경기도 부천시2','W','안녕하세요2')
INSERT INTO MEMBER VALUES(member_index.nextval,'asd','asd','이다혜3','dahye3059@naver.com',010235030,'경기도 부천시3','W','안녕하세요3')
INSERT INTO MEMBER VALUES(member_index.nextval,'zxc','zxc','이다혜4','dahye3059@naver.com',01023503,'경기도 부천시4','W','안녕하세요4')
select * from MEMBER;


drop table Board;

CREATE TABLE Board(
	B_NO NUMBER NOT NULL PRIMARY KEY,
	B_NAME VARCHAR(10) NOT NULL,
	B_TITLE VARCHAR(50) NOT NULL,
	B_DATE VARCHAR(10) NOT NULL,
	B_CONTENT VARCHAR(300) NOT NULL,              -- CLOE처리 할수도..
	B_S_INDEX NUMBER NOT NULL,
	B_FILENAME VARCHAR(300)
)

select * from board;
drop table board cascade CONSTRAINT;
select * from (SELECT ROWNUM RNUM, B_NO, B_TITLE, B_NAME, B_DATE, B_S_INDEX FROM BOARD b) where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = 3) AND RNUM>=1 AND RNUM<=10 ORDER BY B_NO;
select B_S_INDEX from board

insert into Board values(board_no.nextval, '이다혜', '회비관련 공지하겠습니다.', '2018-05-25', '저번에 회비 안낸 노동완씨 이번에 꼭 내십시요.', 3, '파일1.jpg');
insert into Board values(board_no.nextval, '소문혁', '교재관련 공지하겠습니다.', '2018-05-22', '안녕하시요', 3, '파일2.jpg');
insert into Board values(board_no.nextval, '구명회', '회비관련 공지하겠습니다.', '2018-05-20', '가나다라마바사', 3, '파일3.jpg');
insert into Board values(board_no.nextval, '노동완', '장소관련 공지하겠습니다.', '2018-04-02', '이거는 내용내용', 3, null);
insert into Board values(board_no.nextval, '곽승민', '교재관련 공지하겠습니다.', '2018-02-25', '여기도 내용내용내용!!!', 3, null);
insert into Board values(board_no.nextval, '이다혜1', '회비관련 공지하겠습니다.', '2018-05-25', '저번에 회비 안낸 노동완씨 이번에 꼭 내십시요.', 3, null);
insert into Board values(board_no.nextval, '소문혁1', '교재관련 공지하겠습니다.', '2018-05-22', '안녕하시요', 3, null);
insert into Board values(board_no.nextval, '구명회1', '회비관련 공지하겠습니다.', '2018-05-20', '가나다라마바사', 3, null);
insert into Board values(board_no.nextval, '노동완1', '장소관련 공지하겠습니다.', '2018-04-02', '이거는 내용내용', 3, null);
insert into Board values(board_no.nextval, '곽승민1', '교재관련 공지하겠습니다.', '2018-02-25', '여기도 내용내용내용!!!', 3, null);
insert into Board values(board_no.nextval, '이다혜2', '회비관련 공지하겠습니다.', '2018-05-25', '저번에 회비 안낸 노동완씨 이번에 꼭 내십시요.', 3, null);
insert into Board values(board_no.nextval, '소문혁2', '교재관련 공지하겠습니다.', '2018-05-22', '안녕하시요', 3, null);
insert into Board values(board_no.nextval, '구명회2', '회비관련 공지하겠습니다.', '2018-05-20', '가나다라마바사', 3, null);
insert into Board values(board_no.nextval, '노동완2', '장소관련 공지하겠습니다.', '2018-04-02', '이거는 내용내용', 3, null);
insert into Board values(board_no.nextval, '곽승민2', '교재관련 공지하겠습니다.', '2018-02-25', '여기도 내용내용내용!!!', 3, null);
insert into Board values(board_no.nextval, '이다혜3', '회비관련 공지하겠습니다.', '2018-05-25', '저번에 회비 안낸 노동완씨 이번에 꼭 내십시요.', 3, null);
insert into Board values(board_no.nextval, '소문혁3', '교재관련 공지하겠습니다.', '2018-05-22', '안녕하시요', 3, null);
insert into Board values(board_no.nextval, '구명회3', '회비관련 공지하겠습니다.', '2018-05-20', '가나다라마바사', 3, null);
insert into Board values(board_no.nextval, '노동완3', '장소관련 공지하겠습니다.', '2018-04-02', '이거는 내용내용', 3, null);
insert into Board values(board_no.nextval, '곽승민3', '교재관련 공지하겠습니다.', '2018-02-25', '여기도 내용내용내용!!!', 3, null);

select * from board;


select B_NO, B_TITLE, B_M_INDEX, B_DATE 
from (select rownum rnum, B_NO, B_TITLE, B_M_INDEX, B_DATE 
      from board) 
where rnum >= 1 and rnum <= 3
order by rnum;


SELECT B_NO, B_TITLE, B_NAME, B_DATE FROM(SELECT ROWNUM RNUM, B_NO, B_TITLE, B_NAME, B_DATE FROM BOARD) WHERE RNUM>=1 AND RNUM<=10 ORDER BY B_NO;

select * from board;

delete from board where B_NO = 11;

select count(*) from board;

INSERT INTO BOARD VALUES (board_no.nextval, '이름', '제목', '내용', SYSDATE);

CREATE TABLE Study(
   S_INDEX NUMBER NOT NULL PRIMARY KEY,      -- study_index 시퀀스 처리
   S_NAME VARCHAR(16) NOT NULL,            
   S_START VARCHAR(16) NOT NULL,                     --시작날짜
   S_END VARCHAR(16) NOT NULL,                     --끝날짜
   S_PLOPIENUM NUMBER NOT NULL,               --인원
   S_DAY varchar(3) not null,                  --요일
   S_time number not null,                     --활동시간
   S_explain varchar(100) not NULL,            --개요
   S_prepared   varchar(100) not null,            --프로젝트 준비
   S_effective VARCHAR(100) NOT NULL,            --기대및 효과
   S_PLACE VARCHAR(10) NOT NULL            --프로젝트 장소

);
truncate table study;
INSERT INTO Study VALUES(study_index.nextval,'JAVA&JSP','20180501', '20180530', 7, '화',5,'개요입니다.','준비물입니다.','기대효과입니다.','장소');

select * from study;
select * from member;

drop table Study cascade CONSTRAINT;

SELECT S_INDEX, S_C_ID, S_PLOPIENUM, S_NAME, S_PLACE, S_time, S_PLOPIENUM, S_START, S_END, S_DAY, S_explain, S_prepared, S_effective 
FROM STUDY



ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
< 3번 스터디의 게시판 리스트 1~10번째 것만 >
select *
from (SELECT ROWNUM RNUM, B_NO, B_TITLE, B_NAME, B_DATE 
      FROM BOARD) b
where (select S_INDEX
	   from STUDY s
	   where s.S_INDEX = b.B_S_INDEX) = 3
AND	RNUM>=1 AND RNUM<=10 
ORDER BY B_NO
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
< 3번 스터디의 게시판 리스트 개수 >
select count(*)
from BOARD b
where (select S_INDEX
	   from STUDY s
	   where s.S_INDEX = b.B_S_INDEX) = 3
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ	   
< 3번 스터디의 게시판의 글을 눌렀을 때의 제목, 내용>
select B_TITLE, B_CONTENT, M_NAME
from BOARD b, MEMBER m
where (select S_INDEX
	   from STUDY s
	   where s.S_INDEX = b.B_S_INDEX) = 3
AND b.B_NO = 4
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
< 3번 스터디의 게시판의 5번 글을 수정할 때 쿼리 >
update BOARD b
set B_TITLE=?, B_NAME=?, B_DATE=?, B_CONTENT=?
where (select S_INDEX
	   from STUDY s
	   where s.S_INDEX = b.B_S_INDEX) = 3
AND b.B_NO = 5	   
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
< 3번 스터디의 게시판의 5번 글을 삭제할 때 쿼리 >
delete 
from BOARD b
where (select S_INDEX
	   from STUDY s
	   where s.S_INDEX = b.B_S_INDEX) = 3
AND b.B_NO = 5	   
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
< 3번 스터디의 게시판에 글을 등록할 때 쿼리 >
insert into BOARD
values (board_no.nextval), ?, ?, ?, sysdate)
where (select S_INDEX
	   from STUDY s
	   where s.S_INDEX = b.B_S_INDEX) = 3
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ



SELECT S_INDEX, S_CATEGORY, S_PLOPIENUM, S_NAME, S_PLACE, S_time, S_PLOPIENUM, S_START, S_END, S_DAY, S_explain, S_prepared, S_effective FROM STUDY

select * from study;
select * from board;
select B_NO, B_TITLE, B_NAME, B_DATE from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b) where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = 3) AND RNUM>=1 AND RNUM<=10 ORDER BY B_NO desc



create table COMMENT2(
	C_NAME		VARCHAR2(30) NOT NULL,
	C_DATE		VARCHAR2(30) NOT NULL,
	C_CONTENT	VARCHAR2(30) NOT NULL,
	C_CNO		NUMBER NOT NULL,
	C_BNO		NUMBER NOT NULL
)

UPDATE COMMENT2 SET C_CONTENT='UPDATE성공' WHERE C_CNO=2 AND C_BNO=40;
UPDATE COMMENT2 SET C_CONTENT='유유' WHERE C_CNO=? AND C_BNO=?

INSERT INTO COMMENT2 VALUES('이다혜','20180530','댓글1',1,1);
INSERT INTO COMMENT2 VALUES('곽지혜','20180528','댓글2',2,2);
INSERT INTO COMMENT2 VALUES('김연주','20180525','댓글3',2,2);
INSERT INTO COMMENT2 VALUES('김연주','20180525','댓글3',2,2);
INSERT INTO COMMENT2 VALUES('하하','20180525','댓글',1,40);
INSERT INTO COMMENT2 VALUES('호호','20180525','댓글3',2,40);
select * from member;
SELECT * FROM COMMENT2;
select * from study;
select * from board;
update study set S_INDEX = 3;
update comment2 set C_BNO = 68 where C_CONTENT = '안녕하십니까';
update comment2 set C_BNO = 68, C_CNO = 9 where C_CONTENT = 'ㅇㅇㅇㅇ';
update comment2 set C_BNO = 68, C_CNO = 8 where C_CONTENT = '댓글3';

select * from feemember;


drop table feemember;

create table feemember(
	FM_ID NUMBER NOT NULL PRIMARY KEY,
	FM_M_INDEX NUMBER NOT NULL,
	FM_MT_ID NUMBER NOT NULL,
	FM_FEE NUMBER NOT NULL,
	FM_NOTE VARCHAR(30)
)

create table fee(
	F_NO NUMBER NOT NULL PRIMARY KEY,
	FM_M_INDEX NUMBER NOT NULL,
	FM_MT_ID NUMBER NOT NULL,
	FM_FEE NUMBER NOT NULL,
	FM_NOTE VARCHAR(30)
)



select * from fee;

drop table fee;
drop table fee cascade CONSTRAINT;
drop table feeExpense cascade CONSTRAINT;

create table feeExpense(
	FE_ID NUMBER NOT NULL PRIMARY KEY,
	FE_MT_ID NUMBER NOT NULL,
	F_EXPENSE VARCHAR(30) NOT NULL,
	F_EXPENSEFEE NUMBER NOT NULL
)

SELECT * FROM COMMENT2 WHERE C_BNO = ?
insert into feeExpense values (1, 1, '카페예약', 30000);
insert into feeExpense values (2, 1, '밥', 20000);
insert into feeExpense values (3, 1, '디저트', 10000);
insert into feeExpense values (4, 1, '교재', 5000);
insert into feeExpense values (5, 1, '복사', 5000);

insert into feeMember values (1, 2, 1, 5000,'어디갔다옴');
insert into feeMember values (2, 3, 1, 5000, '지각함');
insert into feeMember values (3, 4, 1, 5000, null);
insert into feeMember values (4, 5, 1, 5000, null);

select * from member;

select * from feeMember order by FM_ID;
select * from feeExpense order by FE_ID;
select * from board;

select B_NO ,B_TITLE, B_CONTENT, B_NAME, B_DATE, B_FILENAME from BOARD b where B_S_INDEX = (select S_INDEX from STUDY where S_INDEX = 3) AND b.B_NO = 68
select * from comment2;

select FM_ID, FM_FEE, FM_NOTE 
from (SELECT ROWNUM RNUM, FM_FEE, FM_NOTE, FM_ID 
      FROM FeeMember fm) 
where B_S_INDEX IN (select S_INDEX 
		       from STUDY 
		       where S_INDEX = 3) 
AND (select FE_MT_ID
     from FeeExpense
     where FE_MT_ID = fm.FM_MT_ID) = 1
AND (select M_INDEX 
     from Member
     where M_INDEX = fm.FM_M_INDEX) = 2
AND FM_ID = 1
AND RNUM>=1 
AND RNUM<=10
ORDER BY FM_ID desc

drop table fee;
select * from fee;

CREATE TABLE fee(
	F_NO NUMBER NOT NULL PRIMARY KEY,      		-- 글번호
	F_S_INDEX VARCHAR(16) NOT NULL,				-- 스터디 외래키
	F_DATE varchar(50) NOT NULL				-- 회비 등록 날짜
)

insert into fee values(1, 3, '이다혜', '')

create table fee(
	
)

insert into BOARD
values (board_no.nextval, '이이이2', '테스트2', sysdate, '테스트2', 3, '테스트2.jpg');




where (select S_INDEX 
       from STUDY s 
       where s.S_INDEX = B_S_INDEX) = 3;








select * from board;

select 

select B_TITLE
from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO
      FROM BOARD b) 
      where B_S_INDEX IN (select S_INDEX 
       					  from STUDY 
       					  where S_INDEX = 3) 
AND B_TITLE like '%회비%'
ORDER BY B_NO desc

select B_NO, B_TITLE, B_NAME, B_DATE from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b where B_TITLE like '%교재%') where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = 3) AND RNUM>=1 AND RNUM<=10 ORDER BY B_NO desc
select B_NO, B_TITLE, B_NAME, B_DATE from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b where B_TITLE like '%교재%') where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = 3) AND RNUM>=1 AND RNUM<=10 ORDER BY B_NO desc
select B_NO, B_TITLE, B_NAME, B_DATE from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b where B_TITLE like '%교재%') where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = 3) AND RNUM>=1 AND RNUM<=10 ORDER BY B_NO desc
select count(*) from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b where B_TITLE like '%교재%')  where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = 3) ORDER BY B_NO desc

select B_NO, B_TITLE, B_NAME, B_DATE from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b)where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = 3) AND RNUM>=1 AND RNUM<=10 ORDER BY B_NO desc
select B_NO, B_TITLE, B_NAME, B_DATE from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b)where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = 3) AND RNUM>=1 AND RNUM<=10 ORDER BY B_NO desc





truncate table board;


select B_NO, B_TITLE, B_NAME, B_DATE from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b where B_TITLE like '%회비%') where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = 3) AND RNUM>=1 AND RNUM<=10 ORDER BY B_NO desc




select B_NO, B_TITLE, B_NAME, B_DATE from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b)where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = 3) AND RNUM>=1 AND RNUM<=10 ORDER BY B_NO desc
select count(*) from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b where B_TITLE like '%교재%')  where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = 3) ORDER BY B_NO desc
select B_NO, B_TITLE, B_NAME, B_DATE from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b where B_TITLE like ?) where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = ?) AND RNUM>=? AND RNUM<=? ORDER BY B_NO desc

create table CATEGORY(
	C_ID NUMBER,
	C_GROUP VARCHAR2(20),
	C_SUB VARCHAR2(20)
)
Insert into category values (1, '프로그래밍', 'JAVA');

select * from category;

select * from study;
select * from board;

select B_NO, B_TITLE, B_NAME, B_DATE from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b) where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = 3) AND RNUM>=1 AND RNUM<=10 ORDER BY B_NO DESC

select * from board;
select * from study;

update study set S_INDEX=3;

select B_NO, B_TITLE, B_NAME, B_DATE 
from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO 
       FROM BOARD b) 
where B_S_INDEX IN (select S_INDEX 
		   from STUDY 
 		   where S_INDEX = 3) 
AND RNUM>=1 AND RNUM<=10 
ORDER BY B_NO DESC

SELECT M_INDEX 
FROM MEMBER 
where B_S_INDEX IN (select S_INDEX 
		  		    from STUDY 
 		            where S_INDEX = 3) 

select * from member












-----------------------------------------------------------------------------------
< BoardListBean QUERY_GET - ?번 스터디의 게시판 리스트 가져오는 쿼리 >
select B_NO, B_TITLE, M_NAME, B_DATE 
from (SELECT ROWNUM RNUM, B_NO, B_TITLE, M_NAME, B_DATE, B_S_INDEX
      FROM BOARD b, MEMBER m where b.B_TITLE like ? AND b.B_M_INDEX = ?)
where B_S_INDEX IN (select S_INDEX 
                    from STUDY 
                    where S_INDEX = ?) 
AND RNUM>=? AND RNUM<=? ORDER BY B_NO DESC

-----------------------------------------------------------------------------------

< BoardListBean QUERY_GET_COUNT - ?번 스터디의 게시판 개수 가져오는 쿼리 >
select count(*) 
from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO 
      FROM BOARD b 
      where B_TITLE like ?) 
where B_S_INDEX IN (select S_INDEX 
                    from STUDY 
                    where S_INDEX = ?) 
order by B_NO desc

-----------------------------------------------------------------------------------

< BoardViewRegister QUERY_GET - ?번 스터디의 게시판의 ?번 게시글의 정보 가져오는 쿼리 >
select B_NO ,B_TITLE, B_CONTENT, M_NAME, B_DATE, B_FILENAME 
from BOARD b 
where B_S_INDEX = (select S_INDEX 
                   from STUDY 
                   where S_INDEX = ?) 
AND b.B_NO = ?

-----------------------------------------------------------------------------------

< BoardViewRegister QUERY_PUT - ?번 스터디의 게시판의 ?번 게시글의 정보를 수정하는 쿼리 >
update BOARD b 
set B_TITLE=?, B_CONTENT=? 
where (select S_INDEX 
       from STUDY s 
       where s.S_INDEX = b.B_S_INDEX) = ? 
AND b.B_NO = ?

-----------------------------------------------------------------------------------

< BoardViewRegister QUERY_DELETE - ?번 스터디의 게시판의 ?번 게시글을 삭제하는 쿼리 >
delete from BOARD b
where (select S_INDEX 
       from STUDY s 
       where s.S_INDEX = b.B_S_INDEX) = ? 
AND b.B_NO = ?

-----------------------------------------------------------------------------------

< BoardViewRegister QUERY_POST - ?번 스터디의 게시판에 게시글을 삽입하는 쿼리 >
insert into BOARD b
values (board_no.nextval, 스터디외래키, 회원번호외래키, 스터디시퀀스, ?, sysdate, ?, ?)
where (select S_INDEX 
       from STUDY s 
       where s.S_INDEX = b.B_S_INDEX) = ? 

-----------------------------------------------------------------------------------
       
< CommentBean QUERY_GET - ?번 스터디의 게시판의 ?번 게시글의 댓글리스트를 가져오는 쿼리 >
select C_CONTENT, C_DATE, M_NAME 
from (select C_CONTENT, C_DATE, M_NAME, C_BNO
      from COMMENT c, MEMBER m
      where c.C_M_INDEX = m.M_INDEX)
where (select S_INDEX 
       from STUDY s, BOARD b 
       where s.S_INDEX = b.B_S_INDEX) = ? 
AND C_B_NO = ?
       
-----------------------------------------------------------------------------------       
       
< CommentBean QUERY_GET_COUNT - ?번 스터디의 게시판의 ?번 게시글의 댓글의 개수를 가져오는 쿼리 >    
select COUNT(*) 
from COMMENT 
where (select S_INDEX 
       from STUDY s, BOARD b 
       where s.S_INDEX = b.B_S_INDEX) = ? 
AND C_B_NO = ? 

-----------------------------------------------------------------------------------

< CommentBean QUERY_PUT - ?번 스터디의 게시판의 ?번 게시글의 ?번 댓글을 수정하는 쿼리 >     
UPDATE COMMENT 
SET C_CONTENT=? 
where (select S_INDEX 
       from STUDY s, BOARD b 
       where s.S_INDEX = b.B_S_INDEX) = ? 
AND C_B_NO = ? 
AND C_INDEX = ?
       
-----------------------------------------------------------------------------------

<CommentBean QUERY_DELETE - ?번 스터디의 게시판의 ?번 게시글의 ?번 댓글을 삭제하는 쿼리 >   
DELETE FROM COMMENT 
where (select S_INDEX 
       from STUDY s, BOARD b 
       where s.S_INDEX = b.B_S_INDEX) = ? 
AND C_B_NO = ? 
AND C_INDEX = ?
   
-----------------------------------------------------------------------------------       
  
< CommentBean QUERY_POST - ?번 스터디의 게시판의 ?번 게시글에 댓글을 삽입하는 쿼리 >
insert into COMMENT 
values(댓글시퀀스,스터디외래키,멤버외래키,?,?)
where (select S_INDEX 
       from STUDY s, BOARD b 
       where s.S_INDEX = b.B_S_INDEX) = ? 
AND C_B_NO = ?     

----------------------------------------------------------------------------------- 

<InformSetup QUERY_GET - ?번 스터디의 정보를 가져오는 쿼리 >
select S_INDEX, S_NAME,C_GROUP, C_SUBGROUP, S_M_INDEX, S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME,  S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE
from (select S_INDEX, S_NAME,C_GROUP, C_SUBGROUP, S_M_INDEX, S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME,  S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE
	  from STUDY s, CATEGORY c
	  where s.S_C_ID = c.C_ID)
where s.S_INDEX = ?

----------------------------------------------------------------------------------- 

< InformSetup QUERY_GET - ?번 스터디의 정보를 수정하는 쿼리 >
update STUDY s
set C_GROUP=?, C_SUBGROUP=?, S_MAXMEMBER=?, S_NAME=?, S_PLACE=?, S_TIME=?, S_START=?, S_END=?, S_DAY=?, S_EXPLAIN=?, S_MATERIAL=?, S_EFFECT=?    
where (select C_SUBGROUP, S_MAXMEMBER
       from CATEGORY c
       where c.C_ID = s.S_C_ID)
AND s.S_INDEX = ?

----------------------------------------------------------------------------------- 
 
< InformSetupMember QUERY_GET - ?번 스터디에 참여하고 있는 스터디원들의 정보를 가져오는 쿼리 >
select M_NAME, M_TEL, M_EMAIL 
from MEMBER
where 

----------------------------------------------------------------------------------- 

< CashListBean QUERY_GET - ?번 스터디에 있는 회비목록 리스트 가져오는 쿼리 >


----------------------------------------------------------------------------------- 

< CashListBean QUERY_GET_COUNT - ?번 스터디에 있는 회비 리스트의 개수 가져오는 쿼리 >

----------------------------------------------------------------------------------- 

< CashMemberBean QUERY_GET - ?번 스터디의 ?날짜에 기록한 스터디원들이 낸 회비 리스트를 가져오는 쿼리 >

----------------------------------------------------------------------------------- 

< CashMemberBean QUERY_POST - ?번 스터디의 ?날짜에 스터디원들이 낸 회비 리스트를 삽입하는 쿼리 >

----------------------------------------------------------------------------------- 

< CashExpenseBean QUERY_GET - ?번 스터디의 ?날짜에 기록한 회비 사용 내역 리스트를 가져오는 쿼리 >

----------------------------------------------------------------------------------- 

< CashExpenseBean QUERY_GET - ?번 스터디의 ?날짜에 회비 사용 내역 리스트를 삽입하는 쿼리 >

----------------------------------------------------------------------------------- 

< 

select * from comment;
select * from study;
select * from member;
select * from board;

select COUNT(*) 
from COMMENT, Board
where B_S_INDEX = (select S_INDEX
	from Study
	where S_INDEX = 3)
AND C_B_NO = (select B_NO 
	from Board
	where B_NO = 156)



	CREATE TABLE Comment(
	C_INDEX NUMBER NOT NULL PRIMARY KEY,
	C_S_INDEX NUMBER NOT NULL,
	C_M_INDEX NUMBER NOT NULL,
	C_DATE DATE NOT NULL,
	C_CONTENT VARCHAR(300) NOT NULL
)
select * from study;
CREATE SEQUENCE comment_index
START WITH 1
INCREMENT 1
NOMAXVALUE;
select * from member;
select * from study;
select * from studymemberlist;

insert into board values(board_no.nextval, 5, 6, board_studyseq.nextval, '1테스트 게시글', sysdate, '게시글 테스트 중입니다.', null);
insert into board values(board_no.nextval, 5, 6, board_studyseq.nextval, '2테스트 게시글', sysdate, '게시글 테스트 중입니다.', null);
insert into board values(board_no.nextval, 5, 6, board_studyseq.nextval, '3테스트 게시글', sysdate, '게시글 테스트 중입니다.', null);
insert into board values(board_no.nextval, 5, 6, board_studyseq.nextval, '4테스트 게시글', sysdate, '게시글 테스트 중입니다.', null);
insert into board values(board_no.nextval, 5, 6, board_studyseq.nextval, '5테스트 게시글', sysdate, '게시글 테스트 중입니다.', null);
insert into board values(board_no.nextval, 5, 6, board_studyseq.nextval, '6테스트 게시글', sysdate, '게시글 테스트 중입니다.', null);
insert into board values(board_no.nextval, 5, 6, board_studyseq.nextval, '7테스트 게시글', sysdate, '게시글 테스트 중입니다.', null);
insert into board values(board_no.nextval, 5, 6, board_studyseq.nextval, '8테스트 게시글', sysdate, '게시글 테스트 중입니다.', null);
insert into board values(board_no.nextval, 5, 6, board_studyseq.nextval, '9테스트 게시글', sysdate, '게시글 테스트 중입니다.', null);
insert into board values(board_no.nextval, 5, 6, board_studyseq.nextval, '10테스트 게시글', sysdate, '게시글 테스트 중입니다.', null);
insert into board values(board_no.nextval, 5, 6, board_studyseq.nextval, '11테스트 게시글', sysdate, '게시글 테스트 중입니다.', null);
insert into board values(board_no.nextval, 5, 6, board_studyseq.nextval, '12테스트 게시글', sysdate, '게시글 테스트 중입니다.', null);
insert into board values(board_no.nextval, 5, 6, board_studyseq.nextval, '13테스트 게시글', sysdate, '게시글 테스트 중입니다.', null);
insert into board values(board_no.nextval, 5, 6, board_studyseq.nextval, '14테스트 게시글', sysdate, '게시글 테스트 중입니다.', null);
insert into board values(board_no.nextval, 5, 6, board_studyseq.nextval, '15테스트 게시글', sysdate, '게시글 테스트 중입니다.', null);
select * from board order by B_NO desc;
select * from studymemberlist;


select * from 


select B_NO, B_TITLE, M_NAME, B_DATE 
from (SELECT ROWNUM RNUM, B_NO, B_TITLE, M_NAME, B_DATE, B_S_INDEX
      FROM BOARD b, MEMBER m 
      where B_M_INDEX = m.M_INDEX
      AND B_TITLE like '%1%')
where B_S_INDEX = (select S_INDEX 
                    from STUDY 
                    where S_INDEX = 3) 
AND RNUM>=1 
AND RNUM<=10 
ORDER BY B_NO DESC

select count(*) from (SELECT ROWNUM RNUM, B_NO, B_TITLE, M_NAME, B_DATE, B_S_INDEX FROM BOARD b, MEMBER m where B_M_INDEX = m.M_INDEX) where B_S_INDEX = (select S_INDEX from STUDY where S_INDEX = 3) ORDER BY B_NO DESC


select B_NO ,B_TITLE, B_CONTENT, M_NAME, B_DATE, B_FILENAME 
from BOARD b, Member m 
where B_S_INDEX = (select S_INDEX 
                   from STUDY 
                   where S_INDEX = 3) 
AND B_M_INDEX = (select M_INDEX     --추가
				 from Member
	             where M_INDEX = 25)
AND b.B_NO = 26


select * from board;




select B_NO ,B_TITLE, B_CONTENT, M_NAME, B_DATE, B_FILENAME 
from (SELECT B_NO ,B_TITLE, B_CONTENT, M_NAME, B_DATE, B_FILENAME 
      FROM BOARD b, MEMBER m 
      where B_M_INDEX = m.M_INDEX)
where B_S_INDEX = (select S_INDEX 
                    from STUDY 
                    where S_INDEX = 3) 




select B_NO ,B_TITLE, B_CONTENT, B_NAME, B_DATE, B_FILENAME from BOARD b where B_S_INDEX = (select S_INDEX from STUDY where S_INDEX = ?) AND b.B_NO = ?

select B_NO, B_TITLE, B_CONTENT, M_NAME, B_DATE, B_FILENAME from STUDYBOARDLIST where B_NO = 29;

delete from BOARD where B_S_INDEX = ? AND B_NO = ?


select * from board;

select * from studyboardlist;

select B_NO, B_TITLE, B_CONTENT, M_NAME, B_DATE, B_FILENAME from STUDYBOARDLIST where B_NO = 
update BOARD b 
set B_TITLE=?, B_DATE=?, B_CONTENT=? 
where (select S_INDEX 
       from STUDY s 
       where s.S_INDEX = b.B_S_INDEX) = ? 
AND b.B_NO = ?

select * from member
SELECT COUNT(*) FROM COMMENT WHERE C_BNO = ?
select * from comments;

select C_CONTENT, C_DATE, M_NAME
from Comments c, Member m, Board b
where b.B_S_INDEX = (select S_INDEX
	                 from Study
	                 where S_INDEX = 3)
and C_B_NO = (select B_NO
	from Board
	where B_NO = 28)



SELECT COUNT(*) FROM COMMENTS WHERE C_B_NO = ?;


insert into comments values(comment_index.nextval, 29, 25, sysdate, '테스트 댓글1');
insert into comments values(comment_index.nextval, 29, 25, sysdate, '테스트 댓글2');
insert into comments values(comment_index.nextval, 29, 25, sysdate, '테스트 댓글3');
insert into comments values(comment_index.nextval, 29, 25, sysdate, '테스트 댓글4');
insert into comments values(comment_index.nextval, 29, 25, sysdate, '테스트 댓글5');



스터디번호 3번, 게시물번호


select C_INDEX, M_INDEX, C_DATE, C_CONTENT
from (select C_INDEX, M_INDEX, C_DATE, C_CONTENT
	  from Comments c, Member m, Board b
	  where C_S_INDEX )


select B_NO, C_INDEX, C_CONTENT, C_DATE, M_NAME
from Comments c, Member m, Board b
where b.B_S_INDEX = 3
and c.C_B_NO = B_NO
and c.C_B_NO = 29
and c.C_M_INDEX = m.M_INDEX


select * from comments;


select * from studyboardlist;
select * from studymemberlist;


insert into COMMENTS c 
values(comment_index.nextval,?,?,sysdate,?)
where (select B_S_INDEX
	   from BOARD
	   where B_S_INDEX = c.C_S_INDEX)
AND (select B_S_INDEX
	 from BOARD
	 where B_S_INDEX = 3)	   
AND (select )	 


3번 스터디의 게시판의 29번 게시글에 댓글 insert하기 

insert into COMMENTS
values(comments_index.nextval,?,?,sysdate,?)

select * from study;


select * from board;

select * from category;

select B_NO, B_TITLE, M_NAME, B_DATE from (SELECT ROWNUM RNUM, B_NO, B_TITLE, M_NAME, B_DATE, B_S_INDEX FROM BOARD b, MEMBER m where B_M_INDEX = m.M_INDEX)  where B_S_INDEX = (select S_INDEX from STUDY where S_INDEX = 3) AND RNUM>=1 AND RNUM<=10 ORDER BY B_NO DESC

select distinct C_GROUP from category;

select count(*) from studymemberlist where S_INDEX = 3;

select S_NAME,C_GROUP, C_SUBGROUP, S_START, S_END, S_MAXMEMBER, S_TIME, S_DAY,  S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE from Study s, Category c where s.S_C_ID = c.C_ID and s.S_INDEX = 3

SELECT m_name, m_tel, m_email FROM studyMemberList WHERE s_name = '외국인처럼 말하기';

select * from member;

select S_M_INDEX from Study where S_INDEX = 5;
select * from board;

update BOARD b set B_TITLE='수정테스트', B_CONTENT='수정' where (select S_INDEX from STUDY s where s.S_INDEX = b.B_S_INDEX) = 5 AND b.B_NO = 17


select * from 



insert into BOARD values (board_no.nextval, ?, ?, board_studyseq.nextval , ?, sysdate, ?, ?)
insert into BOARD values (board_no.nextval, 스터디번호 ?, 작성회원번호 ?, board_studyseq.nextval , 제목?, sysdate, 내용?, 파일이름?)


insert into COMMENTS values(comments_index.nextval,?,?,sysdate,?);

select B_NO, B_TITLE, M_NAME, B_DATE 
from (SELECT ROWNUM RNUM, B_NO, B_TITLE, M_NAME, B_DATE, B_S_INDEX 
      FROM (select B_NO, B_TITLE, M_NAME, B_DATE, B_S_INDEX
	        from BOARD b, MEMBER m 
	        where B_M_INDEX = m.M_INDEX
	        ORDER BY B_NO DESC)
			)
where B_S_INDEX = (select S_INDEX 
                   from STUDY 
                   where S_INDEX = 5)  
AND RNUM>=1 AND RNUM<=10


select count(*)
from (SELECT ROWNUM RNUM, B_NO, B_TITLE, M_NAME, B_DATE, B_S_INDEX 
      FROM (select B_NO, B_TITLE, M_NAME, B_DATE, B_S_INDEX
	        from BOARD b, MEMBER m 
	        where B_M_INDEX = m.M_INDEX
	        ORDER BY B_NO DESC) 
      		)
where B_S_INDEX = (select S_INDEX 
			       from STUDY 
			       where S_INDEX = 5)  


select * from comments;

select B_NO, B_TITLE, M_NAME, B_DATE from (SELECT ROWNUM RNUM, B_NO, B_TITLE, M_NAME, B_DATE, B_S_INDEX FROM (select B_NO, B_TITLE, M_NAME, B_DATE, B_S_INDEX from BOARD b, MEMBER m where B_M_INDEX = m.M_INDEX ORDER BY B_NO DESC)) where B_S_INDEX = (select S_INDEX from STUDY where S_INDEX = 5) AND RNUM>=1 AND RNUM<=10





select B_NO, B_TITLE, M_NAME, B_DATE from (SELECT ROWNUM RNUM, B_NO, B_TITLE, M_NAME, B_DATE, B_S_INDEX FROM (select B_NO, B_TITLE, M_NAME, B_DATE, B_S_INDEX from BOARD b, MEMBER m where B_M_INDEX = m.M_INDEX ORDER BY B_NO DESC)) where B_S_INDEX = (select S_INDEX from STUDY where S_INDEX = 5) AND RNUM>=1 AND RNUM<=10


select B_NO, B_TITLE, M_NAME, B_DATE from (SELECT ROWNUM RNUM, B_NO, B_TITLE, M_NAME, B_DATE, B_S_INDEX FROM (select B_NO, B_TITLE, M_NAME, B_DATE, B_S_INDEX from BOARD b, MEMBER m where B_M_INDEX = m.M_INDEX ORDER BY B_NO DESC)) where B_S_INDEX = (select S_INDEX from STUDY where S_INDEX = 5) AND RNUM>=1 AND RNUM<




select * from study;
select * from category;
select C_ID from category where C_GROUP = ? AND C_SUBGROUP = ?;

UPDATE STUDY SET S_CATEGORY=?, S_MAXMEMBER=?, S_NAME=?, S_PLACE=?, S_TIME=?, S_START=?, S_END=?, S_DAY=?, S_EXPLAIN=?, S_MATERIAL=?, S_EFFECT=? where S_INDEX = ?