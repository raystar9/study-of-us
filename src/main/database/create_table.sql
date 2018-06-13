INSERT INTO Member(M_INDEX, M_ID, M_PASSWORD, M_NAME, M_EMAIL, M_TEL, M_ADDRESS, M_GENDER, M_INTRODUCE)
	VALUES (member_index.NEXTVAL, 'sm00', '1234', '곽승민', 'snow@naver.com', 01050667016, '경기도 의정부시 의정부동', '남', '안녕하세요~~');

	drop table message
	select * from member
	
INSERT INTO Member(M_INDEX, M_ID, M_PASSWORD, M_NAME, M_EMAIL, M_TEL, M_ADDRESS, M_GENDER, M_INTRODUCE)
	VALUES (member_index.NEXTVAL, 'so01', '5678', '소문혁', 'soso@daum.com', 01011112222, '서울특별시 노원구', '남', '잘부탁해요~');
	
INSERT INTO Member(M_INDEX, M_ID, M_PASSWORD, M_NAME, M_EMAIL, M_TEL, M_ADDRESS, M_GENDER, M_INTRODUCE)
	VALUES (member_index.NEXTVAL, 'no02', '0000', '노동완', 'nono@naver.com', 01033334444, '경기도 성남시 분당구', '남', '자바의 달인입니다~~');

INSERT INTO Member(M_INDEX, M_ID, M_PASSWORD, M_NAME, M_EMAIL, M_TEL, M_ADDRESS, M_GENDER, M_INTRODUCE)
	VALUES (member_index.NEXTVAL, 'dayhe00', '1111', '이다혜', 'dahye@naver.com', 01055556666, '경기도 부천시', '여', '어머~');

INSERT INTO Member(M_INDEX, M_ID, M_PASSWORD, M_NAME, M_EMAIL, M_TEL, M_ADDRESS, M_GENDER, M_INTRODUCE)
	VALUES (member_index.NEXTVAL, 'goo04', '4444', '구명회', 'goo@naver.com', 01077778888, '경기도 남양주시', '남', '반장입니다.');

INSERT INTO Member(M_INDEX, M_ID, M_PASSWORD, M_NAME, M_EMAIL, M_TEL, M_ADDRESS, M_GENDER, M_INTRODUCE)
	VALUES (member_index.NEXTVAL, 'hong05', '5555', '홍주성', 'honghong@google.com', 01066662222, '서울특별시 동대문구', '남', '까망이');
	
INSERT INTO Member(M_INDEX, M_ID, M_PASSWORD, M_NAME, M_EMAIL, M_TEL, M_ADDRESS, M_GENDER, M_INTRODUCE)
	VALUES (member_index.NEXTVAL, 'kim06', '6666', '김갑수', 'kimkim@naver.com', 01099991111, '부산특별시 동래구', '남', '갑수갑수김갑수');

INSERT INTO Member(M_INDEX, M_ID, M_PASSWORD, M_NAME, M_EMAIL, M_TEL, M_ADDRESS, M_GENDER, M_INTRODUCE)
	VALUES (member_index.NEXTVAL, 'park07', '7777', '박영희', 'parkpark@naver.com', 01012345678, '서울특별시 서대문구', '여', '엄청 미인');

	
INSERT INTO Member(M_INDEX, M_ID, M_PASSWORD, M_NAME, M_EMAIL, M_TEL, M_ADDRESS, M_GENDER, M_INTRODUCE)
	VALUES (member_index.NEXTVAL, 'lee08', '8888', '이미소', 'smile@naver.com', 01023568945, '경기도 고양시', '남', '웃으세요~~');

INSERT INTO Member(M_INDEX, M_ID, M_PASSWORD, M_NAME, M_EMAIL, M_TEL, M_ADDRESS, M_GENDER, M_INTRODUCE)
	VALUES (member_index.NEXTVAL, 'happy09', '9999', '김해피', 'happy@naver.com', 01014785236, '경기도 의정부시', '여', '행복해요~~~');
	
select * from member;
	
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (101, '프로그래밍', 'Java');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (102, '프로그래밍', 'C언어');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (103, '프로그래밍', 'C#');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (104, '프로그래밍', 'C++');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (105, '프로그래밍', 'Linux');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (106, '프로그래밍', 'Python');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (107, '프로그래밍', 'HTML');

INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (201, '언어', '영어');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (202, '언어', '일본어');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (203, '언어', '중국어');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (204, '언어', '불어');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (205, '언어', '스페인어');

INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (301, '자격증', '토익');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (302, '자격증', '토플');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (303, '자격증', '정보처리기사');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (304, '자격증', '리눅스마스터');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (305, '자격증', '한자');

INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (401, '수능', '언어');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (402, '수능', '수학');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (403, '수능', '외국어');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (404, '수능', '사회탐구');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (405, '수능', '과학탐구');
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (406, '수능', '제2외국어');

select * from member;

select * from study;

INSERT INTO Study(S_INDEX, S_NAME, S_C_ID, S_M_INDEX, S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE)
	VALUES (study_index.NEXTVAL, 'Java마스터', 101, 27, '2018-06-01', '2018-06-30', 5, '토요일', '14:00', '자바의 달이이 되어보자.', '강한정신력', '자바 능력 향상', '서울특별시 중구');
	
INSERT INTO Study(S_INDEX, S_NAME, S_C_ID, S_M_INDEX, S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE)
	VALUES (study_index.NEXTVAL, '수능만점', 402, 28, '2018-03-01', '2018-11-11', 3, '주5일', '09:00', '수학 만점을향해서...', '문제집', '수학만점', '경기도 의정부시');
	
INSERT INTO Study(S_INDEX, S_NAME, S_C_ID, S_M_INDEX, S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE)
	VALUES (study_index.NEXTVAL, '동완이가 만든 스터디', 201, 5, '2018-07-01', '2018-09-30', 2, '주말', '12:00', '외국인이 와도 무섭지않아요.', '영어사전', '영어 마스터', '서울특별시 동대문구');
	
	

	
delete from Study;

select * from study;

INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (1, 23);
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (1, 24);
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (1, 27);
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (1, 29);
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (1, 30);
	
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (2, 28);
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (2, 23);
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (2, 32);
	
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (3, 25);
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (3, 27);
	
select * from studymember;

-- Member 테이블 생성
CREATE TABLE Member(
	M_INDEX NUMBER NOT NULL PRIMARY KEY,      -- member_index 시퀀스 처리
	M_ID VARCHAR(16) NOT NULL,
	M_PASSWORD VARCHAR(16) NOT NULL,
	M_NAME VARCHAR(15) NOT NULL,
	M_EMAIL VARCHAR(50) NOT NULL,
	M_TEL NUMBER NOT NULL,
	M_ADDRESS VARCHAR(200),
	M_GENDER VARCHAR(3) NOT NULL,
	M_INTRODUCE VARCHAR(200) NOT NULL
)

drop sequence study_index;
drop sequence feemember_id;
drop sequence feeexpense_id;
drop sequence inquiry_index;
drop sequence meeting_index;
drop sequence member_index;
drop sequence board_no;
drop sequence board_studyseq;
drop sequence comments_index;
drop sequence comment_index;


select * from user_sequences;
﻿-- Member테이블 INDEX의 시퀀스
CREATE SEQUENCE member_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
CREATE SEQUENCE message_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
ALTER SEQUENCE member_index INCREMENT BY 1;   -- 시퀀스의 값을 1로 바꿔줌.

SELECT M_INDEX, M_ID, M_PASSWORD, M_NAME, M_EMAIL, M_TEL, M_ADDRESS, M_GENDER, M_INTRODUCE FROM Member;
INSERT INTO Member(M_INDEX, M_ID, M_PASSWORD, M_NAME, M_EMAIL, M_TEL, M_ADDRESS, M_GENDER, M_INTRODUCE)
	VALUES (member_index.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?);
UPDATE Member SET M_ID=?, M_PASSWORD=?, M_NAME=?, M_EMAIL=?, M_TEL=?, M_ADDRESS=?, M_GENDER=?, M_INTRODUCE=? 
	WHERE M_INDEX=?;
DELETE FROM Member WHERE M_INDEX = ?;



