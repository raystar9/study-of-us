package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import beans.prototype.Member;

public class DataGetter extends DataAccessor {

	public ArrayList<Member> getMembers() throws NamingException, SQLException{
		return getMembers(null);
	}
	
	public ArrayList<Member> getMembers(String condition) throws NamingException, SQLException{
		String query;
		if(condition == null) {
			query = Member.QUERY_GET;
		} else {
			query = Member.QUERY_GET + condition;
		}
		PreparedStatement pstmt = getStatement("OracleDB", query);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Member> members = new ArrayList<>(); 
		while(rs.next()) {
			Member member = new Member();
			member.setIndex(rs.getInt(1));
			member.setId(rs.getString(2));
			members.add(member);
		}
		
		pstmt.close();
		return members;
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
