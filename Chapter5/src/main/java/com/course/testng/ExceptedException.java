package com.course.testng;

import org.testng.annotations.Test;

public class ExceptedException {
    //这是一个测试结果会失败的异常测试

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed() {
        System.out.println("这是一个失败的异常测试～");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuceess() {
        System.out.println("这是一个异常测试");
        throw new RuntimeException();
    }
}
