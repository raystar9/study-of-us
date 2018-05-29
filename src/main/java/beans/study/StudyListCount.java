package beans.study;

import java.util.Date;

public class StudyListCount {
	public static final String QUERY_GET = "select * from (select rownum as rnum, s_index, s_name, s_c_id, s_place, s_time, s_plopienum, s_goal, s_term "
			+ "from ("
			+ "select s_index, s_name, s_c_id, s_place, s_time, s_plopienum, s_goal, s_term "
			+ "from study "
			+ "order by s_index)) "
			+ "where rnum >= ? and rnum <= ?";
	
	public static final String QUERY_GET2 = "select * from (select rownum as rnum, s_index, s_name, s_c_id, s_place, s_time, s_plopienum, s_goal, s_term "
			+ "from ("
			+ "select s_index, s_name, s_c_id, s_place, s_time, s_plopienum, s_goal, s_term "
			+ "from ("
			+ "select * from study where s_place LIKE ? or s_name LIKE ?"
			+ "order by s_index))) "
			+ "where rnum >= ? and rnum <= ?";


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
