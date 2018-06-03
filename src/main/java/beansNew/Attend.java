package beansNew;

public class Attend {
	Meeting meeting;
	Member member;
	String attend;
	
	public Attend() {
	}
	
	public Attend(Meeting meeting, Member member, String attend) {
		this.meeting = meeting;
		this.member = member;
		this.attend = attend;
	}

	public Meeting getMeeting() {
		return meeting;
	}
	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getAttend() {
		return attend;
	}
	public void setAttend(String attend) {
		this.attend = attend;
	}
	
	
}
