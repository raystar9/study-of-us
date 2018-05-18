package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import beans.prototype.Member;
import dao.exceptions.DatabaseConnectException;

public class DataPoster extends DataAccessor {
	
	public DataPoster(DatabaseAccounts query) throws DatabaseConnectException, SQLException {
		super(query);
	}

	public void postMembers(Member member, String query) throws NamingException, SQLException{
		
		PreparedStatement pstmt = getStatement(query);
		pstmt.setInt(1, member.getIndex());
		pstmt.setString(2, member.getId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
	}
}
