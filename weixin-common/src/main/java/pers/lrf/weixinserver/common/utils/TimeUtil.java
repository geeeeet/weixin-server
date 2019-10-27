package pers.lrf.weixinserver.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * desc
 * Created by admin on 2016/10/10.
 */
public class TimeUtil {

    public static final String TIME_FORMAT_SS = "yyyy/MM/dd HH:mm:ss";

    public static final String TIME_FORMAT_DD = "yyyy/MM/dd";


    /**
     * 字符串转时间
     *
     * @param srtDate
     * @return
     */
    public static Date getTimeFormat(String srtDate, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = sdf.parse(srtDate);
        return date;
    }


    /**
     * 获取当前日期
     *
     * @param dateKeyFormat
     * @return
     */
    public static String getCurrentDate(String dateKeyFormat) {
        SimpleDateFormat sf = new SimpleDateFormat(dateKeyFormat);
        return sf.format(new Date());
    }

    /**
     * 获取时间段列表
     *
     * @return
     */
    public static List<String> getHisDateFromNowOn(String startDate, String format) throws ParseException {
        Calendar calendar_start = Calendar.getInstance();
        Calendar calendar_end = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        List<String> final_list = new ArrayList<String>();

        Date start_date = sdf.parse(startDate);
        calendar_start.setTime(start_date);
        Date end_date = sdf.parse(sdf.format(new Date()));
        calendar_end.setTime(end_date);
        calendar_end.add(Calendar.DATE, -1);//自昨天开始计算

        // 逐天递减到指定日期 包含指定天
        while (calendar_end.compareTo(calendar_start) >= 0) {
            final_list.add(sdf.format(calendar_end.getTime()));
            calendar_end.add(Calendar.DATE, -1);
        }
        return final_list;
    }

    /**
     * 获取时间整点
     * 传入3：58 返回4
     *
     * @return
     */
    public static String getHourFloor() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, 10);//延迟10min计算
        return String.valueOf(cal.get(Calendar.HOUR_OF_DAY));//h24
    }


}
