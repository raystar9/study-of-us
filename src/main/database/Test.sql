-- Study 테이블 생성
CREATE TABLE Study(
	S_INDEX NUMBER NOT NULL PRIMARY KEY,      -- study_index 시퀀스 처리
	S_NAME VARCHAR(30) NOT NULL,         
	S_C_ID NUMBER NOT NULL,              -- CATEGORY.C_ID 외래키 지정 해줘야 함.
	S_PLACE VARCHAR(50) NOT NULL,             -- 수정 요망.
	S_TIME DATE NOT NULL,
	S_PLOPIENUM NUMBER NOT NULL,
	S_GOAL VARCHAR(100) NOT NULL,             -- 추가 조정(테이블 따로 뺄것인지?)
	S_TERM DATE NOT NULL
)

drop table study;
ALTER TABLE Study ADD FOREIGN KEY(S_C_ID) REFERENCES Category(C_ID); 

insert into Study values(study_index.nextval, '프로그래밍 자바', 1, '서울', '2018-06-06', 6, '자바 마스터', '2018-07-06');
insert into Study values(study_index.nextval, '프로그래밍 c', 2, '인천', '2018-06-06', 6, 'C 마스터', '2018-07-06');
insert into Study values(study_index.nextval, '프로그래밍 파이썬', 3, '경기', '2018-06-06', 6, '파이썬 마스터', '2018-07-06');
insert into Study values(study_index.nextval, '프로그래밍 c++', 4, '서울', '2018-06-06', 6, 'c++ 마스터', '2018-07-06');
insert into Study values(study_index.nextval, '프로그래밍 c#', 5, '인천', '2018-06-06', 6, 'c# 마스터', '2018-07-06');
insert into Study values(study_index.nextval, '언어 영어', 6, '서울', '2018-06-06', 6, '토익 만점', '2018-07-06');
insert into Study values(study_index.nextval, '언어 불어', 7, '인천', '2018-06-06', 6, '불어 마스터', '2018-07-06');
insert into Study values(study_index.nextval, '언어 중국어', 8, '인천', '2018-06-06', 6, '중국어 만점', '2018-07-06');
insert into Study values(study_index.nextval, '언어 일본어', 9, '충북', '2018-06-06', 6, '일본어 만점', '2018-07-06');
insert into Study values(study_index.nextval, '언어 한국어', 10, '충북', '2018-06-06', 6, '한국어 마스터', '2018-07-06');
insert into Study values(study_index.nextval, '정보처리기사', 11, '대전', '2018-06-06', 6, '정보처리기사 합격', '2018-07-06');
insert into Study values(study_index.nextval, '컴퓨터활용', 12, '서울', '2018-06-06', 6, '컴활 합격', '2018-07-06');
insert into Study values(study_index.nextval, 'ccna', 13, '충북', '2018-06-06', 6, 'ccna 만점', '2018-07-06');
insert into Study values(study_index.nextval, 'ccnp', 14, '서울', '2018-06-06', 6, 'ccnp 합격', '2018-07-06');
insert into Study values(study_index.nextval, '네트워크관리사', 15, '서울', '2018-06-06', 6, '시험 만점', '2018-07-06');
insert into Study values(study_index.nextval, '자바의 정석', 1, '서울', '2018-06-06', 6, '자바 마스터', '2018-07-06');
insert into Study values(study_index.nextval, '이것이 자바다', 1, '서울', '2018-06-06', 6, '자바 마스터', '2018-07-06');
insert into Study values(study_index.nextval, '굿 자바', 1, '서울', '2018-06-06', 6, '자바 마스터', '2018-07-06');
insert into Study values(study_index.nextval, '자바를자바', 1, '서울', '2018-06-06', 6, '자바 마스터', '2018-07-06');
insert into Study values(study_index.nextval, '자바정독', 1, '인천', '2018-06-06', 6, '자바 마스터', '2018-07-06');

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
			from study where s_place LIKE '%%'and s_name LIKE '%자바%' 
			order by s_index)))
			where rnum >= 6 and rnum <= 10
			
					select * from (select rownum rnum, s_index, s_name, s_c_id, s_place, s_time, s_plopienum, s_goal, s_term  
			from (
			select s_index, s_name, s_c_id, s_place, s_time, s_plopienum, s_goal, s_term
			from study
			order by s_index))
			where rnum >= 1 and rnum <= 5
			
			
			select * from study where s_place LIKE '%%' and s_name LIKE '%자바%';
			
SELECT * FROM Study;

-- Study 테이블 INDEX의 시퀀스
CREATE SEQUENCE study_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

drop sequence study_index;
delete from STUDY;
delete from Category;

-- Category 테이블 생성 (스터디 분야에 대한 정보)
CREATE TABLE Category(
	C_ID NUMBER NOT NULL PRIMARY KEY,        -- Study테이블에 외래키로 사용됨.
	C_GROUP VARCHAR(20) NOT NULL,            -- 대분류
	C_SUB VARCHAR(20) NOT NULL               -- 소분류
)


insert into CATEGORY values (1,'프로그래밍','자바');
insert into CATEGORY values (2,'프로그래밍','c언어');
insert into CATEGORY values (3,'프로그래밍','파이썬');
insert into CATEGORY values (4,'프로그래밍','c++');
insert into CATEGORY values (5,'프로그래밍','c#');

insert into CATEGORY values (6,'언어','영어');
insert into CATEGORY values (7,'언어','불어');
insert into CATEGORY values (8,'언어','중국어');
insert into CATEGORY values (9,'언어','일본어');
insert into CATEGORY values (10,'언어','한국어');

insert into CATEGORY values (11,'자격증','정보처리기사');
insert into CATEGORY values (12,'자격증','컴활');
insert into CATEGORY values (13,'자격증','ccna');
insert into CATEGORY values (14,'자격증','ccnp');
insert into CATEGORY values (15,'자격증','네트워크관리사');



select * from CATEGORY 

select * from CATEGORY inner join STUDY on study.S_C_ID = CATEGORY.C_ID where c_sub = '자바'