package fakeDB;

import java.util.ArrayList;

import beans.study.each.schedule.ScheduleBean;
import beansNew.Meeting;
import beansNew.Study;
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
		Study study = FakeDB.getInstance().getStudies().get(index);
		for(Meeting meeting : meetings) {
			if(meeting.getStudy() == study) {
				ScheduleBean schedule = new ScheduleBean();
				schedule.setStart(DateConverter.getDateString(meeting.getDate()));
				schedule.setTitle(meeting.getPlace());
				schedule.setUrl("/study-of-us/study/each/schedule/each");
				result.add(schedule);
			}
		}
		return result;
	}
}
