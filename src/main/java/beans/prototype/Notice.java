package beans.prototype;

public class Notice {
	 public static final String QUERY_GET ="SELECT * FROM Notice";
     public static final String QUERY_POST = "insert into member values(member_index.nextval,?,?,?,?,?,?,?,?)";
     public static final String QUERY_PUT = "UPDATE ";
     public static final String QUERY_DELETE = "DELETE ";
     
     private int memberindex;
     private String content;
	public int getMemberindex() {
		return memberindex;
	}
	public void setMemberindex(int memberindex) {
		this.memberindex = memberindex;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public static String getQueryGet() {
		return QUERY_GET;
	}
	public static String getQueryPost() {
		return QUERY_POST;
	}
	public static String getQueryPut() {
		return QUERY_PUT;
	}
	public static String getQueryDelete() {
		return QUERY_DELETE;
	}
     
     
}
