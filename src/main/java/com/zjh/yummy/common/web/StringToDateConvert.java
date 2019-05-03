package com.zjh.yummy.common.web;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 接收时间参数转换
 */
public class StringToDateConvert implements Converter<String, Date> {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String s) {
        if (s == null) {
            return null;
        }
        try {
            if (s.length() == 19) {
                return dateFormat.parse(s);
            }
            if (s.length() == 10) {
                return dateFormat2.parse(s);
            }
        } catch (Exception e) {
        }
        return null;
    }
}
