package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Login;
import beans.prototype.Member;
import dao.exceptions.DatabaseConnectException;
import dao.interfaces.DataGettable;
import dao.interfaces.DataSettable;
/**
 * 데이터베이스에 쿼리문을 실행하며 해당 쿼리문에 대한 결과를 ArrayList에 담아 반환합니다.
 * @author raystar
 */
public class DataGetter extends DataAccessor {
	
	/**
	 * 데이터베이스에 파라미터로 넘겨받은 유저 계정으로 접속합니다.
	 * @param user - 접속할 계정
	 * @throws DatabaseConnectException
	 * @throws SQLException
	 */
	public DataGetter(DatabaseAccounts user) throws DatabaseConnectException, SQLException {
		super(user);
	}
	
	/*
	 * 쿼리문을 실행하며 넘겨받은 gettable에서 구현한 메서드대로 ResultSet을 List에 담아서 반환합니다.
	 * 또한 onGetResult가 어떤 ArrayList를 반환할 지 모르기때문에 리스트는 제네릭 <?>으로 설정했습니다.
	 */
	private Object get(String query, DataGettable gettable, DataSettable settable) throws DatabaseConnectException, SQLException {
		PreparedStatement pstmt = getStatement(query);
		if(settable != null) {
			settable.prepare(pstmt);
		}
		
		ResultSet rs = pstmt.executeQuery();
		
		Object result = gettable.onGetResult(rs);
		
		pstmt.close();
		return result;
	}

	
	@SuppressWarnings("unused")
	private Object get(String query, DataGettable gettable) throws DatabaseConnectException, SQLException {
		return get(query, gettable, null);
	}
	
	private ArrayList<?> getArrayList(String query, DataGettable gettable) throws DatabaseConnectException, SQLException {
		return getArrayList(query, gettable, null);
	}
	
	private ArrayList<?> getArrayList(String query, DataGettable gettable, DataSettable settable) throws DatabaseConnectException, SQLException {
		return (ArrayList<?>) get(query, gettable, settable);
	}
	
	/**
	 * Member bean의 QUERY_GET에 적힌 쿼리문을 실행하고 결과를 리스트로 반환합니다.
	 * @return Member의 리스트
	 * @throws DatabaseConnectException
	 * @throws SQLException
	 */
	
	public ArrayList<Member> getMembers() throws DatabaseConnectException, SQLException{
		
		@SuppressWarnings("unchecked")
		ArrayList<Member> list = (ArrayList<Member>) getArrayList(Member.QUERY_GET, new DataGettable() {
			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws DatabaseConnectException, SQLException {
				ArrayList<Member> members = new ArrayList<>(); 
				while(rs.next()) {
					Member member = new Member();
					member.setIndex(rs.getInt(1));
					member.setId(rs.getString(2));
					members.add(member);
				}
				return members;
			}
		});
		
		return list;
	}
	
	public Login getLogin(Login loginbean) throws DatabaseConnectException, SQLException{
		Login login = (Login) get(Login.QUERY_GET, new DataGettable() {
			
			@Override
			public Object onGetResult(ResultSet rs) throws DatabaseConnectException, SQLException {
				
				
				Login innerLogin = new Login();			//얘
				if(rs.next()) {
					innerLogin.setId(rs.getString(1));
					innerLogin.setPassword(rs.getString(2));
					}
					
				
				return innerLogin;    //ongetresult 로 리턴해주고.
				
				
			
			}
		}, new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, loginbean.getId());		// 바인딩변수를 채워주기위해서 데이터 세터블을 매개변수 추가하며 오버로딩을한다.
			}
		});
		return login;				//나를 불러준 get 로그인한테 리턴해준다.
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
