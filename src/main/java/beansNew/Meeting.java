package beansNew;

import java.sql.Date;

public class Meeting {
	Study study;
	String place;
	Date date;
	int expectedFee;
	String comment;
	
	public Meeting() {
	}
	public Meeting(Study study, String place, Date date, int expectedFee, String comment) {
		this.study = study;
		this.place = place;
		this.date = date;
		this.expectedFee = expectedFee;
		this.comment = comment;
	}
	public Study getStudy() {
		return study;
	}
	public void setStudy(Study study) {
		this.study = study;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getExpectedFee() {
		return expectedFee;
	}
	public void setExpectedFee(int expectedFee) {
		this.expectedFee = expectedFee;
	}
	public String getComment() {
		return comment;
	}
	
	
	
}
