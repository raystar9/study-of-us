package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.prototype.Meeting;
import beans.prototype.Member;
import beans.prototype.Study;
import beans.study.each.InformSetup;
import beans.study.each.board.BoardViewRegisterBean;
import beans.study.each.board.CommentBean;
import dao.interfaces.DataSettable;

public class DataPoster extends DataSetter {

	public DataPoster(DatabaseAccounts user) {
		super(user);
	}

	public void postMembers(Member member) {

		/*
		 * DataSettable은 익명클래스로 구현하도록 되어있습니다. 외부 혹은 내부 클래스로 선언하여 실제로 구현하여 매개변수로 넣어줄 수도
		 * 있지만 익명클래스로 처리하는 쪽이 더 간결해 보인다고 생각했습니다.
		 */
		set(Member.QUERY_POST, new DataSettable() { // 콜백함수를 통해 setteble 안에있는 prepare 를 사용한다.
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getName());
				pstmt.setString(3, member.getPassword());
				pstmt.setString(4, member.getEmail());
				pstmt.setInt(5, member.getTel());
				pstmt.setString(6, member.getAddress());
				pstmt.setString(7, member.getGender());
				pstmt.setString(8, member.getIntroduce());
				pstmt.executeUpdate();
				pstmt.close();

			}
		});

	}

	public void postBoard(BoardViewRegisterBean board, int studyIndex) {

		// 콜백함수를 통해 setteble 안에있는 prepare 를 사용한다.
		set(BoardViewRegisterBean.QUERY_POST, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, board.getName());
				pstmt.setString(2, board.getTitle());
				pstmt.setString(3, board.getContent());
				pstmt.setInt(4, studyIndex);
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
	}
	
	public void postBoardModify(BoardViewRegisterBean board, int studyIndex) {

		// 콜백함수를 통해 setteble 안에있는 prepare 를 사용한다.
		set(BoardViewRegisterBean.QUERY_PUT, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, board.getTitle());
				pstmt.setString(2, board.getName());
				pstmt.setString(3, board.getDate());
				pstmt.setString(4, board.getContent());
				pstmt.setInt(5, studyIndex);
				pstmt.setInt(6, board.getIndex());
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
	}
	
	public void postMeeting(Meeting meeting) {
		
		set(Meeting.QUERY_POST, new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, meeting.getLocation());
				pstmt.close();
			}
		});
	}
	public void postBoardDelete(int num, int studyIndex) {

		// 콜백함수를 통해 setteble 안에있는 prepare 를 사용한다.
		set(BoardViewRegisterBean.QUERY_DELETE, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, studyIndex);
				pstmt.setInt(2, num);
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
	}

	
	public void postSetup(InformSetup setup) {

		// 콜백함수를 통해 setteble 안에있는 prepare 를 사용한다.
		set(InformSetup.QUERY_PUT, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, setup.getCategory());
				pstmt.setString(2, setup.getPeopleNum());
				pstmt.setString(3, setup.getName());
				pstmt.setString(4, setup.getPlace());
				pstmt.setString(5, setup.getActivityTime());
				pstmt.setString(6, setup.getStartDate());
				pstmt.setString(7, setup.getEndDate());
				pstmt.setString(8, setup.getDay());
				pstmt.setString(9, setup.getExplain());
				pstmt.setString(10, setup.getPrepared());
				pstmt.setString(11, setup.getEffective());
				/*pstmt.setInt(12, index);	where절에 넣을 스터디번호*/
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
	}
				
	public void postStudy(Study study) {
		
		set(Study.QUERY_POST, new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, study.getName());
				pstmt.setInt(2, study.getC_id());
				pstmt.setDate(3, study.getStart());
				pstmt.setDate(4, study.getEnd());
				pstmt.setInt(5, study.getPeoplenum());
				pstmt.setString(6, study.getDay());
				pstmt.setString(7, study.getTime());
				pstmt.setString(8,study.getExplain());
				pstmt.setString(9, study.getPrepared());
				pstmt.setString(10, study.getEffective());
				pstmt.setString(11, study.getPlace());
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
	}
	
public void postComment(CommentBean comment) {
		
		set(CommentBean.QUERY_POST, new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, comment.getName());
				pstmt.setString(2, comment.getDate());
				pstmt.setString(3, comment.getContent());
				pstmt.setInt(4, comment.getCno());
				pstmt.setInt(5, comment.getBno());
				
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
	}
}
