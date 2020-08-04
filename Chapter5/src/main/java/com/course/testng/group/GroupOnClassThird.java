package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "tec")
public class GroupOnClassThird {
    public void tecFrist() {
        System.out.println("tecFrist in GroupOnClassThird3333");
    }

    public void tecSec() {
        System.out.println("tecSec in GroupOnClassThird3333");
    }
}
