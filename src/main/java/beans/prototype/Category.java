package beans.prototype;

public class Category {
	public static final String QUERY_GET = "SELECT "+ ColumnName.ID +", "+ ColumnName.GROUP +", "+ ColumnName.SUB_GROUP +" FROM CATEGORY";
	public static final String QUERY_POST = "INSERT INTO CATEGORY VALUES(seq.nextval, ?, ?)";
	public static final String QUERY_PUT = "UPDATE ";
	public static final String QUERY_DELETE = "DELETE ";
	
	private int id;
	private String group;
	private String subGroup;
	
	public int getId() {
		return id;
	}
	public String getGroup() {
		return group;
	}
	public String getSubGroup() {
		return subGroup;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}
	
	public enum ColumnName{
		ID("C_ID"), GROUP("C_GROUP"), SUB_GROUP("C_SUB");

		ColumnName(String str) {
			_str = str;
		}
		
		private String _str;
		
		@Override
		public String toString() {
			return _str;
		}
		
		public static String[] getNames() {
			String[] strings = {ID.toString(), GROUP.toString(), SUB_GROUP.toString()};
			return strings;
		}
	}
}
