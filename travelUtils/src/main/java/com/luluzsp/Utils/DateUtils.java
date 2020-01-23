package com.luluzsp.Utils;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/11/22 9:25
 * @description：日期时间工具类
 * @modified By：
 * @version:
 */
public class DateUtils {

    /**
     * @Author: luluzsp
     * @Description: 把日期时间转化为特定格式的字符串形式
     * @Date: 9:28 2019/11/22
     * @param date 要格式化的时间
     * @param pattern  格式
     * @return: java.lang.String
     * @Version: 1.0
     */
    public static   String DateToString(Date date, String pattern){

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dateString = sdf.format(date);
        return dateString;
    }


    /**
     * @Author: luluzsp
     * @Description: 字符串转化为日期
     * @Date: 9:32 2019/11/22
     * @param date 要转化的时间
     * @param pattern 转化格式
     * @return: java.util.Date
     * @Version: 1.0
     */
    public static Date StringToDate(String date,String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date patternDate = sdf.parse(date);
        return  patternDate;
    }
}
