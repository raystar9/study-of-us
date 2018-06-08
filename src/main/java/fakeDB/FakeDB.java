package fakeDB;

import java.sql.Date;
import java.util.ArrayList;

import beansNew.Attend;
import beansNew.Board;
import beansNew.Category;
import beansNew.FeeCollect;
import beansNew.FeeSpend;
import beansNew.Meeting;
import beansNew.Member;
import beansNew.MemberCategory;
import beansNew.Study;
import beansNew.StudyMember;
import dateConverter.DateConverter;

public class FakeDB {
	private static FakeDB instance = new FakeDB();
	private ArrayList<Attend> attends = new ArrayList<>();
	private ArrayList<Board> boards = new ArrayList<>();
	private ArrayList<Category> categories = new ArrayList<>();
	private ArrayList<FeeCollect> feeCollects = new ArrayList<>();
	private ArrayList<FeeSpend> feeSpends = new ArrayList<>();
	private ArrayList<Meeting> meetings = new ArrayList<>();
	private ArrayList<Member> members = new ArrayList<>();
	private ArrayList<Study> studies = new ArrayList<>();
	private ArrayList<MemberCategory> memberCategories = new ArrayList<>();
	private ArrayList<StudyMember> studyMembers = new ArrayList<>();
	
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
		initMemberCategory();
	}
	
	private void initMembers() {
		for(int i = 0; i < 50; i++) {
			if(i % 3 == 0) {
				Member member = new Member();
				member.setMemberId(i);
				member.setAddress("남양주");
				member.setEmail("a@naver.com");
				member.setGender("m");
				member.setId("user" + i);
				member.setIntroduce("반갑습니다");
				member.setName("구명회");
				member.setPassword("1234");
				member.setTel("010-000-0000");
				members.add(member);
			} else if (i % 3 == 1) {
				Member member = new Member();
				member.setMemberId(i);
				member.setAddress("서울");
				member.setEmail("b@naver.com");
				member.setGender("m");
				member.setId("user" + i);
				member.setIntroduce("반갑습니다");
				member.setName("이다혜");
				member.setPassword("1234");
				member.setTel("010-000-0000");
				members.add(member);
			} else {
				Member member = new Member();
				member.setMemberId(i);
				member.setAddress("서울");
				member.setEmail("c@naver.com");
				member.setGender("m");
				member.setId("user" + i);
				member.setIntroduce("반갑습니다");
				member.setName("소문혁");
				member.setPassword("1234");
				member.setTel("010-000-0000");
				members.add(member);
			}
		}
		
	}

	private void initCategories() {
		categories.add(new Category("프로그래밍", "자바"));
		categories.add(new Category("프로그래밍", "c"));
		categories.add(new Category("프로그래밍", "파이썬"));
		categories.add(new Category("외국어", "영어"));
		categories.add(new Category("외국어", "중국어"));
		categories.add(new Category("외국어", "독일어"));
	}

	private void initStudies() {
		for(int i = 0; i < 30; i++) {
			Study study = new Study();
			study.setStudyId(i);
			study.setCategoryId(i % 6);
			study.setDayOfWeek("금");
			study.setEffects("최고가 되자.");
			study.setEndDate(DateConverter.convertDate("2018-05-03"));
			study.setExplain("어서오세요!");
			study.setLeaderId(i);
			study.setMaterial("준비물 없음");
			study.setMaxMember(6);
			study.setName("스터디" + i);
			study.setPlace("서울");
			study.setStartDate(DateConverter.convertDate("2018-04-07"));
			study.setTime("7시");
			studies.add(study);
		}
	}


	private void initMeetings() {
		for(int j = 0; j < studies.size(); j++) {
			for(int i = 0; i < 3; i++) {
				Meeting meeting = new Meeting();
				meeting.setMeetingId(i);
				meeting.setStudyId(j);
				meeting.setDate(DateConverter.convertDate("2018-06-0" + (i+5)));
				meeting.setExpectedFee(10000);
				meeting.setPlace("종각역");
				meeting.setComment("꼭 오세요!");
				meetings.add(meeting);
			}
		}
	}

	private void initFeeSpends() {
		for(int i = 0; i < meetings.size(); i++) {
			feeSpends.add(new FeeSpend(2*i, i, "장소대여료", 30000));
			feeSpends.add(new FeeSpend((2*i)+1, i, "간식비", 10000));
		}
	}

	private void initFeeCollects() {
		for(int i = 0; i < meetings.size(); i++) {
			feeCollects.add(new FeeCollect(i*3, i, i*3, 10000, "회비"));
			feeCollects.add(new FeeCollect(i*3 +1, i, i*3 +1, 10000, "회비"));
			feeCollects.add(new FeeCollect(i*3 +2, i, i*3 +2, 10000, "회비"));
		}
		
	}

	private void initBoards() {
		for(int j = 0; j < 30; j++) {
			for(int i = 0; i < 5; i++) {
				new Board(30*i + j, i, j, i, "글제목임" + (30*i + j), new Date(new java.util.Date().getTime()), "글내용임", "자료");
			}
		}
		
	}

	private void initAttends() {
		for(int i = 0; i < meetings.size(); i++) {
			attends.add(new Attend(3*i, i%3, i%30, "a"));
			attends.add(new Attend(3*i + 1, i%3, i%30, "na"));
			attends.add(new Attend(3*i + 2, i%3, i%30, "a"));
		}
	}
	
	private void initMemberCategory() {
		for(int i = 0; i < members.size(); i++) {
			memberCategories.add(new MemberCategory(i, i%6));
		}
	}
	
	private void initStudyMember() {
		
	}
	public void addAttend(Attend attend) {
		attends.add(attend);
	}
	public void addBoard(Board board){
		boards.add(board);
	}
	public void addFeeCollect(FeeCollect feeCollect) {
		feeCollects.add(feeCollect);
	}
	public void addFeeSpend(FeeSpend feeSpend) {
		feeSpends.add(feeSpend);
	}
	public void addMeeting(Meeting meeting) {
		meetings.add(meeting);
	}
	public void addMember(Member member) {
		members.add(member);
	}
	public void addStudy(Study study) {
		studies.add(study);
	}
	public ArrayList<Attend> getAttends() {
		return attends;
	}

	public ArrayList<Board> getBoards() {
		return boards;
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

	public ArrayList<FeeCollect> getFeeCollects() {
		return feeCollects;
	}

	public ArrayList<FeeSpend> getFeesSpends() {
		return feeSpends;
	}

	public ArrayList<Meeting> getMeetings() {
		return meetings;
	}

	public ArrayList<Member> getMembers() {
		return members;
	}

	public ArrayList<Study> getStudies() {
		return studies;
	}
	
	
}
