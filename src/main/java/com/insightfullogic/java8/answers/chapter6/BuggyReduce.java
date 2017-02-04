package com.insightfullogic.java8.answers.chapter6;

import java.util.List;

public class BuggyReduce {

    //Buggy Version:
    // BEGIN buggyMultiplyThrough
    public static int multiplyThrough_Bug(List<Integer> linkedListOfNumbers) {
        //reduce 的第一个参数为函数累计器的基数值
        return linkedListOfNumbers.stream()
                .reduce(5, (acc, x) -> x * acc);
    }
    // END buggyMultiplyThrough

    public static int multiplyThrough(List<Integer> numbers) {
        return 5 * numbers.parallelStream()
                .reduce(1, (acc, x) -> x * acc);
    }

}
