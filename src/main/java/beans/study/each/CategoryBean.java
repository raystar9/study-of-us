package beans.study.each;

public class CategoryBean {
	
	public static final String QUERY_GET = "SELECT C_GROUP, C_SUB FROM CATEGORY";
	public static final String QUERY_PUT = "UPDATE ";
	
	private String category1;	//카테고리 대분류
	private String category2;	//카테고리 소분류
	
	public String getCategory1() {
		return category1;
	}
	public void setCategory1(String category1) {
		this.category1 = category1;
	}
	public String getCategory2() {
		return category2;
	}
	public void setCategory2(String category2) {
		this.category2 = category2;
	}
	
	

}
