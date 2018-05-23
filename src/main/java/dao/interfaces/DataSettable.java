package dao.interfaces;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DataSettable {
	void prepare(PreparedStatement pstmt) throws SQLException;
}
