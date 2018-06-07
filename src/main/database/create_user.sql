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

