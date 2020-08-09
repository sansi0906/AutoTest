package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {
    @Test
    public void TestGetResult() throws IOException {
        /**
         *
         * @param
         * @return void
         * @author sansi
         * @date 2020/8/8 10:17 下午
         * rrsultc存放结果
         */
        String result;
        HttpGet get = new HttpGet("http://www.baidu.cn");
        //这个是用来执行get方法的
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);

        result = EntityUtils.toString(response.getEntity(), "utf-8");
        if (result.contains("baidu")) {
            System.out.println("sucess");
            System.out.println(result);
        } else if (result.contains("谷歌"))
            System.out.println("falil");
//            System.out.println(result);


    }
}
