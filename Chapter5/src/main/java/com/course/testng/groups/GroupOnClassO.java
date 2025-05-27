package com.course.testng.groups;

import org.testng.annotations.Test;

//类也可以写标签
@Test(groups = "stu")
public class GroupOnClassO {
    public void stuO(){
        System.out.println("GroupOnClassO中的stuO运行～1");
    }
    public void stuT(){
        System.out.println("GroupOnClassO中的stuT运行～2");
    }

}
