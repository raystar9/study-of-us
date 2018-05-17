package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import beans.prototype.Member;

public class DataPoster extends DataAccessor {
	
	public void postMembers(Member member, String query) throws NamingException, SQLException{
		
		PreparedStatement pstmt = getStatement("OracleDB", query);
		pstmt.setInt(1, member.getIndex());
		pstmt.setString(2, member.getId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
	}
}
