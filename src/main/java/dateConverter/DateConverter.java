package dateConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
	/**
	 * 
	 * @param dateString yyyy/MM/dd
	 * @return
	 */
	public static Date convertDate(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		try {
			return format.parse(dateString);
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
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		try {
			return format.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
