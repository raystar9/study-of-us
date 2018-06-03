package beansNew;

import java.sql.Date;
import java.util.ArrayList;

public class Study {
	String name;
	Category category;
	Member leader;
	Date startDate;
	Date endDate;
	int maxMember;
	String dayOfWeek;
	String time;
	String explain;
	String material;
	String effects;
	String place;
	ArrayList<Member> members;
	
	public Study() {
	}
	
	public Study(String name, Category category, Member leader, Date startDate, Date endDate,
			int maxMember, String dayOfWeek, String time, String explain, String material, String effects, String place,
			ArrayList<Member> members) {
		this.name = name;
		this.category = category;
		this.leader = leader;
		this.startDate = startDate;
		this.endDate = endDate;
		this.maxMember = maxMember;
		this.dayOfWeek = dayOfWeek;
		this.time = time;
		this.explain = explain;
		this.material = material;
		this.effects = effects;
		this.place = place;
		this.members = members;
	}



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Member getMember() {
		return leader;
	}
	public void setMember(Member member) {
		this.leader = member;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getMaxMember() {
		return maxMember;
	}
	public void setMaxMember(int maxMember) {
		this.maxMember = maxMember;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getEffects() {
		return effects;
	}
	public void setEffects(String effects) {
		this.effects = effects;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	
	public ArrayList<Member> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}
	public void addMember(Member member) {
		members.add(member);
	}
}
