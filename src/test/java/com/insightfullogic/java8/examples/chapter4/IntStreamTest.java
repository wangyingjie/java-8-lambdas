package com.insightfullogic.java8.examples.chapter4;

import org.junit.Test;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wangyingjie1 on 2017/2/3.
 */
public class IntStreamTest {

    @Test
    public void test(){
        List<Long> list = Stream.of(12L, 11L, 2L, 4L, 5L, 10L).collect(Collectors.toList());

        IntSummaryStatistics statistics = list.stream().mapToInt(value -> value.intValue()).summaryStatistics();

        statistics.getAverage();
        statistics.getCount();
        statistics.getMax();
        statistics.getMin();
        statistics.getCount();
        statistics.getSum();

        System.out.println(statistics);
    }

    private List<Integer> getList(){
        List<Integer> list = Stream.of(12, 11, 2, 4, 5, 10).collect(Collectors.toList());
        return list;
    }
}
