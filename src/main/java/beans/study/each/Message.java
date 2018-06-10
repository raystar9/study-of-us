package beans.study.each;

public class Message {
	
	
	public static final String QUERY_GET = "select * from Message where m_s_index = ? ";
	public static final String QUERY_POST = "insert into message values (?,?,?,?)"; 
    public static final String QUERY_DELETE = "delete message where M_S_INDEX = ? and M_M_INDEX = ?";
	public static final String QUERY_GET2 = "SELECT * FROM message where m_s_index = ? and m_m_index = ?";
	
	private int m_s_index;
	private String m_m_id;
	private String m_s_name;
	private int  m_m_index;
	
	
	public int getM_s_index() {
		return m_s_index;
	}
	public void setM_s_index(int m_s_index) {
		this.m_s_index = m_s_index;
	}
	public String getM_m_id() {
		return m_m_id;
	}
	public void setM_m_id(String m_m_id) {
		this.m_m_id = m_m_id;
	}
	public String getM_s_name() {
		return m_s_name;
	}
	public void setM_s_name(String m_s_name) {
		this.m_s_name = m_s_name;
	}
	public int getM_m_index() {
		return m_m_index;
	}
	public void setM_m_index(int m_m_index) {
		this.m_m_index = m_m_index;
	}
	
	

	
}
