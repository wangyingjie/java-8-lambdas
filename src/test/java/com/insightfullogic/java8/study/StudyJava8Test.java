package com.insightfullogic.java8.study;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wangyingjie1 on 2017/2/11.
 */
public class StudyJava8Test {

    @Test
    public void listToMap() {
        //根据List创建Map

        List<Integer> list = IntStream.range(1, 100).boxed().collect(Collectors.toList());
        Map<Integer, Integer> map = list.stream().collect(Collectors.toMap(p -> p, q -> q * 3));
        System.out.println(map);
    }

    @Test
    public void max() {
        //求列表元素的最大数

        List<Integer> list = new Random().ints(-100, 100).limit(250).boxed().collect(Collectors.toList());
        Optional<Integer> max = list.stream().reduce(Math::max);
        max.ifPresent(value -> System.out.println(value));
    }

    @Test
    public void groupingBy() {
        // 2. 根据年龄对Person进行分组

        //Map<Integer, List<Person>> collect = persons.stream().collect(Collectors.groupingBy(Person::getAge));
    }

    @Test
    public void averagingInt() {
        //对所有Person求平均年龄

        //Double collect = persons.stream().collect(Collectors.averagingInt(Person::getAge));
    }


    public class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            super();
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
