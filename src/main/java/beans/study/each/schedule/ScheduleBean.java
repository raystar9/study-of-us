package beans.study.each.schedule;

public class ScheduleBean {
	public static final String QUERY_GET = "";
	
	private String title;
	private String start;
	private String url;
	
	public String getTitle() {
		return title;
	}
	public String getStart() {
		return start;
	}
	public String getUrl() {
		return url;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
