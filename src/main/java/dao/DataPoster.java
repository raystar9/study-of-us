package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import beans.prototype.Member;

public class DataPoster extends DataAccessor {

	public ArrayList<Member> postMembers(Member member) throws NamingException, SQLException{
		return postMembers(member, "");
	}
	
	public ArrayList<Member> postMembers(Member member, String condition) throws NamingException, SQLException{
		String query;
		query = Member.QUERY_POST + condition;
		
		PreparedStatement pstmt = getStatement("OracleDB", query);
		pstmt.setInt(1, member.getIndex());
		pstmt.setString(2, member.getId());
		
		pstmt.executeUpdate();
		
		ArrayList<Member> members = new ArrayList<>(); 
		
		
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
