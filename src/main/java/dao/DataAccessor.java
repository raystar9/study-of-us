package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import exceptionHandler.ExceptionHandler;
import exceptionHandler.TryNamingException;
import exceptionHandler.TrySQLException;

/* 
 * abstract class(추상 클래스)이기에 직접 객체를 생성할 수 없습니다.
 * 
 * AutoCloseable 인터페이스는 객체를 생성한 측에서 Close()메서드 미실행시 경고를 띄우는 기능이 있습니다.
 */ 
public abstract class DataAccessor implements AutoCloseable{
	Connection _conn;
	
	/**
	 * 객체가 생성될 때 넘겨받은 user정보로부터 Connection을 생성합니다.
	 */
	public DataAccessor(DatabaseAccounts user){
		getConnection(user.toString());
	}
	
	protected void getConnection(String user){
		ExceptionHandler.handleNamingException(new TryNamingException() {
			
			@Override
			public void action() throws NamingException{
				Context init;
				DataSource source;
				init = new InitialContext();
				source = (DataSource) init.lookup("java:comp/env/jdbc/" + user);
				
				ExceptionHandler.handleSQLException(new TrySQLException() {
					@Override
					public void action() throws SQLException {
						_conn = source.getConnection();
					}
				});
			}
		});
	}
	
	/**
	 * 넘겨받은 쿼리문을 담은 statement를 반환합니다.
	 * @param query - 실행하고자 하는 쿼리문
	 * @return {@link PreparedStatement}
	 * @throws DatabaseConnectException
	 * @throws SQLException
	 */
	protected PreparedStatement getStatement(String query) throws SQLException{
		
		return _conn.prepareStatement(query);
	}
	
	@Override
	public void close(){
		if(_conn != null) {
			ExceptionHandler.handleSQLException(new TrySQLException() {
				
				@Override
				public void action() throws SQLException {
					_conn.close();
				}
			});
			
		}
	}
}
