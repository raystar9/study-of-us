package beans.prototype;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.exceptions.DatabaseConnectException;
import dao.interfaces.DataGettable;

public class Study implements DataGettable{
	public static final String QUERY_GET = "SELECT * FROM Study";
	public static final String QUERY_POST = "INSERT INTO DEPTNO VALUES(seq.nextval, ?, ?)";
	public static final String QUERY_PUT = "UPDATE ";
	public static final String QUERY_DELETE = "DELETE ";
	
	private int index;
	private String id;
	
	public int getIndex() {
		return index;
	}

	public String getId() {
		return id;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public ArrayList<Study> onGetResult(ResultSet rs) throws DatabaseConnectException, SQLException {
		ArrayList<Study> members = new ArrayList<>(); 
		while(rs.next()) {
			Study member = new Study();
			member.setIndex(rs.getInt(1));
			member.setId(rs.getString(2));
			members.add(member);
		}
		return members;
	}

	
/*	public enum ColumnName{
		INDEX("DEPTNO"), ID("DNAME");

		ColumnName(String str) {
			_str = str;
		}
		
		private String _str;
		
		@Override
		public String toString() {
			return _str;
		}
		
		public static String[] getNames() {
			String[] strings = {INDEX.toString(), ID.toString()};
			return strings;
		}
	}*/
}

