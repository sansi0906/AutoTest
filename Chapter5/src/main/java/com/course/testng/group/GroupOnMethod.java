package com.course.testng.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {
    //执行无序，数字1、2、3、4这种有序列，表示怀疑
    @Test(groups = "server")
    public void testFrist() {
        System.out.println("serverOne");
    }

    @Test(groups = "server")
    public void testSecond() {
        System.out.println("serverTwo");
    }

    @Test(groups = "client")
    public void testThird() {
        System.out.println("clientOne");
    }

    @Test(groups = "client")
    public void testFourth() {
        System.out.println("clientTwo");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer() {
        System.out.println("server组前执行!");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer() {
        System.out.println("server组后执行!!");
    }

    @BeforeGroups("client")
    public void beforeGroupsOnClient() {
        System.out.println("Client组前执行!");
    }

    @AfterGroups("client")
    public void afterGroupsOnClient() {
        System.out.println("Client组后执行!!");
    }

}
