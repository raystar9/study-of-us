package beans.prototype;

public class StudyList {

	 public static final String QUERY_GET ="SELECT * FROM StudyList";
	 
	 
	 		
     public static final String QUERY_POST = "insert into member values(member_index.nextval,?,?,?,?,?,?,?,?)";
     public static final String QUERY_PUT = "UPDATE ";
     public static final String QUERY_DELETE = "DELETE ";
     
     
     
     private int studyindex;
     private int memberindex;
     
     
	public int getStudyindex() {
		return studyindex;
	}
	public void setStudyindex(int studyindex) {
		this.studyindex = studyindex;
	}
	public int getMemberindex() {
		return memberindex;
	}
	public void setMemberindex(int memberindex) {
		this.memberindex = memberindex;
	}
	
	
     
}
