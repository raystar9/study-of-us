/*board_view_form.jsp (게시글 상세보기 페이지) / board_register_form.jsp (게시글 등록 페이지) 에서 사용하는 Bean*/

package beans.study.each.board;



public class BoardViewRegisterBean {

	public static final String QUERY_GET = "select B_NO, B_TITLE, B_CONTENT, M_NAME, B_DATE, B_FILENAME from studyboardlist where B_NO = ?";			//board_view_form.jsp에서 데이터 가져올 때 쿼리
	public static final String QUERY_PUT = "update BOARD b set B_TITLE=?, B_CONTENT=? where (select S_INDEX from STUDY s where s.S_INDEX = b.B_S_INDEX) = ? AND b.B_NO = ?";	//board_view_form.jsp에서 데이터 수정할 때 쿼리
	public static final String QUERY_DELETE = "delete from BOARD where B_S_INDEX = ? AND B_NO = ?";
	public static final String QUERY_POST = "insert into BOARD values (board_no.nextval, ?, ?, sysdate, ?, ?, ?)";					//board_register_form.jsp에서 데이터 삽입할 때 쿼리

	private int index;	 	 // 게시글 번호
	private String title; 	 // 게시글 제목
	private String name; 	 // 게시글 작성자
	private String content;  // 게시글 내용
	private String date; 	 // 게시글 작성일
	private String filename; // 첨부 파일명

	
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}


}
