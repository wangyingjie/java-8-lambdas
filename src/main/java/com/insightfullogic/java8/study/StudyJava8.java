package com.insightfullogic.java8.study;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wangyingjie1 on 2017/2/11.
 */
public class StudyJava8 {


    private  void listToMap() {
        //根据List创建Map

        List<Integer> list = IntStream.range(1, 100).boxed().collect(Collectors.toList());
        Map<Integer, Integer> map = list.stream().collect(Collectors.toMap(p -> p, q->q*3));
        System.out.println(map);
    }
}
