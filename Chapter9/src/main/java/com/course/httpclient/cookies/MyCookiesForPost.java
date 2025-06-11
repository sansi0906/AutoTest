package com.course.httpclient.cookies;


import org.apache.commons.codec.StringEncoderComparator;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
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
    public void testPostWithcooikes() throws IOException {
        String result;
        //获取要测试的接口地址
        String uri = bundle.getString("postWithCookies.uri");
        //拼接最终的测试地址（环境 + 接口地址）
        testUrl = this.url + uri;
        //声明一个Client对象，用来进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();
        //声明一个方法，这个方法就是post方法
        HttpPost post = new HttpPost(testUrl);
        //添加参数
        JSONObject parm = new JSONObject();
        parm.put("name", "huhansan");
        parm.put("age", "18");
        //设置请求头信息
        post.setHeader("content-type", "application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(parm.toString(), "utf-8");
        post.setEntity(entity);
        //设置cookies信息
        client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response = client.execute(post);
        //声明一个对象对响应结果进行存储
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        //对响应结果进行判断,首先转换为json
        JSONObject resultJson = new JSONObject(result);
        //获取json值
        String sunccess = (String) resultJson.get("huhansan");
        int status = (Integer) resultJson.get("status");
        //进行返回结果校验
        Assert.assertEquals("sunccess", sunccess);
        Assert.assertEquals(1, status);
    }

}
