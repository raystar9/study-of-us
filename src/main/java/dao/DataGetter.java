package dao;

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
		
		JSONArray array = new JSONArray();
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			JSONObject obj = new JSONObject();
			obj.put(Member.INDEX.toString(), rs.getInt(Member.INDEX.getColumnName()));
			obj.put(Member.ID.toString(), rs.getString(Member.ID.getColumnName()));
			array.add(obj);
		}
		pstmt.close();
		return array;
	}
}
