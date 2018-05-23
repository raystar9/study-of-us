package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	private ArrayList<?> get(String query, DataGettable gettable) throws DatabaseConnectException, SQLException {
		PreparedStatement pstmt = getStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<?> list = new ArrayList<>();
		
		list = gettable.onGetResult(rs);
		
		pstmt.close();
		return list;
	}
	
	/**
	 * Member bean의 QUERY_GET에 적힌 쿼리문을 실행하고 결과를 리스트로 반환합니다.
	 * @return Member의 리스트
	 * @throws DatabaseConnectException
	 * @throws SQLException
	 */
	
	public ArrayList<Member> getMembers() throws DatabaseConnectException, SQLException{
		
		@SuppressWarnings("unchecked")
		ArrayList<Member> list = (ArrayList<Member>) get(Member.QUERY_GET, new DataGettable() {
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
		
		
		set(StudySearch.QUERY_GET,new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				System.out.println("이부분은 실행?"+searchVal);
				String search = "%"+searchVal+"%";
				System.out.println(search);
				pstmt.setString(1, search);
			}
		});
		@SuppressWarnings("unchecked")
		ArrayList<StudySearch> list = (ArrayList<StudySearch>) get(StudySearch.QUERY_GET, new DataGettable() {
			
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

	private void set(String queryGet, DataSettable dataSettable) {
		// TODO Auto-generated method stub
		
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
