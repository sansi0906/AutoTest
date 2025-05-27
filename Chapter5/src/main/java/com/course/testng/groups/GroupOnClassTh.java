package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupOnClassTh {
    public void teacherO(){
        System.out.println("GroupOnClassTh中的teacherO运行～5");
    }
    public void teacherT(){
        System.out.println("GroupOnClassTh中的teacherT运行～6");
    }
}
