package beans.study;

import java.util.Date;

public class StudyListCount {
	public static final String QUERY_GET = "select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE "
			+ "from ("
			+ "select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE "
			+ "from study "
			+ "order by s_index)) "
			+ "where rnum >= ? and rnum <= ?";
	
	
	public static final String QUERY_GET2 = "select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE "
			+ "from ("
			+ "select s_index, s_name, s_c_id, S_MT_INDEX, S_START, S_END, S_PLOPIENUM, S_DAY, S_TIME,S_EXPLAIN,S_PREPARED,S_EFFECTIVE ,S_PLACE "
			+ "from ("
			+ "select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where s_place LIKE ? and s_name LIKE ? and category.C_SUB LIKE ? "
			+ "order by s_index))) "
			+ "where rnum >= ? and rnum <= ?";


	private int index;
	private String name;
	private int c_id;
	private int mt_index; 
	private Date start;
	private Date end;
	private int peoplenum;
	private String day;
	private String time;
	private String explain;
	private String prepared;
	private String effective;
	private String place;
	
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
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	public int getMt_index() {
		return mt_index;
	}
	public void setMt_index(int mt_index) {
		this.mt_index = mt_index;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public int getPeoplenum() {
		return peoplenum;
	}
	public void setPeoplenum(int peoplenum) {
		this.peoplenum = peoplenum;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public static String getQueryGet() {
		return QUERY_GET;
	}
	public static String getQueryGet2() {
		return QUERY_GET2;
	}
	
	
	
	
}
