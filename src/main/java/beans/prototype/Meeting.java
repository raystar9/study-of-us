package beans.prototype;

import java.sql.Date;
import java.util.ArrayList;

public class Meeting {
	public static final String QUERY_GET = "";
	public static final String QUERY_POST = "";
	
	private int index;
	private ArrayList<Member> members = new ArrayList<>();
	private String location;
	private Date date;
	private int fee;
	private String comment;
	
	public ArrayList<Member> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}
	public int getIndex() {
		return index;
	}
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
	public void setIndex(int index) {
		this.index = index;
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
