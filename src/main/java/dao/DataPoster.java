package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.prototype.Meeting;
import beans.prototype.Member;
import beans.prototype.Study;
import beans.study.each.board.BoardViewRegisterBean;
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

	public void postBoard(BoardViewRegisterBean board) {

		// 콜백함수를 통해 setteble 안에있는 prepare 를 사용한다.
		set(BoardViewRegisterBean.QUERY_POST, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, board.getName());
				pstmt.setString(2, board.getTitle());
				pstmt.setString(3, board.getContent());
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
	}
	
	public void postBoardModify(BoardViewRegisterBean board) {

		// 콜백함수를 통해 setteble 안에있는 prepare 를 사용한다.
		set(BoardViewRegisterBean.QUERY_PUT, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, board.getTitle());
				pstmt.setString(2, board.getName());
				pstmt.setString(3, board.getDate());
				pstmt.setString(4, board.getContent());
				pstmt.setInt(5, board.getIndex());
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
	public void postBoardDelete(int num) {

		// 콜백함수를 통해 setteble 안에있는 prepare 를 사용한다.
		set(BoardViewRegisterBean.QUERY_DELETE, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, num);
				
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
}
