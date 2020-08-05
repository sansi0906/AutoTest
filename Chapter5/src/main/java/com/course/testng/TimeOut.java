package com.course.testng;

import org.testng.annotations.Test;

/**
 * @author sansi
 * @date 2020/8/6 12:02 上午
 * 单位：毫秒
 * 毫秒级别实际存在误差
 */
public class TimeOut {
    @Test(timeOut = 3000)
    public void testSucess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 3000)
    public void testFailed() throws InterruptedException {
        Thread.sleep(3000);
    }
}
