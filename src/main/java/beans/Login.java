package beans;

public class Login {

	
	
	
	public static final String QUERY_GET="select M_id,M_password where id = ? ";
	private String id;
	private String password;
	
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
}
