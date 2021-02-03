package com.hao.commont.util.date;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
    public static final long minute = 1000 * 60;

    public GetDate() {
    }

    public static String getNowDate(String mode) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(mode);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String dateToStr(Date curDate, String mode) {
        SimpleDateFormat formatter = new SimpleDateFormat(mode);
        String dateString = formatter.format(curDate);
        return dateString;
    }

    public static Date getNowDate() throws ParseException {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(dateString);
    }

    public static Date getNowDateShort() throws ParseException {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return (new SimpleDateFormat("yyyy-MM-dd")).parse(dateString);
    }

    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    public static Date shortStrToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    public static String dateToStr(java.util.Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    public static Date strToShortDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    public static String dateToShortStr(java.util.Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    public static Date strToBirthday(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     *
     * @param dateDate
     * @return "yyyy-MM-dd"
     */
    public static String dateToStrShort(java.util.Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    public static Date getNow() {
        Date currentTime = new Date();
        return currentTime;
    }

    public static long getS(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate.getTime();
    }

    public static long getStrToLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate.getTime();
    }

    public static long getLongTime() {
        return new Date().getTime();
    }

    public static int getOffMinutes(long btime) {
        return getOffMinutes(btime, System.currentTimeMillis());
    }

    public static int getOffMinutes(long btime, long ltime) {
        return (int) ((ltime - btime) / minute);
    }

    public static String getNowYear() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String getNowMonth() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String getNowDay() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String getNowHour() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String getNowMinute() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("mm");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static String getNowSecond() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static java.sql.Date changeUtilToSql(Date date) {
        java.sql.Date sDate = null;
        if (date != null) {
            sDate = new java.sql.Date(date.getTime());
        }
        return (sDate);
    }

    /**
     * @param length
     *            你需要的串有多长，4<length<14
     * @return 对于length长度的日期字符串，从年份开始
     */
    public static String getNowDateBunch(int length) {
        // int length=0;
        // switch(flag){
        // case 1:{
        // length=4;break;
        // }
        // case 2:{
        // length=6;break;
        // }
        // case 3:{
        // length=8;break;
        // }
        // case 4:{
        // length=10;break;
        // }
        // case 5:{
        // length=12;break;
        // }
        // case 6:{
        // length=14;break;
        // }
        // default :return "";
        // }
        Date currentTime = new Date();
        String modelDate = "yyyyMMddHHmmss".substring(0, length > 14 ? 14
                : length);
        SimpleDateFormat formatter = new SimpleDateFormat(modelDate);
        return formatter.format(currentTime);
    }

    public static String formatDate(String dateStr, String model) {
        String[] dates = dateStr.split("-");
        model = model.replaceAll("[Y|y]{4}", dates[0]); // 替换年，不区分大小写
        model = model.replaceAll("MM", dates[1]); // 替换月，区分大小写
        model = model.replaceAll("[D|d]{2}", dates[2]); // 替换日，不区分大小写
        return model;
    }
}
