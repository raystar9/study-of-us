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