
select * from member where M_id = 'so' = (select * from studymember where = ) 

select * from message inner join member on message.M_INDEX = member.m_index

drop table message
select * from message
create table message (
	M_S_INDEX NUMBER, 
	M_M_ID VARCHAR(20),
	M_S_NAME VARCHAR(50),
	M_M_INDEX NUMBER
)

select * from study inner join member on study.s_m_index = member.m_index where s_m_index = ?
select * from Message where m_s_index = 7

select s_m_index from study inner join member on study.s_m_index = member.m_index where m_ID = 'so'



select * from study natural join member 
select * from member


select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_M_INDEX , S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE ,C_GROUP, C_SUBGROUP  
			from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where C_GROUP LIKE '%프로그래밍%') where rnum >= 1 and rnum <= 4 order by s_index;
select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_M_INDEX , S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE ,C_GROUP, C_SUBGROUP  
			from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID  where S_NAME LIKE '%%' and S_PLACE LIKE '%%' and C_GROUP LIKE '%프로그래밍%' and S_DAY LIKE '%%' and S_TIME LIKE '%%' order by s_index) 

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

select * from studtmember
select * from massage

select * from 

INSERT INTO Study(S_INDEX, S_NAME, S_C_ID, S_M_INDEX, S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE)
	VALUES (study_index.NEXTVAL, 'Java마스터', 101, 27, '2018-06-01', '2018-06-30', 5, '토요일', '14:00', '자바의 달이이 되어보자.', '강한정신력', '자바 능력 향상', '서울특별시 중구');
	
INSERT INTO Study(S_INDEX, S_NAME, S_C_ID, S_M_INDEX, S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE)
	VALUES (study_index.NEXTVAL, 'SO가 생성한 스터디', 402, 7, '2018-03-01', '2018-11-11', 3, '주5일', '09:00', '수학 만점을향해서...', '문제집', '수학만점', '경기도 의정부시');
	
INSERT INTO Study(S_INDEX, S_NAME, S_C_ID, S_M_INDEX, S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE)
	VALUES (study_index.NEXTVAL, '외국인처럼 말하기', 201, 25, '2018-07-01', '2018-09-30', 2, '주말', '12:00', '외국인이 와도 무섭지않아요.', '영어사전', '영어 마스터', '서울특별시 동대문구');
	
	SELECT * FROM message where m_s_index = 5 and m_m_index = 7

	
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
	
	
	CREATE TABLE StudyMember(
	SM_S_INDEX NUMBER NOT NULL,
	SM_M_INDEX NUMBER NOT NULL
)
select * from studymember;
delete message;
select * from message;