package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.Login;
import beans.StudyListCount;
import beans.StudySearch;
import beans.prototype.Member;
import beans.prototype.Study;
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
	private Object get(String query, DataSettable settable, DataGettable gettable) throws DatabaseConnectException, SQLException {
		PreparedStatement pstmt = getStatement(query);
		if(settable != null) {
			settable.prepare(pstmt);
		}
		
		ResultSet rs = pstmt.executeQuery();			//2 번째로 되고
		
		Object result = gettable.onGetResult(rs);
		
		pstmt.close();
		return result;
	}

	
	@SuppressWarnings("unused")
	private Object get(String query, DataGettable gettable) throws DatabaseConnectException, SQLException {
		return get(query, null, gettable);
	}
	
	private ArrayList<?> getArrayList(String query, DataGettable gettable) throws DatabaseConnectException, SQLException {
		return getArrayList(query, null, gettable);
	}
	
	private ArrayList<?> getArrayList(String query, DataSettable settable, DataGettable gettable) throws DatabaseConnectException, SQLException {
		return (ArrayList<?>) get(query, settable, gettable);
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

	public ArrayList<Study> getStudys() throws DatabaseConnectException, SQLException {
		@SuppressWarnings("unchecked")
		ArrayList<Study> list = (ArrayList<Study>) get(Study.QUERY_GET, new DataGettable() {
			
			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws DatabaseConnectException, SQLException {
				ArrayList<Study> studies = new ArrayList<>();
				while(rs.next()) {
					Study study = new Study();
					study.setIndex(rs.getInt(1));
					study.setName(rs.getString(2));
					study.setC_id(rs.getString(3));
					study.setPlace(rs.getString(4));
					study.setTime(rs.getDate(5));
					study.setPloplenum(6);
					study.setGoal(rs.getString(7));
					study.setTerm(rs.getDate(8));
					
					studies.add(study);
				}
				return studies;
			}
		});
		
		// TODO Auto-generated method stub
		return list;
	}

	public ArrayList<StudySearch> getSearchList(String searchVal) throws DatabaseConnectException, SQLException {
		
	
		@SuppressWarnings("unchecked")
		ArrayList<StudySearch> list = (ArrayList<StudySearch>) get(StudySearch.QUERY_GET, 
			new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				String serach = "%"+searchVal+"%";
				System.out.println(serach);
				pstmt.setString(1, serach);
			}
			
		}, 
			new DataGettable() {
			
			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws DatabaseConnectException, SQLException {
				ArrayList<StudySearch> StudySearchlist = new ArrayList<>();
				while(rs.next()) {
					StudySearch studysearch = new StudySearch();
					studysearch.setIndex(rs.getInt(1));
					studysearch.setName(rs.getString(2));
					studysearch.setC_id(rs.getString(3));
					studysearch.setPlace(rs.getString(4));
					studysearch.setTime(rs.getDate(5));
					studysearch.setPloplenum(6);
					studysearch.setGoal(rs.getString(7));
					studysearch.setTerm(rs.getDate(8));
					
					StudySearchlist.add(studysearch);
				}
				return StudySearchlist;
			}
		});
		return list;
	}

	public ArrayList<StudyListCount> getStudyPaging(int startcount, int endcount) throws DatabaseConnectException, SQLException{
		@SuppressWarnings("unchecked")
		ArrayList<StudyListCount> list = (ArrayList<StudyListCount>) get(StudyListCount.QUERY_GET, new DataGettable() {
			
			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws DatabaseConnectException, SQLException {
				ArrayList<StudyListCount> StudyListCountlist = new ArrayList<>();
				while(rs.next()) {
					StudyListCount StudyListCount = new StudyListCount();
					StudyListCount.setIndex(rs.getInt(2));
					StudyListCount.setName(rs.getString(3));
					StudyListCount.setC_id(rs.getString(4));
					StudyListCount.setPlace(rs.getString(5));
					StudyListCount.setTime(rs.getDate(6));
					StudyListCount.setPloplenum(7);
					StudyListCount.setGoal(rs.getString(8));
					StudyListCount.setTerm(rs.getDate(9));
					
					StudyListCountlist.add(StudyListCount);
				}
				return StudyListCountlist;
			}
		}, new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, startcount);
				pstmt.setInt(2, endcount);
				
			}
		});
		return list;
	}



	
	
	public Login getLogin(Login loginbean) throws DatabaseConnectException, SQLException{
		Login login = (Login) get(Login.QUERY_GET, new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
						//1번째실행 위에 executeQuery 가 2번재
				pstmt.setString(1, loginbean.getId());		// 바인딩변수를 채워주기위해서 데이터 세터블을 매개변수 추가하며 오버로딩을한다.
			}
		}, new DataGettable() {
			
			@Override
			public Object onGetResult(ResultSet rs) throws DatabaseConnectException, SQLException {
				Login innerLogin = null;
				if(rs.next()) {
					innerLogin = new Login();			//얘
					innerLogin.setId(rs.getString(1));
					innerLogin.setPassword(rs.getString(2));
				}
				return innerLogin;    //ongetresult 로 리턴해주고.
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
