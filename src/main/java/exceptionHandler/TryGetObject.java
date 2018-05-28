package exceptionHandler;

import java.sql.SQLException;

public interface TryGetObject {

	Object action(Object result) throws SQLException;

}
