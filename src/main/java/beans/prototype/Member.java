package beans.prototype;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import dao.interfaces.DataGettable;

public class Member implements DataGettable{
	public static final String QUERY_GET = "SELECT DEPTNO, DNAME FROM DEPT";
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
	public ArrayList<Member> onGet(ResultSet rs) throws NamingException, SQLException {
		ArrayList<Member> members = new ArrayList<>(); 
		while(rs.next()) {
			Member member = new Member();
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

