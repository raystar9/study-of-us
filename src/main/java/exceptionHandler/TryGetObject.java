package exceptionHandler;

import java.sql.SQLException;

public interface TryGetObject {

	void action(Object result) throws SQLException;

}
