package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.prototype.Member;
import beans.prototype.Study;
import beans.prototype.StudyList;
import beans.root.Find;
import beans.root.Login;
import beans.study.StudyListCount;
import beans.study.StudyListSelect;
import beans.study.StudySearch;
import beans.study.each.InformSetup;
import beans.study.each.InformSetupMember;
import beans.study.each.attendacne.MemberAttendanceBean;
import beans.study.each.board.BoardListBean;
import beans.study.each.board.BoardViewRegisterBean;
import beans.study.each.board.CommentBean;
import beans.study.each.fee.CashListBean;
import beans.study.each.fee.FeeCollectListBean;
import beans.study.each.schedule.ScheduleBean;
import beansNew.FeeSpend;
import beansNew.Meeting;
import beansNew.StudyMember;
import dao.interfaces.DataGettable;
import dao.interfaces.DataSettable;
import dateConverter.DateConverter;
import exceptionHandler.ExceptionHandler;
import exceptionHandler.TryGetObject;
import query.Queries;

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
	public DataGetter(DatabaseAccounts user) {
		super(user);
	}

	/*
	 * 쿼리문을 실행하며 넘겨받은 gettable에서 구현한 메서드대로 ResultSet을 List에 담아서 반환합니다. 또한
	 * onGetResult가 어떤 ArrayList를 반환할 지 모르기때문에 리스트는 제네릭 <?>으로 설정했습니다.
	 */
	private Object get(String query, DataSettable settable, DataGettable gettable) {

		return ExceptionHandler.handleSQLException(new TryGetObject() {

			@Override
			public Object action(Object result) throws SQLException {
				PreparedStatement pstmt = getStatement(query);
				if (settable != null) {
					settable.prepare(pstmt);
				}

				ResultSet rs = pstmt.executeQuery(); // 2 번째로 되고

				result = gettable.onGetResult(rs);

				System.out.println(result);
				pstmt.close();

				return result;
			}
		});
	}

	private Object get(String query, DataGettable gettable) {
		return get(query, null, gettable);
	}

	/**
	 * Member bean의 QUERY_GET에 적힌 쿼리문을 실행하고 결과를 리스트로 반환합니다.
	 * 
	 * @return Member의 리스트
	 * @throws DatabaseConnectException
	 * @throws SQLException
	 */

	public ArrayList<Member> getMembers() {

		@SuppressWarnings("unchecked")
		ArrayList<Member> list = (ArrayList<Member>) get(Member.QUERY_GET, new DataGettable() {
			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<Member> members = new ArrayList<>();
				while (rs.next()) {
					Member member = new Member();
					member.setId(rs.getString(1));
					members.add(member);
				}
				return members;
			}
		});
		return list;
	}

	public ArrayList<Study> getStudies() {
		@SuppressWarnings("unchecked")
		ArrayList<Study> list = (ArrayList<Study>) get(Study.QUERY_GET, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<Study> studies = new ArrayList<>();
				while (rs.next()) {
					Study study = new Study();
					study.setIndex(rs.getInt(1));
					study.setName(rs.getString(2));
					study.setC_id(rs.getInt(3));
					study.setMt_index(rs.getInt(4));
					study.setStart(rs.getDate(5));
					study.setEnd(rs.getDate(6));
					study.setPeoplenum(rs.getInt(7));
					study.setDay(rs.getString(8));
					study.setTime(rs.getString(9));
					study.setExplain(rs.getString(10));
					study.setPrepared(rs.getString(11));
					study.setEffective(rs.getString(12));
					study.setPlace(rs.getString(13));

					studies.add(study);
				}
				return studies;
			}
		});

		// TODO Auto-generated method stub
		return list;
	}

	public ArrayList<Study> getStudies(String search, String[] check, String secondArray, int startcount,
			int endcount) {

		String sql = StudyListCount.QUERY_GET3 + StudyListCount.QUERY_GET4;
		if (search != null && search != "") {
			sql = StudyListCount.QUERY_GET3;
			// ) 로 짜른부분왓 ㅓ다시
			sql += " where s_name LIKE '%" + search + "%'" + StudyListCount.QUERY_GET4;
			if (!secondArray.equals("소분 +`류") && secondArray != "") {
				sql = (sql.substring(0, sql.length() - 3));
				sql += "where c_sub LIKE '%" + secondArray + "%' ))";
			}
			if (check != null) { // 검색어와 체크값을 같이 검색 했을 시
				String str = "";
				// 체크값을 만족하는 경우
				if (!secondArray.equals("소분류") && secondArray != "") {
					sql = (sql.substring(0, sql.length() - 1));
					str = " where s_place LIKE ";
				} else {
					str = ") where s_place LIKE ";
				}
				for (int i = 0; i < check.length; i++) {
					if (i < 1) {
						str += "'%" + check[i] + "%' ";
					} else {
						str += "or s_place LIKE '%" + check[i] + "%' ";
					}
				}
				sql += str + ")";
			}

		}
		sql += StudyListCount.QUERY_GET5;
		System.out.println(sql);

		@SuppressWarnings("unchecked")
		ArrayList<Study> list = (ArrayList<Study>) get(sql, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, startcount);
				pstmt.setInt(2, endcount);

			}
		}, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<Study> studies = new ArrayList<>();
				while (rs.next()) {
					Study study = new Study();
					study.setIndex(rs.getInt(2));
					study.setName(rs.getString(3));
					study.setC_id(rs.getInt(4));
					study.setMt_index(rs.getInt(5));
					study.setStart(rs.getDate(6));
					study.setEnd(rs.getDate(7));
					study.setPeoplenum(rs.getInt(8));
					study.setDay(rs.getString(9));
					study.setTime(rs.getString(10));
					study.setExplain(rs.getString(11));
					study.setPrepared(rs.getString(12));
					study.setEffective(rs.getString(13));
					study.setPlace(rs.getString(14));

					studies.add(study);
				}
				return studies;
			}
		});

		// TODO Auto-generated method stub
		return list;
	}

	public ArrayList<Study> getStudies(String search, String[] check, String secondArray) {

		String sql = StudyListCount.QUERY_GET3 + StudyListCount.QUERY_GET4;
		if (search != null && search != "") {
			sql = StudyListCount.QUERY_GET3;
			// ) 로 짜른부분왓 ㅓ다시
			sql += " where s_name LIKE '%" + search + "%'" + StudyListCount.QUERY_GET4;
			if (!secondArray.equals("소분류") && secondArray != "") {
				sql = (sql.substring(0, sql.length() - 3));
				sql += "where c_sub LIKE '%" + secondArray + "%' ))";
			}
			if (check != null) { // 검색어와 체크값을 같이 검색 했을 시
				String str = "";
				// 체크값을 만족하는 경우
				if (!secondArray.equals("소분류") && secondArray != "") {
					sql = (sql.substring(0, sql.length() - 1));
					str = " where s_place LIKE ";
				} else {
					str = ") where s_place LIKE ";
				}
				for (int i = 0; i < check.length; i++) {
					if (i < 1) {
						str += "'%" + check[i] + "%' ";
					} else {
						str += "or s_place LIKE '%" + check[i] + "%' ";
					}
				}
				sql += str + ")";
			}

		}
		System.out.println(sql);

		@SuppressWarnings("unchecked")
		ArrayList<Study> list = (ArrayList<Study>) get(sql, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<Study> studies = new ArrayList<>();
				while (rs.next()) {
					Study study = new Study();
					study.setIndex(rs.getInt(2));
					study.setName(rs.getString(3));
					study.setC_id(rs.getInt(4));
					study.setMt_index(rs.getInt(5));
					study.setStart(rs.getDate(6));
					study.setEnd(rs.getDate(7));
					study.setPeoplenum(rs.getInt(8));
					study.setDay(rs.getString(9));
					study.setTime(rs.getString(10));
					study.setExplain(rs.getString(11));
					study.setPrepared(rs.getString(12));
					study.setEffective(rs.getString(13));
					study.setPlace(rs.getString(14));

					studies.add(study);
				}
				return studies;
			}
		});

		// TODO Auto-generated method stub
		return list;
	}

	public ArrayList<StudySearch> getSearchList(String searchVal, int startcount, int endcount) {

		@SuppressWarnings("unchecked")
		ArrayList<StudySearch> list = (ArrayList<StudySearch>) get(StudySearch.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				String serach = "%" + searchVal + "%";
				System.out.println(serach);
				pstmt.setString(1, serach);
				pstmt.setInt(2, startcount);
				pstmt.setInt(3, endcount);
			}
		}, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<StudySearch> StudySearchlist = new ArrayList<>();
				while (rs.next()) {
					StudySearch studysearch = new StudySearch();
					studysearch.setIndex(rs.getInt(2));
					studysearch.setName(rs.getString(3));
					studysearch.setC_id(rs.getString(4));
					studysearch.setPlace(rs.getString(5));
					studysearch.setTime(rs.getDate(6));
					studysearch.setPloplenum(7);
					studysearch.setGoal(rs.getString(8));
					studysearch.setTerm(rs.getDate(9));

					StudySearchlist.add(studysearch);
				}
				return StudySearchlist;
			}
		});
		return list;
	}

	public ArrayList<StudyListCount> getStudyPaging(int startcount, int endcount) {
		@SuppressWarnings("unchecked")
		ArrayList<StudyListCount> list = (ArrayList<StudyListCount>) get(StudyListCount.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, startcount);
				pstmt.setInt(2, endcount);

			}
		}, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<StudyListCount> StudyListCountlist = new ArrayList<>();
				while (rs.next()) {
					StudyListCount study = new StudyListCount();
					study.setIndex(rs.getInt(2));
					study.setName(rs.getString(3));
					study.setC_id(rs.getInt(4));
					study.setMt_index(rs.getInt(5));
					study.setStart(rs.getDate(6));
					study.setEnd(rs.getDate(7));
					study.setPeoplenum(rs.getInt(8));
					study.setDay(rs.getString(9));
					study.setTime(rs.getString(10));
					study.setExplain(rs.getString(11));
					study.setPrepared(rs.getString(12));
					study.setEffective(rs.getString(13));
					study.setPlace(rs.getString(14));

					StudyListCountlist.add(study);
				}
				return StudyListCountlist;
			}
		});
		return list;
	}

	public Login getLogin(String id) {
		Login login = (Login) get(Login.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// 1번째실행 위에 executeQuery 가 2번재
				pstmt.setString(1, id); // 바인딩변수를 채워주기위해서 데이터 세터블을 매개변수 추가하며 오버로딩을한다.
			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				Login innerLogin = null;
				if (rs.next()) {
					innerLogin = new Login(); // 얘
					innerLogin.setId(rs.getString(1));
					innerLogin.setPassword(rs.getString(2));
				}
				return innerLogin; // ongetresult 로 리턴해주고.
			}
		});
		return login; // 나를 불러준 get 로그인한테 리턴해준다.
	}

	// 게시판에 들어갔을 때 나오는 목록 데이터를 가져오는 메소드
	public ArrayList<BoardListBean> getBoardList(int page, int limit, int studyIndex, String pluswhere, String search) {
		String sql = BoardListBean.QUERY_GET + pluswhere
				+ "ORDER BY B_NO DESC)) where B_S_INDEX = (select S_INDEX from STUDY where S_INDEX = ?) AND RNUM>=? AND RNUM<=?";
		@SuppressWarnings("unchecked")
		ArrayList<BoardListBean> list = (ArrayList<BoardListBean>) get(sql, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				int startrow = (page - 1) * limit + 1; // 읽기 시작할 row 번호( 1 11 21 )
				int endrow = startrow + limit - 1; // 읽을 마지막 row 번호( 10 20 30 )

				if (search != null && search != "") {
					String search2 = "%" + search + "%";
					pstmt.setString(1, search2);
					pstmt.setInt(2, studyIndex);
					pstmt.setInt(3, startrow);
					pstmt.setInt(4, endrow);
				} else {
					pstmt.setInt(1, studyIndex);
					pstmt.setInt(2, startrow);
					pstmt.setInt(3, endrow);
				}
			}

		}, new DataGettable() {

			@Override
			public ArrayList<BoardListBean> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<BoardListBean> boardlist = new ArrayList<>();
				System.out.println("sql = " + sql);
				while (rs.next()) {
					BoardListBean board = new BoardListBean();
					board.setIndex(rs.getInt(1));
					board.setTitle(rs.getString(2));
					board.setName(rs.getString(3));
					board.setDate(rs.getDate(4));
					boardlist.add(board);
				}
				return boardlist;
			}
		}

		);

		return list;
	}

	public ArrayList<StudySearch> getSearchStudies(String searchVal) {
		@SuppressWarnings("unchecked")
		ArrayList<StudySearch> list = (ArrayList<StudySearch>) get(StudySearch.QUERY_GET2, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				String search = "%" + searchVal + "%";
				pstmt.setString(1, search);

			}
		}, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<StudySearch> studies = new ArrayList<>();
				while (rs.next()) {
					StudySearch study = new StudySearch();
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
	/*
	 * private ArrayList<?> getBean(ResultSet rs, Class<?> beanClass) throws
	 * SQLException{ Field[] fields = beanClass.getDeclaredFields();
	 * ArrayList<beanClass> objects = new ArrayList<>(); for(int i = 0; i <
	 * fields.length; i++) { rs.next(); switch(fields[i].getType().toString()) {
	 * case "int" : objects.add(rs.getInt(i+1)); break; case "String" :
	 * objects.add(rs.getString(i+1)); break;
	 * 
	 */

	// 게시판에서 게시글을 눌렀을 때 상세정보 가져오는 메소드
	public BoardViewRegisterBean getBoardView(int num) {

		BoardViewRegisterBean list = (BoardViewRegisterBean) get(BoardViewRegisterBean.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, num);
			}

		}, new DataGettable() {

			@Override
			public BoardViewRegisterBean onGetResult(ResultSet rs) throws SQLException {
				BoardViewRegisterBean boardcontent = new BoardViewRegisterBean();
				while (rs.next()) {
					boardcontent.setIndex(rs.getInt(1));
					boardcontent.setTitle(rs.getString(2));
					boardcontent.setContent(rs.getString(3));
					boardcontent.setName(rs.getString(4));
					boardcontent.setDate(rs.getString(5));
					boardcontent.setFilename(rs.getString(6));
				}
				return boardcontent;
			}
		});

		return list;
	}

	// 게시판의 글 개수를 가져오는 메소드
	public int getBoardCount(int studyIndex, String pluswhere, String search) {
		String sql = BoardListBean.QUERY_GET_COUNT + pluswhere
				+ " ORDER BY B_NO DESC)) where B_S_INDEX = (select S_INDEX from STUDY where S_INDEX = ?)";

		int boardcount = (int) get(sql, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				// 아직 뭐 들어갈지 몰라서 정의하지 않았음
				if (search != null && search != "") {
					String search2 = "%" + search + "%";
					pstmt.setString(1, search2);
					pstmt.setInt(2, studyIndex);

				} else {
					pstmt.setInt(1, studyIndex);
				}
			}
		}, new DataGettable() {

			@Override
			public Integer onGetResult(ResultSet rs) throws SQLException {
				int count = 0;
				while (rs.next()) {
					count = rs.getInt(1);
				}
				return count;
			}
		});

		return boardcount;
	}

	// idcheck
	public Login getIdCheck(String id) {
		Login login = (Login) get(Login.QUERY_GET2, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// 바인딩변수채워주고
				pstmt.setString(1, id);
			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				Login idck = null;
				if (rs.next()) {
					// 값이있다면 인스턴스변수 참조해서 값을 넣어준다
					idck = new Login();
					idck.setId(rs.getString(1));
				}

				return idck;
			}
		});
		return login;
	}

	public ArrayList<Study> getStudies(String searchVal, String placeVal, String secondArray) {
		@SuppressWarnings("unchecked")
		ArrayList<Study> list = (ArrayList<Study>) get(Study.QUERY_GET3, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				String place = "%%";
				String search = "%%";
				String second = "%%";

				if (placeVal != null) {
					place = "%" + placeVal + "%";
				}
				if (searchVal != null) {
					search = "%" + searchVal + "%";
				}
				if (secondArray != null) {
					second = "%" + secondArray + "%";
				}
				pstmt.setString(1, place);
				pstmt.setString(2, search);
				pstmt.setString(3, second);

			}
		}, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<Study> studies = new ArrayList<>();
				while (rs.next()) {
					Study study = new Study();
					study.setIndex(rs.getInt(1));
					study.setName(rs.getString(2));
					study.setC_id(rs.getInt(3));
					study.setMt_index(rs.getInt(4));
					study.setStart(rs.getDate(5));
					study.setEnd(rs.getDate(6));
					study.setPeoplenum(rs.getInt(7));
					study.setDay(rs.getString(8));
					study.setTime(rs.getString(9));
					study.setExplain(rs.getString(10));
					study.setPrepared(rs.getString(11));
					study.setEffective(rs.getString(12));
					study.setPlace(rs.getString(13));

					studies.add(study);
				}
				return studies;
			}
		});

		// TODO Auto-generated method stub
		return list;
	}

	public ArrayList<StudyListCount> getStudyPaging(int startcount, int endcount, String searchVal, String placeVal,
			String secondArray) {
		@SuppressWarnings("unchecked")
		ArrayList<StudyListCount> list = (ArrayList<StudyListCount>) get(StudyListCount.QUERY_GET2, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				String place = "%%";
				String search = "%%";
				String second = "%%";

				if (placeVal != null) {
					place = "%" + placeVal + "%";
				}
				if (searchVal != null) {
					search = "%" + searchVal + "%";
				}
				if (secondArray != null) {
					second = "%" + secondArray + "%";
				}
				System.out.println("place sql 값" + place);
				System.out.println("place sql 값" + search);
				System.out.println("place sql 값" + second);
				pstmt.setString(1, place);
				pstmt.setString(2, search);
				pstmt.setString(3, second);
				pstmt.setInt(4, startcount);
				pstmt.setInt(5, endcount);

			}
		}, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<StudyListCount> StudyListCountlist = new ArrayList<>();
				while (rs.next()) {
					StudyListCount study = new StudyListCount();
					study.setIndex(rs.getInt(2));
					study.setName(rs.getString(3));
					study.setC_id(rs.getInt(4));
					study.setMt_index(rs.getInt(5));
					study.setStart(rs.getDate(6));
					study.setEnd(rs.getDate(7));
					study.setPeoplenum(rs.getInt(8));
					study.setDay(rs.getString(9));
					study.setTime(rs.getString(10));
					study.setExplain(rs.getString(11));
					study.setPrepared(rs.getString(12));
					study.setEffective(rs.getString(13));
					study.setPlace(rs.getString(14));

					StudyListCountlist.add(study);
				}
				return StudyListCountlist;
			}
		});
		return list;
	}

	// 정보보기&설정 구성원들 총원 가져오는 메소드
	public int getInformMemberCount(int studyIndex) {

		int membercount = (int) get(InformSetup.QUERY_GET_COUNT, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, studyIndex);
			}

		}, new DataGettable() {

			@Override
			public Integer onGetResult(ResultSet rs) throws SQLException {
				int count = 0;
				while (rs.next()) {
					count = rs.getInt(1);
				}
				return count;
			}
		});

		return membercount;
	}

	// 정보보기&설정 구성원들 이름, 전화번호 등 가져오는 메소드
	public ArrayList<InformSetupMember> getInformMember(String studyName) {
		@SuppressWarnings("unchecked")
		ArrayList<InformSetupMember> list = (ArrayList<InformSetupMember>) get(InformSetupMember.QUERY_GET,
				new DataSettable() {

					@Override
					public void prepare(PreparedStatement pstmt) throws SQLException {
						pstmt.setString(1, studyName);
					}

				}, new DataGettable() {

					@Override
					public ArrayList<InformSetupMember> onGetResult(ResultSet rs) throws SQLException {
						ArrayList<InformSetupMember> informlist = new ArrayList<InformSetupMember>();
						while (rs.next()) {
							InformSetupMember InformMem = new InformSetupMember();
							InformMem.setName(rs.getString(1));
							InformMem.setPhone(rs.getInt(2));
							InformMem.setEmail(rs.getString(3));
							informlist.add(InformMem);
						}
						return informlist;
					}
				});

		return list;
	}

	// 설정 정보 가져오는 메소드
	public InformSetup getInformation(int studyIndex) {
		InformSetup list = (InformSetup) get(InformSetup.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, studyIndex);
			}

		}, new DataGettable() {

			@Override
			public InformSetup onGetResult(ResultSet rs) throws SQLException {
				InformSetup Inform = new InformSetup();
				while (rs.next()) {
					Inform.setName(rs.getString(1));
					Inform.setCategory1(rs.getString(2));
					Inform.setCategory2(rs.getString(3));
					Inform.setStartDate(rs.getString(4));
					Inform.setEndDate(rs.getString(5));
					Inform.setPeopleNum(rs.getInt(6));
					Inform.setActivityTime(rs.getString(7));
					Inform.setDay(rs.getString(8));
					Inform.setExplain(rs.getString(9));
					Inform.setPrepared(rs.getString(10));
					Inform.setEffective(rs.getString(11));
					Inform.setPlace(rs.getString(12));
				}
				return Inform;
			}
		});

		return list;
	}

	// 댓글 총 개수 가져오는 메소드
	public int getCommentCount(int num) {
		int commentcount = (int) get(CommentBean.QUERY_GET_COUNT, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, num);
			}
		}, new DataGettable() {

			@Override
			public Integer onGetResult(ResultSet rs) throws SQLException {
				int count = 0;
				while (rs.next()) {
					count = rs.getInt(1);
				}
				return count;
			}
		});

		return commentcount;
	}

	// 게시글 당 댓글 총 리스트 가져오는 메소드
	public ArrayList<CommentBean> getCommentList(int studyIndex, int boardnum) {
		@SuppressWarnings("unchecked")
		ArrayList<CommentBean> list = (ArrayList<CommentBean>) get(CommentBean.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, studyIndex);
				pstmt.setInt(2, boardnum);
			}
		}, new DataGettable() {

			@Override
			public ArrayList<CommentBean> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<CommentBean> commentlist = new ArrayList<CommentBean>();
				while (rs.next()) {
					CommentBean comment = new CommentBean();
					comment.setCno(rs.getInt(1));
					comment.setBno(rs.getInt(2));
					comment.setName(rs.getString(3));
					comment.setDate(rs.getString(4));
					comment.setContent(rs.getString(5));
					commentlist.add(comment);
				}
				return commentlist;
			}
		});

		return list;
	}

	// 스터디명 체크
	public Study getSname_ck(String sname) {
		Study study = (Study) get(Study.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, sname);
			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				Study sck = null;
				if (rs.next()) {
					sck = new Study();
					sck.setName(rs.getString(1));
				}
				return sck;
			}
		});
		return study;
	}

	public ArrayList<Study> getStudies(int index) {
		@SuppressWarnings("unchecked")
		ArrayList<Study> list = (ArrayList<Study>) get(Study.QUERY_GET4, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {

				pstmt.setInt(1, index);

			}
		}, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<Study> studies = new ArrayList<>();
				while (rs.next()) {
					Study study = new Study();
					study.setIndex(rs.getInt(1));
					study.setName(rs.getString(2));
					study.setC_id(rs.getInt(3));
					study.setMt_index(rs.getInt(4));
					study.setStart(rs.getDate(5));
					study.setEnd(rs.getDate(6));
					study.setPeoplenum(rs.getInt(7));
					study.setDay(rs.getString(8));
					study.setTime(rs.getString(9));
					study.setExplain(rs.getString(10));
					study.setPrepared(rs.getString(11));
					study.setEffective(rs.getString(12));
					study.setPlace(rs.getString(13));

					studies.add(study);
				}
				return studies;
			}
		});

		// TODO Auto-generated method stub
		return list;
	}

	// 스터디 리스트 가져오기
	public ArrayList<StudyListSelect> getStudyList(int index) {
		@SuppressWarnings("unchecked")
		ArrayList<StudyListSelect> studylist = (ArrayList<StudyListSelect>) get(StudyListSelect.QUERY_GET,
				new DataSettable() {

					@Override
					public void prepare(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1, index);
					}
				}, new DataGettable() {

					@Override
					public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
						ArrayList<StudyListSelect> studylists = new ArrayList<>();
						while (rs.next()) {
							StudyListSelect sl = new StudyListSelect();

							sl.setProgress(rs.getInt("progress"));
							sl.setS_name(rs.getString("s_name"));
							sl.setS_peoplenum(rs.getInt("s_peoplenum"));

							studylists.add(sl);

						}
						return studylists;
					}
				});
		return studylist;
	}

	// 스터디 count 수 가져오기
	public StudyListSelect getStudyListCount(int index) {
		StudyListSelect count = (StudyListSelect) get(StudyListSelect.QUERY_GET2, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, index);

			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				StudyListSelect slist = null;
				if (rs.next()) {
					slist = new StudyListSelect();
					slist.setCount(rs.getInt("count"));
				}

				return slist;
			}
		});

		// TODO Auto-generated method stub
		return count;
	}

	// 회비관리 리스트 가져오는 메소드
	public ArrayList<CashListBean> getCashList(int page, int limit, String studyName) {

		@SuppressWarnings("unchecked")
		ArrayList<CashListBean> list = (ArrayList<CashListBean>) get(CashListBean.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				int startrow = (page - 1) * limit + 1;
				int endrow = startrow + limit - 1;
				pstmt.setString(1, studyName);
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
			}

		}, new DataGettable() {

			@Override
			public ArrayList<CashListBean> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<CashListBean> cashlist = new ArrayList<>();
				while (rs.next()) {
					CashListBean cash = new CashListBean();
					// 회비 상세보기로 넘어갈 때 index 넘겨줘야 하니까 필요함
					cash.setMeetingIndex(rs.getInt(1));
					cash.setDate(rs.getString(2));
					cashlist.add(cash);
				}
				return cashlist;
			}
		}

		);

		return list;
	}

	// 회비관리의 리스트 개수를 가져오는 메소드
	public int getCashCount(String studyName) {

		int cashcount = (int) get(CashListBean.QUERY_GET_COUNT, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, studyName);
			}

		}, new DataGettable() {

			@Override
			public Integer onGetResult(ResultSet rs) throws SQLException {
				int count = 0;
				while (rs.next()) {
					count = rs.getInt(1);
				}
				return count;
			}
		});

		return cashcount;
	}

	// 보여줄 스터디를 정리햇 ㅓ가져오기
	public ArrayList<StudyListSelect> getStudyList(int index, int page, int limit) {
		@SuppressWarnings("unchecked")
		ArrayList<StudyListSelect> studylist = (ArrayList<StudyListSelect>) get(StudyListSelect.QUERY_GET3,
				new DataSettable() {
					@Override
					public void prepare(PreparedStatement pstmt) throws SQLException {
						// 읽기 시작할 row 번호 1
						int startrow = (page - 1) * limit + 1;
						System.out.println("스타트로우" + startrow);
						// 읽을 마지막 row 번호 2
						int endrow = startrow + limit - 1;
						System.out.println("엔드로우" + endrow);

						pstmt.setInt(1, index);
						pstmt.setInt(2, startrow);
						pstmt.setInt(3, endrow);

						System.out.println(StudyListSelect.QUERY_GET3);

					}
				}, new DataGettable() {

					@Override
					public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
						ArrayList<StudyListSelect> studylists = new ArrayList<>();
						while (rs.next()) {
							StudyListSelect sl = new StudyListSelect();

							sl.setProgress(rs.getInt("progress"));
							sl.setS_name(rs.getString("s_name"));
							sl.setS_peoplenum(rs.getInt("s_peoplenum"));
							studylists.add(sl);
						}

						return studylists;
					}
				});
		return studylist;
	}

	public Study getSindex() {

		@SuppressWarnings("unchecked")
		Study index = (Study) get(Study.QUERY_GET5, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				Study s_index = null;
				if (rs.next()) {
					s_index = new Study();
					s_index.setIndex(rs.getInt("s_index"));
				}
				return s_index;
			}
		});
		return index;
	}

	public ArrayList<StudyList> studylist(int s_index, int m_index) {
		@SuppressWarnings("unchecked")
		ArrayList<StudyList> list = (ArrayList<StudyList>) get(StudyList.QUERY_GET2, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, s_index);
				pstmt.setInt(2, m_index);

			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {

				ArrayList<StudyList> StudyListCheck = new ArrayList<>();
				while (rs.next()) {
					StudyList studycheck = new StudyList();
					studycheck.setStudyindex(rs.getInt(1));
					studycheck.setMemberindex(rs.getInt(2));
					StudyListCheck.add(studycheck);
				}
				return StudyListCheck;
			}
		});

		return list;
		// TODO Auto-generated method stub

	}

	// 로그인할때 인덱스 번호를 가져오기
	public Login getIndex(String id) {
		Login index = (Login) get(Login.QUERY_GET3, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, id);
			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				Login innerIndex = null;
				if (rs.next()) {
					innerIndex = new Login();
					innerIndex.setIndex(rs.getInt(1));
				}
				return innerIndex;
			}
		});
		return index;
	}

	public Find getFind(String name) {
		Find find = (Find) get(Find.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, name); // 바인딩변수를 채워주기위해서 데이터 세터블을 매개변수 추가하며 오버로딩을한다.
			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				Find innerLogin = null;
				if (rs.next()) {
					innerLogin = new Find();
					innerLogin.setId(rs.getString(1));
					innerLogin.setName(rs.getString(2));
				}
				return innerLogin;
			}
		});
		return find;
	}

		public Find getEmail(String email) {
			Find find = (Find) get(Find.QUERY_GET2, new DataSettable() {

				@Override
				public void prepare(PreparedStatement pstmt) throws SQLException {
					pstmt.setString(1, email); // 바인딩변수를 채워주기위해서 데이터 세터블을 매개변수 추가하며 오버로딩을한다.
				}
			}, new DataGettable() {

				@Override
				public Object onGetResult(ResultSet rs) throws SQLException {
					Find innerLogin = null;
					if (rs.next()) {
						innerLogin = new Find();
						innerLogin.setId(rs.getString(1));
						innerLogin.setEmail(rs.getString(2));
					}
					return innerLogin; 
				}
			});
			return find; 
		}
	
	
				//구명회파트
				@SuppressWarnings("unchecked")
				public ArrayList<MemberAttendanceBean> getAttends(int meetingId){
					return (ArrayList<MemberAttendanceBean>) get(MemberAttendanceBean.QUERY_GET,new DataSettable() {
						
						@Override
						public void prepare(PreparedStatement pstmt) throws SQLException {
							pstmt.setInt(1, meetingId);
						}
					}  ,new DataGettable() {
						@Override
						public Object onGetResult(ResultSet rs) throws SQLException {
							ArrayList<MemberAttendanceBean> results = new ArrayList<>();
							while(rs.next()) {
								MemberAttendanceBean bean = new MemberAttendanceBean();
								bean.setMemberId(rs.getInt(1));
								bean.setMemberName(rs.getString(2));
								bean.setAttend(rs.getString(3));
								results.add(bean);
							}
							return results;
						}
					});
				}
			@SuppressWarnings("unchecked")
			public ArrayList<ScheduleBean> getSchedules(String studyName){
				return (ArrayList<ScheduleBean>) get(ScheduleBean.QUERY_GET,new DataSettable() {
					
					@Override
					public void prepare(PreparedStatement pstmt) throws SQLException {
						pstmt.setString(1, studyName);
					}
				}  ,new DataGettable() {
					@Override
					public Object onGetResult(ResultSet rs) throws SQLException {
						ArrayList<ScheduleBean> results = new ArrayList<>();
						while(rs.next()) {
							ScheduleBean bean = new ScheduleBean();
							bean.setId(rs.getInt(1));
							bean.setTitle(rs.getString(2));;
							bean.setStart(DateConverter.getDateString(rs.getTimestamp(3)));;
							results.add(bean);
						}
						return results;
					}
				});
			}
				public Meeting getEachSchedules(String studyName, int meetingId){
					return (Meeting) get(Meeting.QUERY_GET, new DataSettable() {
						
						@Override
						public void prepare(PreparedStatement pstmt) throws SQLException {
							pstmt.setString(1, studyName);
							pstmt.setInt(2, meetingId);
						}
					}  ,new DataGettable() {
						@Override
						public Object onGetResult(ResultSet rs) throws SQLException {
							Meeting result = new Meeting();
							if(rs.next());{
								result.setPlace(rs.getString(1));
								result.setTimestampate(rs.getTimestamp(2));
								result.setExpectedFee(rs.getInt(3));
								result.setComment(rs.getString(4));
							}
							return result;
						}
					});
				}
				
		public boolean isAttendChecked(int meetingId){
			return (boolean) get(Queries.IS_ATTENDANCE_CHECKED, new DataSettable() {
				
				@Override
				public void prepare(PreparedStatement pstmt) throws SQLException {
					pstmt.setInt(1, meetingId);
				}
			}  ,new DataGettable() {
				@Override
				public Object onGetResult(ResultSet rs) throws SQLException {
					rs.next();
					if(rs.getInt(1) != 0) {
						return true;
					} else {
						return false;
					}
				}
			});
		}

	// 공용
	@SuppressWarnings("unchecked")
	public ArrayList<Integer> getMemberIndexes(String studyName) {
		return (ArrayList<Integer>) get(Queries.GET_STUDY_MEMBER, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, studyName);
			}
		}, new DataGettable() {
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				ArrayList<Integer> results = new ArrayList<>();
				while (rs.next()) {
					results.add(rs.getInt(1));
				}
				return results;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Integer> getMemberIndexes(int studyIndex) {
		return (ArrayList<Integer>) get(StudyMember.QUERY_GET_MEMBERS, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, studyIndex);
			}
		}, new DataGettable() {
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				ArrayList<Integer> results = new ArrayList<>();
				while (rs.next()) {
					results.add(rs.getInt(1));
				}
				return results;
			}
		});
	}

	public int getStudyIndex(String studyName) {
		return (int) get(Queries.GET_STUDY_ID, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, studyName);
			}
		}, new DataGettable() {
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				rs.next();
				return rs.getInt(1);
			}
		});
	}

	@SuppressWarnings("unchecked")
	public ArrayList<String> getMemberNames(String studyName) {
		return (ArrayList<String>) get(Queries.GET_STUDY_MEMBER, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				System.out.println(studyName);
				pstmt.setString(1, studyName);
			}
		}, new DataGettable() {
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				ArrayList<String> results = new ArrayList<>();
				while(rs.next()) {
					results.add(rs.getString(2));
				}
				return results;
			}
		});
	}

	/*
	 * public int[] getMemIndex(int studyIndex) {
	 * 
	 * int[] Index1 = (int[]) get(Member2.QUERY_GET_INDEX, new DataSettable() {
	 * 
	 * @Override public void prepare(PreparedStatement pstmt) throws SQLException {
	 * // TODO Auto-generated method stub pstmt.setInt(1, studyIndex); }
	 * 
	 * }, new DataGettable() {
	 * 
	 * @Override public int[] onGetResult(ResultSet rs) throws SQLException { int[]
	 * index = new int[100]; int i = 0; while (rs.next()) { index[i] = rs.getInt(1);
	 * i++; } return index; } });
	 * 
	 * return Index1; }
	 */

	@SuppressWarnings("unchecked")
	public ArrayList<FeeSpend> getFeeExpense(int meetingId) {
		return (ArrayList<FeeSpend>) get(FeeSpend.QUERY_GET, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, meetingId);
			}
		}, new DataGettable() {
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				ArrayList<FeeSpend> result = new ArrayList<>();
				while (rs.next()) {
					FeeSpend fs = new FeeSpend();
					fs.setExpense(rs.getInt(1));
					fs.setComment(rs.getString(2));
					result.add(fs);
				}
				return result;
			}
		});
	}

	@SuppressWarnings("unchecked")
	public ArrayList<FeeCollectListBean> getFeeMember(int meetingId) {
		return (ArrayList<FeeCollectListBean>) get(FeeCollectListBean.QUERY_GET, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, meetingId);
			}
		}, new DataGettable() {
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				ArrayList<FeeCollectListBean> result = new ArrayList<>();
				while (rs.next()) {
					FeeCollectListBean fs = new FeeCollectListBean();
					fs.setMemberName(rs.getString(1));
					fs.setFee(rs.getInt(2));
					fs.setNote(rs.getString(3));
					result.add(fs);
				}
				return result;
			}
		});
	}

	public int getFeeSpentTotal(int meetingId) {
		return (int) get(Queries.GET_TOTAL_SPENT_FEE, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, meetingId);
			}
		}, new DataGettable() {
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				rs.next();
				return rs.getInt(1);
			}
		});
	}

	public int getFeeCollectTotal(int meetingId) {
		return (int) get(Queries.GET_TOTAL_COLLECT_FEE, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, meetingId);
			}
		}, new DataGettable() {
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				rs.next();
				return rs.getInt(1);
			}
		});
	}
	/*
	 * private ArrayList<?> getBean(ResultSet rs, Class<?> beanClass) throws
	 * SQLException{ Field[] fields = beanClass.getDeclaredFields();
	 * ArrayList<beanClass> objects = new ArrayList<>(); for(int i = 0; i <
	 * fields.length; i++) { rs.next(); switch(fields[i].getType().toString()) {
	 * case "int" : objects.add(rs.getInt(i+1)); break; case "String" :
	 * objects.add(rs.getString(i+1)); break;
	 * 
	 */

	public boolean isFeeRegistered(String meetingId) {
		return (boolean) get(Queries.IS_FEE_REGISTERED, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, meetingId);
			}
		}, new DataGettable() {
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				rs.next();
				if (rs.getInt(1) == 0) {
					return false;
				} else {
					return true;
				}
			}
		});

	}

	// 스터디 설정에서 카테고리 가져오는 메소드
	public String[] getSubCategory(String mainCategory) {

			String[] SubCategory = (String[]) get(InformSetup.QUERY_GET_CATEGORY2, new DataSettable() {

				@Override
				public void prepare(PreparedStatement pstmt) throws SQLException {
					// TODO Auto-generated method stub
					pstmt.setString(1, mainCategory);
				}

			}, new DataGettable() {

				@Override
				public String[] onGetResult(ResultSet rs) throws SQLException {
					String[] cate = new String[getSubCategoryCount(mainCategory)];
					int i = 0;
					while (rs.next()) {
						cate[i] = rs.getString(1);
						i++;
					}
					return cate;
				}
			});

			return SubCategory;
		}
	
	public int getSubCategoryCount(String mainCategory) {

		int SubCategoryCount = (int) get(InformSetup.QUERY_GET_CATEGORY2_COUNT, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, mainCategory);
			}

		}, new DataGettable() {

			@Override
			public Integer onGetResult(ResultSet rs) throws SQLException {
				int count = 0;
				while (rs.next()) {
					count = rs.getInt(1);
				}
				return count;
			}
		});

		return SubCategoryCount;
	}
	
	public String[] getMainCategory() {

		String[] mainCategory = (String[]) get(InformSetup.QUERY_GET_CATEGORY1, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
			}

		}, new DataGettable() {

			@Override
			public String[] onGetResult(ResultSet rs) throws SQLException {
				String[] cate = new String[getMainCategoryCount()];
				int i = 0;
				while (rs.next()) {
					cate[i] = rs.getString(1);
					i++;
				}
				return cate;
			}
		});

		return mainCategory;
	}
	
	public int getMainCategoryCount() {

		int MainCategoryCount = (int) get(InformSetup.QUERY_GET_CATEGORY1_COUNT, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
			}

		}, new DataGettable() {

			@Override
			public Integer onGetResult(ResultSet rs) throws SQLException {
				int count = 0;
				while (rs.next()) {
					count = rs.getInt(1);
				}
				return count;
			}
		});

		return MainCategoryCount;
	}
	
	public int getCategoryNum(String category1, String category2) {

		int categoryNum = (int) get(InformSetup.QUERY_GET_CATEGORY_NUM, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, category1);
				pstmt.setString(2, category2);
			}

		}, new DataGettable() {

			@Override
			public Integer onGetResult(ResultSet rs) throws SQLException {
				int num = 0;
				while (rs.next()) {
					num = rs.getInt(1);
				}
				return num;
			}
		});

		return categoryNum;
	}

}
