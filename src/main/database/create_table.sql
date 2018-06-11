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


﻿-- Member테이블 INDEX의 시퀀스
CREATE SEQUENCE member_index
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
	S_NAME VARCHAR(16) NOT NULL,
	S_C_ID NUMBER NOT NULL,              -- CATEGORY.C_ID 외래키 지정 해줘야 함.
	S_MT_INDEX NUMBER NOT NULL,
	S_M_INDEX NOT NULL,
	S_START DATE NOT NULL,
	S_END DATE NOT NULL,
	S_PLOPIENUM NUMBER NOT NULL,
	S_DAY DATE NOT NULL,
	S_TIME DATE NOT NULL,
	S_EXPLAIN VARCHAR(100) NOT NULL,
	S_PREPARED VARCHAR(50) NOT NULL,
	S_EFFECTIVE VARCHAR(100) NOT NULL,
	S_PLACE VARCHAR(50) NOT NULL           
)

CREATE SEQUENCE study_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

ALTER TABLE Study ADD FOREIGN KEY(S_C_ID) REFERENCES Category(C_ID); -- 외래키 지정.
ALTER TABLE Study ADD FOREIGN KEY(S_MT_INDEX) REFERENCES Meeting(MT_INDEX);
ALTER TABLE Study ADD FOREIGN KEY(S_M_INDEX) REFERENCES Member(M_INDEX);

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
	C_SUB VARCHAR(20) NOT NULL               -- 소분류
)

SELECT C_ID, C_GROUP, C_SUB FROM Category;
INSERT INTO Category(C_ID, C_GROUP, C_SUB) VALUES (?, ?, ?);
UPDATE Category SET C_GROUP=?, C_SUB=? WHERE C_ID=?;
DELETE FROM Category WHERE C_ID=?;




-- Interesting 테이블 생성(회원별 관심사)
CREATE TABLE Interesting(
	I_M_INDEX NUMBER NOT NULL,
	I_C_ID NUMBER NOT NULL,
	PRIMARY KEY(I_M_INDEX, I_C_ID)           -- 다중 PRIMARY KEY 지정.
)

ALTER TABLE Interesting ADD FOREIGN KEY(I_M_INDEX) REFERENCES Member(M_INDEX);
ALTER TABLE Interesting ADD FOREIGN KEY(I_C_ID) REFERENCES Category(C_ID);

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

ALTER TABLE PreferenceArea ADD FOREIGN KEY(P_M_INDEX) REFERENCES Member(M_INDEX);

SELECT P_M_INDEX, P_AREA FROM PreferenceArea;
INSERT INTO PreferenceArea(P_M_INDEX, P_AREA) VALUES (?, ?);
UPDATE PreferenceArea SET P_AREA=? WHERE P_M_INDEX=?;
DELETE FROM PreferenceArea WHERE P_M_INDEX=?;



-- StudyList 테이블 생성(스터디의 명단 정보)
CREATE TABLE StudyList(
	SL_S_INDEX NUMBER NOT NULL,
	SL_M_INDEX NUMBER NOT NULL,
	PRIMARY KEY(SL_S_INDEX, SL_M_INDEX)
)

ALTER TABLE StudyList ADD FOREIGN KEY(SL_S_INDEX) REFERENCES Study(S_INDEX); 
ALTER TABLE StudyList ADD FOREIGN KEY(SL_M_INDEX) REFERENCES Member(M_INDEX); 

SELECT SL_S_INDEX, SL_M_INDEX FROM StudyList;
INSERT INTO StudyList(SL_S_INDEX, SL_M_INDEX) VALUES (?, ?);
UPDATE StudyList SET SL_S_INDEX=?, SL_M_INDEX=? WHERE SL_S_INDEX=? AND SL_M_INDEX=?;
DELETE FROM StudyList WHERE SL_S_INDEX=? AND SL_M_INDEX=?;



-- Board 테이블 생성(게시판 정보)
CREATE TABLE Board(
	B_NO NUMBER NOT NULL PRIMARY KEY,
	B_S_INDEX NUMBER NOT NULL,
	B_M_INDEX NUMBER NOT NULL,
	B_STUDYSEQ NUMBER NOT NULL,
	B_TITLE VARCHAR(100) NOT NULL,
	B_DATE DATE NOT NULL,
	B_CONTENT VARCHAR(300) NOT NULL               -- CLOE처리 할수도..
)

CREATE SEQUENCE board_no
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

CREATE SEQUENCE board_studyseq
START WITH 1
INCREMENT BY 1
NOMAXVALUE;


ALTER TABLE Board ADD FOREIGN KEY(B_M_INDEX) REFERENCES Member(M_INDEX); 

SELECT B_NO, B_M_INDEX, B_TITLE, B_DATE, B_CONTENT FROM Board;
INSERT INTO Board(B_NO, B_M_INDEX, B_TITLE, B_DATE, B_CONTENT) VALUES (board_no.NEXTVAL, ?, ?, ?, ?);
UPDATE Board SET B_M_INDEX=?, B_TITLE=?, B_DATE=?, B_CONTENT=? WHERE B_NO=?;
DELETE FROM Board WHERE B_NO=?;



-- 스터디 공지 정보 테이블
CREATE TABLE Meeting(
	MT_ID NUMBER NOT NULL PRIMARY KEY,
	MT_S_INDEX NUMBER NOT NULL,
	MT_ATTEND VARCHAR(3) NOT NULL,
	MT_PLACE VARCHAR(50) NOT NULL,
	MT_DATE DATE NOT NULL,
	MT_EXPECTFEE NUMBER NOT NULL
)

CREATE SEQUENCE meeting_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

ALTER TABLE Meeting ADD FOREIGN KEY(MT_S_INDEX) REFERENCES Study(S_INDEX);

