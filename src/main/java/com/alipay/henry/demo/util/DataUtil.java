/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.alipay.henry.demo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Henry
 * @version $Id: DataUtil.java, v 0.1 2018-09-09 上午11:56 Henry Exp $$
 */
public class DataUtil {


    private static final String DEFAULT_FORMAT = "yyyy-MM-dd";

    /**
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date,DEFAULT_FORMAT);
    }

    /**
     *
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        if(date == null) {
            return null;
        }
        String f = format;
        if(f == null) {
            f = DEFAULT_FORMAT;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
}