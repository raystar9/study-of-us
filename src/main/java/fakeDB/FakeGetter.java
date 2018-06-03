package fakeDB;

import java.util.ArrayList;

import beans.study.each.schedule.ScheduleBean;
import beansNew.Meeting;
import dateConverter.DateConverter;

public class FakeGetter {
	public ArrayList<ScheduleBean> getSchedules(){
		ArrayList<ScheduleBean> results = new ArrayList<>();
		for(Meeting meeting : FakeDB.getInstance().getMeetings()) {
			ScheduleBean schedule = new ScheduleBean();
			schedule.setStart(DateConverter.getDateString(meeting.getDate()));
			schedule.setTitle(meeting.getPlace());
			schedule.setUrl("each");
		}
		return results;
	}
}
