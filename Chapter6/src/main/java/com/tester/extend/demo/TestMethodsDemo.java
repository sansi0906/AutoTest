package com.tester.extend.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodsDemo {
    @Test
    public void testOne() {
        Assert.assertEquals(1, 2);
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(1, 1);
    }

    @Test
    public void testThree() {
        Assert.assertEquals("aaa", "aba");
    }

    @Test
    public void logDeno() {
        Reporter.log("This is our own log file！！");
        throw new RuntimeException("这是我自己抛出的异常！！！");
    }


}
