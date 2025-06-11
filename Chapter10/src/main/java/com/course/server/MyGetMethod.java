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
@Api(value = "/", description = "Get方法List")
public class MyGetMethod {
    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value = "获取cookies方法", httpMethod = "GET")
    public String getCookies(HttpServletResponse response) {
        //HttpServerletRequest 装请求信息的类
        //HttpServerletResponse 装响应信息的类

        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "获取cookies信息成功";
    }

    //    要求客户端携带cookies访问
    @RequestMapping(value = "/getWithCookies", method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies访问", httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "必须携带cookies信息访问";

        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") &&
                    cookie.getValue().equals("true")) {
                return "恭喜你访问成功";
            }
        }
        return "必须携带cookies信息访问";

    }

    /*开发一个需要携带参数才能访问的get请求
    第一种实现方式 url： key=value & key =value
     */

    @RequestMapping(value = "/getGoodsList", method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get方法", httpMethod = "GET")

    public Map<String, Integer> getGoodsList(@RequestParam Integer start,
                                             @RequestParam Integer end) {
        Map<String, Integer> mygoodslist = new HashMap<>();
        mygoodslist.put("xhx", 11);
        mygoodslist.put("x", 18);
        mygoodslist.put("cs", 55);
        return mygoodslist;
    }

    /**
     * 第二种需要携带参数访问的get请求
     * IP：port /url/start/end
     */

    @RequestMapping(value = "/getWith/Parm/{start}/{end}", method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get请求的第二种实现", httpMethod = "GET")
    public Map myGoodsList(@PathVariable Integer start, @PathVariable Integer end) {
        Map<String, Integer> mygoodslist = new HashMap<>();
        mygoodslist.put("xhx", 111);
        mygoodslist.put("x", 181);
        mygoodslist.put("cs", 551);
        return mygoodslist;
    }
}
