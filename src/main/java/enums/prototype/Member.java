package enums.prototype;

public enum Member implements DataAccessable{
	INDEX("index", "DEPTNO"), ID("id", "DNAME");

	Member(String key, String columnName) {
		_key = key;
		_columnName = columnName;
	}
	private static final String _queryString = "SELECT DEPTNO, DNAME FROM DEPT";
	private String _key;
	private String _columnName;
	private static final int SIZE = Member.values().length;
	
	@Override
	public String toString() {
		return _key;
	}
	@Override
	public String getColumnName() {
		return _columnName;
	}
	public static String getQueryString() {
		return _queryString;
	}
	public static int getSize() {
		return SIZE;
	}
}
