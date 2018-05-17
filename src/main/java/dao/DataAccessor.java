package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class DataAccessor implements AutoCloseable{
	Connection _conn;
	
	protected Connection getConnection(String user) throws NamingException, SQLException{
		Context init = new InitialContext();
		DataSource source;
		source = (DataSource) init.lookup("java:comp/env/jdbc/" + user);
		_conn = source.getConnection();
		return _conn;
	}
	
	protected PreparedStatement getStatement(String user, String query) throws NamingException, SQLException{
		
		Connection conn = getConnection(user);
		
		return conn.prepareStatement(query);
	}
	
	public void close() throws SQLException{
		_conn.close();
	}
}
