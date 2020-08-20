package com.course.server;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/", description = "all get methods!")
public class MyGetMethod {
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到Cookies", httpMethod = "GET")
    public String getCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "恭喜你获取cookies成功！";
    }

    /**
     * @param request
     * @return
     * @author sansi
     * @date 2020/8/11 12:46 上午
     * 要求客户端携带客户端访问
     */
    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到Cookies", httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "你必须携带cookies访问！";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") &&
                    cookie.getValue().equals("true")) {
                return "恭喜你访问成功";

            }
        }
        return "你必须携带cookies访问！";

    }

    /**
     * 开发一个需要携带参数可以访问的get请求
     * 第一种实现方式 url：key=value &key =value
     * 模拟获取商品列表
     */
    @RequestMapping(value = "get/with/param", method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到Cookies", httpMethod = "GET")
    public Map<String, Integer> getList(@RequestParam Integer start,
                                        @RequestParam Integer end) {
        Map<String, Integer> myGoodList = new HashMap<>();
        myGoodList.put("baozai", 18);
        myGoodList.put("shaoe", 22);
        myGoodList.put("laweif", 25);
        return myGoodList;

    }

    /**
     * 第二种携带参数访问的get请求
     * 方式：url：IP：port/get/with/papram/10/20
     */
    @RequestMapping(value = "get/with/param/{start}/{end}", method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到Cookies", httpMethod = "GET")
    public Map myGetList(@PathVariable Integer start,
                         @PathVariable Integer end) {
        Map<String, Integer> yourLsit = new HashMap<>();
        yourLsit.put("regou", 2);
        yourLsit.put("hanbao", 12);
        yourLsit.put("mill", 5);
        return yourLsit;
    }
}
