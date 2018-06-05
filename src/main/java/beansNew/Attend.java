package beansNew;

public class Attend {
	int attendId;
	int meetingId;
	int memberId;
	String attend;
	
	public Attend() {
	}

	public Attend(int attendId, int meetingId, int memberId, String attend) {
		this.attendId = attendId;
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
