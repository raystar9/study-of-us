package beansNew;

public class FeeSpend {
	Meeting meeting;
	String comment;
	int expense;
	
	public FeeSpend() {
	}
	public FeeSpend(Meeting meeting, String comment, int expense) {
		this.meeting = meeting;
		this.comment = comment;
		this.expense = expense;
	}
	public Meeting getMeeting() {
		return meeting;
	}
	public void setMeeting(Meeting meeting) {
		this.meeting = meeting;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getExpense() {
		return expense;
	}
	public void setExpense(int expense) {
		this.expense = expense;
	}
	
}
