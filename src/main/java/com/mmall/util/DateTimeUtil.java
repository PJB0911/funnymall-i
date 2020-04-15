package com.mmall.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * 日期处理工具类
 *
 * @author PJB
 * @date 2020/4/11
 */
public class DateTimeUtil {


    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";


    /**
     * 字符串时间转换成Date类型
     *
     * @param dateTimeStr   字符串时间表现形式
     * @param formatPattern 需要转换的格式
     * @return 最终的时间
     */
    public static Date strToDate(String dateTimeStr,String formatPattern){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatPattern);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }
    /**
     * 将Date类型转换成字符串时间类型
     *
     * @param date          Date时间
     * @param formatPattern 需要转换的时间
     * @return 最终字符串时间形式
     */
    public static String dateToStr(Date date,String formatPattern){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatPattern);
    }

    /**
     * 字符串时间转换成Date类型（"yyyy-MM-dd HH:mm:ss"）
     *
     * @param dateTimeStr   字符串时间表现形式
     * @return 最终的时间
     */
    public static Date strToDate(String dateTimeStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    /**
     * 将Date类型转换成字符串时间类型（ "yyyy-MM-dd HH:mm:ss"）
     *
     * @param date          Date时间
     * @return 最终字符串时间形式
     */
    public static String dateToStr(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);
    }



}
