package com.course.testng;

import org.testng.annotations.Test;


public class BasicAnnotation {
//    @Test
//    public void testCaseFrist() {
//        System.out.println("2--This is test Eg Frist!");
//    }

    @Test
    public void testCaseSec() {

        System.out.println("2--This is test Eg second!");
        System.out.println("Thread Id-Class2:" + Thread.currentThread().getId());

    }

//    @BeforeMethod
//    public void beforeMethod() {
//        System.out.println("1--测试之前运行");
//    }
//
//    @AfterMethod
//    public void afterMethod() {
//        System.out.println("3--测试之后运行！");
//    }
//
//    @BeforeClass
//    public void berforeClass() {
//        System.out.println("类之前运行");
//    }
//
//    @AfterClass
//    public void afterClas() {
//        System.out.println("类之后运行");
//    }
//
//    @BeforeSuite
//    public void beforSuite() {
//        System.out.println("BeforeSuite");
//    }
//
//    @AfterSuite
//    public void afterSuite() {
//        System.out.println("afterSuite");
//    }
}
