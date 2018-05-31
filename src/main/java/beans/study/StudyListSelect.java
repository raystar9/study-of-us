package beans.study;

public class StudyListSelect {
	public static final String QUERY_GET = "select s.s_name,s.s_peoplenum, nvl(to_number(greatest(sysdate - s.s_start,0))/ "
	 		+ "decode(to_number(s.s_end - s.s_start),0,null,to_number(s.s_end - s.s_start)),0) * 100 as progress "
	 		+ "from study s, studyList sl "
	 		+ "where s.s_index = sl.sl_s_index and sl.sl_m_index = ? ";
	
	public static final String QUERY_GET2 = "select count(sl_s_index) as count from studyList where sl_m_index = ? ";
	
	private int count;
	private int progress;
	private String s_name;
	private int s_peoplenum;
	
	
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getS_peoplenum() {
		return s_peoplenum;
	}
	public void setS_peoplenum(int s_peoplenum) {
		this.s_peoplenum = s_peoplenum;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
