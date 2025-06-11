package com.tester.cases;

import com.tester.config.TestConfig;
import com.tester.model.UpdateUserInfoCase;
import com.tester.model.User;
import com.tester.utils.DataBaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateUserInfoTest {

    @Test(dependsOnGroups="loginTrue",description = "更新一个用户")
    public void updateUserInfo() throws IOException, InterruptedException {
        SqlSession sqlSession = DataBaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateInfoCase", 1);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserUrl);
        String result = getResult(updateUserInfoCase);
        Thread.sleep(2000);

        User user = sqlSession.selectOne(updateUserInfoCase.getExpected(), updateUserInfoCase);
        System.out.println(user.toString());
        Assert.assertNotNull(user);
        Assert.assertNotNull(result);
    }

    @Test(dependsOnGroups="loginTrue",description = "删除一个用户")
    public void deleteUser() throws IOException, InterruptedException {
        SqlSession sqlSession = DataBaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = sqlSession.selectOne("updateInfoCase", 2);
        System.out.println(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserUrl);

        String  result = getResult(updateUserInfoCase);
        Thread.sleep(2000);
        User user = sqlSession.selectOne(updateUserInfoCase.getExpected(), updateUserInfoCase);
        System.out.println(user.toString());
        Assert.assertNotNull(user);
        Assert.assertNotNull(result);
    }

    private String getResult(UpdateUserInfoCase updateUserInfoCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.updateUserUrl);
        JSONObject parm = new JSONObject();
        parm.put("userId", updateUserInfoCase.getUserId());
        parm.put("userName", updateUserInfoCase.getUserName());
        parm.put("sex", updateUserInfoCase.getSex());
        parm.put("age", updateUserInfoCase.getAge());
        parm.put("isDelete", updateUserInfoCase.getIsDelete());
        parm.put("permission", updateUserInfoCase.getPermission());
        post.setHeader("content-type", "applicastion/json");
        StringEntity stringEntity = new StringEntity(parm.toString(), "utf-8");
        post.setEntity(stringEntity);
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.cookieStore);
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");

        System.out.println(result);
        return result;

    }
}
