package fakeDB;

import java.util.ArrayList;

import beans.study.each.attendacne.MemberAttendanceBean;
import beans.study.each.schedule.ScheduleBean;
import beansNew.Attend;
import beansNew.Meeting;
import beansNew.Member;
import dateConverter.DateConverter;

public class FakeGetter {
	public ArrayList<ScheduleBean> getSchedules(){
		ArrayList<ScheduleBean> results = new ArrayList<>();
		for(Meeting meeting : FakeDB.getInstance().getMeetings()) {
			ScheduleBean schedule = new ScheduleBean();
			schedule.setStart(DateConverter.getDateString(meeting.getDate()));
			schedule.setTitle(meeting.getPlace());
			results.add(schedule);
		}
		return results;
	}
	public ArrayList<ScheduleBean> getSchedule(int index) {
		ArrayList<ScheduleBean> result = new ArrayList<>();
		ArrayList<Meeting> meetings = FakeDB.getInstance().getMeetings();
		for(Meeting meeting : meetings) {
			if(meeting.getStudyId() == index) {
				ScheduleBean schedule = new ScheduleBean();
				schedule.setStart(DateConverter.getDateString(meeting.getDate()));
				schedule.setTitle(meeting.getPlace());
				schedule.setUrl("/study-of-us/study/each/schedule/each");
				result.add(schedule);
			}
		}
		return result;
	}
	
	public ArrayList<MemberAttendanceBean> getMemberAttendance() {
		ArrayList<MemberAttendanceBean> result = new ArrayList<>();
		FakeDB db = FakeDB.getInstance();
		ArrayList<Member> m = db.getMembers();
		ArrayList<Attend> a = db.getAttends();
		for(int j = 0; j < a.size(); j++) {
			for(int i = 0; i < m.size(); i++) {
				if(a.get(j).getMemberId() == m.get(i).getMemberId()) {
					result.add(new MemberAttendanceBean(m.get(i).getName(), a.get(j).getAttend()));
				}
			}
		}
		
		return result;
	}
	
}
