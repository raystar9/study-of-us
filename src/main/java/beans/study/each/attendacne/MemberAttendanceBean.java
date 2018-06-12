package beans.study.each.attendacne;

public class MemberAttendanceBean {
	public static final String QUERY_GET = "select m_index, m_name, a_attend from studyMemberList, studyMeeting, attend where studyMemberList.s_index = studyMeeting.s_index and a_m_index = m_index and a_mt_id = ?";
	public static final String QUERY_UPDATE = "UPDATE attend SET a_attend = ? where a_index = ?";
	
	int memberId;
	String memberName;
	String attend;
	
	public MemberAttendanceBean(int memberId, String memberName, String attend) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.attend = attend;
	}
	
	
	public MemberAttendanceBean() {
	}


	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public String getMemberName() {
		return memberName;
	}
	public String getAttend() {
		return attend;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public void setAttend(String attend) {
		this.attend = attend;
	}
}
