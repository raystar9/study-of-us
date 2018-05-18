package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dao.exceptions.DatabaseConnectException;

/* 
 * 접근지정자가 default(혹은 package private)입니다. 이는 패키지 밖에서 객체를 생성하는 것을 허용하지 않습니다.
 * 따라서 패키지 외부에서 볼 수 있는 클래스는 DataGetter, DataPoster, DataPutter, DataDeleter 네 가지입니다.
 * 또한 abstract class(추상 클래스)이기에 직접 객체를 생성할 수도 없습니다.
 * 
 * AutoCloseable 인터페이스는 객체를 생성한 측에서 Close()메서드 미실행시 경고를 띄우는 기능이 있습니다.
 */ 
public abstract class DataAccessor implements AutoCloseable{
	Connection _conn;
	
	/**
	 * 객체가 생성될 때 넘겨받은 user정보로부터 Connection을 생성합니다.
	 */
	public DataAccessor(DatabaseAccounts user) throws DatabaseConnectException, SQLException {
		getConnection(user.toString());
	}
	
	protected Connection getConnection(String user) throws DatabaseConnectException, SQLException{
		Context init;
		DataSource source;
		try {
			init = new InitialContext();
			source = (DataSource) init.lookup("java:comp/env/jdbc/" + user);
			_conn = source.getConnection();
		} catch (NamingException e) {
			throw new DatabaseConnectException();
		}
		
		return _conn;
	}
	
	/**
	 * 넘겨받은 쿼리문을 담은 statement를 반환합니다.
	 * @param query - 실행하고자 하는 쿼리문
	 * @return {@link PreparedStatement}
	 * @throws DatabaseConnectException
	 * @throws SQLException
	 */
	protected PreparedStatement getStatement(String query) throws DatabaseConnectException, SQLException{
		
		return _conn.prepareStatement(query);
	}
	
	@Override
	public void close() throws SQLException{
		if(_conn != null) {
			_conn.close();
		}
	}
}
