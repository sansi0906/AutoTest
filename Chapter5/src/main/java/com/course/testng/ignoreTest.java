package com.course.testng;

import org.testng.annotations.Test;

public class ignoreTest {
    @Test
    public void ignoreOne() {
        System.out.println("ignore frist!");
    }

    @Test(enabled = true)
    public void ignoreTwo() {
        System.out.println("ignore second!");
    }

    @Test(enabled = true)
    public void ignoreThree() {
        System.out.println("ignore third！");
    }
}
