package beans.prototype;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.exceptions.DatabaseConnectException;
import dao.interfaces.DataGettable;

/**
 * 
 * @author raystar
 *
 */
/*
 * Member 테이블과 1:1 매칭되는 자바빈입니다.
 * 만일 GROUP BY, WHERE절등 조건이 추가되야 한다면 새로운 자바 빈을 생성해야합니다.
 */
public class Member implements DataGettable{
	/*
	 * prototype패키지의 bean들의 쿼리문은 CRUD명령이 모두 포함됩니다. 하지만 일반적인 bean들은 get과 put, 혹은 둘중 하나의 쿼리문만이 존재합니다.
	 */
	public static final String QUERY_GET = "SELECT "+ ColumnName.INDEX +", DNAME FROM DEPT";
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
	
	/*
	 * 상수인 QUERY_GET에서 정의한 SELECT문을 실행한 뒤 결과로 반환한 ResultSet을 List로 담는 방법을 기술해 둔 콜백 메서드입니다. 
	 */
	@Override
	public ArrayList<Member> onGetResult(ResultSet rs) throws DatabaseConnectException, SQLException {
		ArrayList<Member> members = new ArrayList<>(); 
		while(rs.next()) {
			Member member = new Member();
			member.setIndex(rs.getInt(1));
			member.setId(rs.getString(2));
			members.add(member);
		}
		return members;
	}

	/*
	 * prototype에만 존재하는 enum입니다. 테이블의 컬럼명을 기술합니다.
	 */
	public enum ColumnName{
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
	}
}

