package beans;

public class Board_View_Register {

	public static final String QUERY_GET = "SELECT";
	public static final String QUERY_POST = "INSERT";
	public static final String QUERY_PUT = "UPDATE";

	private String title; 	 // 게시글 제목
	private String name; 	 // 게시글 작성자
	private String content;  // 게시글 내용
	private int index; 		 // 게시글 번호

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

	

}
