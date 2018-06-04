package beans.root;

public class Find {
	public static final String QUERY_GET="select M_id,M_name from member where M_name = ? ";
	public static final String QUERY_GET2="select M_id,M_email from member where M_email = ? ";
	private String id;
	private String name;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	
	
}
