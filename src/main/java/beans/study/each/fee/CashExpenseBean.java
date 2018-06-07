package beans.study.each.fee;

public class CashExpenseBean {
	
	public static final String QUERY_GET = "select";
	public static final String QUERY_POST = "INSERT INTO FEEEXPENSE VALUES(FE_INDEX=시퀀스, FE_NT_ID=시퀀스, FE_EXPENSE=?, FE_NOTE=?) WHERE ";
	
	private String content;		//사용 내역 
	private int expense;		//사용 금액
	
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
