package beans;
import java.sql.Date;


public class StudySearch {
	public static final String QUERY_GET = "select * from study where S_NAME LIKE ?";
	
	private int index;
	private String name;
	private String c_id;
	private String place;
	private Date time;
	private int ploplenum;
	private String goal;
	private Date term;
	
	
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
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getPloplenum() {
		return ploplenum;
	}
	public void setPloplenum(int ploplenum) {
		this.ploplenum = ploplenum;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public Date getTerm() {
		return term;
	}
	public void setTerm(Date term) {
		this.term = term;
	}
	public static String getQueryGet() {
		return QUERY_GET;
	}
}

