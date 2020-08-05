package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {
    @Test
    public void testFrist() {
        System.out.println("testFrist run .");
//        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"testFrist"})
    public void testSec() {
        System.out.println("testSec run .");
    }

}
