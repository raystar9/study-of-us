package beansNew;

public class MemberCategory {
	int memberId;
	int categoryId;
	
	public MemberCategory(int memberId, int categoryId) {
		this.memberId = memberId;
		this.categoryId = categoryId;
	}
	public int getMemberId() {
		return memberId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
