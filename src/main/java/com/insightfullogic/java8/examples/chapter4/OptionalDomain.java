package com.insightfullogic.java8.examples.chapter4;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by wangyingjie1 on 2017/2/3.
 */
public class OptionalDomain {

    @Test
    public void optional() {
        Optional<String> abc = Optional.of("abc");

        String s1 = abc.get();

        Optional<String> c = abc.filter(string -> string.endsWith("c"));

        String s2 = c.get();
    }

    @Test
    public void optional2() {
        Optional<String> abc = Optional.of("1111x");

        String s1 = abc.get();

        Optional<Integer> c = abc.map(s -> Integer.valueOf(s));

        Integer s2 = c.get();

        System.out.println(s1 + "=========" + s2);

    }

    @Test
    public void optional3() {

        Optional<Object> empty = Optional.empty();

        if (empty.isPresent()) {// Present  ['prez(ə)nt] adj. 现在的；出席的
            Object o = empty.get();
        }

        Optional<Object> objectOptional = Optional.ofNullable(null);

    }

    @Test
    public void optional4() {

        Optional<Object> empty = Optional.empty();

        Object abc = empty.orElse("abc");

        System.out.println(abc);

        // 获取的默认值带有逻辑时，可以通过 orElseGet 来处理
        Object orElseGet = empty.orElseGet(() -> {

            if (1 > 3) return "yyyy";

            return "xxxx";
        });

        System.out.println(orElseGet);
    }
}
