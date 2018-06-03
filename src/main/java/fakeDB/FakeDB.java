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
	private ArrayList<FeeSpend> feeSpends = new ArrayList<>();
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
			member.setTel("010-000-0000");
			members.add(member);
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
			study.setCategory(categories.get(i % 6));
			study.setDayOfWeek("금");
			study.setEffects("최고가 되자.");
			study.setEndDate(DateConverter.convertDate("2018-05-03"));
			study.setExplain("어서오세요!");
			study.setLeader(members.get(i));
			study.setMaterial("준비물 없음");
			study.setMaxMember(6);
			study.setMembers(new ArrayList<>());
			study.setName("스터디" + i);
			study.setPlace("서울");
			study.setStartDate(DateConverter.convertDate("2018-04-07"));
			study.setTime("7시");
			ArrayList<Member> ms = new ArrayList<>();
			for(int j = 0; j < 3; j++) {
				ms.add(members.get(i + j));
			}
			study.setMembers(ms);
			studies.add(study);
		}
	}


	private void initMeetings() {
		for(Study study : studies) {
			for(int i = 0; i < 3; i++) {
				Meeting meeting = new Meeting();
				meeting.setStudy(study);
				meeting.setDate(DateConverter.convertDate("2018-06-0" + (i+5)));
				meeting.setExpectedFee(10000);
				meeting.setPlace("종각역");
				meeting.setComment("꼭 오세요!");
				meetings.add(meeting);
			}
		}
	}

	private void initFeeSpends() {
		for(Meeting meeting : meetings) {
			feeSpends.add(new FeeSpend(meeting, "장소대여료", 30000));
			feeSpends.add(new FeeSpend(meeting, "간식비", 10000));
		}
	}

	private void initFeeCollects() {
		for(Meeting meeting : meetings) {
			feeCollects.add(new FeeCollect(meeting, meeting.getStudy().getLeader(), 10000, "회비"));
			feeCollects.add(new FeeCollect(meeting, meeting.getStudy().getMembers().get(1), 8000, "회비"));
			feeCollects.add(new FeeCollect(meeting, meeting.getStudy().getMembers().get(2), 8000, "회비"));
		}
		
	}

	private void initBoards() {
		for(Study study : studies) {
			boards.add(new Board(1, study, study.getLeader(), "글제목임",
					DateConverter.convertDate("2018-06-04"), "글내용임", "파일명임"));
			boards.add(new Board(2, study, study.getLeader(), "글제목임",
					DateConverter.convertDate("2018-06-04"), "글내용임", "파일명임"));
			boards.add(new Board(3, study, study.getLeader(), "글제목임",
					DateConverter.convertDate("2018-06-04"), "글내용임", "파일명임"));
		}
		
	}

	private void initAttends() {
		for(Meeting meeting : meetings) {
			attends.add(new Attend(meeting, meeting.getStudy().getMembers().get(0), "a"));
			attends.add(new Attend(meeting, meeting.getStudy().getMembers().get(1), "na"));
			attends.add(new Attend(meeting, meeting.getStudy().getMembers().get(2), "a"));
		}
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
