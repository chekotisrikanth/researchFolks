package com.marketing.tool.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtills {
	
public static Date getCurrentDate() throws ParseException {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	
     //Calendar.getInstance().getTime();
	String dateString = sdf.format(Calendar.getInstance().getTime());
	
	return sdf.parse(dateString);
}
public static Date getDateFromString(String dateString) throws ParseException {
	
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	return sdf.parse(dateString);
}

public static String getStringFromDate(Date dateString) throws ParseException {
	
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	sdf.format(dateString);
	return sdf.format(dateString);
}


// 04/22/2016
}
