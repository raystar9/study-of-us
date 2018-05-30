package dateConverter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConverter {
	/**
	 * 
	 * @param dateString yyyy/MM/dd
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
	 * @param dateString yyyy/MM/dd hh:mm
	 * @return
	 */
	public static Date convertDateTime(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
		try {
			java.util.Date res = format.parse(dateString);
			return new Date(res.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static String getDateString(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");
		return format.format(date);
	}
	
	//TODO 메서드 공통부분 합쳐야됨.
}
