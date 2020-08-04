package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "stu")

public class GroupOnClassSecond {
    public void studentOne() {
        System.out.println("studentOne in GroupOnClassSecond2222");
    }

    public void studentSec() {
        System.out.println("studentSec in GroupOnClassSecond2222");
    }
}
