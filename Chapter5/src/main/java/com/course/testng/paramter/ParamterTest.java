package com.course.testng.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterTest {
    /**
     * @param name
     * @param age
     * @return void
     * @author sansi
     * @date 2020/8/5 3:29 下午
     * 遇到问题：没有正确引入"Parameters"，导致运行失败！！！
     */
    @Test
    @Parameters({"name", "age"})
    public void paramterTest(String name, int age) {
        System.out.println("她叫" + name + "，今年" + age + "岁了");
    }
}
