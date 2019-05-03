package com.zjh.yummy.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderUtil {

    private static DateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public static String getOrderNo(Object suffix){
        String format = OrderUtil.format.format(new Date());
        return format + suffix;
    }
}
