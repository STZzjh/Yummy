package com.zjh.yummy.common;

import java.util.UUID;

public class RandomUtil {

    public static String getRandomString(int lenth){
        String all = UUID.randomUUID().toString().replaceAll("-", "");
        String substring = all.substring(0, lenth);
        return substring;
    }
}
