package exceptionHanlder;

import java.sql.SQLException;

import javax.naming.NamingException;

/**
 * Exception 처리를 담당하는 클래스입니다.
 * close()를 호출해야 하는 finally때문에 콜백함수를 넣을 수밖에 없었습니다.
 * @author raystar
 *
 */
public class ExceptionHandler{

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
