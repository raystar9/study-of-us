-- ADMIN계정 (관리자)
﻿CREATE USER project
IDENTIFIED BY 1234; 

GRANT connect,resource,dba TO project;


-- SELECT계정(조회만 가능)
CREATE USER soupselect
IDENTIFIED BY 1234;


-- 시노님(SYSNONYM) 권한주기 및 생성
-- system에서.
GRANT create sysnonym to soupselect;
-- project계정에서.
GRANT select ON tablename TO 권한받는 계정;
-- soupselect계정에서.
CREATE SYNONYM sysnonym명 FOR 권한주는계정.테이블이름;

-- project 계정에서 권한주기.
GRANT select ON Member TO soupselect;
GRANT select ON Study TO soupselect;
GRANT select ON Category TO soupselect;
GRANT select ON Interesting TO soupselect;
GRANT select ON PreferenceArea TO soupselect;
GRANT select ON StudyMember TO soupselect;
GRANT select ON Board TO soupselect;
GRANT select ON Meeting TO soupselect;
GRANT select ON FeeExpense TO soupselect;
GRANT select ON FeeMember TO soupselect;
GRANT select ON Attend TO soupselect;
GRANT select ON Comments TO soupselect;


-- soupselect계정에서.
CREATE SYNONYM member FOR project.member;
CREATE SYNONYM study FOR project.study;
CREATE SYNONYM category FOR project.category;
CREATE SYNONYM interesting FOR project.interesting;
CREATE SYNONYM preferencearea FOR project.preferencearea;
CREATE SYNONYM studymember FOR project.studymember;
CREATE SYNONYM board FOR project.board;
CREATE SYNONYM meeting FOR project.meeting;
CREATE SYNONYM feeexpense FOR project.feeexpense;
CREATE SYNONYM feemember FOR project.feemember;
CREATE SYNONYM attend FOR project.attend;
CREATE SYNONYM comments FOR project.comments;











INSERT INTO Member(M_INDEX, M_ID, M_PASSWORD, M_NAME, M_EMAIL, M_TEL, M_ADDRESS, M_GENDER, M_INTRODUCE)
	VALUES (member_index.NEXTVAL, 'sm00', '1234', '곽승민', 'snow@naver.com', 01050667016, '경기도 의정부시 의정부동', '남', '안녕하세요~~');

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
	VALUES (study_index.NEXTVAL, 'Java마스터', 101, 5, '2018-06-01', '2018-06-30', 5, '토요일', '14:00', '자바의 달이이 되어보자.', '강한정신력', '자바 능력 향상', '서울특별시 중구');
	
INSERT INTO Study(S_INDEX, S_NAME, S_C_ID, S_M_INDEX, S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE)
	VALUES (study_index.NEXTVAL, '수능만점', 402, 6, '2018-03-01', '2018-11-11', 3, '주5일', '09:00', '수학 만점을향해서...', '문제집', '수학만점', '경기도 의정부시');
	
INSERT INTO Study(S_INDEX, S_NAME, S_C_ID, S_M_INDEX, S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE)
	VALUES (study_index.NEXTVAL, '외국인처럼 말하기', 201, 3, '2018-07-01', '2018-09-30', 2, '주말', '12:00', '외국인이 와도 무섭지않아요.', '영어사전', '영어 마스터', '서울특별시 동대문구');
	
	
select * from study;

drop table feemember;
drop table feeexpense;
drop table attend;
drop table meeting;

select * from study;


delete from Study;

select * from study;

INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (4, 1);
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (4, 2);
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (4, 5);
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (4, 7);
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (4, 8);
	
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (5, 6);
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (5, 1);
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (5, 10);
	
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (6, 3);
INSERT INTO STUDYMEMBER (SM_S_INDEX, SM_M_INDEX)
	VALUES (6, 5);
	
select * from study;
select * from studymember;

drop table StudyMember;
drop table PreferenceArea;
drop table Message;
drop table Interesting;
drop table Comments;
drop table board;
drop table category;
drop table member;
drop table study;
drop table i_comment;
drop table inquiryboard;
drop table meeting;

select * from meeting;
alter table meeting modify(MT_DATE TIMESTAMP);

select * from study;

delete from meeting;


drop view studyboard;
drop view studyboardlist;
drop view studymeeting;
drop view studymemberlist;
