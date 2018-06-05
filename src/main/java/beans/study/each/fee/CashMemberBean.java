package beans.study.each.fee;

public class CashMemberBean {
	
	public static final String QUERY_GET = "SELECT ";		
	public static final String QUERY_GET_COUNT = "SELECT";	
	public static final String QUERY_PUT = "UPDATE";		
	public static final String QUERY_DELETE = "DELETE ";	
	public static final String QUERY_POST = "INSERT";		
	
	private int memfee;			//스터디원이 낸 회비
	private String note;		//스터디원의 비고
	private String name;		//스터디원의 이름
	
	
	public int getMemfee() {
		return memfee;
	}
	public void setMemfee(int memfee) {
		this.memfee = memfee;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
