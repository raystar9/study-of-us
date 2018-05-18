-- Member���̺� INDEX�� ������
CREATE SEQUENCE member_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

-- Member ���̺� ����
CREATE TABLE Member(
	M_INDEX NUMBER NOT NULL PRIMARY KEY,      -- member_index ������ ó��
	M_ID VARCHAR(16) NOT NULL,
	M_PASSWORD VARCHAR(16) NOT NULL,
	M_NAME VARCHAR(15) NOT NULL,
	M_EMAIL VARCHAR(50) NOT NULL,
	M_TEL NUMBER NOT NULL,
	M_ADDRESS VARCHAR(200),
	M_GENDER VARCHAR(2) NOT NULL,
	M_INTRODUCE VARCHAR(200) NOT NULL
)

SELECT * FROM Member;
ALTER SEQUENCE member_index INCREMENT BY 1;   -- �������� ���� 1�� �ٲ���.

-- Study ���̺� ����
CREATE TABLE Study(
	S_INDEX NUMBER NOT NULL PRIMARY KEY,      -- study_index ������ ó��
	S_NAME VARCHAR(16) NOT NULL,         
	S_C_ID NUMBER NOT NULL,              -- CATEGORY.C_ID �ܷ�Ű ���� ����� ��.
	S_PLACE VARCHAR(50) NOT NULL,             -- ���� ���.
	S_TIME DATE NOT NULL,
	S_PLOPIENUM NUMBER NOT NULL,
	S_GOAL VARCHAR(100) NOT NULL,             -- �߰� ����(���̺� ���� ��������?)
	S_TERM DATE NOT NULL
)

SELECT * FROM Study;

-- Study ���̺� INDEX�� ������
CREATE SEQUENCE study_index
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

-- Category ���̺� ���� (���͵� �о߿� ���� ����)
CREATE TABLE Category(
	C_ID NUMBER NOT NULL PRIMARY KEY,        -- Study���̺� �ܷ�Ű�� ����.
	C_GROUP VARCHAR(20) NOT NULL,            -- ��з�
	C_SUB VARCHAR(20) NOT NULL               -- �Һз�
)

SELECT * FROM Category;

ALTER TABLE Study MODIFY(S_C_ID NUMBER);
ALTER TABLE Study ADD FOREIGN KEY(S_C_ID) REFERENCES Category(C_ID); -- �ܷ�Ű ����.


-- Interesting ���̺� ����(ȸ���� ���ɻ�)
CREATE TABLE Interesting(
	I_M_INDEX NUMBER NOT NULL,
	I_C_ID NUMBER NOT NULL,
	PRIMARY KEY(I_M_INDEX, I_C_ID)           -- ���� PRIMARY KEY ����.
)

-- PreferenceArea ���̺� ����(ȸ���� ��ȣ����)
ALTER TABLE Interesting ADD FOREIGN KEY(I_M_INDEX) REFERENCES Member(M_INDEX);
ALTER TABLE Interesting ADD FOREIGN KEY(I_C_ID) REFERENCES Category(C_ID);

CREATE TABLE PreferenceArea(
	P_M_INDEX NUMBER NOT NULL,
	P_AREA VARCHAR(30) NOT NULL,
	PRIMARY KEY(P_M_INDEX, P_AREA)
)

ALTER TABLE PreferenceArea ADD FOREIGN KEY(P_M_INDEX) REFERENCES Member(M_INDEX); 

-- StudyList ���̺� ����(���͵��� ��� ����)
CREATE TABLE StudyList(
	SL_S_INDEX NUMBER NOT NULL,
	SL_M_INDEX NUMBER NOT NULL,
	PRIMARY KEY(SL_S_INDEX, SL_M_INDEX)
)

ALTER TABLE StudyList ADD FOREIGN KEY(SL_S_INDEX) REFERENCES Study(S_INDEX); 
ALTER TABLE StudyList ADD FOREIGN KEY(SL_M_INDEX) REFERENCES Member(M_INDEX); 

-- Board ���̺� ����(�Խ��� ����)
CREATE TABLE Board(
	B_NO NUMBER NOT NULL PRIMARY KEY,
	B_M_INDEX NUMBER NOT NULL,
	B_DATE VARCHAR(10) NOT NULL,
	B_CONTENT VARCHAR(300) NOT NULL               -- CLOEó�� �Ҽ���..
)

-- Board ���̺� NO�� ������
CREATE SEQUENCE board_no
START WITH 1
INCREMENT BY 1
NOMAXVALUE;

ALTER TABLE Board ADD FOREIGN KEY(B_M_INDEX) REFERENCES Member(M_INDEX); 

-- Notice ���̺� ����(���͵� ���� �������� ����)
CREATE TABLE Notice(
	N_S_INDEX NUMBER NOT NULL PRIMARY KEY,
	N_CONTENT VARCHAR(300) NOT NULL              -- CLOEó�� �Ҽ���
)

ALTER TABLE Notice ADD FOREIGN KEY(N_S_INDEX) REFERENCES Study(S_INDEX);

