package query;

public class Queries {

	public static final String GET_STUDY_ID = "SELECT s_index FROM study WHERE s_name = ?";
	public static final String GET_STUDY_MEMBER_NAMES = "SELECT m_name FROM studymember, study, member WHERE sm_s_index = s_index AND sm_m_index = m_index AND s_name = ?";

}
