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

insert into Study values(study_index.nextval, '자바스터디', 1, '서울', '2018-06-06', 6, '자바의정석 정독', '2018-07-06');
insert into Study values(study_index.nextval, '이것이자바다', 2, '경기', '2018-06-06', 6, '자바의정석 정독', '2018-07-06');
insert into Study values(study_index.nextval, '영어스터디', 3, '충북', '2018-06-06', 6, '토익 만점', '2018-07-06');
insert into Study values(study_index.nextval, '추가본', 3, '수원', '2018-06-06', 6, '토익 만점', '2018-07-06');

delete from study

select * from STUDY;

select rownum as rnum, s_index, s_name, s_c_id, s_place, s_time, s_plopienum, s_goal, s_term  
			from study (select s_index, s_name, s_c_id, s_place, s_time, s_plopienum, s_goal, s_term
			from study
			orderby s_index)
			
			select * from (select rownum rnum, s_index, s_name, s_c_id, s_place, s_time, s_plopienum, s_goal, s_term  
			from (
			select s_index, s_name, s_c_id, s_place, s_time, s_plopienum, s_goal, s_term
			from study
			order by s_index))
			where rnum >= 1 and rnum <= 5
			
			select * from (select rownum rnum, s_index, s_name, s_c_id, s_place, s_time, s_plopienum, s_goal, s_term  
			from (
			select s_index, s_name, s_c_id, s_place, s_time, s_plopienum, s_goal, s_term
			from (
			select * 
			from study where s_place LIKE '%서울%'
			order by s_index)))
			where rnum >= 1 and rnum <= 5
			
					select * from (select rownum rnum, s_index, s_name, s_c_id, s_place, s_time, s_plopienum, s_goal, s_term  
			from (
			select s_index, s_name, s_c_id, s_place, s_time, s_plopienum, s_goal, s_term
			from study
			order by s_index))
			where rnum >= 1 and rnum <= 5
			
			
			select * from study where s_place LIKE '%서울%' or s_name LIKE '';
			
SELECT * FROM Study;

-- Study 테이블 INDEX의 시퀀스
CREATE SEQUENCE study_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

drop sequence study_index;
delete from STUDY;

-- Category 테이블 생성 (스터디 분야에 대한 정보)
CREATE TABLE Category(
	C_ID NUMBER NOT NULL PRIMARY KEY,        -- Study테이블에 외래키로 사용됨.
	C_GROUP VARCHAR(20) NOT NULL,            -- 대분류
	C_SUB VARCHAR(20) NOT NULL               -- 소분류
)

insert into CATEGORY values (1,'프로그래밍','자바');