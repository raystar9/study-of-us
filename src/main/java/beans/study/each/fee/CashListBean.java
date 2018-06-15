package beans.study.each.fee;


public class CashListBean {
	
	public static final String QUERY_GET = "SELECT mt_id, mt_date FROM(SELECT rownum as post, mt_id, mt_date FROM studyMeeting WHERE s_name = ? order by mt_date desc) WHERE post >= ? AND post <= ?";		
	public static final String QUERY_GET_COUNT = "SELECT count(*) FROM studyMeeting WHERE s_name = ?";		

	private int meetingIndex;		// 회비게시글 작성 번호
	private String date; 	// 회비게시 작성일
	
	public int getMeetingIndex() {
		return meetingIndex;
	}
	
	public void setMeetingIndex(int meetingIndex) {
		this.meetingIndex = meetingIndex;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
