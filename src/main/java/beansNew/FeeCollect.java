package beansNew;

public class FeeCollect {
	Meeting meeting;
	Member member;
	int fee;
	String note;
	
	public FeeCollect() {
	}
	public FeeCollect(Meeting meeting, Member member, int fee, String note) {
		this.meeting = meeting;
		this.member = member;
		this.fee = fee;
		this.note = note;
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
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	
}
