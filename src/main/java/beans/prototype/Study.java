package beans.prototype;

import java.sql.Date;

public class Study{
	
	public static final String QUERY_GET = "SELECT * FROM study "; 
	public static final String QUERY_GET2 = "select * from study where s_place LIKE ? and s_name LIKE ? ";
	public static final String QUERY_GET3 = "select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where s_place LIKE ? and s_name LIKE ? and category.C_SUB LIKE ? ";
	public static final String QUERY_GET4 = "SELECT * FROM study where s_index = ? ";
	public static final String QUERY_GET5 = "select max(s_index) s_index from study";
	public static final String QUERY_POST = "INSERT INTO study VALUES(study_index.nextval, ?,?,?,?,?,?,?,?,?,?,?)";
	public static final String QUERY_PUT = "UPDATE ";
	public static final String QUERY_DELETE = "DELETE ";
	
	
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
	public int getMt_index() {
		return mt_index;
	}
	public void setMt_index(int mt_index) {
		this.mt_index = mt_index;
	}
	
	
	
	

	
	


	
/*	public enum ColumnName{
		INDEX("DEPTNO"), ID("DNAME");

		ColumnName(String str) {
			_str = str;
		}
		
		private String _str;
		
		@Override
		public String toString() {
			return _str;
		}
		
		public static String[] getNames() {
			String[] strings = {INDEX.toString(), ID.toString()};
			return strings;
		}
	}*/
}