package beans;

import java.util.Date;

public class Cash_View_Register {
	
	public static final String QUERY_GET = "SELECT";
	public static final String QUERY_PUT = "UPDATE";
	public static final String QUERY_DELETE = "DELETE ";

	private String title; 		 // 회비게시글 제목
	private Date date; 		 // 회비게시글 날짜
	private int fee; 			 // 스터디원들이 낸 회비
	private String note; 		 // 스터디원들의 비고
	private String expense; 	 // 회비 사용 내역
	private int expenseFee; 	 // 회비 사용 금액
	private int totalFee; 		 // 스터디원들이 낸 회비 총액
	private int totalExpenseFee; // 스터디원들이 사용한 지출 총액
	private int total; 			 // 누적된 총액

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public int getExpenseFee() {
		return expenseFee;
	}

	public void setExpenseFee(int expenseFee) {
		this.expenseFee = expenseFee;
	}

	public int getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(int totalFee) {
		this.totalFee = totalFee;
	}

	public int getTotalExpenseFee() {
		return totalExpenseFee;
	}

	public void setTotalExpenseFee(int totalExpenseFee) {
		this.totalExpenseFee = totalExpenseFee;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
