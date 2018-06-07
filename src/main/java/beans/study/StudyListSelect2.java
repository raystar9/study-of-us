package beans.study;


public class StudyListSelect2 {


	
	//내가 참여한 디비숫자를 알려준다.
	public static final String QUERY_GET2 = "select count(rnum) as count from( " 
			+ " select rownum as rnum, s_index,s_name,s_peoplenum,progress "
			+ " from( " 
			+ " select rownum as rnum, s.s_index, s.s_name ,s.s_peoplenum, nvl(to_number(greatest(sysdate - s.s_start,0))/decode(to_number(s.s_end - s.s_start),0,null,to_number(s.s_end - s.s_start)),0) * 100 progress from study s, studyList sl " 
			+ "   where s.s_index = sl.sl_s_index and sl.sl_m_index = ? order by s_start desc " 
			+ " )where progress >= 100 ) " ; 

	
	/*"select count(sl_s_index) as count from studyList where sl_m_index = ? ";*/
	
	
	// 페이징 처리 
	public static final String QUERY_GET3 =   "select * from( "
			+ " select s_start,s_end, rownum as rnum, s_index,s_name,s_peoplenum,progress "
			+ " from( "
			+ " select s.s_start,s.s_end,rownum as rnum, s.s_index, s.s_name ,s.s_peoplenum, nvl(to_number(greatest(sysdate - s.s_start,0))/decode(to_number(s.s_end - s.s_start),0,null,to_number(s.s_end - s.s_start)),0) * 100 progress from study s, studyList sl "
			+ "   where s.s_index = sl.sl_s_index and sl.sl_m_index = ? order by s_start desc " 
			+ " )where progress >= 100) "
			+ " where rnum >= ? and rnum <= ? " ;
	
	// 몇일 남았는지 표시
	public static final String QUERY_GET4 = "select * from( "
			+ " select rownum as rnum, s_index, dday, progress "
			+ " from( "
			+ " select s_index, greatest((greatest((s_end - s_start),0)) - (greatest(sysdate - s_start,0)),0) as dday,nvl(to_number(greatest(sysdate - s.s_start,0))/decode(to_number(s.s_end - s.s_start),0,null,to_number(s.s_end - s.s_start)),0) * 100 progress " 
			+ " from study s , studylist sl " 
			+ " where sl.sl_s_index = s.s_index and sl.sl_m_index = ? order by s_start desc ) where progress >= 100 ) "
			+ " where rnum >= ? and rnum <= ? ";

			 

	
	private String start;
	private String end;
	private int now; 
	private int dday;
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
	public int getNow() {
		return now;
	}
	public void setNow(int now) {
		this.now = now;
	}
	public int getDday() {
		return dday;
	}
	public void setDday(int dday) {
		this.dday = dday;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	
	

	
}
