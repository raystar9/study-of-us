create view StudyMeeting 
as select s_index, s_name, mt_id, mt_s_index, mt_place, mt_date, mt_expectedfee 
from study, meeting 
where s_index = mt_s_index; 

create view StudyBoard
as select s_index, s_name, b_no, b_s_index, b_m_index, b_studyseq, b_title, b_date, b_content, b_filename
from study, board
where s_index = b_s_index;