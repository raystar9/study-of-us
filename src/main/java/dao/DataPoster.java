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
		
		/*
		 * DataSettable은 익명클래스로 구현하도록 되어있습니다.
		 * 외부 혹은 내부 클래스로 선언하여 실제로 구현하여 매개변수로 넣어줄 수도 있지만
		 * 익명클래스로 처리하는 쪽이 더 간결해 보인다고 생각했습니다.
		 */
		set(Member.QUERY_POST, new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException{
				pstmt.setInt(1, member.getM_index());
				pstmt.setString(2, member.getM_id());
			}
		});
	}
}
