package beans;

import java.util.Date;

public class Board_View_Register {

	public static final String QUERY_GET = "SELECT";		//board_view_form.jsp에서 데이터 가져올 때 쿼리
	public static final String QUERY_PUT = "UPDATE";		//board_view_form.jsp에서 데이터 수정할 때 쿼리
	public static final String QUERY_DELETE = "DELETE ";	//board_view_form.jsp에서 데이터 삭제할 때 쿼리
	public static final String QUERY_POST = "INSERT";		//board_register_form.jsp에서 데이터 삽입할 때 쿼리

	private String title; 	 // 게시글 제목
	private String name; 	 // 게시글 작성자
	private String content;  // 게시글 내용
	private int index; 		 // 게시글 번호
	private Date date; 		 // 게시글 작성일

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

	public int getNo() {
		return index;
	}

	public void setNo(int no) {
		this.index = no;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

}
