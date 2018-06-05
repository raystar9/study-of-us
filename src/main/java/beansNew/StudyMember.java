package beansNew;

public class StudyMember {
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
