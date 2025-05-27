package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupOnClassT {

    public void stuO(){
        System.out.println("GroupOnClassT中的stuO运行～3");
    }
    public void stuT(){
        System.out.println("GroupOnClassT中的stuT运行～4");
    }

}
