package beans.prototype;

import java.util.Date;

public class Meeting {
	public static final String QUERY_GET = "";
	public static final String QUERY_POST = "";
	
	private String location;
	private Date date;
	private int fee;
	private String comment;
	
	public String getLocation() {
		return location;
	}
	public Date getDate() {
		return date;
	}
	public int getFee() {
		return fee;
	}
	public String getComment() {
		return comment;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
