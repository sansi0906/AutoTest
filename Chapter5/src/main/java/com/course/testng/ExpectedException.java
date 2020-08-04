package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeExceptionSuccess() {
        System.out.println("this is a exception test");
        throw new RuntimeException();
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void runtimeExceptionFailed() {
        System.out.println("this is a failed test");
    }


}
