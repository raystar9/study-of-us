package beans.study.each.board;

import java.util.Date;

public class BoardList {

	public static final String QUERY_GET = "SELECT";		//board_list_form.jsp에서 데이터 가져올 때 쿼리
	public static final String QUERY_GET_COUNT = "SELECT";	//board_list_form.jsp에서 게시물 수 가져올 때 쿼리

	private int index; 		// 게시글 번호
	private String title; 	// 게시글 제목
	private String name; 	// 게시글 작성자
	private Date date; 		// 게시글 작성일
	private int count; 		// 게시글 개수

	
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

}
