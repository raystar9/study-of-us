package beansNew;

public class FeeSpend {
	int feeSpendId;
	int meetingId;
	String comment;
	int expense;
	
	public FeeSpend() {
	}

	public FeeSpend(int feeSpendId, int meetingId, String comment, int expense) {
		this.feeSpendId = feeSpendId;
		this.meetingId = meetingId;
		this.comment = comment;
		this.expense = expense;
	}


	public int getFeeSpendId() {
		return feeSpendId;
	}

	public void setFeeSpendId(int feeSpendId) {
		this.feeSpendId = feeSpendId;
	}

	public int getMeetingId() {
		return meetingId;
	}

	public String getComment() {
		return comment;
	}

	public int getExpense() {
		return expense;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setExpense(int expense) {
		this.expense = expense;
	}
	
	
}
