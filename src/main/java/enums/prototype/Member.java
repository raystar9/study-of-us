package enums.prototype;

public enum Member implements DataAccessable{
	INDEX("index", "DEPTNO"), ID("id", "DNAME");

	Member(String id, String query) {
		_id = id;
		_query = query;
	}
	private static final String _queryString = "SELECT id,pass FROM member where id = 1";
	private String _id;
	private String _query;
	private static final int SIZE = Member.values().length;
	
	@Override
	public String toString() {
		return _id;
	}
	@Override
	public String getColumnName() {
		return _query;
	}
	public static String getQueryString() {
		return _queryString;
	}
	public static int getSize() {
		return SIZE;
	}
}
