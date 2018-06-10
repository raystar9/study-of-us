package beans.study;

import java.sql.Date;

public class StudySearch {
	public static final String QUERY_GET = "select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_M_INDEX , S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE ,C_GROUP, C_SUBGROUP " + 
			"from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID  where S_NAME LIKE ? and S_PLACE LIKE ?  and C_GROUP LIKE ? and C_SUBGROUP LIKE ? and S_DAY LIKE ? and S_TIME LIKE ? order by s_index)   ";
	
	public static final String QUERY_GET7 = "select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_M_INDEX , S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE ,C_GROUP, C_SUBGROUP " 
			+"from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where C_GROUP LIKE ?  order by s_index) where rnum >= ? and rnum <= ?";

	public static final String QUERY_GET2 = "select * from (select rownum as rnum, s_index, s_name, s_c_id, S_MT_INDEX, S_M_INDEX , S_START, S_END, S_MAXMEMBER, S_DAY, S_TIME, S_EXPLAIN, S_MATERIAL, S_EFFECT, S_PLACE ,C_GROUP, C_SUBGROUP " + 
			"from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID  where S_NAME LIKE ? and S_PLACE LIKE ? and C_GROUP LIKE ? and C_SUBGROUP LIKE ? and S_DAY LIKE ? and S_TIME LIKE ? order by s_index) where rnum >= ? and rnum <= ? ";

	public static final String QUERY_GET3 = "select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where s_place LIKE ? and s_name LIKE ? and category.C_SUB LIKE ? ";

	public static final String QUERY_GET4 = "select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where C_GROUP = '프로그래밍' order by S_index desc ";
	public static final String QUERY_GET5 = "select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where C_GROUP = '언어' order by S_index desc ";
	public static final String QUERY_GET6 = "select * from study inner join CATEGORY on STUDY.S_C_ID = CATEGORY.C_ID where C_GROUP = '자격증' order by S_index desc ";
	
	
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
	private String C_GROUP;
	private String C_SUBGROUP;
	
	
	
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
	public String getC_SUBGROUP() {
		return C_SUBGROUP;
	}
	public void setC_SUBGROUP(String c_SUBGROUP) {
		C_SUBGROUP = c_SUBGROUP;
	}
	public String getC_GROUP() {
		return C_GROUP;
	}
	public void setC_GROUP(String c_GROUP) {
		C_GROUP = c_GROUP;
	}
	

}
