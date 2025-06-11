package com.tester.cases;


import static org.assertj.core.api.Assertions.assertThat;

import com.tester.config.TestConfig;
import com.tester.model.GetUserInfoCase;
import com.tester.model.User;
import com.tester.utils.DataBaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.*;

public class GetUserInfoTest {

    @Test(dependsOnGroups = "loginTrue", description = "获取用户信息")
    public void getUserInfo() throws IOException, InterruptedException {
        SqlSession sqlSession = DataBaseUtil.getSqlSession();
        GetUserInfoCase getUserInfoCase = sqlSession.selectOne("getUserInfoCase", 1);
        System.out.println(getUserInfoCase.toString());
        System.out.println(TestConfig.getUserInfoUrl);
        JSONArray resultJson = getJsonResult(getUserInfoCase);

//        String resultString = resultJson.getString(0);
//        System.out.println("resultString============" + resultString);
        Thread.sleep(2000);
        User user = sqlSession.selectOne(getUserInfoCase.getExpected(), getUserInfoCase);
//        JSONObject userInfo = new JSONObject(user);
//        System.out.println("user++++++++++"+userInfo.toString());
//        List userList = new ArrayList();
//        userList.add(user);
//        JSONArray jsonArray = new JSONArray(userList);
//        String uu = jsonArray.getJSONObject(0).toString();
//        System.out.println("jsonArraytoString--------" + jsonArray.toString());

//        String jsonString = jsonArray.getJSONObject(0).toString();
//        System.out.println("jsonString--------" + jsonString);

//        System.out.println("resultJson+++++++" + resultJson.toString());
//        assertThat(resultString).isEqualToIgnoringNewLines(uu);
        assertThat(resultJson.toString()).contains(user.getUserName());
        assertThat(resultJson.toString()).contains(user.getPassword());
        assertThat(resultJson.toString()).contains(user.getAge());
//        System.out.println("11111" + resultJson);
//        System.out.println("22222" + jsonArray);
//        Assert.assertEquals(resultJson.getString(0), userInfo.toString());

    }

    private JSONArray getJsonResult(GetUserInfoCase getUserInfoCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.getUserInfoUrl);
        JSONObject parm = new JSONObject();
        parm.put("userId", getUserInfoCase.getUserId());
        post.setHeader("content-type", "application/json");
        StringEntity entity = new StringEntity(parm.toString(), "utf-8");
        post.setEntity(entity);
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
//        System.out.println("调用接口result:" + result);
        List resultList = new ArrayList();
        resultList.add(result);
//        System.out.println("resultList-------"+resultList.toString());
        JSONArray array = new JSONArray(resultList);
//        System.out.println("array++++++"+array.toString());

        return array;
    }
}