-- Study 테이블 생성
CREATE TABLE Study(
	S_INDEX NUMBER NOT NULL PRIMARY KEY,      -- study_index 시퀀스 처리
	S_NAME VARCHAR(50) NOT NULL,
	S_C_ID NUMBER NOT NULL,              -- CATEGORY.C_ID 외래키 지정 해줘야 함.
	S_MT_INDEX NUMBER,
	S_M_INDEX NUMBER NOT NULL,
	S_START DATE NOT NULL,
	S_END DATE NOT NULL,
	S_MAXMEMBER NUMBER NOT NULL,
	S_DAY VARCHAR(15) NOT NULL,
	S_TIME VARCHAR(15) NOT NULL,
	S_EXPLAIN VARCHAR(100) NOT NULL,
	S_MATERIAL VARCHAR(50) NOT NULL,
	S_EFFECT VARCHAR(100) NOT NULL,
	S_PLACE VARCHAR(50) NOT NULL           
)

alter table Study modify S_MT_INDEX null;
alter table Study modify(S_NAME VARCHAR(50));
alter table Study modify(S_DAY VARCHAR(10));
alter table Study modify(S_TIME VARCHAR(15));
alter table Study rename column S_MEXMEMBER TO S_MAXMEMBER

alter table Study modify S_NAME null;
alter table Study ADD UNIQUE(S_NAME);

drop sequence study_index;
CREATE SEQUENCE study_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;
                 
select * from study;

alter table study add(S_MT_INDEX NUMBER);

create table temp as select S_INDEX, S_NAME, S_C_ID, S_MT_INDEX, S_M_INDEX, S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE  from study;
DROP TABLE STUDY;

ALTER TABLE Study ADD FOREIGN KEY(S_C_ID) REFERENCES Category(C_ID); -- 외래키 지정.
ALTER TABLE Study ADD FOREIGN KEY(S_MT_INDEX) REFERENCES Meeting(MT_ID) ON DELETE CASCADE;
ALTER TABLE Study ADD FOREIGN KEY(S_M_INDEX) REFERENCES Member(M_INDEX) ON DELETE CASCADE;

