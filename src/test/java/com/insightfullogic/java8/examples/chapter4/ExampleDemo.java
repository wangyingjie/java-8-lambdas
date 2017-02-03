package com.insightfullogic.java8.examples.chapter4;

import org.junit.Test;

import java.util.function.BinaryOperator;

/**
 * Created by wangyingjie1 on 2017/2/3.
 */
public class ExampleDemo {

    private interface IntegerBiFunction extends BinaryOperator<Integer> {

    }

    private void overMethod(BinaryOperator<Integer> lambda) {

    }

    private void overMethod(IntegerBiFunction lambda) {

    }

    @Test
    public void test() {
        overMethod((x, y) -> x + y);
    }
}
