package beans.root;


public class Login {
	public static final String QUERY_GET="select M_id,M_password, M_INDEX from member where M_id = ? ";
	public static final String QUERY_GET2="select M_id from member where M_id = ? ";
	public static final String QUERY_GET3 = "select M_INDEX from member where M_ID = ? ";
	private String id;
	private String password;
	private int index;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}



