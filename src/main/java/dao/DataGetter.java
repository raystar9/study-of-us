package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.prototype.Comment;
import beans.prototype.Inquiry;
import beans.prototype.Member;
import beans.prototype.Study;
import beans.prototype.StudyList;
import beans.root.Find;

import beans.root.Login;
import beans.study.StudyListCount;
import beans.study.StudyListSelect;
import beans.study.StudyListSelect2;
import beans.study.StudySearch;
import beans.study.StudySearchMain;
import beans.study.each.InformSetup;
import beans.study.each.InformSetupMember;
import beans.study.each.attendacne.MemberAttendanceBean;
import beans.study.each.Message;
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
import servlet.root.InquiryComment;

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

	public ArrayList<StudySearch> getStudies(String search, String location, String category, String subcategory,
			String day, String time) {
		@SuppressWarnings("unchecked")
		ArrayList<StudySearch> list = (ArrayList<StudySearch>) get(StudySearch.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				System.out.println("search : " + search + " location : " + location + " category : " + category
						+ " subcategory : " + subcategory + " day : " + day + " time : " + time);
				pstmt.setString(1, search);
				pstmt.setString(2, location);
				pstmt.setString(3, category);
				pstmt.setString(4, subcategory);
				pstmt.setString(5, day);
				pstmt.setString(6, time);

			}
		}, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<StudySearch> studies = new ArrayList<>();
				while (rs.next()) {
					StudySearch study = new StudySearch();
					study.setIndex(rs.getInt("s_index"));
					study.setName(rs.getString("s_name"));
					study.setS_c_id(rs.getInt("s_c_id"));
					study.setS_mt_index(rs.getInt("s_mt_index"));
					study.setS_m_index(rs.getInt("s_m_index"));
					study.setStart(rs.getDate("s_start"));
					study.setEnd(rs.getDate("s_end"));
					study.setMaxmember(rs.getInt("s_maxmember"));
					study.setDay(rs.getString("s_day"));
					study.setTime(rs.getString("s_time"));
					study.setExplain(rs.getString("s_explain"));
					study.setMaterial(rs.getString("s_material"));
					study.setEffect(rs.getString("s_effect"));
					study.setPlace(rs.getString("s_place"));

					studies.add(study);
				}
				return studies;
			}
		});

		// TODO Auto-generated method stub
		return list;
	}

	public ArrayList<StudySearch> getStudies(String search, String location, String category, String subcategory,
			String day, String time, int startcount, int endcount) {
		@SuppressWarnings("unchecked")
		ArrayList<StudySearch> list = (ArrayList<StudySearch>) get(StudySearch.QUERY_GET2, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, search);
				pstmt.setString(2, location);
				pstmt.setString(3, category);
				pstmt.setString(4, subcategory);
				pstmt.setString(5, day);
				pstmt.setString(6, time);
				pstmt.setInt(7, startcount);
				pstmt.setInt(8, endcount);

			}
		}, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<StudySearch> studies = new ArrayList<>();
				while (rs.next()) {
					StudySearch study = new StudySearch();
					study.setIndex(rs.getInt("s_index"));
					study.setName(rs.getString("s_name"));
					study.setS_c_id(rs.getInt("s_c_id"));
					study.setS_mt_index(rs.getInt("s_mt_index"));
					study.setS_m_index(rs.getInt("s_m_index"));
					study.setStart(rs.getDate("s_start"));
					study.setEnd(rs.getDate("s_end"));
					study.setMaxmember(rs.getInt("s_maxmember"));
					study.setDay(rs.getString("s_day"));
					study.setTime(rs.getString("s_time"));
					study.setExplain(rs.getString("s_explain"));
					study.setMaterial(rs.getString("s_material"));
					study.setEffect(rs.getString("s_effect"));
					study.setPlace(rs.getString("s_place"));

					studies.add(study);
				}
				return studies;
			}
		});

		// TODO Auto-generated method stub
		return list;
	}

	public ArrayList<Study> getStudies(String search) {
		@SuppressWarnings("unchecked")
		ArrayList<Study> list = (ArrayList<Study>) get(StudySearch.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, search);
			}
		}, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<Study> studies = new ArrayList<>();
				while (rs.next()) {
					Study study = new Study();
					study.setIndex(rs.getInt(1));
					study.setName(rs.getString(2));
					study.setS_c_id(rs.getInt(3));
					study.setS_mt_index(rs.getInt(4));
					study.setS_m_index(rs.getInt(5));
					study.setStart(rs.getDate(6));
					study.setEnd(rs.getDate(7));
					study.setMaxmember(rs.getInt(8));
					study.setDay(rs.getString(9));
					study.setTime(rs.getString(10));
					study.setExplain(rs.getString(11));
					study.setMaterial(rs.getString(12));
					study.setEffect(rs.getString(13));
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
					StudySearch study = new StudySearch();
					study.setIndex(rs.getInt(1));
					study.setName(rs.getString(2));
					study.setS_c_id(rs.getInt(3));
					study.setS_mt_index(rs.getInt(4));
					study.setS_m_index(rs.getInt(5));
					study.setStart(rs.getDate(6));
					study.setEnd(rs.getDate(7));
					study.setMaxmember(rs.getInt(8));
					study.setDay(rs.getString(9));
					study.setTime(rs.getString(10));
					study.setExplain(rs.getString(11));
					study.setMaterial(rs.getString(12));
					study.setEffect(rs.getString(13));
					study.setPlace(rs.getString(14));

					StudySearchlist.add(study);
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
					innerLogin.setIndex(rs.getInt(3));
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
				while (rs.next()) {
					BoardListBean board = new BoardListBean();
					board.setIndex(rs.getInt(1));
					board.setTitle(rs.getString(2));
					board.setName(rs.getString(3));
					board.setDate(rs.getDate(4));
					board.setFilename(rs.getString(5));
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
					study.setS_c_id(rs.getInt(3));
					study.setS_mt_index(rs.getInt(4));
					study.setS_m_index(rs.getInt(5));
					study.setStart(rs.getDate(6));
					study.setEnd(rs.getDate(7));
					study.setMaxmember(rs.getInt(8));
					study.setDay(rs.getString(9));
					study.setTime(rs.getString(10));
					study.setExplain(rs.getString(11));
					study.setMaterial(rs.getString(12));
					study.setEffect(rs.getString(13));
					study.setPlace(rs.getString(14));
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
					study.setS_c_id(rs.getInt(3));
					study.setS_mt_index(rs.getInt(4));
					study.setS_m_index(rs.getInt(5));
					study.setStart(rs.getDate(6));
					study.setEnd(rs.getDate(7));
					study.setMaxmember(rs.getInt(8));
					study.setDay(rs.getString(9));
					study.setTime(rs.getString(10));
					study.setExplain(rs.getString(11));
					study.setMaterial(rs.getString(12));
					study.setEffect(rs.getString(13));
					study.setPlace(rs.getString(14));

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

		return membercount+1;
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
					study.setS_c_id(rs.getInt(3));
					study.setS_mt_index(rs.getInt(4));
					study.setS_m_index(rs.getInt(5));
					study.setStart(rs.getDate(6));
					study.setEnd(rs.getDate(7));
					study.setMaxmember(rs.getInt(8));
					study.setDay(rs.getString(9));
					study.setTime(rs.getString(10));
					study.setExplain(rs.getString(11));
					study.setMaterial(rs.getString(12));
					study.setEffect(rs.getString(13));
					study.setPlace(rs.getString(14));

					studies.add(study);
				}
				return studies;
			}
		});

		// TODO Auto-generated method stub
		return list;
	}

	public ArrayList<Member> getStudy_m_id(int index) {
		@SuppressWarnings("unchecked")
		ArrayList<Member> list = (ArrayList<Member>) get(Message.QUERY_GET3, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {

				pstmt.setInt(1, index);

			}
		}, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<Member> studies = new ArrayList<>();
				while (rs.next()) {
					Member member = new Member();

					member.setId(rs.getString("m_id"));

					studies.add(member);
				}
				return studies;
			}
		});

		// TODO Auto-generated method stub
		return list;
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
		return count;
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
				ArrayList<StudyList> studies = new ArrayList<>();
				while (rs.next()) {
					StudyList study = new StudyList();
					study.setMemberindex(rs.getInt("SM_M_INDEX"));
					study.setStudyindex(rs.getInt("SM_S_INDEX"));
					studies.add(study);
				}
				return studies;
			}
		});

		// TODO Auto-generated method stub
		return list;
	}

	public ArrayList<Message> studyMessage(int s_index, int m_index) {
		@SuppressWarnings("unchecked")
		ArrayList<Message> list = (ArrayList<Message>) get(Message.QUERY_GET2, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, s_index);
				pstmt.setInt(2, m_index);

			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				ArrayList<Message> studies = new ArrayList<>();
				while (rs.next()) {
					Message study = new Message();
					study.setM_m_index(rs.getInt("m_m_index"));
					study.setM_s_index(rs.getInt("m_s_index"));
					studies.add(study);
				}
				return studies;
			}
		});

		// TODO Auto-generated method stub
		return list;
	}

	public ArrayList<StudySearch> getCategryStudies(String category) {
		@SuppressWarnings("unchecked")
		ArrayList<StudySearch> list = (ArrayList<StudySearch>) get(StudySearchMain.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, category);

			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				ArrayList<StudySearch> studies = new ArrayList<>();
				while (rs.next()) {
					StudySearch study = new StudySearch();
					study.setIndex(rs.getInt(1));
					study.setName(rs.getString(2));
					study.setS_c_id(rs.getInt(3));
					study.setS_mt_index(rs.getInt(4));
					study.setS_m_index(rs.getInt(5));
					study.setStart(rs.getDate(6));
					study.setEnd(rs.getDate(7));
					study.setMaxmember(rs.getInt(8));
					study.setDay(rs.getString(9));
					study.setTime(rs.getString(10));
					study.setExplain(rs.getString(11));
					study.setMaterial(rs.getString(12));
					study.setEffect(rs.getString(13));
					study.setPlace(rs.getString(14));

					studies.add(study);
				}
				return studies;
			}
		});

		// TODO Auto-generated method stub
		return list;
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
ArrayList<StudyListSelect> studylist = (ArrayList<StudyListSelect>) get(StudyListSelect.QUERY_GET3 , new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				//읽기 시작할 row 번호 1
				int startrow = (page - 1 ) * limit + 1;
				System.out.println("스타트로우" + startrow);
				//읽을 마지막 row 번호 2
				int endrow = startrow + limit -1;
				System.out.println("엔드로우" +endrow);
				
				pstmt.setInt(1, index);
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
			
				System.out.println(StudyListSelect.QUERY_GET3);
				
			}
		}, new DataGettable() {
			
			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<StudyListSelect> studylists = new ArrayList<>();
				while(rs.next()) {
					StudyListSelect sl = new StudyListSelect();
					
					sl.setProgress(rs.getInt("progress"));
					sl.setS_name(rs.getString("s_name"));
					sl.setS_maxmember(rs.getInt("s_maxmember"));
					sl.setStart(rs.getString("s_start").substring(0,11));
					sl.setEnd(rs.getString("s_end").substring(0,11));
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

	public ArrayList<StudyListSelect> getDday(int index, int page, int limit) {
		@SuppressWarnings("unchecked")
		ArrayList<StudyListSelect> dday = (ArrayList<StudyListSelect>) get(StudyListSelect.QUERY_GET4,
				new DataSettable() {
					@Override
					public void prepare(PreparedStatement pstmt) throws SQLException {
						int startrow = (page - 1) * limit + 1;
						int endrow = startrow + limit - 1;
						pstmt.setInt(1, index);
						pstmt.setInt(2, startrow);
						pstmt.setInt(3, endrow);
					}
				}, new DataGettable() {

					@Override
					public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
						ArrayList<StudyListSelect> days = new ArrayList<>();
						while (rs.next()) {
							StudyListSelect day = new StudyListSelect();
							day.setDday(rs.getInt("dday"));
							days.add(day);
						}

						return days;

					}
				});
		return dday;
	}
	// TODO 어떤게 진짜인지 모름;;
	/*
	 * public ArrayList<StudyList> studylist(int s_index, int m_index) {
	 * 
	 * @SuppressWarnings("unchecked") ArrayList<StudyList> list =
	 * (ArrayList<StudyList>) get(StudyList.QUERY_GET2, new DataSettable() {
	 * 
	 * @Override public void prepare(PreparedStatement pstmt) throws SQLException {
	 * pstmt.setInt(1, s_index); pstmt.setInt(2, m_index);
	 * 
	 * } }, new DataGettable() {
	 * 
	 * @Override public Object onGetResult(ResultSet rs) throws SQLException {
	 * 
	 * ArrayList<StudyList> StudyListCheck = new ArrayList<>(); while (rs.next()) {
	 * StudyList studycheck = new StudyList();
	 * studycheck.setStudyindex(rs.getInt(1));
	 * studycheck.setMemberindex(rs.getInt(2)); StudyListCheck.add(studycheck);
	 * return list; // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 * }
	 */

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

	public Find getPass(String id) {
		Find find = (Find) get(Find.QUERY_GET3, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, id); // 바인딩변수를 채워주기위해서 데이터 세터블을 매개변수 추가하며 오버로딩을한다.
			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				Find innerLogin = null;
				if (rs.next()) {
					innerLogin = new Find();
					innerLogin.setId(rs.getString(1));
					innerLogin.setPassword(rs.getString(2));
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

	// 구명회파트
	@SuppressWarnings("unchecked")
	public ArrayList<MemberAttendanceBean> getAttends(int meetingId) {
		return (ArrayList<MemberAttendanceBean>) get(MemberAttendanceBean.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, meetingId);
			}
		}, new DataGettable() {
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				ArrayList<MemberAttendanceBean> results = new ArrayList<>();
				while (rs.next()) {
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
	public ArrayList<ScheduleBean> getSchedules(String studyName) {
		return (ArrayList<ScheduleBean>) get(ScheduleBean.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, studyName);
			}
		}, new DataGettable() {
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				ArrayList<ScheduleBean> results = new ArrayList<>();
				while (rs.next()) {
					ScheduleBean bean = new ScheduleBean();
					bean.setId(rs.getInt(1));
					bean.setTitle(rs.getString(2));
					;
					bean.setStart(DateConverter.getDateString(rs.getTimestamp(3)));
					;
					results.add(bean);
				}
				return results;
			}
		});
	}

	public Meeting getEachSchedules(String studyName, int meetingId) {
		return (Meeting) get(Meeting.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, studyName);
				pstmt.setInt(2, meetingId);
			}
		}, new DataGettable() {
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				Meeting result = new Meeting();
				if (rs.next())
					;
				{
					result.setPlace(rs.getString(1));
					result.setTimestampate(rs.getTimestamp(2));
					result.setExpectedFee(rs.getInt(3));
					result.setComment(rs.getString(4));
				}
				return result;
			}
		});
	}

	public boolean isAttendChecked(int meetingId) {
		return (boolean) get(Queries.IS_ATTENDANCE_CHECKED, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, meetingId);
			}
		}, new DataGettable() {
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				rs.next();
				if (rs.getInt(1) != 0) {
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
		return (ArrayList<Integer>) get(Queries.GET_STUDY_MEMBERS, new DataSettable() {
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
		return (ArrayList<String>) get(Queries.GET_STUDY_MEMBERS, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				System.out.println(studyName);
				pstmt.setString(1, studyName);
			}
		}, new DataGettable() {
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				ArrayList<String> results = new ArrayList<>();
				while (rs.next()) {
					results.add(rs.getString(2));
				}
				return results;
			}
		});
	}

	public String getMemberName(String studyName, int memberIndex) {
		return (String) get(Queries.GET_STUDY_MEMBER, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				System.out.println(studyName);
				pstmt.setString(1, studyName);
				pstmt.setInt(2, memberIndex);
			}
		}, new DataGettable() {
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				rs.next();
				return rs.getString(2);
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
	public StudyListSelect2 getStudyListCount2(int index) {
		StudyListSelect2 count = (StudyListSelect2) get(StudyListSelect2.QUERY_GET2, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, index);

			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				StudyListSelect2 slist = null;
				if (rs.next()) {
					slist = new StudyListSelect2();
					slist.setCount(rs.getInt("count"));
				}

				return slist;
			}
		});

		// TODO Auto-generated method stub
		return count;
	}

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

	public ArrayList<StudyListSelect2> getStudyList2(int index, int page, int limit) {
		@SuppressWarnings("unchecked")
		ArrayList<StudyListSelect2> studylist = (ArrayList<StudyListSelect2>) get(StudyListSelect2.QUERY_GET3,
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
						ArrayList<StudyListSelect2> studylists = new ArrayList<>();
						while (rs.next()) {
							StudyListSelect2 sl = new StudyListSelect2();

							sl.setProgress(rs.getInt("progress"));
							sl.setS_name(rs.getString("s_name"));
							sl.setS_maxmember(rs.getInt("s_maxmember"));
							sl.setStart(rs.getString("s_start"));
							sl.setEnd(rs.getString("s_end"));
							studylists.add(sl);
						}

						return studylists;
					}
				});
		return studylist;
	}

	public ArrayList<StudyListSelect2> getDday2(int index, int page, int limit) {
		@SuppressWarnings("unchecked")
		ArrayList<StudyListSelect2> dday = (ArrayList<StudyListSelect2>) get(StudyListSelect2.QUERY_GET4,
				new DataSettable() {
					@Override
					public void prepare(PreparedStatement pstmt) throws SQLException {
						int startrow = (page - 1) * limit + 1;
						int endrow = startrow + limit - 1;
						pstmt.setInt(1, index);
						pstmt.setInt(2, startrow);
						pstmt.setInt(3, endrow);
					}
				}, new DataGettable() {

					@Override
					public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
						ArrayList<StudyListSelect2> days = new ArrayList<>();
						while (rs.next()) {
							StudyListSelect2 day = new StudyListSelect2();
							day.setDday(rs.getInt("dday"));
							days.add(day);
						}

						return days;

					}
				});
		return dday;
	}

	public ArrayList<StudySearch> getprogramming() {
		@SuppressWarnings("unchecked")
		ArrayList<StudySearch> list = (ArrayList<StudySearch>) get(StudySearch.QUERY_GET4, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<StudySearch> studies = new ArrayList<>();
				while (rs.next()) {
					StudySearch study = new StudySearch();
					study.setIndex(rs.getInt("s_index"));
					study.setName(rs.getString("s_name"));
					study.setS_c_id(rs.getInt("s_c_id"));
					study.setS_mt_index(rs.getInt("s_mt_index"));
					study.setS_m_index(rs.getInt("s_m_index"));
					study.setStart(rs.getDate("s_start"));
					study.setEnd(rs.getDate("s_end"));
					study.setMaxmember(rs.getInt("s_maxmember"));
					study.setDay(rs.getString("s_day"));
					study.setTime(rs.getString("s_time"));
					study.setExplain(rs.getString("s_explain"));
					study.setMaterial(rs.getString("s_material"));
					study.setEffect(rs.getString("s_effect"));
					study.setPlace(rs.getString("s_place"));

					studies.add(study);
				}
				return studies;
			}
		});

		// TODO Auto-generated method stub
		return list;
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

	public ArrayList<Inquiry> getInquiryBoard(int index, int page, int limit) {
		@SuppressWarnings("unchecked")
		ArrayList<Inquiry> boardlist = (ArrayList<Inquiry>) get(Inquiry.QUERY_GET, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				int startrow = (page - 1) * limit + 1;
				System.out.println("inquiry startrow : " + startrow);

				int endrow = startrow + limit - 1;

				pstmt.setInt(1, index);
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);

			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				ArrayList<Inquiry> boardlists = new ArrayList<>();
				while (rs.next()) {
					Inquiry inquiry = new Inquiry();

					inquiry.setI_index(rs.getInt("i_index"));
					inquiry.setRnum(rs.getInt("rnum"));
					inquiry.setSubject(rs.getString("i_subject"));
					inquiry.setM_id(rs.getString("m_id"));
					inquiry.setDate(rs.getString("i_date"));
					boardlists.add(inquiry);
				}

				return boardlists;
			}
		});
		return boardlist;
	}

	// 문의 테이블 count 가져오기
	public Inquiry getInquiryCount(int index) {
		Inquiry count = (Inquiry) get(Inquiry.QUERY_COUNT, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, index);
			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				Inquiry inquiry = null;
				if (rs.next()) {
					inquiry = new Inquiry();
					inquiry.setCount(rs.getInt("count"));
				}
				return inquiry;
			}
		});
		return count;
	}

	public ArrayList<StudySearch> getlanguage() {
		@SuppressWarnings("unchecked")
		ArrayList<StudySearch> list = (ArrayList<StudySearch>) get(StudySearch.QUERY_GET5, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<StudySearch> studies = new ArrayList<>();
				while (rs.next()) {
					StudySearch study = new StudySearch();
					study.setIndex(rs.getInt("s_index"));
					study.setName(rs.getString("s_name"));
					study.setS_c_id(rs.getInt("s_c_id"));
					study.setS_mt_index(rs.getInt("s_mt_index"));
					study.setS_m_index(rs.getInt("s_m_index"));
					study.setStart(rs.getDate("s_start"));
					study.setEnd(rs.getDate("s_end"));
					study.setMaxmember(rs.getInt("s_maxmember"));
					study.setDay(rs.getString("s_day"));
					study.setTime(rs.getString("s_time"));
					study.setExplain(rs.getString("s_explain"));
					study.setMaterial(rs.getString("s_material"));
					study.setEffect(rs.getString("s_effect"));
					study.setPlace(rs.getString("s_place"));

					studies.add(study);
				}
				return studies;
			}
		});

		// TODO Auto-generated method stub
		return list;
	}

	public ArrayList<StudySearch> getcertificate() {
		@SuppressWarnings("unchecked")
		ArrayList<StudySearch> list = (ArrayList<StudySearch>) get(StudySearch.QUERY_GET6, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<StudySearch> studies = new ArrayList<>();
				while (rs.next()) {
					StudySearch study = new StudySearch();
					study.setIndex(rs.getInt("s_index"));
					study.setName(rs.getString("s_name"));
					study.setS_c_id(rs.getInt("s_c_id"));
					study.setS_mt_index(rs.getInt("s_mt_index"));
					study.setS_m_index(rs.getInt("s_m_index"));
					study.setStart(rs.getDate("s_start"));
					study.setEnd(rs.getDate("s_end"));
					study.setMaxmember(rs.getInt("s_maxmember"));
					study.setDay(rs.getString("s_day"));
					study.setTime(rs.getString("s_time"));
					study.setExplain(rs.getString("s_explain"));
					study.setMaterial(rs.getString("s_material"));
					study.setEffect(rs.getString("s_effect"));
					study.setPlace(rs.getString("s_place"));

					studies.add(study);
				}
				return studies;
			}
		});

		// TODO Auto-generated method stub
		return list;
	}

	public ArrayList<StudySearch> getCategryStudies(String category, int startcount, int endcount) {
		@SuppressWarnings("unchecked")
		ArrayList<StudySearch> list = (ArrayList<StudySearch>) get(StudySearch.QUERY_GET7, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, category);
				pstmt.setInt(2, startcount);
				pstmt.setInt(3, endcount);
			}
		}, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<StudySearch> studies = new ArrayList<>();
				while (rs.next()) {
					StudySearch study = new StudySearch();
					study.setIndex(rs.getInt("s_index"));
					study.setName(rs.getString("s_name"));
					study.setS_c_id(rs.getInt("s_c_id"));
					study.setS_mt_index(rs.getInt("s_mt_index"));
					study.setS_m_index(rs.getInt("s_m_index"));
					study.setStart(rs.getDate("s_start"));
					study.setEnd(rs.getDate("s_end"));
					study.setMaxmember(rs.getInt("s_maxmember"));
					study.setDay(rs.getString("s_day"));
					study.setTime(rs.getString("s_time"));
					study.setExplain(rs.getString("s_explain"));
					study.setMaterial(rs.getString("s_material"));
					study.setEffect(rs.getString("s_effect"));
					study.setPlace(rs.getString("s_place"));

					studies.add(study);
				}
				return studies;
			}
		});

		// TODO Auto-generated method stub
		return list;
	}

	public ArrayList<StudySearch> getMindex(String id) {

		String sql = "select M_INDEX from member where M_ID = ? ";

		@SuppressWarnings("unchecked")
		ArrayList<StudySearch> list = (ArrayList<StudySearch>) get(sql, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, id);
			}
		}, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<StudySearch> studies = new ArrayList<>();
				while (rs.next()) {
					StudySearch study = new StudySearch();
					study.setS_m_index(rs.getInt(1));
					studies.add(study);
				}
				return studies;

			}
		});
		return list;
	}

	public ArrayList<Message> getMessage(int messagecheck) {

		@SuppressWarnings("unchecked")
		ArrayList<Message> list = (ArrayList<Message>) get(Message.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, messagecheck);

			}
		}, new DataGettable() {

			@Override
			public ArrayList<Message> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<Message> Messagelist = new ArrayList<>();
				while (rs.next()) {
					Message message = new Message();
					message.setS_index(rs.getInt("MS_S_INDEX"));
					message.setM_m_id(rs.getString("M_M_ID"));
					message.setM_s_index(rs.getInt("M_S_INDEX"));
					message.setM_s_name(rs.getString("M_S_NAME"));
					message.setM_m_index(rs.getInt("M_M_INDEX"));
					Messagelist.add(message);
				}
				return Messagelist;
			}
		});

		return list;
	}

	public int getMessageIDcheck(String s_m_index) {
		String sql = "select s_m_index from study inner join member on study.s_m_index = member.m_index where m_ID = ?";
		int checkval = (int) get(sql, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, s_m_index);

			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				int result = 0;
				if (rs.next()) {
					result = rs.getInt(1);
				}
				return result;
			}
		});
		return checkval;
	}

	public Inquiry getInquiryBoardView(int num) {
		Inquiry inquiry = (Inquiry) get(Inquiry.QUERY_GET2, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, num);

			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				Inquiry view = null;
				if (rs.next()) {
					view = new Inquiry();
					view.setM_id(rs.getString("M_ID"));
					view.setSubject(rs.getString("I_SUBJECT"));
					view.setContent(rs.getString("i_content"));
					view.setFile(rs.getString("i_file"));
				}
				return view;
			}
		});

		return inquiry;
	}

	public ArrayList<Comment> getinquiryComment(int num) {
		@SuppressWarnings("unchecked")
		ArrayList<Comment> commentlist = (ArrayList<Comment>) get(Comment.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, num);
			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				ArrayList<Comment> comments = new ArrayList<>();
				while (rs.next()) {
					Comment cm = new Comment();
					cm.setM_id(rs.getString("m_id"));
					cm.setContent(rs.getString("comment_content"));
					cm.setDate(rs.getString("comment_date"));
					comments.add(cm);

				}
				return comments;
			}
		});
		return commentlist;
	}

	public ArrayList<Inquiry> getAdminInquiryBoard(int index, int page, int limit) {

		@SuppressWarnings("unchecked")
		ArrayList<Inquiry> boardlist = (ArrayList<Inquiry>) get(Inquiry.QUERY_ADMIN, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				int startrow = (page - 1) * limit + 1;
				System.out.println("inquiry startrow : " + startrow);

				int endrow = startrow + limit - 1;

				pstmt.setInt(1, startrow);
				pstmt.setInt(2, endrow);

			}
		}, new DataGettable() {

			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				ArrayList<Inquiry> boardlists = new ArrayList<>();
				while (rs.next()) {
					Inquiry inquiry = new Inquiry();

					inquiry.setI_index(rs.getInt("i_index"));
					inquiry.setRnum(rs.getInt("rnum"));
					inquiry.setSubject(rs.getString("i_subject"));
					inquiry.setM_id(rs.getString("m_id"));
					inquiry.setDate(rs.getString("i_date"));
					boardlists.add(inquiry);
				}

				return boardlists;
			}
		});
		return boardlist;
	}

	public Inquiry getAdminCount() {
		Inquiry count = (Inquiry) get(Inquiry.QUERY_ADMIN_COUNT, new DataGettable() {
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				Inquiry inquiry = null;
				if (rs.next()) {
					inquiry = new Inquiry();
					inquiry.setCount(rs.getInt("count"));
				}
				return inquiry;
			}
		});
		return count;
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

}