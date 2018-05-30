
delete study;


CREATE TABLE Study(
	S_INDEX NUMBER NOT NULL PRIMARY KEY,      -- study_index 시퀀스 처리
	S_NAME VARCHAR(16) NOT NULL,
	S_C_ID NUMBER NOT NULL,              -- CATEGORY.C_ID 외래키 지정 해줘야 함.
	S_MT_INDEX NUMBER NOT NULL,
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
)
select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE 
			from (
			select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE 
			from (
			select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where s_place LIKE '%%' and s_name LIKE '%%' and category.C_SUB LIKE '%%'
			order by s_index))) 
			where rnum >= 1 and rnum <= 5;
			
			
			select * from study where s_place LIKE '%인천%' and s_name LIKE '%자바%' and LIKE 
			
			select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where Study.s_c_id = 1

			CREATE TABLE Category(
	C_ID NUMBER NOT NULL PRIMARY KEY,        -- Study테이블에 외래키로 사용됨.
	C_GROUP VARCHAR(20) NOT NULL,            -- 대분류
	C_SUB VARCHAR(20) NOT NULL               -- 소분류
)

CREATE SEQUENCE study_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE 
			from (
			select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE 
			from (
			select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where s_place LIKE '%자바%' and s_name LIKE '%영어%' and category.C_SUB LIKE '%자바%' 
			order by s_index))) 
			where rnum >= 1 and rnum <= 5;

select * from Category

select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE
			from (
			select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE 
			from study 
			order by s_index)) 
			where rnum >= 1 and rnum <= 5;
insert into study values(study_index.nextval,'자바스터디',1,2,'2018-05-29','2018-06-15',6,'2018-06-15','2018-06-15','2018-06-15','2018-06-15','2018-06-15','인천');
insert into study values(study_index.nextval,'영어스터디',2,2,'2018-05-29','2018-06-15',6,'2018-06-15','2018-06-15','2018-06-15','2018-06-15','2018-06-15','서울');