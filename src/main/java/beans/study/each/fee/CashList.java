package beans.study.each.fee;

import java.util.Date;

public class CashList {
	
	public static final String QUERY_GET = "SELECT";		//cash_list_form.jsp에서 데이터 가져올 때 쿼리

	private int index; 		// 회비게시글 작성 번호
	private String title; 	// 회비게시글 제목
	private String name; 	// 회비게시글 작성자
	private Date date; 		// 회비게시 작성일
	private int total; 		// 회비 총액

	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
