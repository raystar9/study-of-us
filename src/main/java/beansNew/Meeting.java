package beansNew;

import java.sql.Date;

public class Meeting {
	public static final String QUERY_GET = "SELECT mt_place, mt_date, mt_expectedfee, mt_comment FROM meetingview WHERE S_NAME = ? AND mt_id = ?";
	public static final String QUERY_POST = "INSERT INTO meeting(mt_id, mt_place, mt_date, mt_expectedfee, mt_comment) VALUES(meeting_index.nextval, ?, ?, ?, ?)";
	
	int meetingId;
	int studyId;
	String place;
	Date date;
	int expectedFee;
	String comment;
	
	public Meeting() {
	}
	public Meeting(int studyId, String place, Date date, int expectedFee) {
		this.studyId = studyId;
		this.place = place;
		this.date = date;
		this.expectedFee = expectedFee;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
