package com.insightfullogic.java8.examples.chapter7;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wangyingjie1 on 2017/2/4.
 */
public class LamdbaTest {

    public static List<String> allToUpper(List<String> words) {
        return words.stream()
                .map(string -> toUpperCase(string))
                .peek(action -> System.out.println(action))
                .collect(Collectors.toList());
    }

    private static String toUpperCase(String string) {
        return string.toUpperCase();
    }

    //通过方法引用重构之后，测试用例只需要测试 toUpperCase() 方法
    public static List<String> allToUpper2(List<String> words) {
        return words.stream()
                .map(LamdbaTest::toUpperCase)
                .collect(Collectors.toList());
    }



    public static void main(String[] args) {
        List<String> list = Stream.of("xx", "yy", "zz").collect(Collectors.toList());

        String firstStr = list.stream().findFirst().get();
        System.out.println("firstStr====" + firstStr);

        List<String> list1 = LamdbaTest.allToUpper(list);

        System.out.println(list1);

        List<String> stringList = list.stream().map(strint -> {
            return "aaaaa";
        }).collect(Collectors.toList());

        List<String> list2 = allToUpper2(stringList);

        System.out.println(list2);
    }


}
