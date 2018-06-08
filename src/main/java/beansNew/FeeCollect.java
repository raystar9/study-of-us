package beansNew;

public class FeeCollect {
	
	public static final String QUERY_POST = "INSERT INTO FeeMember(FM_ID, FM_M_INDEX, FM_MT_ID, FM_FEE, FM_NOTE) values(feemember_id.nextval, ?, ?, ?, ?)";
	
	int feeCollectId;
	int meetingId;
	int memberId;
	int fee;
	String note;
	
	public FeeCollect() {
	}


	public FeeCollect(int feeCollectId, int meetingId, int memberId, int fee, String note) {
		this.feeCollectId = feeCollectId;
		this.meetingId = meetingId;
		this.memberId = memberId;
		this.fee = fee;
		this.note = note;
	}


	public int getFeeCollectId() {
		return feeCollectId;
	}

	public void setFeeCollectId(int feeCollectId) {
		this.feeCollectId = feeCollectId;
	}

	public int getMeetingId() {
		return meetingId;
	}

	public int getMemberId() {
		return memberId;
	}

	public int getFee() {
		return fee;
	}

	public String getNote() {
		return note;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
