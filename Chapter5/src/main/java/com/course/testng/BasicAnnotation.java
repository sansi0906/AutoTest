package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {
    //最基本的TestNG注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1() {
        System.out.println("这是第一个测试用例示例～1");
    }

    @Test
    public void testCase2() {
        System.out.println("这是第二个测试用例示例～2");
    }

    @BeforeMethod
    public void berforeMethod() {
        System.out.println("BeforeMethod这是在测试方法之前执行的～");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod这是在测试方法之后执行的～");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass这个是在类执行前执行的方法~");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass这个是在类执行之后执行的方法～");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite测试套件");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite测试套件");
    }
}
