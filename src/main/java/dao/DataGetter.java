package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.prototype.Member;
import dao.exceptions.DatabaseConnectException;
import dao.interfaces.DataGettable;

public class DataGetter extends DataAccessor {
	
	public DataGetter(DatabaseAccounts query) throws DatabaseConnectException, SQLException {
		super(query);
	}
	
	private ArrayList<?> get(String query, DataGettable gettable) throws DatabaseConnectException, SQLException {
		PreparedStatement pstmt = getStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<?> list = new ArrayList<>();
		
		list = gettable.onGet(rs);
		
		pstmt.close();
		return list;
	}
	
	public ArrayList<Member> getMembers(String query) throws DatabaseConnectException, SQLException{
		
		@SuppressWarnings("unchecked")
		ArrayList<Member> list = (ArrayList<Member>) get(query, new Member());
		
		return list;
	}
	
/*	private ArrayList<?> getBean(ResultSet rs, Class<?> beanClass) throws SQLException{
		Field[] fields = beanClass.getDeclaredFields();
		ArrayList<beanClass> objects = new ArrayList<>();
		for(int i = 0; i < fields.length; i++) {
			rs.next();
			switch(fields[i].getType().toString()) {
			case "int" :
				objects.add(rs.getInt(i+1));
				break;
			case "String" :
				objects.add(rs.getString(i+1));
				break;
			}
		};
		return objects;
	}*/
}
