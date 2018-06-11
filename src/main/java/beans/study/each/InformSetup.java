/*inform_form.jsp (스터디 정보보기 페이지) / setup_form.jsp (스터디 설정 페이지)에서 사용하는 Bean*/

package beans.study.each;

import java.sql.Date;

public class InformSetup {
	
	public static final String QUERY_GET = "select S_NAME,C_GROUP, C_SUBGROUP, S_START, S_END, S_MAXMEMBER, S_TIME, S_DAY,  S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE from Study s, Category c where s.S_C_ID = c.C_ID and s.S_INDEX = ?";
	public static final String QUERY_GET_CATEGORY1 = "select distinct C_GROUP from category";
	public static final String QUERY_GET_CATEGORY1_COUNT = "select count(*) from (select distinct C_GROUP from category)";
	public static final String QUERY_GET_CATEGORY2 = "select C_SUBGROUP from category where C_GROUP = ?";
	public static final String QUERY_GET_CATEGORY2_COUNT = "select count(*) from category where C_GROUP = ?";
	public static final String QUERY_GET_COUNT = "select count(*) from studymemberlist where S_INDEX = ?";
	public static final String QUERY_PUT = "UPDATE STUDY SET S_C_ID=?, S_MAXMEMBER=?, S_NAME=?, S_PLACE=?, S_TIME=?, S_START=?, S_END=?, S_DAY=?, S_EXPLAIN=?, S_MATERIAL=?, S_EFFECT=? where S_INDEX = ?"; 
	public static final String QUERY_GET_CATEGORY_NUM = "select C_ID from category where C_GROUP = ? AND C_SUBGROUP = ?"; 
	
	
	private int index;				//스터디 번호
	private String name;			//스터디 명
	private String category1;		//카테고리1
	private String category2;		//카테고리2
	private int peopleNum;			//스터디 모집인원
	private String place;			//스터디 장소
	private String activityTime;	//스터디 활동시간
	private String startDate;			//스터디 시작날짜
	private	String endDate;			//스터디 종료날짜
	private String day;				//스터디 활동요일
	private String explain;			//스터디 개요
	private String prepared;		//주요 교재 및 준비물
	private	String effective;		//기대효과 및 활동분야
	
	
	
	public String getActivityTime() {
		return activityTime;
	}
	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getPrepared() {
		return prepared;
	}
	public void setPrepared(String prepared) {
		this.prepared = prepared;
	}
	public String getEffective() {
		return effective;
	}
	public void setEffective(String effective) {
		this.effective = effective;
	}
	public String getCategory1() {
		return category1;
	}
	public void setCategory1(String category1) {
		this.category1 = category1;
	}
	public String getCategory2() {
		return category2;
	}
	public void setCategory2(String category2) {
		this.category2 = category2;
	}

}
