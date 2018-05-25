package beans.prototype;

public class FeeExpense {
	 public static final String QUERY_GET ="SELECT * FROM FeeExpense";
     public static final String QUERY_POST = "insert into member values(member_index.nextval,?,?,?,?,?,?,?,?)";
     public static final String QUERY_PUT = "UPDATE ";
     public static final String QUERY_DELETE = "DELETE ";
     
     private int id;
     private int feeid;
     private String expense;
     private int expensefee;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFeeid() {
		return feeid;
	}
	public void setFeeid(int feeid) {
		this.feeid = feeid;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public int getExpensefee() {
		return expensefee;
	}
	public void setExpensefee(int expensefee) {
		this.expensefee = expensefee;
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
