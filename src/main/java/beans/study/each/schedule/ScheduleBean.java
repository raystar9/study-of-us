package beans.study.each.schedule;

import java.util.Date;

public class ScheduleBean {
	public static final String QUERY_GET = "";
	
	private String title;
	private Date start;
	private String url;
	
	public String getTitle() {
		return title;
	}
	public Date getStart() {
		return start;
	}
	public String getUrl() {
		return url;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
