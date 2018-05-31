package beans.prototype;

public class Attendance {

	public static final String QUERY_GET = "";
	
	private String id;
	private Meeting meeting;
	private Member member;
	private String attend;
	public String getId() {
		return id;
	}
	public Meeting getMeeting() {
		return meeting;
	}
	public Member getMember() {
		return member;
	}
	public String getAttend() {
		return attend;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public void setAttend(String attend) {
		this.attend = attend;
	}
	
	
}
