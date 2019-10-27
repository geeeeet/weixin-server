package pers.lrf.weixinserver.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.i18n.LocaleContextHolder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Date Utility Class used to convert Strings to Dates and Timestamps
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a> Modified by
 * <a href="mailto:dan@getrolling.com">Dan Kibler </a> to correct time
 * pattern. Minutes should be mm not MM (MM is month).
 */
public final class DateUtil {
    private static Log log = LogFactory.getLog(DateUtil.class);
    public static final String BUNDLE_KEY = "ApplicationResources";
    private static final String TIME_PATTERN = "HH:mm";
    public static final String FORMAT_STRING_24 = "yyyy-MM-dd HH:mm:ss";//24小时制
    public static final String FORMAT_STRING_12 = "yyyy-MM-dd hh:mm:ss";//12小时制

    /**
     * Checkstyle rule: utility classes should not have public constructor
     */
    private DateUtil() {
    }

    /**
     * 获取两个日期字符串之间的日期集合
     * @param startTime:String
     * @param endTime:String
     * @return list:yyyy-MM-dd
     */
    public static List<String> getBetweenDate(String startTime,String endTime,String type){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (type != null && !"".equals(type)){
            sdf = new SimpleDateFormat(type);
        }
        List<String> list = new ArrayList<>();
        try {
            // 转化成日期类型
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);

            //用Calendar 进行日期比较判断
            Calendar calendar = Calendar.getInstance();
            while (startDate.getTime()<=endDate.getTime()){
                // 把日期添加到集合
                list.add(sdf.format(startDate));
                // 设置日期
                calendar.setTime(startDate);
                //把日期增加一天
                calendar.add(Calendar.DATE, 1);
                // 获取增加后的日期
                startDate=calendar.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Return default datePattern (MM/dd/yyyy)
     *
     * @return a string representing the date pattern on the UI
     */
    public static String getDatePattern() {
        Locale locale = LocaleContextHolder.getLocale();
        String defaultDatePattern;
        try {
            defaultDatePattern = ResourceBundle.getBundle(BUNDLE_KEY, locale)
                    .getString("date.format");
        } catch (MissingResourceException mse) {
            defaultDatePattern = "MM/dd/yyyy";
        }

        return defaultDatePattern;
    }

    public static String getDateTimePattern() {
        return DateUtil.getDatePattern() + " HH:mm:ss.S";
    }

    /**
     * This method attempts to convert an Oracle-formatted date in the form
     * dd-MMM-yyyy to mm/dd/yyyy.
     *
     * @param aDate date from database as a string
     * @return formatted string for the ui
     */
    public static String getDate(Date aDate) {
        SimpleDateFormat df;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(getDatePattern());
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date/time in the
     * format you specify on input
     *
     * @param aMask   the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @throws ParseException when String doesn't match the expected format
     * @see SimpleDateFormat
     */
    public static Date convertStringToDate(String aMask, String strDate)
            throws ParseException {
        SimpleDateFormat df;
        Date date;
        df = new SimpleDateFormat(aMask);

        if (log.isDebugEnabled()) {
            log.debug("converting '" + strDate + "' to date with mask '"
                    + aMask + "'");
        }

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            // log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }

    public static Date convertDate(String strDate) {
        Date date = null;
        try {

            SimpleDateFormat df = new SimpleDateFormat();
            date = df.parse(strDate);
        } catch (ParseException pe) {
            log.error("ParseException: " + pe);
        }
        return (date);
    }

    /**
     * This method returns the current date time in the format: MM/dd/yyyy HH:MM
     * a
     *
     * @param theTime the current time
     * @return the current date/time
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(TIME_PATTERN, theTime);
    }

    /**
     * This method returns the current date in the format: MM/dd/yyyy
     *
     * @return the current date
     * @throws ParseException when String doesn't match the expected format
     */
    public static Calendar getToday() throws ParseException {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

        // This seems like quite a hack (date -> string -> date),
        // but it works ;-)
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));

        return cal;
    }

    /**
     * This method generates a string representation of a date's date/time in
     * the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param aDate a date object
     * @return a formatted string representation of the date
     * @see SimpleDateFormat
     */
    public static String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            log.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date based on the
     * System Property 'dateFormat' in the format you specify on input
     *
     * @param aDate A date to convert
     * @return a string representation of the date
     */
    public static String convertDateToString(Date aDate) {
        return getDateTime(getDatePattern(), aDate);
    }

    /**
     * This method converts a String to a date using the datePattern
     *
     * @param strDate the date to convert (in format MM/dd/yyyy)
     * @return a date object
     * @throws ParseException when String doesn't match the expected format
     */
    public static Date convertStringToDate(String strDate)
            throws ParseException {
        Date aDate = null;

        try {
            if (log.isDebugEnabled()) {
                log.debug("converting date with pattern: " + getDatePattern());
            }

            aDate = convertStringToDate(getDatePattern(), strDate);
        } catch (ParseException pe) {
            log.error("Could not convert '" + strDate
                    + "' to a date, throwing exception");
            pe.printStackTrace();
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return aDate;
    }

    /**
     * ��ȡ����ʱ�䡣
     *
     * @param beginDateTime
     * @param timeExpiry    ��λΪ�롣
     * @return
     * @throws ParseException
     */
    public static Date getExpiryDateTime(String beginDateTime, long timeExpiry)
            throws ParseException {

        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date d1 = sim.parse(beginDateTime);
        long time = d1.getTime();

        timeExpiry = timeExpiry * 1000;

        time += timeExpiry;

        return new Date(time);
    }

    /**
     * 过期时间
     *
     * @param beginDate
     * @param timeExpiry
     * @return
     * @throws ParseException
     */
    public static Date getExpiryDateTime(Date beginDate, long timeExpiry)
            throws ParseException {
        long time = beginDate.getTime();
        timeExpiry = timeExpiry * 1000;
        time += timeExpiry;
        return new Date(time);
    }

    /**
     * 从一个日期取得间隔一段时间的另一个日期
     *
     * @param date     参照日期，从该日期开始计算
     * @param distance 间隔时间量，- 表示之前，+ 表示之后
     * @param type     间隔单位：年(year)，月(month)，日(date)，周(week)
     * @return date
     */
    public static Date addDate(Date date, Integer distance, String type) {
        try {
            if (null == date || null == distance) {
                return null;
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            if ("date".equalsIgnoreCase(type)) {
                cal.add(Calendar.DATE, distance);
            }
            if ("month".equalsIgnoreCase(type)) {
                cal.add(Calendar.MONTH, distance);
            }
            if ("year".equalsIgnoreCase(type)) {
                cal.add(Calendar.YEAR, distance);
            }
            if ("week".equalsIgnoreCase(type)) {
                cal.add(Calendar.DATE, distance * 7);
            }
            return cal.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param
     * @return X秒前，Y分钟前，a月b日
     */
    public static String dateInterval2(Date myDate) {
        //TODO:如果是空，就用当前时间
        if (myDate == null)
            myDate = new Date();
        final long _SECOND = 1000L;//1秒
        final long _MINUTES = _SECOND * 60L;//1分钟
        final long _HOUR = _MINUTES * 60L;//1小时
        final long _DAY = _HOUR * 24L;//1天

        Calendar myCalendar = Calendar.getInstance();
        myCalendar.setTime(myDate);
        int hour = myCalendar.get(Calendar.HOUR_OF_DAY);
        int day = myCalendar.get(Calendar.DAY_OF_MONTH);
        String minute = (myCalendar.get(Calendar.MINUTE) > 9) ? "" + myCalendar.get(Calendar.MINUTE) : "0" + myCalendar.get(Calendar.MINUTE);

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        //int nowHours = calendar.get(Calendar.HOUR_OF_DAY);
        int nowDay = calendar.get(Calendar.DAY_OF_MONTH);
        long longtime = calendar.getTime().getTime() - myDate.getTime();
        String str = "";
        if (longtime > _DAY) {  //>24小时
            str = getDateTime("MM-dd HH:mm", myDate);
        } else if (longtime > _HOUR) {//1~24小时:a在今天，b不在今天
            if (day < nowDay)
                str = getDateTime("MM-dd HH:mm", myDate);
            else
                str = hour + ":" + minute + "d";
        } else if (longtime > _MINUTES) { //时间在分钟的范围内 1~60分钟
            str = Math.round(longtime / _MINUTES) + "m";
        } else if (longtime > _SECOND) { //时间在秒的范围内   1~60秒
            str = Math.round(longtime / _SECOND) + "s";
        } else {
            str = 1 + "s";
        }
        return str;
    }

    public static Long dateInterval(Date date) {
        Long dateInterval = null;
        Calendar calendar = Calendar.getInstance();
        Date begin = calendar.getTime();
        dateInterval = (begin.getTime() - date.getTime()) / (60000);
        return dateInterval;
    }

    public static Boolean isSameDay(Date date) {
        Boolean isSameDay = false;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int year1 = calendar1.get(Calendar.YEAR);
        if (year != year1) {
            return isSameDay;
        }
        int day = calendar.get(Calendar.DAY_OF_YEAR);
        int day1 = calendar1.get(Calendar.DAY_OF_YEAR);
        if (day == day1) {
            isSameDay = true;
        }

        return isSameDay;
    }

    public static int getYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.YEAR);
    }

    public static int getMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MONTH) + 1;
    }

    public static int getWeekOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    public static int getWeekOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 返回当月最小时间
     *
     * @param
     */
    public static String getMonthMinDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String month = "";
        month = DateUtil.formatNum(cal.get(Calendar.MONTH) + 1);
        return cal.get(Calendar.YEAR) + "-" + month + "-01 00:00:00";
    }

    /**
     * 返回当月最大时间
     *
     * @param
     */
    public static String getMonthMaxDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String month = "";
        String day = "";
        month = DateUtil.formatNum(cal.get(Calendar.MONTH) + 1);
        day = DateUtil.formatNum(cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.get(Calendar.YEAR) + "-" + month + "-" + day + " 23:59:59";
    }

    private static String formatNum(int temp) {
        String reStr;
        if (temp < 10) {
            reStr = "0" + temp;
        } else {
            reStr = "" + temp;
        }
        return reStr;
    }

    /**
     * @param start1
     * @param end1
     * @param start2
     * @param end2
     * @return
     * @Description 比较两个时间段是否有交集
     * @author zhangys
     * @date 2015-12-09
     * @modifyNote
     */
    public static boolean compareDatesRetain(Date start1, Date end1, Date start2, Date end2) {
        try {
            if (start1 == null || end1 == null || start2 == null || end2 == null) {
                return false;
            } else if (start1.compareTo(end1) > 0 || start2.compareTo(end2) > 0) {
                return false;
            } else if (start1.getTime() < start2.getTime() && start2.getTime() < end1.getTime()) {
                return false;
            } else if (start1.getTime() < end2.getTime() && start2.getTime() < end1.getTime()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Date getTodayStart() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date todayStart = calendar.getTime();
        return todayStart;
    }

    public static Date getTomorrowStart() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, 1);
        Date todayStart = calendar.getTime();
        return todayStart;
    }

    public static Date getYesterdayStart() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.add(Calendar.DATE, -1);
        Date yesterDayStart = calendar.getTime();
        System.out.println(yesterDayStart);
        return yesterDayStart;
    }

    /**
     * @param start
     * @param end
     * @return
     * @Description 求两个日期相差天数
     * @author zhangys
     * @date 2015-12-09
     * @modifyNote
     */
    public static long differenceDays(Date start, Date end) {
        try {
            if (start == null || end == null)
                return 0;
            return (end.getTime() - start.getTime()) / (86400000);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Description：根据field设置对应的时间值
     *
     * @param date  时间对象
     * @param field 要设置的属性（可以是年月日、时分秒）
     * @param value 要设置的值
     * @return 返回设置后的新的时间对象
     * @author 李瑞威
     * @createTime 2016年8月16日 上午9:56:23
     */
    public static Date setDateByFieldNum(Date date, int field, int value) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(field, value);
        return cal.getTime();
    }

    public static void main(String[] args) throws ParseException {
        String s = DateUtil.getDateTime("yyyy-MM-dd HH:mm:ss", new Date());
        System.out.println(s);
    }
}
