package beans.study;


public class StudyListSelect {


	
	//내가 참여한 디비숫자를 알려준다.
	public static final String QUERY_GET2 = "select count(rnum) as count from( " 
			+ " select rownum as rnum, s_index,s_name,s_maxmember,progress "
			+ " from( " 
			+ " select rownum as rnum, s.s_index, s.s_name , s.s_maxmember, nvl(to_number(greatest(sysdate - s.s_start,0))/decode(to_number(s.s_end - s.s_start),0,null,to_number(s.s_end - s.s_start)),0) * 100 progress from study s, studymember sm " 
			+ "   where s.s_index = sm.sm_s_index and sm.sm_m_index = ? order by s_start desc " 
			+ " )where progress < 100 ) " ; 

	
	/*"select count(sl_s_index) as count from studyList where sl_m_index = ? ";*/
	
	
	// 전체 목록 가져오기 페이징 처리 
	public static final String QUERY_GET3 =    "select * from( "
			+ " select s_start,s_end, rownum as rnum, s_index,s_name,s_maxmember,progress "
			+ " from( "
			+ " select s.s_start,s.s_end,rownum as rnum, s.s_index, s.s_name ,s.s_maxmember, nvl(to_number(greatest(sysdate - s.s_start,0))/decode(to_number(s.s_end - s.s_start),0,null,to_number(s.s_end - s.s_start)),0) * 100 progress from study s, studymember sm "
			+ "   where s.s_index = sm.sm_s_index and sm.sm_m_index = ? order by s_start desc " 
			+ " )where progress < 100) "
			+ " where rnum >= ? and rnum <= ? " ;
	
	
	// 몇일 남았는지 표시
	public static final String QUERY_GET4 = "select * from( "
			+ " select rownum as rnum, s_index, dday, progress "
			+ " from( "
			+ " select s_index, greatest((greatest((s_end - s_start),0)) - (greatest(sysdate - s_start,0)),0) as dday,nvl(to_number(greatest(sysdate - s.s_start,0))/decode(to_number(s.s_end - s.s_start),0,null,to_number(s.s_end - s.s_start)),0) * 100 progress " 
			+ " from study s , studymember sm " 
			+ " where sm.sm_s_index = s.s_index and sm.sm_m_index = ? order by s_start desc ) where progress < 100 ) "
			+ " where rnum >= ? and rnum <= ? ";

	public static final String QUERY_GET5 = "select m_name from study s , member m "
			+ "where m.m_index = s.s_m_index where s.m_index ";
			 

	
	private String start;
	private String end; 
	private int now; 
	private int dday;
	private int count;
	private int progress;
	private String s_name;
	private int s_maxmember;
	private int s_m_index;
	
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getS_maxmember() {
		return s_maxmember;
	}
	public void setS_maxmember(int s_maxmember) {
		this.s_maxmember = s_maxmember;
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
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
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
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public int getS_m_index() {
		return s_m_index;
	}
	public void setS_m_index(int s_m_index) {
		this.s_m_index = s_m_index;
	}
	
	

	
}
