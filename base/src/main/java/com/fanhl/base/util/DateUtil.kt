package com.fanhl.base.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * 日期时间工具类
 *
 * Created by fanhl on 15/8/6.
 *
 * @author fanhl
 */
object DateUtil {
    /** 没时间写  */
    val FORMAT_TIMESTAMP = "MMM dd, yyyy HH:mm:ss a"
    /** 没时间写  */
    val FORMAT_LONG = "yyyy-MM-dd HH:mm:ss"
    /** 没时间写  */
    val FORMAT_LONG2 = "yyyy-MM-dd_HH-mm-ss-MMM"
    /** 没时间写  */
    val FORMAT_yMdHm = "yyyy-MM-dd HH:mm"
    /** 没时间写  */
    val FORMAT_SHORT = "yyyy-MM-dd"
    /** 没时间写  */
    val FORMAT_SHORT2 = "yyyy/MM/dd"
    /** 没时间写  */
    val FORMAT_NUMBER = "yyyyMMdd"
    /** 没时间写  */
    val FORMAT_CN = "yyyy年MM月dd日 HH:mm:ss"
    /** 没时间写  */
    val FORMAT_CN_SHORT = "yyyy年MM月dd日"
    /** 没时间写  */
    val FORMAT_TIME = "HH:mm"
    /** 没时间写  */
    val FORMAT_TIME_NE = "HH:mm"
    /** 没时间写  */
    val FORMAT_yyyyMM = "yyyy-MM"
    /** 没时间写  */
    val FORMAT_hms = "HH:mm:ss"
    /** 没时间写  */
    val FORMAT_CN_YM = "yyyy年MM月"
    /** 没时间写  */
    val FORMAT_CN_YM2 = "yyyy年M月"
    /** 没时间写  */
    val FORMAT_CN_YMD = "yyyy年MM月dd日"
    /** 没时间写  */
    val FORMAT_CN_MD = "M月d日"
    /** 没时间写  */
    val FORMAT_CN_d_Hm = "dd日 HH:mm"
    /** 没时间写  */
    val FORMAT_MdHm = "MM-dd HH:mm"
    /** 没时间写  */
    val FORMAT_Md = "MM-dd"
    /** 没时间写  */
    val FORMAT_Md2 = "MM/dd"
    /** 没时间写  */
    val FORMAT_CN_M = "MM月"
    /** 没时间写  */
    val FORMAT_d = "d"
    /** 没时间写  */
    val FORMAT_UTC = "yyyy-MM-dd'T'HH:mm:ss'Z'"
    /** 没时间写  */
    val FORMAT_WEEK = "EEE"


    /**
     * 2016-05-31T01:45:32Z --> 2016-05-31 09:45:32 +8:00
     *
     * @param str
     * 没时间写
     * @return 没时间写
     */
    fun utc2LocalDate(str: String?): Date? {
        return utc2LocalDate(str, FORMAT_UTC)
    }

    /**
     * 2016-05-31T01:45:32Z --> 时间戳
     *
     * @param str
     * 没时间写
     * @return 没时间写
     */
    fun utc2LocalTime(str: String): Long {
        return utc2LocalDate(str, FORMAT_UTC)!!.time
    }