SELECT MT_ID, MT_S_INDEX, MT_ATTEND, MT_PLACE, MT_DATE, MT_EXPECTFEE FROM Meeting;
INSERT INTO Meeting(MT_ID, MT_S_INDEX, MT_ATTEND, MT_PLACE, MT_DATE, MT_EXPECTFEE) 
		VALUES (meeting_index.NEXTVAL, ?, ?, ?, ?, ?);
UPDATE Meeting SET MT_S_INDEX=?, MT_ATTEND=?, MT_PLACE=?, MT_DATE=?, MT_EXPECTFEE=? WHERE MT_ID=?;
DELETE FROM Meeting WHERE MT_ID?;




-- 스터디 공지 시퀀스를 위한 테이블
CREATE TABLE MeetingMember(
	MTM_ID NUMBER NOT NULL PRIMARY KEY,
	MTM_MT_ID NUMBER NOT NULL
)

CREATE SEQUENCE meetingmember_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

ALTER TABLE MeetingMember ADD FOREIGN KEY(MTM_MT_ID) REFERENCES Meeting(MT_ID);

SELECT MTM_ID, MTM_MT_ID FROM MeetingMember;
INSERT INTO MeetingMember(MTM_ID, MTM_MT_ID) VALUES (meetingmember_index.NEXTVAL, ?);
UPDATE MeetingMember SET MTM_MT_ID=? WHERE MTM_ID=?;
DELETE FROM MeetingMember WHERE MTM_ID?;




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

ALTER TABLE FeeMember ADD FOREIGN KEY(FM_M_INDEX) REFERENCES Member(M_INDEX);
ALTER TABLE FeeMember ADD FOREIGN KEY(FM_MT_ID) REFERENCES Member(MT_ID);

SELECT FM_ID, FM_M_INDEX, FM_MT_ID, FM_FEE, FM_NOTE FROM FeeMember;
INSERT INTO FeeMember(FM_ID, FM_M_INDEX, FM_MT_ID, FM_FEE, FM_NOTE) VALUES (feemember_id.NEXTVAL, ?, ?, ?, ?);
UPDATE FeeMember SET FM_M_INDEX=?, FM_MT_ID=?, FM_FEE=?, FM_NOTE=? WHERE FM_ID=?;
DELETE FROM FeeMember WHERE FM_ID=?;




-- 회비관리 지출내역 정보 테이블
CREATE TABLE FeeExpense(
	FE_ID NUMBER NOT NULL PRIMARY KEY,
	FE_MT_ID NUMBER NOT NULL,
	FE_EXPENSE VARCHAR(30) NOT NULL,
	FE_EXPENSEFEE NUMBER NOT NULL
)

CREATE SEQUENCE feeexpense_id
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

ALTER TABLE FeeExpense ADD FOREIGN KEY(FE_MT_ID) REFERENCES Meeting(MT_ID);

SELECT FE_ID, FE_F_ID, FE_EXPENSE, FE_EXPENSEFEE FROM FeeExpense;
INSERT INTO FeeExpense(FE_ID, FE_MT_ID, FE_EXPENSE, FE_EXPENSEFEE) VALUES (?, ?, ?, ?);
UPDATE FeeExpense SET FE_MT_ID=?, FE_EXPENSE=?, FE_EXPENSEFEE=? WHERE FE_ID=?;
DELETE FROM FeeExpense WHERE FE_ID=?;




-- 스터디정보를 담고 있는 테이블
CREATE TABLE StudyInformation(
	SI_S_INDEX NUMBER NOT NULL,
	SI_M_INDEX NUMBER NOT NULL,
	PRIMARY KEY(SI_S_INDEX, SI_M_INDEX)
)

ALTER TABLE StudyInformation ADD FOREIGN KEY(SI_S_INDEX) REFERENCES Study(S_INDEX);
ALTER TABLE StudyInformation ADD FOREIGN KEY(SI_M_INDEX) REFERENCES Member(M_INDEX);

SELECT SI_S_INDEX, SI_M_INDEX FROM StudyInformation;
INSERT INTO StudyInformation(SI_S_INDEX, SI_M_INDEX) VALUES (?, ?);
UPDATE StudyInformation SET SI_S_INDEX=?, SI_M_INDEX=? WHERE SI_S_INDEX=? AND SI_M_INDEX=?;
DELETE FROM StudyInformation WHERE SI_S_INDEX=? AND SI_M_INDEX=?;





-- 댓글 관리 테이블
CREATE TABLE Comment(
	C_INDEX NUMBER NOT NULL PRIMARY KEY,
	C_S_INDEX NUMBER NOT NULL,
	C_M_INDEX NUMBER NOT NULL,
	C_DATE DATE NOT NULL,
	C_CONTENT VARCHAR(300) NOT NULL
)

CREATE SEQUENCE comment_index
START WITH 1
INCREMENT by 1
NOMAXVALUE;

ALTER TABLE Comment ADD FOREIGN KEY(C_S_INDEX) REFERENCES Study(S_INDEX);
ALTER TABLE Comment ADD FOREIGN KEY(C_M_INDEX) REFERENCES Member(M_INDEX);

SELECT C_INDEX, C_S_INDEX, C_M_INDEX, C_DATE, C_CONTENT FROM Comment;
INSERT INTO Comment(C_INDEX, C_S_INDEX, C_M_INDEX, C_DATE, C_CONTENT) VALUES (comment_index.NEXTVAL, ?, ?, ?, ?);
UPDATE Comment SET C_INDEX=?, C_S_INDEX=?, C_M_INDEX=?, C_DATE=?, C_CONTENT=? WHERE C_INDEX=?;
DELETE FROM Comment WHERE SI_S_INDEX=? AND C_INDEX=?;


