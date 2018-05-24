package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.BoardList;
import beans.prototype.Member;
import dao.exceptions.DatabaseConnectException;
import dao.interfaces.DataGettable;
import dao.interfaces.DataSettable;

/**
 * 데이터베이스에 쿼리문을 실행하며 해당 쿼리문에 대한 결과를 ArrayList에 담아 반환합니다.
 * 
 * @author raystar
 */
public class DataGetter extends DataAccessor {

	/**
	 * 데이터베이스에 파라미터로 넘겨받은 유저 계정으로 접속합니다.
	 * 
	 * @param user
	 *            - 접속할 계정
	 * @throws DatabaseConnectException
	 * @throws SQLException
	 */
	public DataGetter(DatabaseAccounts user) throws DatabaseConnectException, SQLException {
		super(user);
	}

	/*
	 * 쿼리문을 실행하며 넘겨받은 gettable에서 구현한 메서드대로 ResultSet을 List에 담아서 반환합니다. 또한
	 * onGetResult가 어떤 ArrayList를 반환할 지 모르기때문에 리스트는 제네릭 <?>으로 설정했습니다.
	 */
	private ArrayList<?> get(String query, DataGettable gettable) throws DatabaseConnectException, SQLException {
		return get(query, gettable, null);
	}

	private ArrayList<?> get(String query, DataGettable gettable, DataSettable settable)
			throws DatabaseConnectException, SQLException {
		PreparedStatement pstmt = getStatement(query);
		if (settable != null) {
			settable.prepare(pstmt);
		}

		ResultSet rs = pstmt.executeQuery();

		ArrayList<?> list = new ArrayList<>();

		list = gettable.onGetResult(rs);

		pstmt.close();
		return list;
	}

	/**
	 * Member bean의 QUERY_GET에 적힌 쿼리문을 실행하고 결과를 리스트로 반환합니다.
	 * 
	 * @return Member의 리스트
	 * @throws DatabaseConnectException
	 * @throws SQLException
	 */

	public ArrayList<Member> getMembers() throws DatabaseConnectException, SQLException {

		@SuppressWarnings("unchecked")
		ArrayList<Member> list = (ArrayList<Member>) get(Member.QUERY_GET, new DataGettable() {
			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws DatabaseConnectException, SQLException {
				ArrayList<Member> members = new ArrayList<>();
				while (rs.next()) {
					Member member = new Member();
					member.setM_index(rs.getInt(1));
					member.setM_id(rs.getString(2));
					members.add(member);
				}
				return members;
			}
		});

		return list;
	}

	public ArrayList<BoardList> getBoardList() throws DatabaseConnectException, SQLException {

		@SuppressWarnings("unchecked")
		ArrayList<BoardList> list = (ArrayList<BoardList>) get(BoardList.QUERY_GET, new DataGettable() {
			
			@Override
			public ArrayList<BoardList> onGetResult(ResultSet rs) throws DatabaseConnectException, SQLException {
				ArrayList<BoardList> boardlist = new ArrayList<>();
				while (rs.next()) {
					BoardList board = new BoardList();
					board.setCount(rs.getInt(1));
					board.setIndex(rs.getInt(2));
					board.setTitle(rs.getString(3));
					board.setName(rs.getString(4));
					board.setDate(rs.getDate(5));
					boardlist.add(board);
				}
				return boardlist;
			}
		});

		return list;
	}

}
