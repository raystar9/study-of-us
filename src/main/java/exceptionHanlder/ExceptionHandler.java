package exceptionHanlder;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import dao.DataAccessor;
import dao.exceptions.DatabaseConnectException;

/**
 * Exception 처리를 담당하는 클래스입니다.
 * close()를 호출해야 하는 finally때문에 콜백함수를 넣을 수밖에 없었습니다.
 * @author raystar
 *
 */
public class ExceptionHandler{
	//TODO 삭제 예정
	public static void general(ExceptionHandleable handleable) {
		DataAccessor accessor = null;
		try {
			accessor = handleable.methods();
		} catch (DatabaseConnectException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(accessor != null) {
					accessor.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void handleNamingException(TryNamingException tryNamingException) {
		try {
			tryNamingException.action();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static void handleSQLException(TrySQLException trySQLException) {
		try {
			trySQLException.action();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void handleSQLException(Object object, TryGetObject tryGetObject) {
		try {
			tryGetObject.action(object);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
