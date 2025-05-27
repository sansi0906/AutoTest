package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age) {
        System.out.println("姓名是" + name + ",年龄是" + age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData() {
        Object[][] obj = new Object[][]{
                {"sansi", 18},
                {"sisi", 28},
                {"wusi", 38}

        };
        return obj;
    }

    @Test(dataProvider = "methodData")
    public void testO(String name, int age) {
        System.out.println("testO姓名是" + name + ",年龄是" + age);

    }

    @Test(dataProvider = "methodData")
    public void testT(String name, int age) {
        System.out.println("testT姓名是" + name + ",年龄是" + age);

    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method) {
        Object[][] result = null;
        if (method.getName().equals("testO")) {
            result = new Object[][]{
                    {"zhangsan", 20},
                    {"lisi", 30}
            };
        } else if (method.getName().equals("testT")) {
            result = new Object[][]{
                    {"wangwu", 50},
                    {"zhaoliu", 60}
            };
        }
        return result;
    }

}
