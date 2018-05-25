package fakeDB;

import java.util.ArrayList;

import beans.prototype.Member;
import beans.prototype.Study;

public class FakeDB {
	FakeDB instance = new FakeDB();
	ArrayList<Member> members = new ArrayList<>();
	ArrayList<Study> studies = new ArrayList<>();
	
	private FakeDB() {
		initMember();
		initStudy();
	}
	
	public FakeDB getInstance() {
		return instance;
	}
	
	private void initMember() {
		Member member = new Member();
		members.add(member);
		members.add(member);
		members.add(member);
		members.add(member);
		members.add(member);
		members.add(member);
		members.add(member);
	}
	
	private void initStudy() {
		Study study = new Study();
		studies.add(study);
	}
	
	public ArrayList<Member> getMembers() {
		return members;
	}
	
	public ArrayList<Study> getStudies() {
		return studies;
	}
	
	public void postMember(Member member) {
		members.add(member);
	}
	
	public void postStudy(Study study) {
		studies.add(study);
	}
}
