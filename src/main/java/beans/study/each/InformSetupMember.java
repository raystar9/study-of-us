/*inform_form.jsp (스터디 정보 보기 페이지) 에서 회원들의 정보 가져올때 사용되는 Bean*/

package beans.study.each;

public class InformSetupMember {
	//해당 스터디를 들어갔을 때 그 스터디 안에있는 회원들의 정보를 가져옴
	public static final String QUERY_GET = "SELECT m_name, m_tel, m_email FROM studyMemberList WHERE s_name = ?"; 
	
	private String name;	//스터디원 이름
	private int phone;		//스터디원 전화번호
	private String email;	//스터디원 이메일
	private int personNum;	//해당 스터디원 수
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPersonNum() {
		return personNum;
	}
	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}
	
}
