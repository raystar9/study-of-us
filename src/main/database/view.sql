create view StudyMeeting 
as select s_index, s_name, mt_id, mt_s_index, mt_place, mt_date, mt_expectedfee 
from study, meeting 
where s_index = mt_s_index; 

create view StudyBoard
as select s_index, s_name, b_no, b_s_index, b_m_index, b_studyseq, b_title, b_date, b_content, b_filename
from study, board
where s_index = b_s_index;

create view studymemberlist 
as SELECT s_index, s_name, m_index, m_id, m_password, m_name, m_email, m_tel, m_address, m_gender, m_introduce 
FROM study, member, studymember
where sm_s_index = s_index 
and sm_m_index = m_index;

create view studyBoardList 
as SELECT s_index, s_name, b_no, b_studyseq,  b_title, b_date, b_content, b_filename, m_name 
FROM board, study, member 
WHERE b_s_index = s_index 
AND b_m_index = m_index 
ORDER BY b_studyseq DESC;

