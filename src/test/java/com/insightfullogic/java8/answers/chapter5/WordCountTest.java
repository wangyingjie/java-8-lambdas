package com.insightfullogic.java8.answers.chapter5;

import org.junit.Test;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class WordCountTest {

    @Test
    public void passesBookExample() {
        Stream<String> names = Stream.of("John", "Paul", "George", "John", "Paul", "John");

        //names.parallel();

        Map<String, Long> counts = WordCount.countWords(names);

        assertEquals(3, counts.size());
        assertEquals(Long.valueOf(3), counts.get("John"));
        assertEquals(Long.valueOf(2), counts.get("Paul"));
        assertEquals(Long.valueOf(1), counts.get("George"));

        ThreadLocalRandom random = ThreadLocalRandom.current();
        int nextInt = random.nextInt(1, 7);//范围随机数
    }

}
