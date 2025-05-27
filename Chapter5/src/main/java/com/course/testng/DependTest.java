package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {

    @Test
    public void testO() {
        System.out.println("testO run~");
        //依赖测试，如果testO异常则testT不运行
//        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"testO"})
    public void testT() {
        System.out.println("testT run");
    }
}