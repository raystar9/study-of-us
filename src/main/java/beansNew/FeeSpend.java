package beansNew;

public class FeeSpend {
	public static final String QUERY_POST = "INSERT INTO FeeExpense(FE_INDEX, FE_MT_ID, FE_EXPENSE, FE_NOTE) VALUES (feeexpense_id, ?, ?, ?)";
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
