﻿-- Member테이블 INDEX의 시퀀스
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

SELECT * FROM Member;
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

INSERT INTO Study VALUES(study_index.nextval,'JAVA&JSP','JAVA','부천','3','5','자바와 JSP 마스터','2018-05-24')

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
	B_CONTENT VARCHAR(300) NOT NULL               -- CLOE처리 할수도..
)

insert into Board values(board_no.nextval, '이다혜', '회비관련 공지하겠습니다.', '2018-05-25', '저번에 회비 안낸 노동완씨 이번에 꼭 내십시요.');
insert into Board values(board_no.nextval, '소문혁', '교재관련 공지하겠습니다.', '2018-05-22', '안녕하시요');
insert into Board values(board_no.nextval, '구명회', '회비관련 공지하겠습니다.', '2018-05-20', '가나다라마바사');
insert into Board values(board_no.nextval, '노동완', '장소관련 공지하겠습니다.', '2018-04-02', '이거는 내용내용');
insert into Board values(board_no.nextval, '곽승민', '교재관련 공지하겠습니다.', '2018-02-25', '여기도 내용내용내용!!!');

insert into Board values(board_no.nextval, '이다혜1', '회비관련 공지하겠습니다.', '2018-05-25', '저번에 회비 안낸 노동완씨 이번에 꼭 내십시요.');
insert into Board values(board_no.nextval, '소문혁1', '교재관련 공지하겠습니다.', '2018-05-22', '안녕하시요');
insert into Board values(board_no.nextval, '구명회1', '회비관련 공지하겠습니다.', '2018-05-20', '가나다라마바사');
insert into Board values(board_no.nextval, '노동완1', '장소관련 공지하겠습니다.', '2018-04-02', '이거는 내용내용');
insert into Board values(board_no.nextval, '곽승민1', '교재관련 공지하겠습니다.', '2018-02-25', '여기도 내용내용내용!!!');
insert into Board values(board_no.nextval, '이다혜2', '회비관련 공지하겠습니다.', '2018-05-25', '저번에 회비 안낸 노동완씨 이번에 꼭 내십시요.');
insert into Board values(board_no.nextval, '소문혁2', '교재관련 공지하겠습니다.', '2018-05-22', '안녕하시요');
insert into Board values(board_no.nextval, '구명회2', '회비관련 공지하겠습니다.', '2018-05-20', '가나다라마바사');
insert into Board values(board_no.nextval, '노동완2', '장소관련 공지하겠습니다.', '2018-04-02', '이거는 내용내용');
insert into Board values(board_no.nextval, '곽승민2', '교재관련 공지하겠습니다.', '2018-02-25', '여기도 내용내용내용!!!');
insert into Board values(board_no.nextval, '이다혜3', '회비관련 공지하겠습니다.', '2018-05-25', '저번에 회비 안낸 노동완씨 이번에 꼭 내십시요.');
insert into Board values(board_no.nextval, '소문혁3', '교재관련 공지하겠습니다.', '2018-05-22', '안녕하시요');
insert into Board values(board_no.nextval, '구명회3', '회비관련 공지하겠습니다.', '2018-05-20', '가나다라마바사');
insert into Board values(board_no.nextval, '노동완3', '장소관련 공지하겠습니다.', '2018-04-02', '이거는 내용내용');
insert into Board values(board_no.nextval, '곽승민3', '교재관련 공지하겠습니다.', '2018-02-25', '여기도 내용내용내용!!!');

select * from board;



select B_NO, B_TITLE, B_M_INDEX, B_DATE 
from (select rownum rnum, B_NO, B_TITLE, B_M_INDEX, B_DATE 
      from board) 
where rnum >= 1 and rnum <= 3
order by rnum;


select * from (select rownum rnum,BOARD_NUM,BOARD_NAME, B_TITLE, BOARD_SUBJECT,BOARD_CONTENT,BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE   
where rnum >= ? and rnum <= ?
order by rnum;





SELECT B_NO, B_TITLE, B_NAME, B_DATE FROM(SELECT ROWNUM RNUM, B_NO, B_TITLE, B_NAME, B_DATE FROM BOARD)WHERE RNUM>=1 AND RNUM<=3 ORDER BY RNUM;

SELECT B_NO, B_TITLE, B_NAME, B_DATE FROM(SELECT ROWNUM RNUM, B_NO, B_TITLE, B_NAME, B_DATE FROM BOARD) WHERE RNUM>=1 AND RNUM<=3 ORDER BY RNUM

select count(*) from board;
