package servlet;

import java.sql.SQLException;

import dao.DataAccessor;
import dao.exceptions.DatabaseConnectException;

public class ExceptionHandler{
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
				accessor.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
