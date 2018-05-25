package exceptionHanlder;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;

import dao.DataAccessor;
import dao.exceptions.DatabaseConnectException;

@FunctionalInterface
public interface ExceptionHandleable {
	public DataAccessor methods() throws DatabaseConnectException, SQLException, ServletException, IOException;
}
