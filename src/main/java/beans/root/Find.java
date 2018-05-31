package beans.root;

public class Find {
	public static final String QUERY_GET="select M_name,M_email from member where M_name = ? ";
	public static final String QUERY_GET2="select M_name from member where M_name = ? ";
	public static final String QUERY_GET3 = "select M_INDEX from member where M_name = ? ";
	private String name;
	private String email;
	private int index;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}
