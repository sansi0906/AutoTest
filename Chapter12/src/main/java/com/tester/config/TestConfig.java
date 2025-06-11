package com.tester.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.servlet.http.Cookie;

public class TestConfig {
    public static String loginUrl;
    public static String updateUserUrl;
    public static String getUserListUrl;
    public static String getUserInfoUrl;
    public static String addUserUrl;


    public static DefaultHttpClient defaultHttpClient;

    public static CookieStore cookieStore;
}
