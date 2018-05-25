package exceptionHanlder;

import java.sql.SQLException;

public interface TrySQLException {

	void action() throws SQLException;
}
