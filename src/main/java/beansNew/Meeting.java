package beansNew;

import java.sql.Date;

public class Meeting {
	int meetingId;
	int studyId;
	String place;
	Date date;
	int expectedFee;
	String comment;
	
	public Meeting() {
	}
	public Meeting(int studyId, String place, Date date, int expectedFee, String comment) {
		this.studyId = studyId;
		this.place = place;
		this.date = date;
		this.expectedFee = expectedFee;
		this.comment = comment;
	}
	public int getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public int getStudyId() {
		return studyId;
	}

	public String getPlace() {
		return place;
	}

	public Date getDate() {
		return date;
	}

	public int getExpectedFee() {
		return expectedFee;
	}

	public String getComment() {
		return comment;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setExpectedFee(int expectedFee) {
		this.expectedFee = expectedFee;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
