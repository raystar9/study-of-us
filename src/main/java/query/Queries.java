package query;

public class Queries {

	public static final String GET_STUDY_ID = "SELECT s_index FROM study WHERE s_name = ?";
	public static final String GET_STUDY_MEMBER = "SELECT m_index, m_name FROM studyMemberList WHERE s_name = ?";

}
