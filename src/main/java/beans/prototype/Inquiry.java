package beans.prototype;

public class Inquiry {
	//게시판 테이블
	public static final String QUERY_GET = "select * from (select rownum rnum,i_subject,i_date, m_id "
			   + " from (select m.m_id,rownum rnum, ib.i_subject, ib.i_date "
		       + " from inquiryboard ib, member m where m.m_index = ib.i_m_index and ib.i_m_index = ?"
		       + " order by ib.i_index desc)) "
		       + " where rnum >= ? and rnum <= ? "
		       + " order by rownum desc ";
	
	public static final String QUERY_COUNT = "select count(*) count from inquiryBoard where i_m_index = ? ";

	public static final String QUERY_POST = "";
	
	
	private int rnum;
	private String m_id;
	private int index;
	private int m_index;
	private String subject;
	private String file;
	private String date;
	private int count;
	
	
	
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
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
