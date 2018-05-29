--member2 테이블

CREATE TABLE Member(
	M_INDEX NUMBER NOT NULL PRIMARY KEY,    
	M_ID VARCHAR(16) NOT NULL,
	M_NAME VARCHAR(15) NOT NULL,
	M_PASSWORD VARCHAR(16) NOT NULL,
	M_EMAIL VARCHAR(50) NOT NULL,
	M_TEL NUMBER NOT NULL,
	M_ADDRESS VARCHAR(200),
	M_GENDER VARCHAR(2) NOT NULL,
	M_INTRODUCE VARCHAR(200) NOT NULL
);


select * from member;


﻿-- Member테이블 INDEX의 시퀀스
CREATE SEQUENCE member_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;


insert into member2 values(member_index.nextval,'ndw8524','노동완','shehddhks123','ndw2280@naver.com','01073580411','')


-- Study 테이블 생성
CREATE TABLE Study(
	S_INDEX NUMBER NOT NULL PRIMARY KEY,      -- study_index 시퀀스 처리
	S_C_ID NUMBER NOT NULL,              -- CATEGORY.C_ID 외래키 지정 해줘야 함.
	S_NAME VARCHAR(16) NOT NULL,				
	S_START DATE NOT NULL,							--시작날짜
	S_END DATE NOT NULL,							--끝날짜
	S_PLOPIENUM NUMBER NOT NULL,					--인원
	S_DAY varchar(3) not null,						--요일
	S_time number not null,							--활동시간
	S_explain varchar(100) not NULL,				--개요
	S_prepared	varchar(100) not null,				--프로젝트 준비
	S_effective VARCHAR(100) NOT NULL,				--기대및 효과
	S_PLACE VARCHAR(10) NOT NULL,				--프로젝트 장소
	constraint FK_s_c_id_study  FOREIGN KEY(S_C_ID) references Category(C_ID)	
);

select * from study;


select * from study;

CREATE TABLE Category(
	C_ID NUMBER NOT NULL PRIMARY KEY,        -- Study테이블에 외래키로 사용됨.
	C_GROUP VARCHAR(20) NOT NULL,            -- 대분류
	C_SUB VARCHAR(20) NOT NULL               -- 소분류
)


select * from category					--1번에 번호들어가고 2번에 대분류 3번에 소분류 들어가도록한다.




