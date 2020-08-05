package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "Person")
    public void getPersonMessage(String name, int age) {
        System.out.println("name = " + name + ",age =" + age);
    }

    @DataProvider(name = "Person")
    public Object[][] personData() {
        Object[][] pm = new Object[][]{
                {"zhangsan", 14},
                {"lisa", 15},
                {"wangliu", 18}
        };
        return pm;
    }

    @Test(dataProvider = "achievement")
    public void getGoodStu(String name, int grade) {
        System.out.println(name + ":" + grade);
    }

    @Test(dataProvider = "achievement")
    public void getBadStu(String name, int grade) {
        System.out.println(name + ":" + grade);
    }

    @DataProvider(name = "achievement")
    public Object[][] achievement(Method method) {
        Object[][] ach = null;
        if (method.getName().equals("getGoodStu")) {
            ach = new Object[][]{
                    {"xiaojiu", 96},
                    {"sanpang", 98}
            };
        } else if (method.getName().equals("getBadStu")) {
            ach = new Object[][]{
                    {"sansi", 33}
            };
        }
        return ach;
    }
}