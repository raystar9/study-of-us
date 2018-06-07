package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.prototype.Member;
import beans.prototype.Study;
import beans.root.Find;
import beans.root.Login;
import beans.study.StudyListCount;
import beans.study.StudyListSelect;
import beans.study.StudyListSelect2;
import beans.study.StudySearch;
import beans.study.each.InformSetup;
import beans.study.each.InformSetupMember;
import beans.study.each.Member2;
import beans.study.each.board.BoardListBean;
import beans.study.each.board.BoardViewRegisterBean;
import beans.study.each.board.CommentBean;
import dao.interfaces.DataGettable;
import dao.interfaces.DataSettable;
import exceptionHandler.ExceptionHandler;
import exceptionHandler.TryGetObject;

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
					innerLogin.setIndex(rs.getInt(3));
				}
				return innerLogin; // ongetresult 로 리턴해주고.
			}
		});
		return login; // 나를 불러준 get 로그인한테 리턴해준다.
	}

	// 게시판에 들어갔을 때 나오는 목록 데이터를 가져오는 메소드
	public ArrayList<BoardListBean> getBoardList(int page, int limit, int studyIndex) {

		@SuppressWarnings("unchecked")
		ArrayList<BoardListBean> list = (ArrayList<BoardListBean>) get(BoardListBean.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				// 아직 뭐 들어갈지 몰라서 정의하지 않았음
				int startrow = (page - 1) * limit + 1; // 읽기 시작할 row 번호( 1 11 21 )
				int endrow = startrow + limit - 1; // 읽을 마지막 row 번호( 10 20 30 )
				pstmt.setInt(1, studyIndex);
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);

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
					board.setDate(rs.getString(4));
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
	public BoardViewRegisterBean getBoardView(int num, int studyIndex) {

		BoardViewRegisterBean list = (BoardViewRegisterBean) get(BoardViewRegisterBean.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, studyIndex);
				pstmt.setInt(2, num);
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
				}
				return boardcontent;
			}
		});

		return list;
	}

	// 게시판의 글 개수를 가져오는 메소드
	public int getBoardCount(int studyIndex) {

		int boardcount = (int) get(BoardListBean.QUERY_GET_COUNT, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				// 아직 뭐 들어갈지 몰라서 정의하지 않았음
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
		ArrayList<Study> list = (ArrayList<Study>) get(Study.QUERY_GET3,new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				String place = "%%";
				String search = "%%";
				String second = "%%";
				
				if(placeVal!=null) {
					place = "%"+placeVal+"%";
				}
				if (searchVal != null) {
					search = "%" + searchVal + "%";
				}
				if(secondArray!=null) {
					second = "%"+secondArray+"%";
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
				
				if(placeVal!=null) {
					place = "%"+placeVal+"%";
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

	public int getInformMemberCount() {

		int membercount = (int) get(Member2.QUERY_GET_COUNT, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				// 아직 뭐 들어갈지 몰라서 정의하지 않았음
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

	public ArrayList<InformSetupMember> getInformMember() {
		@SuppressWarnings("unchecked")
		ArrayList<InformSetupMember> list = (ArrayList<InformSetupMember>) get(InformSetupMember.QUERY_GET,
				new DataSettable() {

					@Override
					public void prepare(PreparedStatement pstmt) throws SQLException {
						// TODO Auto-generated method stub
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

	public InformSetup getInformation() {
		InformSetup list = (InformSetup) get(InformSetup.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
			}

		}, new DataGettable() {

			@Override
			public InformSetup onGetResult(ResultSet rs) throws SQLException {
				InformSetup Inform = new InformSetup();
				while (rs.next()) {
					Inform.setIndex(rs.getInt(1));
					Inform.setCategory(rs.getString(2));
					Inform.setPeopleNum(rs.getString(3));
					Inform.setName(rs.getString(4));
					Inform.setPlace(rs.getString(5));
					Inform.setActivityTime(rs.getString(6));
					Inform.setStartDate(rs.getString(7));
					Inform.setEndDate(rs.getString(8));
					Inform.setDay(rs.getString(9));
					Inform.setExplain(rs.getString(10));
					Inform.setPrepared(rs.getString(11));
					Inform.setEffective(rs.getString(12));
				}
				return Inform;
			}
		});

		return list;
	}

	public ArrayList<CommentBean> getCommentList(int num) {
		@SuppressWarnings("unchecked")
		ArrayList<CommentBean> list = (ArrayList<CommentBean>) get(CommentBean.QUERY_GET, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setInt(1, num);
			}
		}, new DataGettable() {

			@Override
			public ArrayList<CommentBean> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<CommentBean> commentlist = new ArrayList<CommentBean>();
				while (rs.next()) {
					CommentBean comment = new CommentBean();
					comment.setName(rs.getString(1));
					comment.setDate(rs.getString(2));
					comment.setContent(rs.getString(3));
					comment.setCno(rs.getInt(4));
					comment.setBno(rs.getInt(5));
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
		ArrayList<Study> list = (ArrayList<Study>) get(Study.QUERY_GET4,new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
	
				pstmt.setInt(1, index);

			}
		}, new DataGettable() {

			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<Study> studies = new ArrayList<>();
				while(rs.next()) {
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
	


//아이디 찾을 떄 인덱스 번호 가져오기
	public Find getIndex2(String name) {
		Find index = (Find) get(Find.QUERY_GET3,new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, name);
			}
		},new DataGettable() {
			
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				Find innerIndex = null;
				if(rs.next()) {
					innerIndex = new Find();
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
					innerLogin.setName(rs.getString(1));
					innerLogin.setEmail(rs.getString(2));
				}
				return innerLogin; 
			}
		});
		return find; 
	}
		
// 스터디 count 수 가져오기
	public StudyListSelect getStudyListCount(int index) {
		StudyListSelect count = (StudyListSelect) get(StudyListSelect.QUERY_GET2,new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, index);
				
			}
		}, new DataGettable() {
			
			@Override
			public Object onGetResult(ResultSet rs) throws SQLException {
				StudyListSelect slist = null;
				if(rs.next()) {
					slist = new StudyListSelect();
					slist.setCount(rs.getInt("count"));
				}
				
				return slist;
			}
		});
		
		// TODO Auto-generated method stub
		return count;
	}
	
	
//		보여줄 스터디를 정리햇 ㅓ가져오기 
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
					sl.setS_peoplenum(rs.getInt("s_peoplenum"));
					sl.setStart(rs.getString("s_start"));
					sl.setEnd(rs.getString("s_end"));
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
				if(rs.next()) { 
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
		ArrayList<StudyListSelect> dday = (ArrayList<StudyListSelect>) get(StudyListSelect.QUERY_GET4,new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				int startrow = (page - 1 ) * limit + 1;
				int endrow = startrow + limit -1;
				pstmt.setInt(1, index);
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
			}
		}, new DataGettable() {
			
			@Override
			public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
				ArrayList<StudyListSelect> days = new ArrayList<>();
				while(rs.next()) {
					StudyListSelect day = new StudyListSelect();
					day.setDday(rs.getInt("dday"));
					days.add(day);
				}
				
				return days;
				
			}
		});
		return dday;
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
	
	// 스터디 count 수 가져오기
		public StudyListSelect2 getStudyListCount2(int index) {
			StudyListSelect2 count = (StudyListSelect2) get(StudyListSelect2.QUERY_GET2,new DataSettable() {
				
				@Override
				public void prepare(PreparedStatement pstmt) throws SQLException {
					pstmt.setInt(1, index);
					
				}
			}, new DataGettable() {
				
				@Override
				public Object onGetResult(ResultSet rs) throws SQLException {
					StudyListSelect2 slist = null;
					if(rs.next()) {
						slist = new StudyListSelect2();
						slist.setCount(rs.getInt("count"));
					}
					
					return slist;
				}
			});
			
			// TODO Auto-generated method stub
			return count;
		}
	
		public ArrayList<StudyListSelect2> getStudyList2(int index, int page, int limit) {
			@SuppressWarnings("unchecked")
			ArrayList<StudyListSelect2> studylist = (ArrayList<StudyListSelect2>) get(StudyListSelect2.QUERY_GET3 , new DataSettable() {
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
							ArrayList<StudyListSelect2> studylists = new ArrayList<>();
							while(rs.next()) {
								StudyListSelect2 sl = new StudyListSelect2();
								
								sl.setProgress(rs.getInt("progress"));
								sl.setS_name(rs.getString("s_name"));
								sl.setS_peoplenum(rs.getInt("s_peoplenum"));
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
			ArrayList<StudyListSelect2> dday = (ArrayList<StudyListSelect2>) get(StudyListSelect2.QUERY_GET4,new DataSettable() {
				@Override
				public void prepare(PreparedStatement pstmt) throws SQLException {
					int startrow = (page - 1 ) * limit + 1;
					int endrow = startrow + limit -1;
					pstmt.setInt(1, index);
					pstmt.setInt(2, startrow);
					pstmt.setInt(3, endrow);
				}
			}, new DataGettable() {
				
				@Override
				public ArrayList<?> onGetResult(ResultSet rs) throws SQLException {
					ArrayList<StudyListSelect2> days = new ArrayList<>();
					while(rs.next()) {
						StudyListSelect2 day = new StudyListSelect2();
						day.setDday(rs.getInt("dday"));
						days.add(day);
					}
					
					return days;
					
				}
			});
			return dday;
		}
		
		
		
}
















