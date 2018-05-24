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
     
     private int m_index;
     private String m_id;
     private String m_name;
     private String m_password;
     private String m_email;
     private int m_tel;
     private String m_address;
     private String m_gender;
     private String m_introduce;
     
     public int getM_index() {
        return m_index;
     }
     public void setM_index(int m_index) {
        this.m_index = m_index;
     }
     public String getM_id() {
        return m_id;
     }
     public void setM_id(String m_id) {
        this.m_id = m_id;
     }
     public String getM_name() {
        return m_name;
     }
     public void setM_name(String m_name) {
        this.m_name = m_name;
     }
     public String getM_password() {
        return m_password;
     }
     public void setM_password(String m_password) {
        this.m_password = m_password;
     }
     public String getM_email() {
        return m_email;
     }
     public void setM_email(String m_email) {
        this.m_email = m_email;
     }
     public int getM_tel() {
        return m_tel;
     }
     public void setM_tel(int m_tel) {
        this.m_tel = m_tel;
     }
     public String getM_address() {
        return m_address;
     }
     public void setM_address(String m_address) {
        this.m_address = m_address;
     }
     public String getM_gender() {
        return m_gender;
     }
     public void setM_gender(String m_gender) {
        this.m_gender = m_gender;
     }
     public String getM_introduce() {
        return m_introduce;
     }
     public void setM_introduce(String m_introduce) {
        this.m_introduce = m_introduce;
     }
}
