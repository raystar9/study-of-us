package beans.prototype;

public class Interesting {
	
	 public static final String QUERY_GET ="SELECT * FROM Interesting";
     public static final String QUERY_POST = "insert into member values(member_index.nextval,?,?,?,?,?,?,?,?)";
     public static final String QUERY_PUT = "UPDATE ";
     public static final String QUERY_DELETE = "DELETE ";
     
     int memberIndex;
     int categoryId;
	public int getMemberIndex() {
		return memberIndex;
	}
	public void setMemberIndex(int memberIndex) {
		this.memberIndex = memberIndex;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

