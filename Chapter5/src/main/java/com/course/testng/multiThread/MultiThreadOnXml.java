package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThreadOnXml {
    @Test
    public void testO() {
        System.out.println("Thread id : %s%n" + Thread.currentThread().getId());
    }

    @Test
    public void testT() {
        System.out.println("Thread id : %s%n" + Thread.currentThread().getId());
    }

    @Test
    public void testTh() {
        System.out.println("Thread id : %s%n" + Thread.currentThread().getId());
    }
}
