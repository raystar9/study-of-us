package dateConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

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
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
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
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		return format.format(new java.util.Date(date.getTime()));
	}
	
	//TODO 메서드 공통부분 합쳐야됨.
}
