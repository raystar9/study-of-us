package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dao.exceptions.DatabaseConnectException;

public abstract class DataAccessor implements AutoCloseable{
	Connection _conn;
	
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
	
	protected PreparedStatement getStatement(String query) throws DatabaseConnectException, SQLException{
		
		return _conn.prepareStatement(query);
	}
	
	public void close() throws SQLException{
		if(_conn != null) {
			_conn.close();
		}
	}
}
