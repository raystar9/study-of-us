package beans.prototype;

import java.sql.Date;

public class StudySetting {
	 public static final String QUERY_GET ="SELECT * FROM StudySetting";
     public static final String QUERY_POST = "insert into member values(member_index.nextval,?,?,?,?,?,?,?,?)";
     public static final String QUERY_PUT = "UPDATE ";
     public static final String QUERY_DELETE = "DELETE ";
     
     private int index;
     private int categoryid;
     private int studyindex;
     private int currentstateindex;
     private int numperson;
     private Date activitytime;
     private Date day;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public int getStudyindex() {
		return studyindex;
	}
	public void setStudyindex(int studyindex) {
		this.studyindex = studyindex;
	}
	public int getCurrentstateindex() {
		return currentstateindex;
	}
	public void setCurrentstateindex(int currentstateindex) {
		this.currentstateindex = currentstateindex;
	}
	public int getNumperson() {
		return numperson;
	}
	public void setNumperson(int numperson) {
		this.numperson = numperson;
	}
	public Date getActivitytime() {
		return activitytime;
	}
	public void setActivitytime(Date activitytime) {
		this.activitytime = activitytime;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public static String getQueryGet() {
		return QUERY_GET;
	}
	public static String getQueryPost() {
		return QUERY_POST;
	}
	public static String getQueryPut() {
		return QUERY_PUT;
	}
	public static String getQueryDelete() {
		return QUERY_DELETE;
	}
     
     
}
