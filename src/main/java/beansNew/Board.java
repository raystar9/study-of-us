package beansNew;

import java.sql.Date;

public class Board {
	int postNo;
	Study study;
	Member writer;
	String title;
	Date date;
	String content;
	String filename;
	
	
	public Board() {
	}
	public Board(int postNo, Study study, Member writer, String title, Date date, String content, String filename) {
		this.postNo = postNo;
		this.study = study;
		this.writer = writer;
		this.title = title;
		this.date = date;
		this.content = content;
		this.filename = filename;
	}
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public Study getStudy() {
		return study;
	}
	public void setStudy(Study study) {
		this.study = study;
	}
	public Member getWriter() {
		return writer;
	}
	public void setWriter(Member writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
