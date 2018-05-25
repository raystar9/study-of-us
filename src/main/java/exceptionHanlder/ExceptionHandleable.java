package exceptionHanlder;

import java.sql.SQLException;

import dao.DataAccessor;
import dao.exceptions.DatabaseConnectException;
//TODO 삭제예정
@FunctionalInterface
public interface ExceptionHandleable {
	public DataAccessor methods() throws DatabaseConnectException, SQLException;
}
