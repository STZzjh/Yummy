package com.zjh.yummy.common.web;


import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {

    public static HttpServletRequest getHttpServletRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        return request;

    }

    public static LoginUser getUser() {
        HttpServletRequest request = getHttpServletRequest();
        Object user = request.getSession().getAttribute("loginUser");
        if (user == null) {
            return null;
        }else{
            return (LoginUser) user;
        }
    }

    public static String getIpAddress(HttpServletRequest request) {
                 String ip = request.getHeader("x-forwarded-for");
                 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                         ip = request.getHeader("Proxy-Client-IP");
                     }
                 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                         ip = request.getHeader("WL-Proxy-Client-IP");
                    }
                 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                         ip = request.getHeader("HTTP_CLIENT_IP");
                     }
                 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                         ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                     }
                 if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                         ip = request.getRemoteAddr();
                     }
                 return ip;

    }

}
