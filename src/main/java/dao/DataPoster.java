package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.prototype.Member;
import dao.exceptions.DatabaseConnectException;
import dao.interfaces.DataSettable;

public class DataPoster extends DataSetter {
	
	public DataPoster(DatabaseAccounts user) throws DatabaseConnectException, SQLException {
		super(user);
	}

	public void postMembers(Member member) throws DatabaseConnectException, SQLException{
		
		set(Member.QUERY_POST, new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException{
				pstmt.setInt(1, member.getIndex());
				pstmt.setString(2, member.getId());
			}
		});
	}
}
