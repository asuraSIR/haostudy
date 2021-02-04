package com.hao.commont.util.date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtils {
	public static String[] WEEK_NAMES = { "星期日", "星期一", "星期二", "星期三", "星期四",
			"星期五", "星期六" };

	private static Log log = LogFactory.getLog(DateUtils.class);

	public DateUtils() {

	}

	/**
	 * 按照指定的格式获得当前日期string类型
	 * 
	 * @param mode
	 * @return
	 */
	public static String getNowDate(String mode) {
		SimpleDateFormat formatter = new SimpleDateFormat(mode);
		String dateString = formatter.format(Calendar.getInstance().getTime());
		return dateString;
	}

	/**
	 * 获得当前日期date类型
	 * 
	 * @return
	 */
	public static Date getNowDate() {
		return Calendar.getInstance().getTime();
	}

	/**
	 * 将指定的日期格式化成某种格式，返回string类型
	 * 
	 * @param curDate
	 * @param mode
	 * @return
	 */
	public static String dateToStr(Date curDate, String mode) {
		String dateString = "";
		if (curDate != null) {
			SimpleDateFormat formatter = new SimpleDateFormat(mode);
			dateString = formatter.format(curDate);
		}
		return dateString;
	}

	/**
	 * 日期的列表
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List getDayList(String startDate, String endDate) {
		int dayCount = getDayCount(startDate, endDate);
		Calendar startCalendar = getCalendarByStrShort(startDate);
		List<Map> list = new ArrayList<Map>();
		for (int i = 0; i < dayCount; i++) {
			if (i != 0) {
				startCalendar.add(Calendar.DATE, 1);
			}
			Map<String, String> map = new Hashtable<String, String>();
			map.put("dateStr", (String) dateToStrShort(startCalendar.getTime()));
			map.put("dateName",
					(String) WEEK_NAMES[startCalendar.get(Calendar.DAY_OF_WEEK) - 1]);
			list.add(i, map);
		}
		return list;

	}

	/**
	 * 星期的列表
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List getWeekList(String startDate, String endDate) {
		int weekCount = getWeekCount(startDate, endDate);
		List<Map> list = new ArrayList<Map>();
		for (int i = 0; i < weekCount; i++) {
			String[] weekRange = getNextWeek(startDate, i);
			Map<String, String> map = new Hashtable<String, String>();
			map.put("dateStr", weekRange[0] + "―" + weekRange[1]);
			list.add(i, map);
		}
		return list;

	}

	/**
	 * 月列表
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List getMonthList(String startDate, String endDate) {
		int MonthCount = getMonthCount(startDate, endDate);
		List<Map> list = new ArrayList<Map>();
		for (int i = 0; i < MonthCount; i++) {
			String[] monthRange = getNextMonth(startDate, i);
			Map<String, String> map = new Hashtable<String, String>();
			map.put("dateStr", monthRange[0] + "―" + monthRange[1]);
			list.add(i, map);
		}
		return list;

	}

	/**
	 * 季度列表
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List getQuarterList(String startDate, String endDate) {
		int quarterCount = getQuarterCount(startDate, endDate);
		List<Map> list = new ArrayList<Map>();
		for (int i = 0; i < quarterCount; i++) {
			String[] quarterRange = getNextQuarter(startDate, i);
			Map<String, String> map = new Hashtable<String, String>();
			map.put("dateStr", quarterRange[0] + "―" + quarterRange[1]);
			list.add(i, map);
		}
		return list;

	}

	/**
	 * 年列表
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static List getYearList(String startDate, String endDate) {
		int yearCount = getYearCount(startDate, endDate);
		List<Map> list = new ArrayList<Map>();
		for (int i = 0; i < yearCount; i++) {
			String[] yearRange = getNextYear(startDate, i);
			Map<String, String> map = new Hashtable<String, String>();
			map.put("dateStr", yearRange[0] + "―" + yearRange[1]);
			list.add(i, map);
		}
		return list;

	}

	/**
	 * 时间字符串转换为Calendar类型时间
	 * 
	 * @param strDate
	 * @return
	 */
	public static Calendar strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss.SSS");
		ParsePosition pos = new ParsePosition(0);
		Calendar curCalendar = Calendar.getInstance();
		curCalendar.setTime(formatter.parse(strDate, pos));
		return curCalendar;
	}

	/**
	 * 将时间转换为制定字符串
	 * 
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrShort(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短日期字符串类型转换为Calendar类型对象
	 * 
	 * @param dateStrShort
	 * @return
	 */
	public static Calendar getCalendarByStrShort(String dateStrShort) {
		String zeroTime = " 00:00:00.000";
		return strToDate(dateStrShort + zeroTime);

	}

	/**
	 * 指定日期范围内的天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getDayCount(String startDate, String endDate) {
		Calendar startCalendar = DateUtils.getCalendarByStrShort(startDate);
		Calendar endCalendar = DateUtils.getCalendarByStrShort(endDate);
		int dayMCount = 24 * 60 * 60 * 1000;
		return (int) ((endCalendar.getTimeInMillis() - startCalendar
				.getTimeInMillis()) / dayMCount + 1);
	}

	/**
	 * 计算两个日期间不包含周末的天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public static int getDayCountOnclude(String startDate, String endDate)
			throws Exception {
		int num = DateUtils.getDayCount(startDate, endDate); // 日期间天数
		int weekCount = DateUtils.getWeekCount(startDate, endDate); // 日期间星期数
		num = num - weekCount * 2;
		int endDayOnWeek = DateUtils.getCalendarByStrShort(endDate).get(
				Calendar.DAY_OF_WEEK);
		int acceptDayOnWeek = DateUtils.getCalendarByStrShort(startDate).get(
				Calendar.DAY_OF_WEEK);
		if (acceptDayOnWeek > endDayOnWeek) {
			if (endDayOnWeek == 0 && acceptDayOnWeek != 6) {
				num = num - 1;
			} else if (acceptDayOnWeek != 6) {
				num = num - 2;
			}
		}
		return num;
	}

	/**
	 * 日期范围内星期数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getWeekCount(String startDate, String endDate) {
		Calendar startCalendar = DateUtils.getCalendarByStrShort(DateUtils
				.getNextWeek(startDate, 0)[0]);
		Calendar endCalendar = DateUtils.getCalendarByStrShort(DateUtils
				.getNextWeek(endDate, 1)[0]);
		int weekMCount = 7 * 24 * 60 * 60 * 1000;

		return (int) ((endCalendar.getTimeInMillis() - startCalendar
				.getTimeInMillis()) / weekMCount);

	}

	/**
	 * 日期范围内的月数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getMonthCount(String startDate, String endDate) {
		Calendar startCalendar = DateUtils.getCalendarByStrShort(DateUtils
				.getNextMonth(startDate, 0)[0]);
		Calendar endCalendar = DateUtils.getCalendarByStrShort(DateUtils
				.getNextMonth(endDate, 0)[0]);
		int i = 1;
		String endDateStr = DateUtils.dateToStrShort(endCalendar.getTime());
		while (true) {
			if (i == 1) {
				if (DateUtils.dateToStrShort(startCalendar.getTime()).equals(
						endDateStr)) {
					break;
				}
			} else {

				startCalendar.add(Calendar.MONTH, 1);
				if (DateUtils.dateToStrShort(startCalendar.getTime()).equals(
						endDateStr)) {
					break;
				}
			}
			i++;
		}
		return i;
	}

	/**
	 * 日期范围内的季度数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getQuarterCount(String startDate, String endDate) {
		Calendar startCalendar = DateUtils.getCalendarByStrShort(DateUtils
				.getNextQuarter(startDate, 0)[0]);
		Calendar endCalendar = DateUtils.getCalendarByStrShort(DateUtils
				.getNextQuarter(endDate, 0)[0]);
		int i = 1;
		String endDateStr = DateUtils.dateToStrShort(endCalendar.getTime());
		while (true) {
			if (i == 1) {
				if (DateUtils.dateToStrShort(startCalendar.getTime()).equals(
						endDateStr)) {
					break;
				}
			} else {
				startCalendar.add(Calendar.MONTH, 3);
				if (DateUtils.dateToStrShort(startCalendar.getTime()).equals(
						endDateStr)) {
					break;
				}
			}
			i++;
		}
		return i;
	}

	/**
	 * 日期范围内的年数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getYearCount(String startDate, String endDate) {

		int startYear = Integer.parseInt(startDate.substring(0,
				startDate.indexOf('-')));
		int endYear = Integer.parseInt(endDate.substring(0,
				endDate.indexOf('-')));
		return endYear - startYear + 1;
	}

	/**
	 * 获得制定时间前或后的week的开始时间和结束时间
	 * 
	 * @param dateStr
	 * @param count
	 * @return
	 */
	public static String[] getNextWeek(String dateStr, int weekCount) {
		String[] dateRange = { "", "" };
		Calendar curCalendar = getCalendarByStrShort(dateStr);
		curCalendar.setFirstDayOfWeek(Calendar.SUNDAY);
		int dayOfWeek = curCalendar.get(Calendar.DAY_OF_WEEK);
		dayOfWeek = dayOfWeek == 1 ? 7 : dayOfWeek - 1;
		int dayDiff = weekCount <= 0 ? -(dayOfWeek - 1 + 7 * Math
				.abs(weekCount)) : +(1 - dayOfWeek + 7 * weekCount);
		curCalendar.add(Calendar.DATE, dayDiff);
		dateRange[0] = dateToStrShort(curCalendar.getTime());
		curCalendar.add(Calendar.DATE, 6);
		dateRange[1] = dateToStrShort(curCalendar.getTime());
		return dateRange;
	}

	/**
	 * 获得指定时间后的指定月份开始和结束时间
	 * 
	 * @param dateStr
	 * @param monthCount
	 * @return
	 */
	public static String[] getNextMonth(String dateStr, int monthCount) {

		String[] dateRange = { "", "" };
		Calendar curCalendar = getCalendarByStrShort(dateStr);
		curCalendar.add(Calendar.MONTH, monthCount);
		curCalendar.set(Calendar.DAY_OF_MONTH, 1);
		dateRange[0] = dateToStrShort(curCalendar.getTime());
		curCalendar.set(Calendar.DAY_OF_MONTH,
				curCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		dateRange[1] = dateToStrShort(curCalendar.getTime());
		return dateRange;

	}

	/**
	 * 获得指定时间迁移制动季度后的时间范围
	 * 
	 * @param dateStr
	 * @param quarterCount
	 * @return
	 */
	public static String[] getNextQuarter(String dateStr, int quarterCount) {
		String[] dateRange = { "", "" };
		Calendar curCalendar = getCalendarByStrShort(dateStr);
		// 获得当前季度
		int curQuarter = (int) Math.ceil((double) (curCalendar
				.get(Calendar.MONTH) + 1) / 3);
		int curQuarterStartMonth = curQuarter * 3 - 3;
		curCalendar.set(Calendar.MONTH, curQuarterStartMonth);
		// 迁移到制定季度的月份
		curCalendar.add(Calendar.MONTH, quarterCount * 3);
		curCalendar.set(Calendar.DATE, 1);
		dateRange[0] = dateToStrShort(curCalendar.getTime());
		// 季度结束时间
		curCalendar.add(Calendar.MONTH, 2);
		curCalendar.set(Calendar.DATE,
				curCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		dateRange[1] = dateToStrShort(curCalendar.getTime());
		return dateRange;

	}

	/**
	 * 指定时间迁移制定年份后的时间范围
	 * 
	 * @param dateStr
	 * @param yearCount
	 * @return
	 */
	public static String[] getNextYear(String dateStr, int yearCount) {
		String[] dateRange = { "", "" };
		Calendar curCalendar = getCalendarByStrShort(dateStr);
		int curYear = curCalendar.get(Calendar.YEAR);
		curYear = curYear + yearCount;
		curCalendar.set(Calendar.YEAR, curYear);
		curCalendar.set(Calendar.MONTH, 0);
		curCalendar.set(Calendar.DATE, 1);
		dateRange[0] = dateToStrShort(curCalendar.getTime());
		curCalendar.set(Calendar.MONTH, 11);
		curCalendar.set(Calendar.DATE,
				curCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		dateRange[1] = dateToStrShort(curCalendar.getTime());
		return dateRange;
	}

	/**
	 * 比较开始和结束时间
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long dateCompare(String startDate, String endDate) {
		return getCalendarByStrShort(endDate).getTimeInMillis()
				- getCalendarByStrShort(startDate).getTimeInMillis();
	}

	/**
	 * 计算当天的前几天和后几天是几号
	 */
	public static String afterNDay(int n) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		c.setTime(new Date());
		c.add(Calendar.DATE, n);
		Date d2 = c.getTime();
		String s = df.format(d2);
		return s;
	}

	/**
	 * 计算指定日期的前几天和后几天是几号
	 */
	public static String afterNDay(Date date, int n) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		c.setTime(date);
		c.add(Calendar.DATE, n);
		Date d2 = c.getTime();
		String s = df.format(d2);
		return s;
	}

	/**
	 * 计算指定日期的前几天和后几天是几号
	 */
	public static String afterNDay(String dateStr, int n) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		c.setTime(GetDate.shortStrToDate(dateStr));
		c.add(Calendar.DATE, n);
		Date d2 = c.getTime();
		String s = df.format(d2);
		return s;
	}

	/**
	 * 计算指定日期的前几天和后几天是几号
	 */
	public static Date afterNDayToDate(Date date, int n) {
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		c.setTime(date);
		c.add(Calendar.DATE, n);
		Date d2 = c.getTime();
		return d2;
	}

	// 将日期转换为中文日期输出“二?一?年二月三日”
	public static String DateToCN(Date date) {
		if (date == null) {
			return null;
		}
		String[] CN = { "?", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		StringBuffer cn = new StringBuffer();
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		for (int i = 0; i < year.length(); i++) {
			cn.append(CN[year.charAt(i) - 48]);
		}
		cn.append("年");
		int mon = calendar.get(Calendar.MONTH) + 1;
		if (mon < 10) {
			cn.append(CN[mon]);
		} else if (mon < 20) {
			if (mon == 10) {
				cn.append("十");
			} else {
				cn.append("十").append(CN[mon % 10]);
			}
		}
		cn.append("月");
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		if (day < 10) {
			cn.append(CN[day]);
		} else if (day < 20) {
			if (day == 10) {
				cn.append("十");
			} else {
				cn.append("十").append(CN[day % 10]);
			}
		} else if (day < 30) {
			if (day == 20) {
				cn.append("二十");
			} else {
				cn.append("二十").append(CN[day % 10]);
			}
		} else {
			cn.append("三十").append(CN[day % 10]);
		}
		cn.append("日");
		return cn.toString();
	}
}
