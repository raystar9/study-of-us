package beans.study.each.fee;


public class CashListBean {
	
	public static final String QUERY_GET = "SELECT * from ";		
	public static final String QUERY_GET_COUNT = "SELECT";		

	private int index; 		// 회비게시글 작성 번호
	private String date; 	// 회비게시 작성일
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
