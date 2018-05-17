package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import beans.prototype.Member;

public class DataGetter extends DataAccessor {
	
	public ArrayList<Member> getMembers(String query) throws NamingException, SQLException{
		
		PreparedStatement pstmt = getStatement("OracleDB", query);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Member> list = new ArrayList<>();
		list = new Member().onGet(rs);
		
		pstmt.close();
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
