package com.zjh.yummy.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FilenameUtil {

    private static String downloadDir;

    public static String getFileSuffix(String fileWholeName) {
        if (fileWholeName == null || "".equals(fileWholeName)) {
            return "none";
        } else {
            int lastIndexOf = fileWholeName.lastIndexOf(".");
            return fileWholeName.substring(lastIndexOf + 1);
        }
    }

    public static String getDownloadDir() {
        if (downloadDir == null || "".equals(downloadDir)) {
            Properties properties = new Properties();
            InputStream resourceAsStream = FilenameUtil.class.getResourceAsStream("/download.properties");
            try {
                properties.load(resourceAsStream);
                return properties.getProperty("download-dir");
            } catch (IOException e) {
                e.printStackTrace();
                return "E:/download/";
            }

        } else {
            return downloadDir;
        }
    }
}
