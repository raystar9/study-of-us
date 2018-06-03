package beansNew;

public class Category {
	String group;
	String subGroup;
	
	public Category() {
	}
	
	public Category(String group, String subGroup) {
		this.group = group;
		this.subGroup = subGroup;
	}

	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getSubGroup() {
		return subGroup;
	}
	public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}
	
}
