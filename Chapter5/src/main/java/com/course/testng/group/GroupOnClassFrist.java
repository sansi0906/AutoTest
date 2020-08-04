package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "stu")

public class GroupOnClassFrist {
    public void studentOne() {
        System.out.println("studentOne in GroupOnClassFrist1111");
    }

    public void studentSec() {
        System.out.println("studentSec in GroupOnClassFrist1111");
    }
}
