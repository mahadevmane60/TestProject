package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String getHtmlToSqlDate(String htmlDate) throws Exception {
		String patternHTML = "yyyy-MM-dd";
		String patternSQL = "dd-MMM-yyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternHTML);
		Date d= simpleDateFormat.parse(htmlDate);
		SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(patternSQL);
		return simpleDateFormat1.format(d);
	} 
	/** date format arg1 yyyy-MM-dd, arg2 Hr(in 24), arg3 min  e.g. ("2018-6-18", 13, 30)  */
	@SuppressWarnings("deprecation")
	public static boolean isDateGreaterThanCurrentDate(String date,int hr,int min) throws Exception{
		Date currentDate = new Date();
		String patternHTML = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternHTML);
		Date d= simpleDateFormat.parse(date);
		d.setHours(hr);
		d.setMinutes(min);
		if( d.compareTo(currentDate) >0)
		return true;
		return false;
	}
	
	public static java.util.Date getHtmlToJavaDate(String HDate) throws ParseException{		
		return new SimpleDateFormat("yyyy-MM-dd").parse(HDate);
	}
}
