package beansNew;

import java.sql.Date;

public class Board {
	int boardId;
	int postNo;
	int studyId;
	int memberId;
	String title;
	Date date;
	String content;
	String filename;
	
	
	public Board() {
	}


	public Board(int boardId, int postNo, int studyId, int memberId, String title, Date date, String content,
			String filename) {
		this.boardId = boardId;
		this.postNo = postNo;
		this.studyId = studyId;
		this.memberId = memberId;
		this.title = title;
		this.date = date;
		this.content = content;
		this.filename = filename;
	}


	public int getBoardId() {
		return boardId;
	}


	public int getPostNo() {
		return postNo;
	}


	public int getStudyId() {
		return studyId;
	}


	public int getMemberId() {
		return memberId;
	}


	public String getTitle() {
		return title;
	}


	public Date getDate() {
		return date;
	}


	public String getContent() {
		return content;
	}


	public String getFilename() {
		return filename;
	}


	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}


	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}


	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}

	
}
