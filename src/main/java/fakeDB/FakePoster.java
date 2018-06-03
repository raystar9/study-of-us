package fakeDB;

import beansNew.Meeting;

public class FakePoster {
	public void postMeeting(int studyIndex, Meeting meeting) {
		FakeDB db = FakeDB.getInstance();
		meeting.setStudy(db.getStudies().get(studyIndex));
		db.addMeeting(meeting);
	}
}
