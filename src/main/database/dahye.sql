-- Member테이블 INDEX의 시퀀스
CREATE SEQUENCE member_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

drop table Member;
-- Member 테이블 생성
CREATE TABLE Member(
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
   S_CATEGORY VARCHAR(30) NOT NULL,              
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
INSERT INTO Study VALUES(study_index.nextval,'JAVA&JSP','카테카테1','20180501', '20180530', 7, '화',5,'개요입니다.','준비물입니다.','기대효과입니다.','장소');

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
insert into feeExpense values (2, 1, '카페예약', 30000);
insert into feeExpense values (, 1, '카페예약', 30000);
insert into feeExpense values (1, 1, '카페예약', 30000);
insert into feeExpense values (1, 1, '카페예약', 30000);
insert into feeExpense values (1, 1, '카페예약', 30000);

select * from fee;


select B_NO ,B_TITLE, B_CONTENT, B_NAME, B_DATE from BOARD b where B_S_INDEX = (select S_INDEX from STUDY where S_INDEX = 3) AND b.B_NO = 39
select * from comment2;