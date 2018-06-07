package beans.prototype;

import java.sql.Date;

public class Study{
	
	public static final String QUERY_GET = "SELECT * FROM study"; 
	public static final String QUERY_GET2 = "select * from study where s_place LIKE ? and s_name LIKE ? ";
	public static final String QUERY_GET3 = "select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where s_place LIKE ? and s_name LIKE ? and category.C_SUB LIKE ? ";
	public static final String QUERY_GET4 = "SELECT * FROM study where s_index = ? ";
	public static final String QUERY_GET5 = "select max(s_index) s_index from study";
	public static final String QUERY_POST = "INSERT INTO study (s_index ,s_name, s_c_id, s_m_index, s_start, s_end, s_maxmember, s_day, s_time, s_explain, s_material, s_effect, s_place) "
			+ " VALUES(study_index.nextval, ?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String QUERY_PUT = "UPDATE ";
	public static final String QUERY_DELETE = "DELETE ";
	
	
	private int index;
	private String name;
	private int s_c_id;
	private int s_mt_index;
	private int s_m_index; //스터디 팀장
	private Date start;
	private Date end;
	private int maxmember;
	private String day;
	private String time;
	private String explain;
	private String material; //준비물
	private String effect;
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
	public int getS_c_id() {
		return s_c_id;
	}
	public void setS_c_id(int s_c_id) {
		this.s_c_id = s_c_id;
	}
	public int getS_mt_index() {
		return s_mt_index;
	}
	public void setS_mt_index(int s_mt_index) {
		this.s_mt_index = s_mt_index;
	}
	public int getS_m_index() {
		return s_m_index;
	}
	public void setS_m_index(int s_m_index) {
		this.s_m_index = s_m_index;
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
	public int getMaxmember() {
		return maxmember;
	}
	public void setMaxmember(int maxmember) {
		this.maxmember = maxmember;
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
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
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