package beansNew;

import java.sql.Date;

public class Study {
	int studyId;
	String name;
	int categoryId;
	int leaderId;
	Date startDate;
	Date endDate;
	int maxMember;
	String dayOfWeek;
	String time;
	String explain;
	String material;
	String effects;
	String place;
	
	public Study() {
	}

	public int getStudyId() {
		return studyId;
	}

	public String getName() {
		return name;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public int getLeaderId() {
		return leaderId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public int getMaxMember() {
		return maxMember;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public String getTime() {
		return time;
	}

	public String getExplain() {
		return explain;
	}

	public String getMaterial() {
		return material;
	}

	public String getEffects() {
		return effects;
	}

	public String getPlace() {
		return place;
	}

	public void setStudyId(int studyId) {
		this.studyId = studyId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public void setLeaderId(int leaderId) {
		this.leaderId = leaderId;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setMaxMember(int maxMember) {
		this.maxMember = maxMember;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void setEffects(String effects) {
		this.effects = effects;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
}
