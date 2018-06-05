package beans.study.each.attendacne;

public class MemberAttendanceBean {
	String memberName;
	String attend;
	
	public MemberAttendanceBean(String memberName, String attend) {
		this.memberName = memberName;
		this.attend = attend;
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
