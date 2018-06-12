/*cash_view_form.jsp (회비 상세보기 페이지) / cash_register_form.jsp (회비 등록 페이지) 에서 사용하는 Bean*/

package beans.study.each.fee;


public class CashViewRegisterBean {
	
	public static final String QUERY_GET = "SELECT";		//cash_view_form.jsp에서 데이터 가져올 때 쿼리
	public static final String QUERY_GET_COUNT = "SELECT";	//cash_view_form.jsp에서 스터디원수를 가져올 때 쿼리
	public static final String QUERY_PUT = "UPDATE";		//cash_view_form.jsp에서 데이터 수정할 때 쿼리	
	public static final String QUERY_DELETE = "DELETE ";	//cash_view_form.jsp에서 데이터 삭제할 때 쿼리
	public static final String QUERY_POST = "INSERT";		//cash_register_form.jsp에서 데이터 삽입할 때 쿼리

	private String date; 		// 회비게시글 날짜
	private int expensetotal;	// 지출 총액
	private int memfeetotal;	// 낸 회비 총액
	private int alltotal; 		// 누적된 총액
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getExpensetotal() {
		return expensetotal;
	}
	public void setExpensetotal(int expensetotal) {
		this.expensetotal = expensetotal;
	}
	public int getMemfeetotal() {
		return memfeetotal;
	}
	public void setMemfeetotal(int memfeetotal) {
		this.memfeetotal = memfeetotal;
	}
	public int getAlltotal() {
		return alltotal;
	}
	public void setAlltotal(int alltotal) {
		this.alltotal = alltotal;
	}


}
