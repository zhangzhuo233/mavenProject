package com.bd.reflexTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @program: javacore
 * @description: java反射机制demo
 * @author: Mr.zhang
 * @create: 2019-08-27 19:57
 **/
public class ReflexTest {
    public static void main(String[] args) {
        // 获取类对象的三种方式
        // 1.
        // Class myClass = Person.class;
        // 2.
        // myClass = new Person().getClass();
        // 3.
        try {
            Class<?> aClass = Class.forName("com.bd.reflexTest.Person");
            // 使用反射
            Field[] fields = aClass.getDeclaredFields();
            Person per = (Person) aClass.newInstance();
            for (Field tmp:
                 fields) {
                System.out.println(tmp);
            }
            Field name = aClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(per, "张三");
            // for (Method tmp:
            //      aClass.getMethods()) {
            //     System.out.println(tmp);
            // }
            per.test();
            Method myShow = aClass.getDeclaredMethod("show");
            myShow.setAccessible(true);
            myShow.invoke(per);
            // for (Constructor tmp:
            //      aClass.getDeclaredConstructors()) {
            //     System.out.println(tmp);
            // }
            Constructor myCt = aClass.getConstructor();
            // myCt.setAccessible(true);
            Person o = (Person) myCt.newInstance();
            o.test();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
class Person {
    private int age;
    private String name;

    public Person() {
        this.age = 18;
        this.name = "无";
    }
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private void show() {
        System.out.println("show: " + name + " " + age);
    }
    public void test() {
        System.out.println("test: " + name + " " + age);
    }
}