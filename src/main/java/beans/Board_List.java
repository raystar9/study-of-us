package beans;

import java.util.Date;

public class Board_List {

	public static final String QUERY_GET = "SELECT";
	public static final String QUERY_GET_COUNT = "SELECT";
	public static final String QUERY_PUT = "UPDATE";

	private String title; 	// 게시글 제목
	private String name; 	// 게시글 작성자
	private int index; 		// 게시글 번호
	private Date date; 		// 게시글 작성일
	private String count; 	// 게시글 개수

	
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

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

}
