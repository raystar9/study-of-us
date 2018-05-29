/*inform_form.jsp (스터디 정보보기 페이지) / setup_form.jsp (스터디 설정 페이지)에서 사용하는 Bean*/

package beans.study.each;


public class InformSetup {
	
	public static final String QUERY_GET = "SELECT S_INDEX, S_CATEGORY, S_PLOPIENUM, S_NAME, S_PLACE, S_time, S_START, S_END, S_DAY, S_explain, S_prepared, S_effective FROM STUDY";
	public static final String QUERY_PUT = "UPDATE STUDY SET S_CATEGORY=?, S_PLOPIENUM=?, S_NAME=?, S_PLACE=?, S_TIME=?, S_START=?, S_END=?, S_DAY=?, S_EXPLAIN=?, S_PREPARED=?, S_EFFECTIVE=?"; 
	
	private int index;			//스터디 번호
	private String category;	//카테고리
	private String peopleNum;	//스터디 모집인원
	private String name;		//스터디 명
	private String place;		//스터디 장소
	private String activityTime;	//스터디 활동시간
	private String startDate;		//스터디 시작날짜
	private	String endDate;		//스터디 종료날짜
	private String day;			//스터디 활동요일
	private String explain;		//스터디 개요
	private String prepared;	//주요 교재 및 준비물
	private	String effective;	//기대효과 및 활동분야
	
	
	
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public static String getQueryGet() {
		return QUERY_GET;
	}
	public static String getQueryPut() {
		return QUERY_PUT;
	}
	
	
	

}
