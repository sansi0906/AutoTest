package com.course.testng.multiThread;

import org.testng.annotations.Test;

                /**
                 * @param null
                 * @author sansi
                 * @return
                 * @date 2020/8/5 11:56 下午
                 */
public class MultiThreadOnXml {
    @Test
    public void TestFri() {
        System.out.println("Thread Id-Test1:" + Thread.currentThread().getId());
    }

    @Test
    public void TestSec() {
        System.out.println("Thread Id-Test2:" + Thread.currentThread().getId());
    }

    @Test
    public void TestThr() {
        System.out.println("Thread Id-Test2:" + Thread.currentThread().getId());
    }
}
