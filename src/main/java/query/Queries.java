package query;

public class Queries {

	public static final String GET_STUDY_ID = "SELECT s_index FROM study WHERE s_name = ?";
	public static final String GET_STUDY_MEMBERS = "SELECT m_index, m_name FROM studyMemberList WHERE s_name = ?";
	public static final String GET_STUDY_MEMBER = "SELECT m_index, m_name FROM studyMemberList WHERE s_name = ? AND m_index = ?";
	public static final String GET_TOTAL_SPENT_FEE = "select sum(fe_expense) from meeting, feeexpense where fe_mt_id = mt_id AND mt_id <= ?";
	public static final String GET_TOTAL_COLLECT_FEE = "select sum(fm_fee) from meeting, feemember where fm_mt_id = mt_id AND mt_id <= ?";
	public static final String IS_FEE_REGISTERED = "select count(*) from meeting, feemember where fm_mt_id = mt_id AND mt_id = ?";
	public static final String IS_ATTENDANCE_CHECKED = "select count(*) from meeting, attend where a_mt_id = mt_id AND mt_id = ?";
}
