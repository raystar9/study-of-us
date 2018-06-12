package dateConverter;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConverter {
	/**
	 * 
	 * @param dateString yyyy-MM-dd
	 * @return
	 */
	public static Date convertDate(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date res = format.parse(dateString);
			return new Date(res.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 
	 * @param dateString yyyy-MM-dd hh:mm
	 * @return
	 */
	public static Timestamp convertDateTime(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		
		try {
			System.out.println(format.parse(dateString).getTime());
			return new Timestamp(format.parse(dateString).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static String getDateString(Date date) {
		System.out.println(date.getTime());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		return format.format(date);
	}
	
	public static String getDateString(Timestamp timestamp) {
		System.out.println(timestamp.getTime());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		return format.format(timestamp);
	}
	
	//TODO 메서드 공통부분 합쳐야됨.
}
