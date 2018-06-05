package beans.study.each.board;

public class CommentBean {
	
	public static final String QUERY_GET = "SELECT * FROM COMMENT2 WHERE C_BNO = ?";
	public static final String QUERY_GET_COUNT = "SELECT COUNT(*) FROM COMMENT2 WHERE C_BNO = ?";
	public static final String QUERY_PUT = "UPDATE COMMENT2 SET C_CONTENT=? WHERE C_CNO=? AND C_BNO=?";		
	public static final String QUERY_DELETE = "DELETE FROM COMMENT2 WHERE C_CNO = ?";	
	public static final String QUERY_POST = "INSERT INTO COMMENT2 VALUES(?,sysdate,?,?,?)";		
	
	private String name;
	private String date;
	private String content;
	private int cno;
	private int bno;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	
}
