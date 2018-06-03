/*cash_view_form.jsp (회비 상세보기 페이지) / cash_register_form.jsp (회비 등록 페이지) 에서 사용하는 Bean*/

package beans.study.each.fee;

import java.util.Date;

public class CashViewRegisterBean {
	
	public static final String QUERY_GET = "SELECT";		//cash_view_form.jsp에서 데이터 가져올 때 쿼리
	public static final String QUERY_GET_COUNT = "SELECT";	//cash_view_form.jsp에서 스터디원수를 가져올 때 쿼리
	public static final String QUERY_PUT = "UPDATE";		//cash_view_form.jsp에서 데이터 수정할 때 쿼리	
	public static final String QUERY_DELETE = "DELETE ";	//cash_view_form.jsp에서 데이터 삭제할 때 쿼리
	public static final String QUERY_POST = "INSERT";		//cash_register_form.jsp에서 데이터 삽입할 때 쿼리

	private String title; 		 // 회비게시글 제목
	private Date date; 		 	 // 회비게시글 날짜
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
