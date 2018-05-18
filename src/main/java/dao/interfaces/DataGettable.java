package dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.exceptions.DatabaseConnectException;

public interface DataGettable {
	ArrayList<?> onGet(ResultSet rs) throws DatabaseConnectException, SQLException;
}
