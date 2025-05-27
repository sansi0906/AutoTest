package com.course.testng.paramter;

        import org.testng.annotations.Parameters;
        import org.testng.annotations.Test;

public class ParamterTest {
    @Test
    @Parameters({"name", "age"})
    public void paramTestO(String name, int age) {
        System.out.println("学生姓名：" + name + ",年龄是：" + age);
    }
}