    /**
     * 2016-05-31T01:45:32Z --> 2016-05-31 09:45:32 +8:00
     *
     * @param str
     * 没时间写
     * @param format
     * 没时间写
     * @return 没时间写
     */
    fun utc2LocalDate(str: String?, format: String): Date? {
        if (Util.isNullOrEmpty(str)) {
            return null
        }
        val simpleDateFormat = SimpleDateFormat(format)
        simpleDateFormat.timeZone = TimeZone.getTimeZone("GMT")
        var date: Date? = null
        try {
            date = simpleDateFormat.parse(str)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return date
    }

    /**
     * templete: FORMAT_STR -> Date
     *
     * @param str
     * 没时间写
     * @param format
     * 没时间写
     * @return 没时间写
     */
    fun str2date(str: String?, format: String): Date? {
        if (Util.isNullOrEmpty(str)) {
            return null
        }
        val simpleDateFormat = SimpleDateFormat(format)
        var date: Date? = null
        try {
            date = simpleDateFormat.parse(str)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return date
    }

    /**
     * templete: Date -> FORMAT_STR
     *
     * @param date
     * 没时间写
     * @param format
     * 没时间写
     * @return 没时间写
     */
    fun date2str(date: Date?, format: String): String? {
        if (date == null) {
            return null
        }
        val sdf = SimpleDateFormat()
        sdf.applyPattern(format)
        return sdf.format(date)
    }

    /**
     * templete: "yyyy-MM-dd HH:mm:ss" -> Date
     *
     * @param str
     * 没时间写
     * @return 没时间写
     */
    fun long2date(str: String): Date? {
        return str2date(str, FORMAT_LONG)
    }

    /**
     * templete: "yyyy-MM-dd" -> Date
     *
     * @param str
     * 没时间写
     * @return 没时间写
     */
    fun short2date(str: String?): Date? {
        return str2date(str, FORMAT_SHORT)
    }

    /**
     * templete: "yyyy/MM/dd" -> Date
     *
     * @param str
     * 没时间写
     * @return 没时间写
     */
    fun short2date2(str: String): Date? {
        return str2date(str, FORMAT_SHORT2)
    }


    /**
     * templete: "yyyyMMdd" -> Date
     *
     * @param str
     * 没时间写
     * @return 没时间写
     */
    fun number2date(str: String): Date? {
        return str2date(str, FORMAT_NUMBER)
    }

    /**
     * templete: "yyyy年MM月dd日" -> Date
     *
     * @param str
     * 没时间写
     * @return 没时间写
     */
    fun cnshort2date(str: String): Date? {
        return str2date(str, FORMAT_CN_SHORT)
    }

    /**
     * templete: "Sep 15, 2014 12:00:01 AM" -> Date
     *
     * @param str
     * 没时间写
     * @return 没时间写
     */
    fun gson2date(str: String): Date? {
        return str2date(str, FORMAT_TIMESTAMP)
    }

    /**
     * templete: Date -> "yyyy-MM-dd HH:mm:ss"
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun date2long(date: Date): String? {
        return date2str(date, FORMAT_LONG)
    }

    /**
     * templete: Date -> "Sep 15, 2014 12:00:01 AM"
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun date2gson(date: Date): String? {
        return date2str(date, FORMAT_TIMESTAMP)
    }

    /**
     * templete: Date -> "yyyy-MM-dd"
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun date2short(date: Date?): String? {
        return date2str(date, FORMAT_SHORT)
    }

    /**
     * templete: Date -> "yyyy/MM/dd"
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun date2short2(date: Date): String? {
        return date2str(date, FORMAT_SHORT2)
    }

    /**
     * templete: String -> "yyyyMMdd"
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun date2number(date: Date): String? {
        return date2str(date, FORMAT_NUMBER)
    }

    /**
     * templete: String -> "yyyy年MM月dd日 HH:mm:ss"
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun date2cn(date: Date): String? {
        return date2str(date, FORMAT_CN)
    }

    /**
     * templete: String -> "yyyy年MM月dd日 HH:mm:ss"
     *
     * @param time
     * shi
     * @return 没时间写
     */
    fun date2cn(time: Long): String? {
        return date2str(Date(time), FORMAT_LONG)
    }

    /**
     * templete: String -> "yyyy年MM月dd日"
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun date2cnshort(date: Date): String? {
        return date2str(date, FORMAT_CN_SHORT)
    }

    /**
     * @param date
     * 没时间写
     * @param step
     * 没时间写
     * @return 没时间写
     */
    fun addDay(date: Date, step: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DAY_OF_MONTH, step)
        return calendar.time
    }

    /**
     * @param date
     * 没时间写
     * @param step
     * 没时间写
     * @return 没时间写
     */
    fun addMouth(date: Date, step: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.MONTH, step)
        return calendar.time
    }

