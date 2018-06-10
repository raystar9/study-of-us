package beans.prototype;

public class Comment {
	
	
	public static final String QUERY_GET = "select c.comment_content, m.m_id, c.comment_date from comment c , member m "
			+ " where c.comment_m_index = m.m_index and comment_ib_index = ? ";
	
	public static final String QUERY_POST = "insert into comment values(comment_seq.nextval,?,?,?,sysdate)";
	
	
	
	private int c_index;
	private int c_m_index;
	private int c_ib_index;
	private String content;
	private String date;
	
	
	
	public int getC_index() {
		return c_index;
	}
	public void setC_index(int c_index) {
		this.c_index = c_index;
	}
	public int getC_m_index() {
		return c_m_index;
	}
	public void setC_m_index(int c_m_index) {
		this.c_m_index = c_m_index;
	}
	public int getC_ib_index() {
		return c_ib_index;
	}
	public void setC_ib_index(int c_ib_index) {
		this.c_ib_index = c_ib_index;
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
	
	
	
	
	
	
	
	
	
	
}
