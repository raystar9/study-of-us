package beans.study.each.fee;


public class CashListBean {
	
	public static final String QUERY_GET = "SELECT * from ";		
	public static final String QUERY_GET_COUNT = "SELECT";		

	private int index; 		// 회비게시글 작성 번호
	private String title; 	// 회비게시글 제목
	private String name; 	// 회비게시글 작성자
	private String date; 	// 회비게시 작성일
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
