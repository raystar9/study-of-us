package beans.study.each.fee;

public class CashExpenseBean {
	
	public static final String QUERY_GET = "select";
	
	private String content;
	private int expense;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getExpense() {
		return expense;
	}
	public void setExpense(int expense) {
		this.expense = expense;
	}
}
