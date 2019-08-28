package com.bd.lambdaTest;

import java.util.Arrays;
import java.util.List;

/**
 * @program: javacore
 * @description: 使用lambda表达式
 * @author: Mr.zhang
 * @create: 2019-08-27 22:12
 **/
public class LambdaTest {
    public static void main(String[] args) {
        // 创建类实现接口
        Operation op = (a, b) -> a+b;
        System.out.println(op.sum(1,2));
        // 多线程
        new Thread(()-> System.out.println("hello")).start();
        // 比较两对象大小
        List<Student> students = Arrays.asList(new Student(18, "张三"), new Student(19, "李四"),
                new Student(16, "王五"));
        System.out.println(students);
        students.sort(((o1, o2) -> {
            return o1.getAge()-o2.getAge();
        }));
        System.out.println(students);
    }
}

interface Operation {
    int sum(int a, int b);
}

class Student {
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}