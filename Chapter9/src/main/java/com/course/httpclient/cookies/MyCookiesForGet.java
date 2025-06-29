package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private String uri;
    private String testUrl;
    CookieStore store;
    private ResourceBundle bundle;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.hostUrl");
        uri = bundle.getString("getCookies.uri");
        testUrl = url + uri;

    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        HttpGet get = new HttpGet(this.testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);

        //获取cookies信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("key:" + name + ",value:" + value);
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testWithCookies() throws IOException {
        String result;
        uri = bundle.getString("getWithCookies.uri");
        this.testUrl = this.url + uri;

        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        //设置cookies信息
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        //获取响应的状态码

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode:" + statusCode);
        if (statusCode == 200) {
            result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
        }

    }
}
