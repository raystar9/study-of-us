package dao.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

public interface DataGettable {
	ArrayList<?> onGet(ResultSet rs) throws NamingException, SQLException;
}
