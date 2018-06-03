package fakeDB;

import beansNew.Meeting;

public class FakePoster {
	public void postMeeting(int studyIndex, Meeting meeting) {
		FakeDB db = FakeDB.getInstance();
		db.addMeeting(meeting);
	}
}
