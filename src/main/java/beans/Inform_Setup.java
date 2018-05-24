package beans;

import java.util.Date;

public class Inform_Setup {
	
	public static final String QUERY_GET = "SELECT";	//inform_form.jsp에서 데이터 가져올 때 쿼리
	public static final String QUERY_PUT = "UPDATE";	//setup_form.jsp에서 데이터 수정할 때 쿼리
	
	private int index;			//스터디 번호
	private String name;		//스터디 이름
	private String category;	//스터디 카테고리
	private String place;		//스터디 장소
	private Date activityTime;	//스터디 활동시간
	private int peopleNum;		//스터디 모집인원
	private String goal;		//스터디 목표
	private Date startDate;		//스터디 시작날짜
	private	Date endDate;		//스터디 종료날짜
	private Date day;			//스터디 활동요일
	private String summary;		//스터디 개요
	private String toPrepare;	//주요 교재 및 준비물
	private	String effect;		//기대효과 및 활동분야
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getActivityTime() {
		return activityTime;
	}
	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}
	public int getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getToPrepare() {
		return toPrepare;
	}
	public void setToPrepare(String toPrepare) {
		this.toPrepare = toPrepare;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	
	

}
