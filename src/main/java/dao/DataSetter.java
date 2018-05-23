package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.exceptions.DatabaseConnectException;
import dao.interfaces.DataSettable;

/**
 * 접근지정자가 default(혹은 package private)입니다. 이는 패키지 밖에서 객체를 생성하는 것을 허용하지 않습니다.
 * @author raystar
 */
abstract class DataSetter extends DataAccessor{ // 명호형이 만든지 확인하고 고고

	public DataSetter(DatabaseAccounts user) throws DatabaseConnectException, SQLException {
		super(user);
	}
	
	/**
	 * 넘겨받은 query문에 settable에서 PrepareStatement에 set한 값들을 담아 쿼리를 실행하며 결과 int를 반환합니다.
	 * @param query
	 * @param settable
	 * @return result - 쿼리 결과
	 * @throws DatabaseConnectException
	 * @throws SQLException
	 */
	protected int set(String query, DataSettable settable) throws DatabaseConnectException, SQLException {
		PreparedStatement pstmt = _conn.prepareStatement(query);
		
		settable.prepare(pstmt);
		
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
}