    /**
     * @param date
     * 没时间写
     * @param step
     * 没时间写
     * @return 没时间写
     */
    fun addYear(date: Date, step: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.YEAR, step)
        return calendar.time
    }

    /**
     * 取得一周开始的一天(周一)
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun getFirstDayInWeekCn(date: Date?): Date? {
        var firstDate: Date? = null
        if (date != null) {
            val calendar = Calendar.getInstance()
            calendar.time = date
            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                //美式日历的 星期天的当周的周一，是中式日历的当周的周一的下一天
                //美式 7123456
                //中式 1234567
                calendar.add(Calendar.DAY_OF_MONTH, -7)
            }
            calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)    //设置为第一天(周一)
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            firstDate = Date(calendar.timeInMillis)
        }
        return firstDate
    }

    /**
     * 取得一周结束的一天(周日)
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun getLastDayInWeekCn(date: Date?): Date? {
        var firstDate: Date? = null
        if (date != null) {
            val calendar = Calendar.getInstance()
            calendar.time = date
            if (calendar.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)    //设置为周日
                //美式日历的 非星期天的当周的周日，是中式日历的当周的周日的下一周
                //美式 7123456
                //中式 1234567
                calendar.add(Calendar.DAY_OF_MONTH, 7)
            }
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            firstDate = Date(calendar.timeInMillis)
        }
        return firstDate
    }

    /**
     * 取得一个月开始的一天
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun getFirstDayInMonth(date: Date?): Date? {
        var firstDate: Date? = null
        if (date != null) {
            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar.set(Calendar.DAY_OF_MONTH, 1)    //设置为第一天
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            firstDate = Date(calendar.timeInMillis)
        }
        return firstDate
    }

    /**
     * 取得下一个月开始的一天
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun getFirstDayInNextMonth(date: Date?): Date? {
        var firstDate: Date? = null
        if (date != null) {
            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar.set(Calendar.DAY_OF_MONTH, 1)    //设置为第一天
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)

            calendar.add(Calendar.MONTH, 1)            //月份数增1
            firstDate = Date(calendar.timeInMillis)
        }
        return firstDate
    }

    /**
     * 取得一个月结束的一天
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun getLastDayInMonth(date: Date?): Date? {
        var lastDate: Date? = null
        if (date != null) {
            val calendar = Calendar.getInstance()
            calendar.time = date
            calendar.add(Calendar.MONTH, 1)            //月份数增1
            calendar.set(Calendar.DAY_OF_MONTH, 1)    //设置日期设置为月份的1号
            calendar.add(Calendar.DATE, -1)            //日期减1，返回上月的最后一天
            calendar.set(Calendar.HOUR_OF_DAY, 0)
            calendar.set(Calendar.MINUTE, 0)
            calendar.set(Calendar.SECOND, 0)
            calendar.set(Calendar.MILLISECOND, 0)
            lastDate = Date(calendar.timeInMillis)
        }
        return lastDate
    }

    /**
     * 获取当前日期是星期几<br></br>
     *
     * @param date
     * 没时间写
     * @return 当前日期是星期几
     */
    fun getWeekCnOfDate(date: Date): String {
        val weekDays = arrayOf("周日", "周一", "周二", "周三", "周四", "周五", "周六")
        val cal = Calendar.getInstance()
        cal.time = date
        var w = cal.get(Calendar.DAY_OF_WEEK) - 1
        if (w < 0)
            w = 0
        return weekDays[w]
    }

    /**
     * @param milliseconds
     * 没时间写
     * @return 没时间写
     */
    fun second2date(milliseconds: Long): Date {
        return Date(milliseconds)
    }

    /**
     * @param date
     * @return 没时间写
     */
    fun date2time(date: Date): String? {
        return date2str(date, FORMAT_TIME)
    }

    /**
     * 是否为当天
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun isToday(date: Date?): Boolean {
        if (date == null)
            return false
        val today = Date()
        return date2short(today) == date2short(date)
    }

    /**
     * fromDate是否大于toDate（最小单位为天）
     *
     * @param fromDate
     * 没时间写
     * @param toDate
     * 没时间写
     * @return 没时间写
     */
    fun isAfterByDay(fromDate: Date?, toDate: Date?): Boolean {
        if (fromDate == null)
            return false
        if (toDate == null)
            return true
        val fromDate2 = short2date(date2short(fromDate))
        val toDate2 = short2date(date2short(toDate))

        return fromDate2!!.time > toDate2!!.time

        //        if (fromDate.getYear() > toDate.getYear()) {
        //            return true;
        //        } else if (fromDate.getYear() < toDate.getYear()) {
        //            return false;
        //        }else if (fromDate.getMonth() > toDate.getMonth()) {
        //            return true;
        //        } else if (fromDate.getMonth() < toDate.getMonth()) {
        //            return false;
        //        }if (fromDate.getDay() > toDate.getDay()) {
        //            return true;
        //        } else/* if (fromDate.getDay() < toDate.getDay())*/ {
        //            return false;
        //        }
    }

    /**
     * fromDate是否大于等于toDate（最小单位为天）
     *
     * @param fromDate
     * 没时间写
     * @param toDate
     * 没时间写
     * @return 没时间写
     */
    fun isAfterOrEqualByDay(fromDate: Date?, toDate: Date?): Boolean {
        if (fromDate == null)
            return false
        if (toDate == null)
            return true
        val fromDate2 = short2date(date2short(fromDate))
        val toDate2 = short2date(date2short(toDate))

        return fromDate2!!.time >= toDate2!!.time

        //        if (fromDate.getYear() > toDate.getYear()) {
        //            return true;
        //        } else if (fromDate.getYear() < toDate.getYear()) {
        //            return false;
        //        }else if (fromDate.getMonth() > toDate.getMonth()) {
        //            return true;
        //        } else if (fromDate.getMonth() < toDate.getMonth()) {
        //            return false;
        //        }if (fromDate.getDay() > toDate.getDay()) {
        //            return true;
        //        } else/* if (fromDate.getDay() < toDate.getDay())*/ {
        //            return false;
        //        }
    }

    /**
     * 取得当前时间偏移weekOffset周的时间
     *
     * @param date
     * 没时间写
     * @param weekOffset
     * 没时间写
     * @return 没时间写
     */
    fun offsetWeek(date: Date?, weekOffset: Int): Date? {
        if (date == null) {
            return null
        }

        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.WEEK_OF_YEAR, weekOffset)

        return calendar.time
    }

    /**
     * 取得当前时间偏移weekOffset周的时间
     *
     * @param date
     * 没时间写
     * @param monthOffset
     * 没时间写
     * @return 没时间写
     */
    fun offsetMonth(date: Date?, monthOffset: Int): Date? {
        if (date == null) {
            return null
        }

        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.MONTH, monthOffset)

        return calendar.time
    }

    /**
     * @param elapsed_time
     * eg: 1234
     * @return eg: 00:12:34
     */
    fun second2hms(elapsed_time: Int): String {
        var elapsed_time = elapsed_time
        val second = elapsed_time % 60
        elapsed_time /= 60
        val minute = elapsed_time % 60
        elapsed_time /= 60
        val hour = elapsed_time//% 24;
        return if (hour < 100) {
            String.format("%02d:%02d:%02d", hour, minute, second)//小时上于两位时显示两位
        } else {
            String.format("%d:%02d:%02d", hour, minute, second)//小时超过两位有多少显示多少
        }
    }

    /**
     * @param elapsed_time
     * eg: 1234
     * @return eg: 2 ， 2.1
     */
    fun second2hour(elapsed_time: Int): String {
        val hourStr = String.format("%.1f", elapsed_time.toFloat() / 60f / 60f)
        return if (!hourStr.endsWith(".0")) {
            hourStr
        } else {
            hourStr.substring(0, hourStr.length - 2)
        }
    }

    /**
     * 判断两个日期是不是在同一月
     *
     * @param date1
     * 没时间写
     * @param date2
     * 没时间写
     * @return 没时间写
     */
    fun isSameMonth(date1: Date?, date2: Date?): Boolean {
        if (date1 == null || date2 == null) {
            return false
        }

        val cal1 = Calendar.getInstance()
        val cal2 = Calendar.getInstance()
        cal1.time = date1
        cal2.time = date2

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
    }

    /**
     * 在月份的基础上比较大小
     *
     * @param date1
     * 没时间写
     * @param date2
     * 没时间写
     * @return 没时间写
     */
    fun compareMonth(date1: Date, date2: Date): Long {
        val cal1 = Calendar.getInstance()
        val cal2 = Calendar.getInstance()
        cal1.time = date1
        cal2.time = date2

        return if (cal1.get(Calendar.YEAR) != cal2.get(Calendar.YEAR)) {
            ((cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR)) * 12).toLong()
        } else {
            (cal1.get(Calendar.MONTH) - cal2.get(Calendar.MONTH)).toLong()
        }
    }

    /**
     * 在年的基础上比较大小
     *
     * @param date1
     * 没时间写
     * @param date2
     * 没时间写
     * @return 没时间写
     */
    fun compareYear(date1: Date, date2: Date): Long {
        val cal1 = Calendar.getInstance()
        val cal2 = Calendar.getInstance()
        cal1.time = date1
        cal2.time = date2

        return (cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR)).toLong()
    }

    /**
     * 比较日期，年月日比较
     *
     * @param fromDate
     * 没时间写
     * @param toDate
     * 没时间写
     * @return 没时间写
     */
    fun isAfterDay(fromDate: Date, toDate: Date): Boolean {
        val fromCal = Calendar.getInstance()
        val toCal = Calendar.getInstance()
        fromCal.time = fromDate
        toCal.time = toDate

        return fromCal.get(Calendar.YEAR) > toCal.get(Calendar.YEAR) ||
                fromCal.get(Calendar.MONTH) > toCal.get(Calendar.MONTH) ||
                fromCal.get(Calendar.DAY_OF_MONTH) > toCal.get(Calendar.DAY_OF_MONTH)
    }

    /**
     * 判断两个日期是不是在同一天
     *
     * @param date1
     * 没时间写
     * @param date2
     * 没时间写
     * @return 没时间写
     */
    fun isSameDay(date1: Date?, date2: Date?): Boolean {
        if (date1 == null || date2 == null) {
            return false
        }

        val cal1 = Calendar.getInstance()
        val cal2 = Calendar.getInstance()
        cal1.time = date1
        cal2.time = date2

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH)
    }

    /**
     * 判断两个日期是不是在同一周
     *
     * @param date1
     * 没时间写
     * @param date2
     * 没时间写
     * @return 没时间写
     */
    fun isInSameWeek(date1: Date?, date2: Date?): Boolean {
        if (date1 == null || date2 == null) {
            return false
        }

        val cal1 = Calendar.getInstance()
        val cal2 = Calendar.getInstance()
        cal1.time = date1
        cal2.time = date2

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                cal1.get(Calendar.WEEK_OF_MONTH) == cal2.get(Calendar.WEEK_OF_MONTH)
    }

    /**
     * 没时间写
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun getDaysInMonth(date: Date?): Int {
        var daysInMonth = 0
        if (date != null) {
            val calendar = Calendar.getInstance()
            calendar.time = date

            // Get the number of days in that month
            daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        }
        return daysInMonth
    }

    /**
     * 日期是周几，周一算是第一天
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun getDayInWeekCN(date: Date): Int {
        val calendar = Calendar.getInstance()
        calendar.time = date
        //一周的第几天，周天是0，改为周天为7，周一到周天：1-7
        var defaultDayInWeek = calendar.get(Calendar.DAY_OF_WEEK)
        defaultDayInWeek--
        if (defaultDayInWeek == 0) {
            defaultDayInWeek = 7
        }
        return defaultDayInWeek
    }

    /**
     * 日期类型转换
     *
     * @param str
     * "2017-03-14 10:03:58"
     * @return 1489002390 second 秒（注意，这里不是毫秒）
     */
    fun long2sec(str: String?): Long {
        var sec: Long = 0
        if (str != null) {
            val date = long2date(str)
            if (date != null) {
                sec = date.time / 1000
            }
        }
        return sec
    }

    /**
     * 是否需要缓存下个月的数据
     *
     * @param dateSelected
     * 如果选择的年和月小于当前的年和月，则 < 0；等于则 = 0；否则 > 0
     * @return
     */
    fun compare2CurrentMonth(dateSelected: Date): Int {
        // dateSelected - dateCurrent
        val calendarSelected = Calendar.getInstance()
        calendarSelected.time = dateSelected

        val calendarCurrent = Calendar.getInstance()
        calendarCurrent.timeInMillis = System.currentTimeMillis()

        if (calendarSelected.get(Calendar.YEAR) == calendarCurrent.get(Calendar.YEAR)) {
            if (calendarSelected.get(Calendar.MONTH) == calendarCurrent.get(Calendar.MONTH)) {
                return 0
            }
            return if (calendarSelected.get(Calendar.MONTH) < calendarCurrent.get(Calendar.MONTH)) {
                -1
            } else {
                1
            }
        }

        return if (calendarSelected.get(Calendar.YEAR) < calendarCurrent.get(Calendar.YEAR)) {
            -1
        } else {
            1
        }
    }

    /**
     * 比较两个date，日期
     * from - to < 0；
     * from - to = 0；
     * from - to > 0；
     *
     * @param fromDate
     * @param toDate
     * @return
     */
    fun compareByDate(fromDate: Date, toDate: Date): Int {
        // fromDate - toDate
        val calendarFrom = Calendar.getInstance()
        calendarFrom.time = fromDate

        val calendarTo = Calendar.getInstance()
        calendarTo.time = toDate

        if (calendarFrom.get(Calendar.YEAR) == calendarTo.get(Calendar.YEAR)) {
            if (calendarFrom.get(Calendar.DAY_OF_YEAR) == calendarTo.get(Calendar.DAY_OF_YEAR)) {
                return 0
            }
            return if (calendarFrom.get(Calendar.DAY_OF_YEAR) < calendarTo.get(Calendar.DAY_OF_YEAR)) {
                -1
            } else {
                1
            }
        }
        return if (calendarFrom.get(Calendar.YEAR) < calendarTo.get(Calendar.YEAR)) {
            -1
        } else {
            1
        }
    }

    /**
     * 比较两个date，日期
     * from - to < 0；
     * from - to = 0；
     * from - to > 0；
     *
     * @param fromDate
     * @return
     */
    fun compare2TodayBydate(fromDate: Date): Int {
        // fromDate - toDate
        val calendarFrom = Calendar.getInstance()
        calendarFrom.time = fromDate

        val calendarTo = Calendar.getInstance()
        calendarTo.timeInMillis = System.currentTimeMillis()

        if (calendarFrom.get(Calendar.YEAR) == calendarTo.get(Calendar.YEAR)) {
            if (calendarFrom.get(Calendar.DAY_OF_YEAR) == calendarTo.get(Calendar.DAY_OF_YEAR)) {
                return 0
            }
            return if (calendarFrom.get(Calendar.DAY_OF_YEAR) < calendarTo.get(Calendar.DAY_OF_YEAR)) {
                -1
            } else {
                1
            }
        }
        return if (calendarFrom.get(Calendar.YEAR) < calendarTo.get(Calendar.YEAR)) {
            -1
        } else {
            1
        }
    }

    /**
     * 比较两个date，日期
     * from - to < 0；
     * from - to = 0；
     * from - to > 0；
     *
     * @param fromDate
     * 没时间写
     * @param toDate
     * 没时间写
     * @return 没时间写
     */
    fun compareMillsByDate(fromDate: Date, toDate: Date): Long {
        // fromDate - toDate
        return fromDate.time - toDate.time
    }

    /**
     * fromDate与当前时间比较
     *
     * @param fromDate
     * @return 时间，一定还是要用long，不要用int，否则会溢出（负变正）
     */
    fun compareMillsByDate(fromDate: Date): Long {
        // fromDate - toDate
        return fromDate.time - System.currentTimeMillis()
    }

    /**
     * 对比，两个时间，calendarFrom-calendarTo 超过maxDays，自动修正
     *
     * @param calendarFrom
     * 没时间写
     * @param calendarTo
     * 没时间写
     * @param maxDays
     * 没时间写
     * @param isFixFrom
     * 修正from还是to
     * @return 没时间写
     */
    fun fixFromToCalendar(calendarFrom: Calendar, calendarTo: Calendar, maxDays: Int, isFixFrom: Boolean): Calendar {
        val millsFrom = calendarFrom.timeInMillis
        val millsTo = calendarTo.timeInMillis

        //每天毫秒数
        val millsPerDay = (24 * 60 * 60 * 1000).toLong()
        //相差的天数
        val betweenDays = Math.abs((millsFrom - millsTo) / millsPerDay)
        //from > to
        val isFromBigger = millsFrom - millsTo > 0

        val calendarResult = Calendar.getInstance()

        if (isFixFrom) {
            calendarResult.timeInMillis = millsFrom
        } else {
            calendarResult.timeInMillis = millsTo
        }
        // 超过maxDays
        if (betweenDays > maxDays || isFromBigger) {
            if (isFixFrom) {
                calendarResult.timeInMillis = millsTo - maxDays * millsPerDay
            } else {
                //自动修正不能超过今天
                var result = millsFrom + maxDays * millsPerDay
                val current = System.currentTimeMillis()
                if (result > current) {
                    result = current
                }
                calendarResult.timeInMillis = result
            }
        }

        return calendarResult
    }

    /**
     * 对比，两个时间，calendarFrom-calendarTo 是否在maxDays内
     *
     * @param calendarFrom
     * 没时间写
     * @param calendarTo
     * 没时间写
     * @param maxDays
     * 没时间写
     * @return 没时间写
     */
    fun isInMaxDays(calendarFrom: Calendar, calendarTo: Calendar, maxDays: Int): Boolean {
        val millsFrom = calendarFrom.timeInMillis
        val millsTo = calendarTo.timeInMillis

        val millsPerDay = (24 * 60 * 60 * 1000).toLong()
        val betweenDays = Math.abs((millsFrom - millsTo) / millsPerDay)

        return betweenDays <= maxDays
    }


    /**
     * 获取days前后的时间
     *
     * @param mills
     * 没时间写
     * @param days
     * 没时间写
     * @return 没时间写
     */
    fun getMillsBeforeDays(mills: Long, days: Int): Long {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = mills
        calendar.add(Calendar.DATE, days)
        return calendar.timeInMillis
    }

    /**
     * 获取days前/后的时间
     *
     * @param date
     * 没时间写
     * @param days
     * 没时间写
     * @return 没时间写
     */
    fun getMillsBeforeDays(date: Date, days: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = date
        calendar.add(Calendar.DATE, days)
        return calendar.time
    }


    /**
     * 获取months个月前/后的时间
     *
     * @param mills
     * 没时间写
     * @param months
     * 没时间写
     * @return 没时间写
     */
    fun getMillsBeforeMonths(mills: Long, months: Int): Long {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = mills
        calendar.add(Calendar.MONTH, months)
        return calendar.timeInMillis
    }


    /**
     * 当天最早的时间
     *
     * @param date
     * 没时间写
     * @return yyyy-MM-dd 00:00:00
     */
    fun getDateStart(date: Date): String {
        return date2short(date)!! + " 00:00:00"
        /*Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();*/
    }

    /**
     * 当天最晚的时间
     *
     * @param date
     * 没时间写
     * @return yyyy-MM-dd 23:59:59
     */
    fun getDateEnd(date: Date): String {
        return date2short(date)!! + " 23:59:59"
        /*Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();*/
    }

    /**
     * 没时间写
     *
     * @param str
     * 没时间写
     * @return 没时间写
     */
    fun strFormat(str: String): String {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        var date: Date? = null
        try {
            date = simpleDateFormat.parse(str)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return if (Util.isNull(date)) "" else simpleDateFormat.format(date)
    }

    /**
     * 两种格式的时间字符串转换
     *
     * @param str
     * 原始字符串
     * @param originalFormat
     * 原始格式
     * @param targetFormat
     * 目标格式
     * @return 目标字符串
     */
    fun strFormat(str: String, originalFormat: String, targetFormat: String): String {
        val simpleDateFormat = SimpleDateFormat(originalFormat)
        var date: Date? = null
        try {
            date = simpleDateFormat.parse(str)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        if (Util.isNull(date)) return ""
        val simpleDateFormat1 = SimpleDateFormat(targetFormat)
        return simpleDateFormat1.format(date)
    }

    /*两个日期之间相隔几个月*/

    /**
     * 两个日期之间相隔几个月
     *
     * @param startDate
     * 没时间写
     * @param endDate
     * 没时间写
     * @return 没时间写
     */
    fun monthTomonth(startDate: Date, endDate: Date): Int {
        val calendar = Calendar.getInstance()
        calendar.time = startDate
        val startYear = calendar.get(Calendar.YEAR)
        val startMonth = calendar.get(Calendar.MONTH) + 1
        calendar.time = endDate
        val endYear = calendar.get(Calendar.YEAR)
        val endMonth = calendar.get(Calendar.MONTH) + 1
        return if (startYear > endYear) {
            (startYear - endYear) * 12 + (startMonth - endMonth)
        } else if (startYear < endYear) {
            (endYear - startYear) * 12 + (endMonth - startMonth)
        } else
            Math.abs(startMonth - endMonth)
    }

    /**
     * 一个日期距离现在还剩下多久 , 只显示时分秒中的一个
     *
     * @param lotteryCountTime
     * 没时间写
     */
    fun surplusDate(lotteryCountTime: Long): String {
        var lotteryCountTime = lotteryCountTime

        /*秒还是毫秒*/
        lotteryCountTime = lotteryCountTime * 1000
        /*日期延迟30s*/
        lotteryCountTime = lotteryCountTime + 30 * 1000

        if (lotteryCountTime < 1000) {
            return "小于1分钟"
        }

        val dayMills = (24 * 60 * 60 * 1000).toLong()
        val hourMills = (60 * 60 * 1000).toLong()
        val mintureMills = (60 * 1000).toLong()
        val secondsMills: Long = 1000

        val day = (lotteryCountTime / dayMills).toInt()
        val hour = (lotteryCountTime % dayMills / hourMills).toInt()
        val minture = (lotteryCountTime % dayMills % hourMills / mintureMills).toInt()
        val seconds = (lotteryCountTime % dayMills % hourMills % mintureMills / secondsMills).toInt()

        var str = ""
        /**/
        if (0 == day) {

            /*判断小时是否为0*/
            if (0 == hour) {
                /*判断分钟是否为0*/
                if (0 == minture) {
                    //                    str = "还剩" + seconds + "秒";
                    str = "小于1分钟"
                } else {
                    if (0 == minture) {
                        str = "剩余" + seconds + "秒"
                    } else if (0 == seconds) {
                        str = "剩余" + minture + "分"
                    } else {
                        str = "剩余" + minture + "分" + seconds + "秒"
                    }
                }
            } else {
                if (0 == hour) {
                    str = "剩余" + hour + "小时" + minture + "分"
                } else if (0 == minture) {
                    str = "剩余" + hour + "小时"
                } else {
                    str = "剩余" + hour + "小时" + minture + "分"
                }
            }

        } else {
            if (0 == day) {
                str = "剩余" + day + "天" + hour + "小时"
            } else if (0 == hour) {
                str = "剩余" + day + "天"
            } else {
                str = "剩余" + day + "天" + hour + "小时"
            }
        }

        return str
    }

    /**
     * 没时间写
     *
     * @param year
     * 没时间写
     * @param month
     * 没时间写
     * @return 没时间写
     */
    fun isCurrentMonth(year: Int, month: Int): Boolean {

        val calendar = Calendar.getInstance()
        return year == calendar.get(Calendar.YEAR) && month == calendar.get(Calendar.MONTH) + 1

    }

    /**
     * 没时间写
     *
     * @param yearArg
     * 没时间写
     * @param monthArg
     * 没时间写
     * @return 没时间写
     */
    fun isCurrentMonth(yearArg: String, monthArg: String): Boolean {

        try {
            val year = Integer.parseInt(yearArg)
            val month = Integer.parseInt(monthArg)

            val calendar = Calendar.getInstance()
            val actualYear = calendar.get(Calendar.YEAR)
            val actualMonth = calendar.get(Calendar.MONTH) + 1

            return year == actualYear && month == actualMonth
        } catch (e: Exception) {
            return false
        }

    }

    /**
     * 给定的日期是否是该月的最后一天
     *
     * @param dateStr
     * yyyy-MM-dd
     * @return 没时间写
     */
    fun isCurrentMonthLastDay(dateStr: String): Boolean {
        try {
            val date = str2date(dateStr, FORMAT_SHORT)
            val calendar = Calendar.getInstance()
            calendar.time = date
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
            return day == maxDay
        } catch (e: Exception) {
            return true
        }

    }

    /**
     * 是否是当前月
     *
     * @param dateStr
     * 没时间写
     * @return 没时间写
     */
    fun isCurrentMonth(dateStr: String): Boolean {

        try {

            val date = str2date(dateStr, FORMAT_SHORT)
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH) + 1
            calendar.time = date
            val actualYear = calendar.get(Calendar.YEAR)
            val actualMonth = calendar.get(Calendar.MONTH) + 1
            return year == actualYear && month == actualMonth
        } catch (e: Exception) {
            return false
        }

    }

    /**
     * 比较日期跑今天相差几天
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun compare2TodayByDay(date: Date): Long {
        val srcDate = short2date(date2short(date))
        val today = short2date(date2short(Date()))

        if (srcDate == null) {
            return java.lang.Long.MIN_VALUE
        }

        val diff = srcDate.time - today!!.time
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)
    }

    /**
     * 时间显示规则：
     * <3分钟，显示刚刚；
     * >=3分钟且<1小时，显示x分钟前；
     * >1小时且<24小时，显示x小时前；
     * >24小时且<=30天，显示x天前 x[1,30]；
     * x>30且x<=60天，显示1月前；
     * x>60且x<=90，显示2月前；
     * 以此类推，显示到6月前；
     * 时间向小取整，即3分钟21秒前显示3分钟前 2小时1分钟前显示2小时前
     * 大于6月前的显示具体时间：
     * 显示到分，不用显示到秒
     * 当年显示月-日-时-分
     * 跨年的显示年-月-日-时-分
     *
     * @param date
     * 没时间写
     * @return 没时间写
     */
    fun date2near(date: Date?): String? {
        if (date == null) {
            return null
        }

        val now = Date()

        val offset = now.time - date.time

        if (offset < 3 * 60 * 1000) {
            return "刚刚"
        } else if (offset < 60 * 60 * 1000) {
            return TimeUnit.MINUTES.convert(offset, TimeUnit.MILLISECONDS).toString() + "分钟前"
        } else if (offset < 24 * 60 * 60 * 1000) {
            return TimeUnit.HOURS.convert(offset, TimeUnit.MILLISECONDS).toString() + "小时前"
        } else if (offset < 30L * 24 * 60 * 60 * 1000) {
            return TimeUnit.DAYS.convert(offset, TimeUnit.MILLISECONDS).toString() + "天前"
        }/* else if (offset < 30L * 24 * 60 * 60 * 1000) {
            return TimeUnit.DAYS.convert(offset, TimeUnit.MILLISECONDS) + "天前";
        }*/
        else {
            val compareMonth = compareMonth(now, date)
            if (compareMonth <= 6) {
                return compareMonth.toString() + "月前"
            } else {
                val compareYear = compareYear(now, date)
                return if (compareYear == 0L) {
                    date2str(date, FORMAT_MdHm)
                } else {
                    date2str(date, FORMAT_yMdHm)
                }
            }
        }
    }

    /**
     * 秒 转换成 时:分:秒
     *
     * 当大于一分钟时显示 时:分
     * 否则显示 秒
     *
     * 参考：
     * [1h,+)   显示   请在 23:45后再次查询
     * [1min,1h)   显示   请在 00:45后再次查询
     * [0,1min)   显示   请在45秒后再次查询
     *
     * @param seconds
     * 没时间写
     * @return 没时间写
     */
    fun second2hm2s(seconds: Long): String {
        var seconds = seconds
        val secondInMinute = seconds % 60
        seconds /= 60
        val minute = seconds % 60
        seconds /= 60
        val hour = seconds % 24

        return if (hour >= 100) {
            String.format("%d:%02d", hour, minute)//小时超过两位有多少显示多少
        } else if (hour > 0) {
            String.format("%02d:%02d", hour, minute)
        } else if (minute > 0) {
            String.format("%02d:%02d", hour, minute)
        } else {
            String.format("%02d秒", secondInMinute)
        }
    }
}