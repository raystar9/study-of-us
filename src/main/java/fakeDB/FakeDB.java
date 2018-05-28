package fakeDB;

import java.sql.Date;
import java.util.ArrayList;

import beans.prototype.Member;
import beans.prototype.Study;
import beans.study.StudyListCount;

public class FakeDB {
	private static FakeDB instance = new FakeDB();
	ArrayList<Member> members = new ArrayList<>();
	ArrayList<Study> studies1 = new ArrayList<>();
	ArrayList<StudyListCount> studies = new ArrayList<>();
	private FakeDB() {
		initMember();
		initStudy();
	}
	
	public static FakeDB getInstance() {
		return instance;
	}
	
	private void initMember() {
		Member member = new Member();
		member.setName("소문혁");
		member.setIndex(1);
		members.add(member);
		Member member2 = new Member();
		member2.setName("구명회");
		member2.setIndex(2);
		members.add(member2);
		Member member3 = new Member();
		member3.setName("이다혜");
		member3.setIndex(3);
		members.add(member3);
	}
	
	private void initStudy() {
		StudyListCount study = new StudyListCount();
		study.setName("자바스터디");
		study.setGoal("자바마스터");
		study.setTerm(new Date(0));
		
		StudyListCount study2 = new StudyListCount();
		study2.setName("자바스터디");
		study2.setGoal("자바마스터");
		study2.setTerm(new Date(0));
		
		StudyListCount study3 = new StudyListCount();
		study3.setName("자바스터디");
		study3.setGoal("자바마스터");
		study3.setTerm(new Date(0));
		
		StudyListCount study4 = new StudyListCount();
		study4.setName("자바스터디");
		study4.setGoal("자바마스터");
		study4.setTerm(new Date(0));
		
		StudyListCount study5 = new StudyListCount();
		study5.setName("자바스터디");
		study5.setGoal("자바마스터");
		study5.setTerm(new Date(0));
		
		StudyListCount study6 = new StudyListCount();
		study6.setName("자바스터디");
		study6.setGoal("자바마스터");
		study6.setTerm(new Date(0));
		
		studies.add(study);
		studies.add(study2);
		studies.add(study3);
		studies.add(study4);
		studies.add(study5);
		studies.add(study6);
		
	}
	
	public ArrayList<Member> getMembers() {
		return members;
	}
	
	public ArrayList<StudyListCount> getStudies() {
		return studies;
	}
	
	public void postMember(Member member) {
		members.add(member);
	}
	
	public void postStudy(StudyListCount study) {
		studies.add(study);
	}
}
