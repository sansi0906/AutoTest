package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemo {
    @Test
    public void testO() {
        Assert.assertEquals(1, 2);
        System.out.println("True");
    }

    @Test
    public void testT() {
        Assert.assertEquals(1, 1);
    }

    @Test
    public void testTh() {
        Assert.assertEquals("aaa", "aaa");
    }

    @Test
    public void logDemo() {
        Reporter.log("这是我们自己的日志");
        throw new RuntimeException("这个是我自己的运行时异常");
    }
}
