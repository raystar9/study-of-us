package servlet;

import java.sql.SQLException;

import dao.DataAccessor;
import dao.exceptions.DatabaseConnectException;

public interface ExceptionHandleable {
	public DataAccessor methods() throws DatabaseConnectException, SQLException;
}
