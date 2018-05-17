package dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import enums.prototype.Member;

public class DataGetter extends DataAccessor {

	@SuppressWarnings("unchecked")
	public JSONArray getMembers(String condition) throws NamingException, SQLException{
		String query = Member.getQueryString() + condition;
		PreparedStatement pstmt = getStatement("OracleDB", query);
		
		pstmt.setInt(1, Integer.parseInt(Member.INDEX.toString()));
		pstmt.setString(2, Member.ID.toString());
		
		JSONArray array = new JSONArray();
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			JSONObject obj = new JSONObject();
			rs.getInt(Member.INDEX.getColumnName());
			rs.getString(Member.ID.getColumnName());
			array.add(obj);
		}
		return array;
	}
	
	@Override
	public void close() throws IOException{
		try {
			_pstmt.close();
			_conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
