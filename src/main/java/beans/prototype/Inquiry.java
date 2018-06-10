package beans.prototype;

public class Inquiry {
	//게시판 테이블
	public static final String QUERY_GET = "select * from (select i_index,rownum rnum,i_subject,i_date, m_id "
			   + " from (select ib.i_index,m.m_id,rownum rnum, ib.i_subject, ib.i_date "
		       + " from inquiryboard ib, member m where m.m_index = ib.i_m_index and ib.i_m_index = ?"
		       + " order by ib.i_index desc)) "
		       + " where rnum >= ? and rnum <= ? ";
		       
	
	public static final String QUERY_COUNT = "select count(*) count from inquiryBoard where i_m_index = ? ";
	
	public static final String QUERY_GET2 = "select m.m_id, i.i_subject, i.i_content, i.i_date,i.i_file "
			+ "from inquiryBoard i ,member m "
			+ " where i.i_m_index = m.m_index and i.i_index = ? ";
	

	public static final String QUERY_POST = "insert into inquiryBoard values(inquiry_index.nextval,?,?,?,?,sysdate)";
	
	
	
	private int rnum;			//순서
	private String m_id;		//멤버아디
	private int i_index;		
	private int m_index;
	private String subject;
	private String file;
	private String date;
	private int count;
	private String content;
	
	
	
	
	
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getI_index() {
		return i_index;
	}
	public void setI_index(int i_index) {
		this.i_index = i_index;
	}
	public int getM_index() {
		return m_index;
	}
	public void setM_index(int m_index) {
		this.m_index = m_index;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
	
	
	
	
	

}
