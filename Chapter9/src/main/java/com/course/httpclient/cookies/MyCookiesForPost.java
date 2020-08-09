package com.course.httpclient.cookies;

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
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
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
    public void testPostMethod() throws IOException {
        String uri = bundle.getString("test.post.with.cookies");
        //拼接最终请求地址
        String testUrl = this.url + uri;
        //声明一个Client对象 ，用来进行方案执行
        DefaultHttpClient client = new DefaultHttpClient();
        //声明一个方法，这个方法就是post方法   记得将请求的地址放入new HttpPost() ，出错了testUrl;
        HttpPost post = new HttpPost(testUrl);
        //添加参数
        JSONObject param = new JSONObject();
        param.put("name", "sansi");
        param.put("age", "18");
        //这是请求头信息
        post.setHeader("content-type", "application/json");
        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
        //设置cookies信息
        client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response = client.execute(post);
        //获取相应结果
        String result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        //将结果转换为  json
        JSONObject resultJson = new JSONObject(result);
        //获取结果值
        String sucess = (String) resultJson.get("sansi");
        String status = (String) resultJson.get("status");
        //预期结果比对
        Assert.assertEquals("sucess", sucess);
        Assert.assertEquals("1", status);
    }

}
