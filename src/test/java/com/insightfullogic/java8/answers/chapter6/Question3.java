package com.insightfullogic.java8.answers.chapter6;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wangyingjie1 on 2017/2/4.
 */
public class Question3 {

    public static void main(String[] args) {
        List<Integer> list = Stream.of("1", "2", "3", "4").map(x->Integer.valueOf(x)).collect(Collectors.toList());
        System.out.println(list);

        slowSum(list);

        fastSum(list);

    }

    private static void slowSum(List<Integer> list) {
        Integer sum = list.parallelStream().map(x -> x * x).reduce(0, (acc, x) -> acc + x);
        System.out.println("slow sum=" + sum);
    }

    private static void fastSum(List<Integer> list) {
        Integer sum = list.parallelStream().map(x -> x * x).reduce(0, (acc, x) -> acc + x);
        //System.out.println("fast sum=" + sum);

        Integer collect2 = list.parallelStream().map(x -> x * x).reduce(Integer::sum).get();

        System.out.println("collect2 sum=" + collect2);

        long count1 = list.parallelStream().map(x -> x * x).mapToLong(e -> e).sum();
        System.out.println("count1 sum=" + count1);

        int count2 = list.parallelStream().map(x -> x * x).mapToInt(e -> e).sum();
        System.out.println("count2 sum=" + count2);

    }
}
