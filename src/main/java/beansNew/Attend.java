package beansNew;

public class Attend {
	//TODO 시퀀스명 변경해야함!
	public static final String QUERY_POST = "INSERT INTO attend(A_INDEX, A_MT_ID, A_M_INDEX, A_ATTEND) VALUES(attend_index.nextval, ?, ?, ?)";
	
	int attendId;
	int meetingId;
	int memberId;
	String attend;
	
	public Attend() {
	}

	public Attend(int meetingId, int memberId, String attend) {
		this.meetingId = meetingId;
		this.memberId = memberId;
		this.attend = attend;
	}


	public int getAttendId() {
		return attendId;
	}

	public int getMeetingId() {
		return meetingId;
	}

	public int getMemberId() {
		return memberId;
	}

	public String getAttend() {
		return attend;
	}

	public void setAttendId(int attendId) {
		this.attendId = attendId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public void setAttend(String attend) {
		this.attend = attend;
	}

}