SELECT S_INDEX, S_NAME, S_C_ID, S_MT_INDEX, S_M_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME, S_EXPLAIN, S_PREPARED, S_EFFECTIVE, S_PLACE FROM Study;
INSERT INTO Study(S_INDEX, S_NAME, S_C_ID, S_MT_INDEX, S_M_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME, S_EXPLAIN, S_PREPARED, S_EFFECTIVE, S_PLACE)
	VALUES (study_index.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
UPDATE Study SET S_INDEX=?, S_NAME=?, S_C_ID=?, S_MT_INDEX=?, S_M_INDEX=?, S_START=?, S_END=?, S_PLOPIENUM=?, S_DAY=?, S_TIME=?, S_EXPLAIN=?, S_PREPARED=?, S_EFFECTIVE=?, S_PLACE=?
	WHERE S_INDEX=?;
DELETE FROM Study WHERE S_INDEX = ?;



-- Category 테이블 생성 (스터디 분야에 대한 정보)
CREATE TABLE Category(
	C_ID NUMBER NOT NULL PRIMARY KEY,        -- Study테이블에 외래키로 사용됨.
	C_GROUP VARCHAR(20) NOT NULL,            -- 대분류
	C_SUBGROUP VARCHAR(20) NOT NULL               -- 소분류
)

alter table category modify(c_subgroup varchar(50));

SELECT C_ID, C_GROUP, C_SUBGROUP FROM Category;
INSERT INTO Category(C_ID, C_GROUP, C_SUBGROUP) VALUES (?, ?, ?);
UPDATE Category SET C_GROUP=?, C_SUBGROUP=? WHERE C_ID=?;
DELETE FROM Category WHERE C_ID=?;




-- Interesting 테이블 생성(회원별 관심사)
CREATE TABLE Interesting(
	I_M_INDEX NUMBER NOT NULL,
	I_C_ID NUMBER NOT NULL,
	PRIMARY KEY(I_M_INDEX, I_C_ID)           -- 다중 PRIMARY KEY 지정.
)

ALTER TABLE Interesting ADD FOREIGN KEY(I_M_INDEX) REFERENCES Member(M_INDEX) ON DELETE CASCADE;
ALTER TABLE Interesting ADD FOREIGN KEY(I_C_ID) REFERENCES Category(C_ID) ON DELETE CASCADE;

SELECT I_M_INDEX, I_C_ID FROM Interesting;
INSERT INTO Interesting(I_M_INDEX, I_C_ID) VALUES (?, ?);
UPDATE Interesting SET I_M_INDEX, I_C_ID WHERE I_M_INDEX=? AND I_C_ID=?;
DELETE FROM Interesting WHERE I_M_INDEX=? AND I_C_ID=?;




-- PreferenceArea 테이블 생성(회원의 선호지역)
CREATE TABLE PreferenceArea(
	P_M_INDEX NUMBER NOT NULL,
	P_AREA VARCHAR(30) NOT NULL,
	PRIMARY KEY(P_M_INDEX, P_AREA)
)

ALTER TABLE PreferenceArea ADD FOREIGN KEY(P_M_INDEX) REFERENCES Member(M_INDEX) ON DELETE CASCADE;

SELECT P_M_INDEX, P_AREA FROM PreferenceArea;
INSERT INTO PreferenceArea(P_M_INDEX, P_AREA) VALUES (?, ?);
UPDATE PreferenceArea SET P_AREA=? WHERE P_M_INDEX=?;
DELETE FROM PreferenceArea WHERE P_M_INDEX=?;

select * from studymember

<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> studyMain
=======
select * from study
select * from member
>>>>>>> origin/seungmin
-- StudyMember 테이블 생성(맵핑 테이블)
CREATE TABLE StudyMember(
	SM_S_INDEX NUMBER NOT NULL,
	SM_M_INDEX NUMBER NOT NULL,
	PRIMARY KEY(SM_S_INDEX, SM_M_INDEX)
)

<<<<<<< HEAD
ALTER TABLE StudyMember ADD FOREIGN KEY(SM_S_INDEX) REFERENCES Study(S_INDEX); 
ALTER TABLE StudyMember ADD FOREIGN KEY(SM_M_INDEX) REFERENCES Member(M_INDEX); 
=======
ALTER TABLE StudyMember ADD FOREIGN KEY(SM_S_INDEX) REFERENCES Study(S_INDEX) ON DELETE CASCADE; 
ALTER TABLE StudyMember ADD FOREIGN KEY(SM_M_INDEX) REFERENCES Member(M_INDEX) ON DELETE CASCADE; 
>>>>>>> origin/seungmin

SELECT SM_S_INDEX, SM_M_INDEX FROM StudyMember;
INSERT INTO StudyMember(SM_S_INDEX, SM_M_INDEX) VALUES (?, ?);
UPDATE StudyMember SET SM_S_INDEX=?, SM_M_INDEX=? WHERE SM_S_INDEX=? AND SM_M_INDEX=?;
DELETE FROM StudyMember WHERE SM_S_INDEX=? AND SM_M_INDEX=?;



-- Board 테이블 생성(게시판 정보)
CREATE TABLE Board(
	B_NO NUMBER NOT NULL PRIMARY KEY,
	B_S_INDEX NUMBER NOT NULL,
	B_M_INDEX NUMBER NOT NULL,
	B_STUDYSEQ NUMBER NOT NULL,
	B_TITLE VARCHAR(100) NOT NULL,
	B_DATE DATE NOT NULL,
	B_CONTENT VARCHAR(300) NOT NULL,               
	B_FILENAME VARCHAR(100) 
)

CREATE SEQUENCE board_no
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

CREATE SEQUENCE board_studyseq
START WITH 1
INCREMENT BY 1
NOMAXVALUE;


<<<<<<< HEAD
ALTER TABLE Board ADD FOREIGN KEY(B_M_INDEX) REFERENCES Member(M_INDEX); 
ALTER TABLE Board ADD FOREIGN KEY(B_S_INDEX) REFERENCES Study(S_INDEX);


=======
ALTER TABLE Board ADD FOREIGN KEY(B_M_INDEX) REFERENCES Member(M_INDEX) ON DELETE CASCADE; 
ALTER TABLE Board ADD FOREIGN KEY(B_S_INDEX) REFERENCES Study(S_INDEX) ON DELETE CASCADE;


>>>>>>> origin/seungmin
SELECT B_NO, B_M_INDEX, B_TITLE, B_DATE, B_CONTENT, B_FILENAME FROM Board;
INSERT INTO Board(B_NO, B_M_INDEX, B_TITLE, B_DATE, B_CONTENT, B_FILENAME) VALUES (board_no.NEXTVAL, ?, ?, ?, ?, ?);
UPDATE Board SET B_M_INDEX=?, B_TITLE=?, B_DATE=?, B_CONTENT=?, B_FILENAME=? WHERE B_NO=?;
DELETE FROM Board WHERE B_NO=?;



-- 스터디 공지 정보 테이블
CREATE TABLE Meeting(
	MT_ID NUMBER NOT NULL PRIMARY KEY,
	MT_S_INDEX NUMBER NOT NULL,
	MT_PLACE VARCHAR(50) NOT NULL,
	MT_DATE DATE NOT NULL,
<<<<<<< HEAD
	MT_EXPECTEDFEE NUMBER NOT NULL
=======
	MT_EXPECTEDFEE NUMBER NOT NULL,
	MT_LATITUDE NUMBER,
	MT_LONGITUDE NUMBER,
	MT_COMMENT VARCHAR(200)
>>>>>>> origin/seungmin
)


CREATE SEQUENCE meeting_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

ALTER TABLE Meeting ADD FOREIGN KEY(MT_S_INDEX) REFERENCES Study(S_INDEX);

SELECT MT_ID, MT_S_INDEX, MT_ATTEND, MT_PLACE, MT_DATE, MT_EXPECTEDFEE FROM Meeting;
INSERT INTO Meeting(MT_ID, MT_S_INDEX, MT_ATTEND, MT_PLACE, MT_DATE, MT_EXPECTEDFEE) 
		VALUES (meeting_index.NEXTVAL, ?, ?, ?, ?, ?);
UPDATE Meeting SET MT_S_INDEX=?, MT_ATTEND=?, MT_PLACE=?, MT_DATE=?, MT_EXPECTEDFEE=? WHERE MT_ID=?;
DELETE FROM Meeting WHERE MT_ID?;





-- 회비관리 지출내역 정보 테이블
CREATE TABLE FeeExpense(
	FE_INDEX NUMBER NOT NULL PRIMARY KEY,
	FE_MT_ID NUMBER NOT NULL,
	FE_EXPENSE NUMBER NOT NULL,
	FE_NOTE VARCHAR(30) NOT NULL
)

CREATE SEQUENCE feeexpense_id
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

<<<<<<< HEAD
ALTER TABLE FeeExpense ADD FOREIGN KEY(FE_MT_ID) REFERENCES Meeting(MT_ID);
=======
ALTER TABLE FeeExpense ADD FOREIGN KEY(FE_MT_ID) REFERENCES Meeting(MT_ID) ON DELETE CASCADE;
>>>>>>> origin/seungmin

SELECT FE_INDEX, FE_MT_ID, FE_EXPENSE, FE_NOTE FROM FeeExpense;
INSERT INTO FeeExpense(FE_INDEX, FE_MT_ID, FE_EXPENSE, FE_NOTE) VALUES (?, ?, ?, ?);
UPDATE FeeExpense SET FE_INDEX=?, FE_EXPENSE=?, FE_NOTE=? WHERE FE_INDEX=?;
DELETE FROM FeeExpense WHERE FE_INDEX=?;






-- 회비 관리 명단 정보 테이블
CREATE TABLE FeeMember(
	FM_ID NUMBER NOT NULL PRIMARY KEY,
	FM_M_INDEX NUMBER NOT NULL,
	FM_MT_ID NUMBER NOT NULL,
	FM_FEE NUMBER NOT NULL,
	FM_NOTE VARCHAR(30)
)

CREATE SEQUENCE feemember_id
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

ALTER TABLE FeeMember ADD FOREIGN KEY(FM_M_INDEX) REFERENCES Member(M_INDEX) ON DELETE CASCADE;
ALTER TABLE FeeMember ADD FOREIGN KEY(FM_MT_ID) REFERENCES Meeting(MT_ID) ON DELETE CASCADE;

SELECT FM_ID, FM_M_INDEX, FM_MT_ID, FM_FEE, FM_NOTE FROM FeeMember;
INSERT INTO FeeMember(FM_ID, FM_M_INDEX, FM_MT_ID, FM_FEE, FM_NOTE) VALUES (feemember_id.NEXTVAL, ?, ?, ?, ?);
UPDATE FeeMember SET FM_M_INDEX=?, FM_MT_ID=?, FM_FEE=?, FM_NOTE=? WHERE FM_ID=?;
DELETE FROM FeeMember WHERE FM_ID=?;





-- 출석여부 정보 테이블
CREATE TABLE Attend(
	A_INDEX NUMBER NOT NULL PRIMARY KEY,
	A_MT_ID NUMBER NOT NULL,
	A_M_INDEX NUMBER NOT NULL,
	A_ATTEND VARCHAR(3) NOT NULL
)

CREATE SEQUENCE attend_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;


<<<<<<< HEAD
ALTER TABLE Attend ADD FOREIGN KEY(A_MT_ID) REFERENCES Meeting(MT_ID);
ALTER TABLE Attend ADD FOREIGN KEY(A_M_INDEX) REFERENCES Member(M_INDEX);
=======
ALTER TABLE Attend ADD FOREIGN KEY(A_MT_ID) REFERENCES Meeting(MT_ID) ON DELETE CASCADE;
ALTER TABLE Attend ADD FOREIGN KEY(A_M_INDEX) REFERENCES Member(M_INDEX) ON DELETE CASCADE;
>>>>>>> origin/seungmin

SELECT A_INDEX, A_MT_ID, A_M_INDEX, A_ATTEND FROM Attend;
INSERT INTO Attend(A_INDEX, A_MT_ID, A_M_INDEX, A_ATTEND) VALUES (attend_index.NEXTVAL, ?, ?, ?);
UPDATE Attend SET A_INDEX=?, A_MT_ID=?, A_M_INDEX=?, A_ATTEND=? WHERE C_INDEX=?;
DELETE FROM Attend WHERE A_INDEX=?;



SELECT * FROM TAB;

-- 댓글 관리 테이블
CREATE TABLE Comments(
	C_INDEX NUMBER NOT NULL PRIMARY KEY,
	C_B_NO NUMBER NOT NULL,
	C_M_INDEX NUMBER NOT NULL,
	C_DATE DATE NOT NULL,
	C_CONTENT VARCHAR(300) NOT NULL
)

drop table Comments;

CREATE SEQUENCE comments_index
START WITH 1
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
INCREMENT by 1
=======
INCREMENT BY 1
>>>>>>> origin/so33
=======
INCREMENT BY 1
>>>>>>> studyMain
NOMAXVALUE;

ALTER TABLE Comments ADD FOREIGN KEY(C_B_NO) REFERENCES Board(B_NO);
ALTER TABLE Comments ADD FOREIGN KEY(C_M_INDEX) REFERENCES Member(M_INDEX);
<<<<<<< HEAD

SELECT C_INDEX, C_S_INDEX, C_M_INDEX, C_DATE, C_CONTENT FROM Comments;
INSERT INTO Comments(C_INDEX, C_S_INDEX, C_M_INDEX, C_DATE, C_CONTENT) VALUES (comment_index.NEXTVAL, ?, ?, ?, ?);
UPDATE Comments SET C_INDEX=?, C_S_INDEX=?, C_M_INDEX=?, C_DATE=?, C_CONTENT=? WHERE C_INDEX=?;
DELETE FROM Comments WHERE SI_S_INDEX=? AND C_INDEX=?;
=======
=======
INCREMENT BY 1
NOMAXVALUE;

ALTER TABLE Comments ADD FOREIGN KEY(C_B_NO) REFERENCES Board(B_NO) ON DELETE CASCADE;
ALTER TABLE Comments ADD FOREIGN KEY(C_M_INDEX) REFERENCES Member(M_INDEX) ON DELETE CASCADE;
>>>>>>> origin/seungmin

SELECT C_INDEX, C_S_INDEX, C_M_INDEX, C_DATE, C_CONTENT FROM Comments;
INSERT INTO Comments(C_INDEX, C_S_INDEX, C_M_INDEX, C_DATE, C_CONTENT) VALUES (comment_index.NEXTVAL, ?, ?, ?, ?);
UPDATE Comments SET C_INDEX=?, C_S_INDEX=?, C_M_INDEX=?, C_DATE=?, C_CONTENT=? WHERE C_INDEX=?;
DELETE FROM Comments WHERE SI_S_INDEX=? AND C_INDEX=?;


drop table Member cascade CONSTRAINT;
>>>>>>> studyMain
