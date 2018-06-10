package beans.prototype;

public class StudyList {

	 public static final String QUERY_GET ="SELECT * FROM studyMember";
	 public static final String QUERY_GET2 ="SELECT * FROM studyMember where SM_S_INDEX = ? and SM_M_INDEX = ? ";

	 
	 //이거살려야함 -동완
     public static final String QUERY_POST = "insert into studyMember values(?,?)";

     public static final String QUERY_POST2 = "insert into Message (S_INDEX, M_INDEX) values(?,?)";
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
