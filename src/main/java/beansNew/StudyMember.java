package beansNew;

public class StudyMember {
	public static final String QUERY_GET_STUDIES = "SELECT SM_S_INDEX, SM_M_INDEX FROM StudyMember WHERE SM_M_INDEX = ?";
	public static final String QUERY_GET_MEMBERS = "SELECT SM_S_INDEX, SM_M_INDEX FROM StudyMember WHERE SM_S_INDEX = ?";
	public static final String QUERY_POST = "INSERT INTO StudyMember(SM_S_INDEX, SM_M_INDEX) values(?, ?)";
	int studyId;
	int memberId;
	
	public StudyMember(int studyId, int memberId) {
		this.studyId = studyId;
		this.memberId = memberId;
	}
	
	public int getStudyId() {
		return studyId;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
	
}
