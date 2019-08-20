/*
 * �ļ����� DateUtil.java
 * 
 * �������ڣ� 2010-3-16
 *
 * Copyright(C) 2010, by xiaozhi.
 *
 * ԭʼ����: <a href="mailto:xiaozhi19820323@hotmail.com">xiaozhi</a>
 *
 */
package com.qnym.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author liuhaikuo
 * 2018年9月29日14:43:41
 */
public class DateUtil {

	private static Logger logger = LoggerFactory.getLogger(DateUtil.class) ;

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_TIME_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";
	public static final String DATE_FORMAT = "yyyyMMdd";

	public static final int ONE_DAY = 86400 ;
	
	public static final int ONE_HOUR = 3600;
	
	public static final int ONE_MIN = 60;

	public static final int ONE_MIN_MILLSECONDS = ONE_MIN*1000;

	public static final int ONE_HOUR_MILLSECONDS = ONE_HOUR*1000;

	public static final int ONE_DAY_MILLSECONDS = ONE_DAY*1000;

	public static final Long YEAR_MILLSECONDS_2019 = 1546272000*1000L;

	public static final String getSystemCurrentDateTime() {
		DateFormat df=new SimpleDateFormat(DATE_TIME_FORMAT);
		df.getCalendar().setTimeInMillis(System.currentTimeMillis());
		return df.format(df.getCalendar().getTime());
	}

	public static final String getSystemCurrentDate() {
		DateFormat df=new SimpleDateFormat(DATE_FORMAT);
		df.getCalendar().setTimeInMillis(System.currentTimeMillis());
		df.getCalendar().add(Calendar.DAY_OF_YEAR,-1);
		return df.format(df.getCalendar().getTime());
	}

	public static final String getSystemCurrentDate(int addDays) {
		DateFormat df=new SimpleDateFormat(DATE_FORMAT);
		df.getCalendar().setTimeInMillis(System.currentTimeMillis());
		df.getCalendar().add(Calendar.DAY_OF_YEAR,addDays);
		return df.format(df.getCalendar().getTime());
	}

	public static final String getAddDate(Date date, int addDays) {
		DateFormat df=new SimpleDateFormat(DATE_FORMAT);
		df.getCalendar().setTimeInMillis(date.getTime());
		df.getCalendar().add(Calendar.DAY_OF_YEAR,addDays);
		return df.format(df.getCalendar().getTime());
	}

	public static final Date getAddDateTime(Date date, int addDays) {
		DateFormat df=new SimpleDateFormat(DATE_FORMAT);
		df.getCalendar().setTimeInMillis(date.getTime());
		df.getCalendar().add(Calendar.DAY_OF_YEAR,addDays);
		return df.getCalendar().getTime();
	}

	public static final String getSystemCurrentDate(String format) {
		DateFormat df=new SimpleDateFormat(format);
		df.getCalendar().setTimeInMillis(System.currentTimeMillis());
		return df.format(df.getCalendar().getTime());
	}

	public  static String getDateFormatterHour(int hours){
		DateFormat df=new SimpleDateFormat(DATE_TIME_FORMAT);
		df.getCalendar().setTime(new Date());
		df.getCalendar().add(Calendar.HOUR,-hours);
		return df.format(df.getCalendar().getTime());
	}

	/**
	 * 当前时间加上秒数
	 * @param time
	 * @return
	 */
	public  static String getDateFormatterAddSecond(Integer time){
		DateFormat df=new SimpleDateFormat(DATE_TIME_FORMAT);
		df.getCalendar().setTimeInMillis(System.currentTimeMillis());
		df.getCalendar().add(Calendar.SECOND,time);
		return df.format(df.getCalendar().getTime());
	}

	/**
	 * 取当前时间（精确到整分）
	 * @return
	 */
	public  static Long getCurTimeForMinute(){
		DateFormat df=new SimpleDateFormat(DATE_TIME_FORMAT);
		df.getCalendar().setTimeInMillis(System.currentTimeMillis());
		df.getCalendar().set(Calendar.SECOND,0);
		df.getCalendar().set(Calendar.MILLISECOND,0);
		return  df.getCalendar().getTime().getTime();
	}

	/**
	 * 取当前时间字符串（精确到整分）
	 * @return
	 */
	public static String getCurTimeStrForMinute(){
		DateFormat df=new SimpleDateFormat(DATE_TIME_FORMAT);
		df.getCalendar().setTimeInMillis(System.currentTimeMillis());
		df.getCalendar().set(Calendar.SECOND,0);
		df.getCalendar().set(Calendar.MILLISECOND,0);
		return  df.format(df.getCalendar().getTime());
	}

	/**
	 *  日期字符串转日期
	 *  格式yyyy-MM-dd HH:mm:ss
	 */
	public static Date strToDate(String date){
		DateFormat df=new SimpleDateFormat(DATE_TIME_FORMAT);
		try {
			df.parse(date);
			return df.getCalendar().getTime();

		}catch (Exception e){
			logger.error("parse date error date {} ",date);
		}
		return  null;
	}

	/**
	 *  日期字符串转日期
	 *  格式yyyyMMdd 20190802
	 */
	public static Date strToDateSimple(String date){
		DateFormat df=new SimpleDateFormat(DATE_FORMAT);
		try {
			df.parse(date);
			return df.getCalendar().getTime();

		}catch (Exception e){
			logger.error("parse date error date {} ",date);
		}
		return  null;
	}
	/**
	 *  日期字符串转日期
	 *  格式yyyyMMdd 20190802
	 */
	public static String strToDateStrSimple(Date date){
		DateFormat df=new SimpleDateFormat(DATE_FORMAT);
		df.getCalendar().setTime(date);
		try {
			return  df.format(df.getCalendar().getTime());

		}catch (Exception e){
			logger.error("parse date error date {} ",date);
		}
		return  null;
	}



	/**
	 * 当前时间加上秒数
	 * @param time
	 * @return
	 */
	public  static String getFormatDate(Long time){
		DateFormat df=new SimpleDateFormat(DATE_TIME_FORMAT);
		df.getCalendar().setTimeInMillis(time);
		return df.format(df.getCalendar().getTime());
	}


	/**
	 * 时间戳转换成日期格式字符串
	 * @param seconds 精确到秒的字符串
	 * @return
	 */
    public static String timeStamp2Date(String seconds, String format) {

		if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
			return "";
		}
		if(format == null || format.isEmpty()){
			format = "yyyy-MM-dd HH:mm:ss";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(Long.valueOf(seconds+"000")));
	}

	public static void main(String[] args) {
		Long ss =getCurTimeForMinute();
		System.out.println(ss);
		String s2 = getFormatDate(ss);
		System.out.println(s2);
		System.out.println((System.currentTimeMillis()+"").length());

		System.out.println(11111);
		String date = getSystemCurrentDate();
		System.out.println(date);

		System.out.println(getSystemCurrentDate("yyyy-MM-dd 00:00:00"));

		Double d = new Double("21.87");
		d = d*1000;
		System.out.println(d.intValue());

		Double d2 = new Double(21780/1000.00);

		System.out.println(d2);

		Integer num = null;
//		if(num>0){
//			System.out.println((new Date().getTime()));
//
//		}

		System.out.println(strToDateStrSimple(new Date()));
		System.out.println((DateUtil.getFormatDate(1521600325000L)));
	}

}
