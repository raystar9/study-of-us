package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.prototype.Comment;
import beans.prototype.Inquiry;
import beans.prototype.Member;
import beans.prototype.Study;
import beans.prototype.StudyList;
import beans.study.each.InformSetup;
import beans.study.each.Message;
import beans.study.each.board.BoardViewRegisterBean;
import beans.study.each.board.CommentBean;
import beans.study.each.fee.CashExpenseBean;
import beansNew.Attend;
import beansNew.FeeCollect;
import beansNew.FeeSpend;
import beansNew.Meeting;
import dao.interfaces.DataSettable;
import dateConverter.DateConverter;

public class DataPoster extends DataSetter {

	public DataPoster(DatabaseAccounts user) {
		super(user);
	}

	public int postMembers(Member member) {

		/*
		 * DataSettable은 익명클래스로 구현하도록 되어있습니다. 외부 혹은 내부 클래스로 선언하여 실제로 구현하여 매개변수로 넣어줄 수도
		 * 있지만 익명클래스로 처리하는 쪽이 더 간결해 보인다고 생각했습니다.
		 */
		set(Member.QUERY_POST, new DataSettable() { // 콜백함수를 통해 setteble 안에있는 prepare 를 사용한다.
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getId());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setString(4, member.getEmail());
				pstmt.setString(5, member.getTel());
				pstmt.setString(6, member.getAddress());
				pstmt.setString(7, member.getGender());
				pstmt.setString(8, member.getIntroduce());
				pstmt.executeUpdate();
				pstmt.close();

			}
		});
		return 1;
	}

	public void postBoard(BoardViewRegisterBean board, int studyIndex, int personIndex) {

		// 콜백함수를 통해 setteble 안에있는 prepare 를 사용한다.
		set(BoardViewRegisterBean.QUERY_POST, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, studyIndex);
				pstmt.setInt(2, personIndex);
				pstmt.setString(3, board.getTitle());
				pstmt.setString(4, board.getContent());
				pstmt.setString(5, board.getFilename());
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
				pstmt.setString(2, board.getContent());
				pstmt.setInt(3, studyIndex);
				pstmt.setInt(4, board.getIndex());
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
	}

	public void postMeeting(Meeting meeting) {

		set(Meeting.QUERY_POST, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, meeting.getStudyId());
				pstmt.setString(2, meeting.getPlace());
				pstmt.setTimestamp(3, meeting.getTimestamp());
				pstmt.setInt(4, meeting.getExpectedFee());
				pstmt.setString(5, meeting.getComment());
				pstmt.executeUpdate();
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

	public void postSetup(InformSetup setup, int studyIndex, int categoryNum) {

		// 콜백함수를 통해 setteble 안에있는 prepare 를 사용한다.
		set(InformSetup.QUERY_PUT, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, setup.getPeopleNum());
				pstmt.setString(2, setup.getName());
				pstmt.setString(3, setup.getPlace());
				pstmt.setDate(4, DateConverter.convertDate(setup.getActivityTime()));
				pstmt.setDate(5, DateConverter.convertDate(setup.getStartDate()));
				pstmt.setDate(6, DateConverter.convertDate(setup.getEndDate()));
				pstmt.setString(7, setup.getDay());
				pstmt.setString(8, setup.getExplain());
				pstmt.setString(9, setup.getPrepared());
				pstmt.setString(10, setup.getEffective());
				/* pstmt.setInt(12, index); where절에 넣을 스터디번호 */
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
	}

	public int postStudy(Study study) {
		set(Study.QUERY_POST, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, study.getName());
				pstmt.setInt(2, study.getS_c_id());
				pstmt.setInt(3, study.getS_m_index());
				pstmt.setDate(4, study.getStart());
				pstmt.setDate(5, study.getEnd());
				pstmt.setInt(6, study.getMaxmember());
				pstmt.setString(7, study.getDay());
				pstmt.setString(8, study.getTime());
				pstmt.setString(9, study.getExplain());
				pstmt.setString(10, study.getMaterial());
				pstmt.setString(11, study.getEffect());
				pstmt.setString(12, study.getPlace());
				pstmt.executeUpdate();
				pstmt.close();
				
			}
		});
		return 1;
	}

	public void postComment(CommentBean comment) {
		
		set(CommentBean.QUERY_POST, new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, comment.getBno());
				pstmt.setInt(2, comment.getPersonIndex());
				pstmt.setString(3, comment.getContent());
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
	}

	
	public void Insertindex(int s_index, int m_index) {
		
		set(StudyList.QUERY_POST, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, s_index);
				pstmt.setInt(2, m_index);
				
				pstmt.executeUpdate();
				pstmt.close();
				
			}
		}
		);
	}

	public void postCommentDelete(int bno,int cno) {

		set(CommentBean.QUERY_DELETE, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, bno);
				pstmt.setInt(2, cno);
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
	}

	public void postCommentInsert(CommentBean comment) {

		set(CommentBean.QUERY_POST, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, comment.getBno());
				pstmt.setInt(2, comment.getPersonIndex());
				pstmt.setString(3, comment.getContent());
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
	}

	public void postCommentUpdate(String content, int cno, int bno) {

		set(CommentBean.QUERY_PUT, new DataSettable() {

			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, content);
				pstmt.setInt(2, cno);
				pstmt.setInt(3, bno);
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
	}

	
	public void postStudyList(int m_index, int s_index) {
		set(StudyList.QUERY_POST,new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, s_index);
				pstmt.setInt(2, m_index);
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
	}
	
	//구명회 파트
	
	public void postAttend(ArrayList<Attend> attends) {
		for(Attend attend : attends) {
			set(Attend.QUERY_POST, new DataSettable() {
				@Override
				public void prepare(PreparedStatement pstmt) throws SQLException {
					pstmt.setInt(1, attend.getMeetingId());
					pstmt.setInt(2, attend.getMemberId());
					pstmt.setString(3, attend.getAttend());
					pstmt.executeQuery();
					pstmt.close();
				}
			});
		}
	}
	
	public void postFeeMemberInsert(ArrayList<FeeCollect> collects) {
		for(FeeCollect collect : collects){	
			set(FeeCollect.QUERY_POST, new DataSettable() {
				
				@Override
				public void prepare(PreparedStatement pstmt) throws SQLException {
					pstmt.setInt(1, collect.getMemberId());
					pstmt.setInt(2, collect.getMeetingId());
					pstmt.setInt(3, collect.getFee());
					pstmt.setString(4, collect.getNote());
					pstmt.executeUpdate();
					pstmt.close();
					
				}
			});
		}
	}
	
	public void postExpenseInsert(ArrayList<CashExpenseBean> expense) {
		for(CashExpenseBean ex : expense){	
			set(CashExpenseBean.QUERY_POST, new DataSettable() {
				
				@Override
				public void prepare(PreparedStatement pstmt) throws SQLException {
					pstmt.setInt(1, ex.getExpense());
					pstmt.setString(2, ex.getContent());
					pstmt.executeUpdate();
					pstmt.close();
					
				}
			});
		}
	}

		public void postFeeSpend(ArrayList<FeeSpend> spends) {
			for(FeeSpend spend : spends) {
				set(FeeSpend.QUERY_POST, new DataSettable() {
					@Override
					public void prepare(PreparedStatement pstmt) throws SQLException {
						pstmt.setInt(1, spend.getMeetingId());
						pstmt.setInt(2, spend.getExpense());
						pstmt.setString(3, spend.getComment());
						pstmt.executeQuery();
						pstmt.close();
					}
				});
			}
		}
	



	public void setMessage(int s_index, int s_m_index, String m_id, String s_name, int m_m_index) {
		set(Message.QUERY_POST,new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, s_index);
				pstmt.setInt(2, s_m_index);
				pstmt.setString(3, m_id);
				pstmt.setString(4, s_name);
				pstmt.setInt(5, m_m_index);
				pstmt.executeUpdate();
				pstmt.close();
				
			}
		});
	}

	public void delMessage(int sm_s_index, int sm_m_index) {
		set(Message.QUERY_DELETE, new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, sm_s_index);
				pstmt.setInt(2, sm_m_index);
				pstmt.executeUpdate();
				pstmt.close();
				
			}
		});
	}


	public boolean writeInquiry(Inquiry inquiry, int index) {
		set(inquiry.QUERY_POST, new DataSettable() {
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, index);
				pstmt.setString(2, inquiry.getSubject());
				pstmt.setString(3, inquiry.getFile());
				pstmt.setString(4, inquiry.getContent());
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
		return true;
	}

	
	
	public int postInquiryComment(int ib_index, String comment, int m_index) {
		set(Comment.QUERY_POST,new DataSettable() {
			
			@Override
			public void prepare(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1, m_index);
				pstmt.setInt(2, ib_index);
				pstmt.setString(3, comment);
				pstmt.executeUpdate();
				pstmt.close();
			}
		});
		return 1;
	}
}

