package exceptionHanlder;

import java.sql.SQLException;

import dao.DataAccessor;
import dao.exceptions.DatabaseConnectException;

@FunctionalInterface
public interface ExceptionHandleable {
	public DataAccessor methods() throws DatabaseConnectException, SQLException;
}
