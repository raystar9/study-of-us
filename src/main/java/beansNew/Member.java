package beansNew;

import java.util.ArrayList;

public class Member {
	String id;
	String password;
	String name;
	String email;
	String tel;
	String address;
	String gender;
	String introduce;
	ArrayList<Study> studies;
	
	
	public Member() {
	}
	public Member(String id, String password, String name, String email, String tel, String address, String gender,
			String introduce, ArrayList<Study> studies) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.tel = tel;
		this.address = address;
		this.gender = gender;
		this.introduce = introduce;
		this.studies = studies;
	}
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
	public ArrayList<Study> getStudies(){
		return studies;
	}
	public void setStudies(ArrayList<Study> studies) {
		this.studies = studies;
	}
	public void addStudy(Study study) {
		studies.add(study);
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
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
