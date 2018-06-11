package beans.study.each.board;

import java.sql.Date;

public class CommentBean {
	
	public static final String QUERY_GET = "select C_INDEX, B_NO, M_NAME, C_DATE, C_CONTENT from Comments c, Member m, Board b where b.B_S_INDEX = ? and c.C_B_NO = B_NO and c.C_B_NO = ? and c.C_M_INDEX = m.M_INDEX";
	public static final String QUERY_GET_COUNT = "SELECT COUNT(*) FROM COMMENTS WHERE C_B_NO = ?";
	public static final String QUERY_PUT = "UPDATE COMMENTS SET C_CONTENT=? WHERE C_INDEX=? AND C_B_NO=?";		
	public static final String QUERY_DELETE = "delete from COMMENTS where C_B_NO = ? AND C_INDEX = ?";	
	public static final String QUERY_POST = "insert into COMMENTS values(comments_index.nextval,?,?,sysdate,?)";		
	
	private String name;
	private String date;
	private String content;
	private int cno;
	private int bno;
	private int personIndex;
	
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
	public int getPersonIndex() {
		return personIndex;
	}
	public void setPersonIndex(int personIndex) {
		this.personIndex = personIndex;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
