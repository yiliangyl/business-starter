package com.qyl.utils.component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @Author: qyl
 * @Date: 2021/2/7 23:50
 * @Description: Cookie工具类
 */
public class CookieUtil {

    /**
     * 设置cookie的值
     * @param response
     * @param cookieName
     * @param cookieValue
     * @param maxAge cookie生效的最大秒数
     */
    public static void setCookie(HttpServletResponse response, String cookieName, String cookieValue, Integer maxAge) {
        if (cookieValue == null) {
            cookieValue = "";
        } else {
            // 使用utf-8编码
            cookieValue = URLEncoder.encode(cookieValue, StandardCharsets.UTF_8);
        }
        Cookie cookie = new Cookie(cookieName, cookieValue);
        // 设置cookie存活时间
        cookie.setMaxAge(maxAge);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 获得Cookie
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies == null);
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                 String cookieValue = cookie.getValue();
                 deleteCookie(cookieName);
                 return cookieValue;
            }
        }
        return null;
    }

    private static void deleteCookie(String cookieName) {
        // 删除之前要先new一个name相同value为空的cookie
        Cookie cookie = new Cookie(cookieName, null);
        // 路径要一样，生命周期要为0
        cookie.setPath("/");
        cookie.setMaxAge(0);
    }

    /**
     * 删除cookie
     * @param request
     * @param cookieName
     */
    public static void deleteCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)) {
                // 删除之前要先new一个name相同value为空的cookie
                Cookie c = new Cookie(cookieName, null);
                // 路径要一样，生命周期要为0
                c.setPath("/");
                c.setMaxAge(0);
            }
        }
    }
}
