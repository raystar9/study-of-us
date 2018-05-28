package dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataGettable {
	Object onGetResult(ResultSet rs) throws SQLException;
}
