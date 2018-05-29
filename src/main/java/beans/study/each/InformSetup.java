/*inform_form.jsp (스터디 정보보기 페이지) / setup_form.jsp (스터디 설정 페이지)에서 사용하는 Bean*/

package beans.study.each;

import java.util.Date;

public class InformSetup {
	
	public static final String QUERY_GET = "SELECT * ";	//inform_form.jsp에서 데이터 가져올 때 쿼리
	public static final String QUERY_PUT = "UPDATE";	//setup_form.jsp에서 데이터 수정할 때 쿼리
	
	private int index;			//스터디 번호
	private int cateforyNum;	//카테고리 외래키
	private String start;		//스터디 시작 날짜
	private String end;			//스터디 끝 날짜
	private String peopleNum;	//스터디 참여인원
	private String name;		//스터디 명
	private String category;	//스터디 카테고리
	private String place;		//스터디 장소
	private int activityTime;	//스터디 활동시간
	private int maxNum;			//스터디 모집인원
	private String goal;		//스터디 목표
	private Date startDate;		//스터디 시작날짜
	private	Date endDate;		//스터디 종료날짜
	private Date day;			//스터디 활동요일
	private String explain;		//스터디 개요
	private String prepared;	//주요 교재 및 준비물
	private	String effective;		//기대효과 및 활동분야
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getCateforyNum() {
		return cateforyNum;
	}
	public void setCateforyNum(int cateforyNum) {
		this.cateforyNum = cateforyNum;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(String peopleNum) {
		this.peopleNum = peopleNum;
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
	public int getActivityTime() {
		return activityTime;
	}
	public void setActivityTime(int activityTime) {
		this.activityTime = activityTime;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
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
	public static String getQueryGet() {
		return QUERY_GET;
	}
	public static String getQueryPut() {
		return QUERY_PUT;
	}
	
	
	

}
