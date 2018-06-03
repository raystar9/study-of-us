package fakeDB;

import java.util.ArrayList;

import beansNew.Attend;
import beansNew.Board;
import beansNew.Category;
import beansNew.FeeCollect;
import beansNew.FeeSpend;
import beansNew.Meeting;
import beansNew.Member;
import beansNew.Study;
import dateConverter.DateConverter;

public class FakeDB {
	private static FakeDB instance = new FakeDB();
	private ArrayList<Attend> attends = new ArrayList<>();
	private ArrayList<Board> boards = new ArrayList<>();
	private ArrayList<Category> categories = new ArrayList<>();
	private ArrayList<FeeCollect> feeCollects = new ArrayList<>();
	private ArrayList<FeeSpend> feesSpends = new ArrayList<>();
	private ArrayList<Meeting> meetings = new ArrayList<>();
	private ArrayList<Member> members = new ArrayList<>();
	private ArrayList<Study> studies = new ArrayList<>();
	
	public static FakeDB getInstance() {
		return instance;
	}
	
	private FakeDB() {
		initMembers();
		initCategories();
		initStudies();
		initBoards();
		initMeetings();
		initAttends();
		initFeeCollects();
		initFeeSpends();
	}
	
	private void initMembers() {
		for(int i = 0; i < 50; i++) {
			Member member = new Member();
			member.setAddress("서울");
			member.setEmail("a@naver.com");
			member.setGender("m");
			member.setId("user" + i);
			member.setIntroduce("반갑습니다");
			member.setName("나회원");
			member.setPassword("1234");
			member.setStudies(new ArrayList<Study>());
			member.setTel("0100000000");
		}
		
	}

	private void initStudies() {
		for(int i = 0; i < 30; i++) {
			Study study = new Study();
			study.setCategory(new Category("프로그래밍","자바"));
			study.setDayOfWeek("금");
			study.setEffects("자바왕이 됩니다.");
			study.setEndDate(DateConverter.convertDate("2018-05-03"));
			study.setExplain("어서오세요!");
			study.setMaterial("준비물 없음");
			study.setMaxMember(6);
			study.setMembers(new ArrayList<>());
			study.setName("자바스터디왕");
			study.setPlace("서울");
			study.setStartDate(DateConverter.convertDate("2018-04-07"));
			study.setTime("7시");
		}
	}


	private void initMeetings() {
		// TODO Auto-generated method stub
		
	}

	private void initFeeSpends() {
		// TODO Auto-generated method stub
		
	}

	private void initFeeCollects() {
		// TODO Auto-generated method stub
		
	}

	private void initCategories() {
		// TODO Auto-generated method stub
		
	}

	private void initBoards() {
		// TODO Auto-generated method stub
		
	}

	private void initAttends() {
		// TODO Auto-generated method stub
		
	}
}
