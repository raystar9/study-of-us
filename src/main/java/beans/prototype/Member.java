package beans.prototype;

/**
 * 
 * @author raystar
 *
 */
/*
 * Member 테이블과 1:1 매칭되는 자바빈입니다.
 * 만일 GROUP BY, WHERE절등 조건이 추가되야 한다면 새로운 자바 빈을 생성해야합니다.
 */
public class Member{
	/*
	 * prototype패키지의 bean들의 쿼리문은 CRUD명령이 모두 포함됩니다. 하지만 일반적인 bean들은 get과 put, 혹은 둘중 하나의 쿼리문만이 존재합니다.
	 */
	 public static final String QUERY_GET ="SELECT * FROM MEMBER";
     public static final String QUERY_POST = "insert into member values(member_index.nextval,?,?,?,?,?,?,?,?)";
     public static final String QUERY_PUT = "UPDATE ";
     public static final String QUERY_DELETE = "DELETE ";
     
     private int index;
     private String id;
     private String name;
     private String password;
     private String email;
     private int tel;
     private String address;
     private String gender;
     private String introduce;
     
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
     
     
}
