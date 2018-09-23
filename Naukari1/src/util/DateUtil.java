package util;

import java.text.SimpleDateFormat;

public class DateUtil
{
  public DateUtil() {}
  
  public static String getHtmlToSqlDate(String htmlDate) throws Exception {
    String patternHTML = "yyyy-MM-dd";
    String patternSQL = "dd-MMM-yyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternHTML);
    java.util.Date d = simpleDateFormat.parse(htmlDate);
    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(patternSQL);
    return simpleDateFormat1.format(d);
  }
  
  public static boolean isDateGreaterThanCurrentDate(String date, int hr, int min) throws Exception
  {
    java.util.Date currentDate = new java.util.Date();
    String patternHTML = "yyyy-MM-dd";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternHTML);
    java.util.Date d = simpleDateFormat.parse(date);
    d.setHours(hr);
    d.setMinutes(min);
    if (d.compareTo(currentDate) > 0)
      return true;
    return false;
  }
  
  public static java.util.Date getHtmlToJavaDate(String HDate) throws java.text.ParseException {
    return new SimpleDateFormat("yyyy-MM-dd").parse(HDate);
  }
}