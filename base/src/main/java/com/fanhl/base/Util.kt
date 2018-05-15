package com.fanhl.base

import android.util.Log
import android.util.SparseArray

import java.io.ByteArrayOutputStream
import java.io.IOException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Arrays
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.zip.Deflater
import java.util.zip.Inflater

/**
 * desc:工具类
 * time: 2018年1月5日10:22:09
 *
 * @author dabai
 */
object Util {

    private val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
            Locale.getDefault())
    private val cal = Calendar.getInstance()

    val shortDateString: String
        get() {
            val calendar = Calendar.getInstance()
            return String.format("%d-%d-%d",
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH) + 1,
                    calendar.get(Calendar.DATE))
        }

    val dayofWeekString: String
        get() {
            val calendar = Calendar.getInstance()
            val dayIndex = calendar.get(Calendar.DAY_OF_WEEK)
            when (dayIndex - 1) {
                0 -> {
                    return "星期天"
                }
                1 -> {
                    return "星期一"
                }
                2 -> {
                    return "星期二"
                }
                3 -> {
                    return "星期三"
                }
                4 -> {
                    return "星期四"
                }
                5 -> {
                    return "星期五"
                }
                6 -> {
                    return "星期六"
                }
                else -> {
                    return ""
                }
            }
        }

    private val PLATE_NUMBER_FORMAT = "^[京津沪渝宁琼皖粤冀豫云辽黑湘鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵青藏川][A-Z](([A-HJ-NP-Z0-9]{5,5})|([A-HJ-NP-Z0-9]{4,4}[警学]))$"

    /**
     * concat all arrays one by one.
     */
    fun concatAll(first: ByteArray, vararg rest: ByteArray): ByteArray {
        var totalLength = first.size
        for (array in rest) {
            totalLength += array.size
        }
        val result = Arrays.copyOf(first, totalLength)
        var offset = first.size
        for (array in rest) {
            System.arraycopy(array, 0, result, offset, array.size)
            offset += array.size
        }
        return result
    }

    fun intToByteArray(a: Int): ByteArray {
        return byteArrayOf((a shr 24 and 0xFF).toByte(), (a shr 16 and 0xFF).toByte(), (a shr 8 and 0xFF).toByte(), (a and 0xFF).toByte())
    }

    fun long2Byte(x: Long): ByteArray {
        val bb = ByteArray(8)
        bb[0] = (x shr 56).toByte()
        bb[1] = (x shr 48).toByte()
        bb[2] = (x shr 40).toByte()
        bb[3] = (x shr 32).toByte()
        bb[4] = (x shr 24).toByte()
        bb[5] = (x shr 16).toByte()
        bb[6] = (x shr 8).toByte()
        bb[7] = (x shr 0).toByte()
        return bb
    }

    /**
     * zlib decompress
     */
    fun decompress(data: ByteArray): ByteArray {
        Log.i("info", "data.length = " + data.size)
        var output = ByteArray(0)

        val decompresser = Inflater()
        decompresser.reset()
        decompresser.setInput(data)

        val o = ByteArrayOutputStream()
        try {
            val buf = ByteArray(1024)
            Log.i("info", "start inflate")
            while (!decompresser.finished()) {
                val i = decompresser.inflate(buf)
                o.write(buf, 0, i)
            }
            output = o.toByteArray()
            Log.i("info", "end inflate,output.length = " + output.size)
        } catch (e: Exception) {
            output = data
            e.printStackTrace()
        } finally {
            try {
                o.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
        decompresser.end()
        return output
    }

    /**
     * zlib compress
     */
    fun compress(data: ByteArray): ByteArray {
        var output = ByteArray(0)

        val compresser = Deflater()

        compresser.reset()
        compresser.setInput(data)
        compresser.finish()
        val bos = ByteArrayOutputStream(data.size)
        try {
            val buf = ByteArray(1024)
            while (!compresser.finished()) {
                val i = compresser.deflate(buf)
                bos.write(buf, 0, i)
            }
            output = bos.toByteArray()
        } catch (e: Exception) {
            output = data
            e.printStackTrace()
        } finally {
            try {
                bos.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
        compresser.end()
        return output
    }

    /**
     * format a date by "yyyy-MM-dd hh:mm:ss" format.
     */
    fun formatDate(milli: Long): String {
        if (milli <= 0) {
            return ""
        }
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss")
        return sdf.format(Date(milli))
    }

    /**
     * format a date by the given format.
     */
    fun formatDate(milli: Long, format: String): String {
        if (milli <= 0) {
            return ""
        }
        sdf.applyPattern(format)
        return sdf.format(Date(milli))
    }

    /**
     * get a UTC time in milliseconds
     *
     * @param date
     * the special date string,the format is "yyyy-MM-dd HH:mm:ss"
     */
    fun getTimeMillis(date: String): Long {
        try {
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss")
            cal.time = sdf.parse(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return cal.timeInMillis
    }

    fun getTimeMillis(date: String, defaultReture: Long): Long {
        try {
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss")
            cal.time = sdf.parse(date)
        } catch (e: Exception) {
            e.printStackTrace()
            return defaultReture
        }

        return cal.timeInMillis
    }

    fun getTimeMillis(date: String, format: String): Long {
        try {
            sdf.applyPattern(format)
            cal.time = sdf.parse(date)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return cal.timeInMillis
    }

    fun getIntervalDays(date1: String, date2: String): Int {
        try {
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss")

            cal.time = sdf.parse(date1)
            val a = cal.get(Calendar.DAY_OF_MONTH)

            cal.time = sdf.parse(date2)
            val b = cal.get(Calendar.DAY_OF_MONTH)

            return Math.abs(a - b)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return 0
    }

    fun getIntervalDays(date1: Long, date2: Long): Int {
        cal.timeInMillis = date1
        val a = cal.get(Calendar.DAY_OF_MONTH)

        cal.timeInMillis = date2
        val b = cal.get(Calendar.DAY_OF_MONTH)

        return Math.abs(a - b)
    }

    /**
     * 判断是否符合车牌号码格式
     */
    fun formatPlateNumber(plateNumber: String?): Boolean {
        return plateNumber != null && plateNumber.matches(PLATE_NUMBER_FORMAT.toRegex())
    }

    fun isNullOrEmpty(s: String?): Boolean {
        return s?.trim { it <= ' ' }?.contentEquals("") ?: true

    }

    /**
     * 为空判断
     *
     * @param s
     * 输入
     * @return 是否为否
     */
    @Deprecated("不要使用这个方法 直接使用 s==null", ReplaceWith("s == null"))
    fun isNull(s: Any?): Boolean {
        return s == null
    }

    fun isNullOrEmpty(list: List<*>?): Boolean {
        return list?.isEmpty() ?: true

    }

    /**
     * 是否为null或空
     *
     * @param set
     * set
     * @return 是否为null或空
     */
    fun isNullOrEmpty(set: Set<*>?): Boolean {
        return set == null || set.size == 0
    }

    fun isNullOrEmpty(list: SparseArray<*>?): Boolean {
        return if (list == null) {
            true
        } else list.size() == 0

    }

    fun nullToDefault(s: String?): String {
        var s = s
        if (s == null) {
            s = ""
        }

        return s
    }

    fun isEqualString(s1: String?, s2: String?): Boolean {
        var s1 = s1
        var s2 = s2
        if (s1 == null && s2 != null) {
            return false
        }

        if (s1 != null && s2 == null) {
            return false
        }

        if (s1 == null) {
            s1 = ""
        }
        if (s2 == null) {
            s2 = ""
        }

        return s1 == s2
    }

    fun <T> nullToDefault(arrayList: ArrayList<T>?): ArrayList<T> {
        return arrayList ?: ArrayList()

    }

    fun <T> nullToDefault(arraylist: SparseArray<T>?): SparseArray<T> {
        return arraylist ?: SparseArray()

    }

    fun getListSize(list: List<*>?): Int {
        return list?.size ?: 0

    }


}
