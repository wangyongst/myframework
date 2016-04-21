package com.baihe.utils.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
	
	public static final int SECOND_OF_HOUR = 60 * 60;
	public static final int SECOND_OF_DAY = SECOND_OF_HOUR * 24;
	public static final int MILLIS_OF_DAY = SECOND_OF_DAY * 1000;
	
	public static final SimpleDateFormat DEFAULT_DATE_FORMAT = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static String format(Date date, String format){
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	public static String format(String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
	
	public static String currentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	
	public static String currentTime() {
		return DEFAULT_DATE_FORMAT.format(new Date());
	}
	
	public static String currentYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(new Date());
	}
	
	public static String currentMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		return sdf.format(new Date());
	}
	
	public static String currentDay() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		return sdf.format(new Date());
	}
	
	public static int intervalDays(Date start, Date end) {
		long intervalMills = end.getTime() - start.getTime();
		return (int) (intervalMills / MILLIS_OF_DAY);
	}
	
	/**
	 * 返回当月第一天
	 * @return
	 * @author lonely
	 */
	public static String firstDayInCurrentMonth(){
		Calendar calendar  =   new  GregorianCalendar();
		calendar.set( Calendar.DATE,  1 );
		SimpleDateFormat simpleFormate  =   new  SimpleDateFormat( "yyyy-MM-dd" );
		return simpleFormate.format(calendar.getTime());
	}
	
	/**
	 * 返回当月最后一天
	 * @return
	 * @author lonely
	 */
	public static String lastDayInCurrentMonth(){
		Calendar calendar  =   new  GregorianCalendar();
		calendar.set( Calendar.DATE,  1 );
		calendar.roll(Calendar.DATE,  - 1 );
		SimpleDateFormat simpleFormate  =   new  SimpleDateFormat( "yyyy-MM-dd" );
		return simpleFormate.format(calendar.getTime());
	}
	
	/**
	 * String转为Date
	 * @param dateStr 日期字符串
	 * @param format 日期字符串格式，如"yyyy-MM-dd"
	 * @return
	 */
	public static Date StringToDate(String dateStr,String format){
		
		SimpleDateFormat sdf=new SimpleDateFormat(format);//小写的mm表示的是分钟 
		Date date = null;
		try {
			date =  sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		
		return date;
	}
	
	/**
	 * 日期运算
	 * @param date 要运算的日期
	 * @param area 运算区域，年y,月M,日d,时H,分m,秒s
	 * @param num  运算数，正数代表加，负数代表减
	 * @return
	 */
	public static Date dateOperational(Date date,String area,int num){
		
		Calendar c = Calendar.getInstance();   
		c.setTime(date);
		if(area.equals("y")){
			c.add(Calendar.YEAR, num);
		}else if(area.equals("M")){
			c.add(Calendar.MONTH, num);
		}else if(area.equals("d")){
			c.add(Calendar.DAY_OF_MONTH, num);
		}else if(area.equals("H")){
			c.add(Calendar.HOUR, num);
		}else if(area.equals("m")){
			c.add(Calendar.MINUTE, num);
		}else if(area.equals("s")){
			c.add(Calendar.SECOND, num);
		}
		return StringToDate(format(c.getTime(),"yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss");
	}
	
	/** 
     * 获取当年的第一天 
     * @param year 
     * @return 
     */  
    public static Date firstDayInYear(){  
        Calendar currCal=Calendar.getInstance();    
        int currentYear = currCal.get(Calendar.YEAR);  
        return getYearFirst(currentYear);  
    }  
      
    /** 
     * 获取当年的最后一天 
     * @param year 
     * @return 
     */  
    public static Date lastDayInYear(){  
        Calendar currCal=Calendar.getInstance();    
        int currentYear = currCal.get(Calendar.YEAR);  
        return getYearLast(currentYear);  
    }  
      
    /** 
     * 获取某年第一天日期 
     * @param year 年份 
     * @return Date 
     */  
    public static Date getYearFirst(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        Date currYearFirst = calendar.getTime();  
        return currYearFirst;  
    }  
      
    /** 
     * 获取某年最后一天日期 
     * @param year 年份 
     * @return Date 
     */  
    public static Date getYearLast(int year){  
        Calendar calendar = Calendar.getInstance();  
        calendar.clear();  
        calendar.set(Calendar.YEAR, year);  
        calendar.roll(Calendar.DAY_OF_YEAR, -1);  
        Date currYearLast = calendar.getTime();  
          
        return currYearLast;  
    }  
    
    public static String millisToDate(Long millis){
    	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTimeInMillis(millis);
    	
    	return formatter.format(calendar.getTime());
    }

}
