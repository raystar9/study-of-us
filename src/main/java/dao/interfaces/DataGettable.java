package dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.exceptions.DatabaseConnectException;

public interface DataGettable {
	Object onGetResult(ResultSet rs) throws DatabaseConnectException, SQLException;
}
