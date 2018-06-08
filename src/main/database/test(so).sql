
select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where c_sub = ?

select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where c_group = '프로그래밍';
		
select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_M_INDEX , S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE ,C_GROUP, C_SUBGROUP 
			from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID ) where C_SUBGROUP LIKE '%%'
			
			select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_M_INDEX , S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE ,C_GROUP, C_SUBGROUP 
			 from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID ) where S_NAME LIKE ? and S_PLACE LIKE ? and C_SUBGROUP LIKE ? and S_DAY LIKE ? and S_TIME LIKE ? 


select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_M_INDEX , S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE ,C_GROUP, C_SUBGROUP 
from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID order by s_index) where S_NAME LIKE '%외국%' and S_PLACE LIKE '%서울%' and C_SUBGROUP LIKE '%%' and S_DAY LIKE '%주말%' and S_TIME LIKE '%12:00%' and rnum >= 1 and rnum <= 5; 

select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where C_GROUP = '프로그래밍' order by S_index desc 
select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where c_group LIKE '%%'

select * from CATEGORY 
select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE 
			from (
			select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE 
			from (
			select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where s_place LIKE '%%' and s_name LIKE '%%' and category.C_SUB LIKE '%%'
			order by s_index))) 
			where rnum >= 1 and rnum <= 5;



delete study;

select * from studylist


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

			
			
			select * from study where s_place LIKE '%인천%' and s_name LIKE '%자바%' and LIKE 
			select * from study where s_place LIKE '%인천%' or s_place LIKE '%서울%'
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

검색어 , 카테고리 , 시간대 , 요일 , 지역

select * from Category
select * from study

drop table study cascade constraint;
select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE
			from (
			select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE 
			from study 
			order by s_index)) 
			where rnum >= 1 and rnum <= 5;
