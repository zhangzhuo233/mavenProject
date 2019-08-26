package com.bd.colletionTest;

import java.util.HashMap;

/**
 * @program: javacore
 * @description: to test genericity(泛型)
 * @author: Mr.zhang
 * @create: 2019-08-14 17:12
 **/

// 泛型类
public class GenericityTest<T> {
    public void test(T p) {
        System.out.println(p);
    }

    public static void main(String[] args) {
        new GenericityTest<String>().test("test");
    }
}
class GenericityTest2 {
    // 泛型方法
    public <T> void test(T p) {
        System.out.println(p);
    }

    public static void main(String[] args) {
        new GenericityTest2().test(1);

        String str = "hello";
        String str1 = "hello";
        System.out.println(str==str1);
        str = new String("hello");
        str1 = new String("hello");
        System.out.println(str==str1);
        System.out.println(str.equals(str1));


    }
}
class StringTest {
    /** 
    * @Description: 统计str中foundStr出现的次数
    * @Param: [str, map] 
    * @return: void 
    * @Author: Mr.zhang
    * @Date: 2019-08-16 
    */
    public static Integer countStr(String str, String foundStr) {
        int index = str.indexOf(foundStr);
        int count = 0;
        while (index >= 0) {
            count++;
            index = str.indexOf(foundStr, index+foundStr.length());
        }
        return count;
    }
    /** 
    * @Description: 统计str中每个字符出现的次数
    * @Param: [str, map] 
    * @return: void 
    * @Author: Mr.zhang
    * @Date: 2019-08-16 
    */
    public static void countCh(String str, HashMap<Character, Integer> map) {
        char ch = '\0';
        Integer num = 0;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            num = map.get(ch);
            if (num == null)
                map.put(ch, 1);
            else
                map.put(ch, num+1);
        }
    }

    public static int diGui(int num) {
        if (num == 1) {
            return 1;
        } else {
            return num * diGui(num-1);
        }
    }

    public static void main(String[] args) {
        String str = "helalo A hellllo hello b helloa";
        String foundStr = "hello";
        System.out.println(countStr(str, foundStr));
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        countCh(str, map);
        System.out.println(map);
        System.out.println(diGui(3));
    }
}