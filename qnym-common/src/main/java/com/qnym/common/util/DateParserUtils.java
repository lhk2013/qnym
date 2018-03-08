package com.qnym.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParserUtils {
	private final static Logger logger = LoggerFactory.getLogger(DateParserUtils.class);

	private final static ThreadLocal<SimpleDateFormat> gomeDQFormat1 = new ThreadLocal<SimpleDateFormat>() {

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}

	};

	private final static ThreadLocal<SimpleDateFormat> gomeDQFormat2 = new ThreadLocal<SimpleDateFormat>() {

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
		}

	};

	private final static ThreadLocal<SimpleDateFormat> gomeDQFormat3 = new ThreadLocal<SimpleDateFormat>() {

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("dd-MM月-yy");
		}

	};

	private final static ThreadLocal<SimpleDateFormat> lmisFormat = new ThreadLocal<SimpleDateFormat>() {

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMddHHmmssSSS");
		}

	};

	private final static ThreadLocal<SimpleDateFormat> crmFormat = new ThreadLocal<SimpleDateFormat>() {

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMddHHmmss");
		}

	};

	private final static ThreadLocal<SimpleDateFormat> timeFormat = new ThreadLocal<SimpleDateFormat>() {

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("HH:mm");
		}

	};

	private static final ThreadLocal<SimpleDateFormat> ahsFormat = new ThreadLocal<SimpleDateFormat>(){
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		}
	};

	public static long parserDate(String date, String field) {
		try {
			if (date.length() > 19) {
				date = date.substring(0, 19);
			}
			return gomeDQFormat1.get().parse(date).getTime();
		} catch (Exception e) {
		}
		try {
			if (date.length() > 19) {
				date = date.substring(0, 19);
			}
			return gomeDQFormat2.get().parse(date).getTime();
		} catch (Exception e) {
		}
		try {
			if (date.length() > 9) {
				date = date.substring(0, 9);
			}
			return gomeDQFormat3.get().parse(date).getTime();
		} catch (Exception e) {
		}
		throw new IllegalArgumentException(String.format("parser time error,field=[%s],date=[%s]", field, date));
	}

	public static long parserTime(String date, String field) {
		try {
			if (date.length() == 5) {
				return timeFormat.get().parse(date).getTime();
			}
		} catch (Exception e) {
		}
		throw new IllegalArgumentException(String.format("parser time error,field=[%s],date=[%s]", field, date));
	}

	public static long parserLmisDate(String date, String field) {
		long time = 0L;
		try {
			if (date != null && !date.isEmpty()) {
				if (date.indexOf("GMT+8") == 0) {
					time = lmisFormat.get().parse(date.substring(5)).getTime();
				}
			}
		} catch (Exception e) {
			logger.info(String.format("parser time error,field=[%s],date=[%s]", field, date));
		}
		return time;
	}

	public static long parserCrmDate(String date, String field) {
		long time = 0L;
		try {
			if (date != null && !date.isEmpty()) {
				time = crmFormat.get().parse(date).getTime();
			}
		} catch (Exception e) {
			logger.info(String.format("parser time error,field=[%s],date=[%s]", field, date));
		}
		return time;
	}

	public static String parserDate(long time) {
		return gomeDQFormat1.get().format(new Date(time));
	}
	public static String parseAHSDateString( Date dt) {
		return ahsFormat.get().format(dt);
	}
}
