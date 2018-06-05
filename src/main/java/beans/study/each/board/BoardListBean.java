package beans.study.each.board;


public class BoardListBean {

	public static final String QUERY_GET = "select B_NO, B_TITLE, B_NAME, B_DATE from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b";		//board_list_form.jsp에서 데이터 가져올 때 쿼리
	public static final String QUERY_GET_COUNT = "select count(*) from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b";	//board_list_form.jsp에서 게시물 수 가져올 때 쿼리
	public static final String QUERY_GET_SEARCH_COUNT = "select count(*) from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b) where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = ?) AND ? like '%?%' ORDER BY B_NO desc";	//board_list_form.jsp에서 게시물 수 가져올 때 쿼리

	
	public static final String QUERY_GET2 = "select B_NO, B_TITLE, B_NAME, B_DATE from (SELECT ROWNUM RNUM, B_TITLE, B_NAME, B_DATE, B_S_INDEX, B_NO FROM BOARD b) where B_S_INDEX IN (select S_INDEX from STUDY where S_INDEX = 3) AND RNUM>=1 AND RNUM<=10 AND B_TITLE like '%교재%'  ORDER BY B_NO desc";

	private int index; 		// 게시글 번호
	private String title; 	// 게시글 제목
	private String name; 	// 게시글 작성자
	private String date; 	// 게시글 작성일
	private String filename;// 첨부파일 이름
	private int count; 		// 게시글 개수

	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

}
