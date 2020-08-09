package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
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

public class MyCookieForGet {
    private String url;
    private ResourceBundle bundle;
    //存储cookies信息
    private CookieStore store;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("a");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        //从配置文件中获取url
        String uri = bundle.getString("b");
        String cookieUrl = this.url + uri;
        //逻辑代码书写
        HttpGet get = new HttpGet(cookieUrl);
        //DefaultHttpClient方法支持获取cookies
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        //获取cookies信息,此处出错，原因上面定义，下面需要处理为this
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        //循环cookies中数据
        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("Cookie Name=" + name + ";      Cookie vaule=" + value + ";");
        }
    }

    @Test(dependsOnMethods = "testGetCookies")
    public void testGetWithCookies() throws IOException {
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url + uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        //设置cookies
        client.setCookieStore(this.store);
        //发送请求
        HttpResponse response = client.execute(get);
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode= " + statusCode);
        if (statusCode == 200) {
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(result);
        } else if (statusCode != 200) {
            System.out.println(statusCode + "失败啦！");
        }

    }
}
