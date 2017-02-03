package com.insightfullogic.java8.examples.chapter5;

import java.util.Collections;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

// BEGIN class_def

/**
 * @see StringJoiner
 *
 * 字符串链接工具类
 */
public class StringCollector implements Collector<String, StringCombiner, String> {
// END class_def

    private static final Set<Characteristics> characteristics = Collections.emptySet();

    private final String delim;
    private final String prefix;
    private final String suffix;

    public StringCollector(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    @Override
    // BEGIN supplier
    public Supplier<StringCombiner> supplier() {// 用来创建一个容器
        return () -> new StringCombiner(delim, prefix, suffix);
    }
    // END supplier

    @Override
    // BEGIN accumulator
    public BiConsumer<StringCombiner, String> accumulator() {//将当前元素叠加到收集器上
        return StringCombiner::add;
    }
    // END accumulator

    @Override
    // BEGIN combiner
    public BinaryOperator<StringCombiner> combiner() {//n. 组合器 如果有两个收集器则进行组合
        return StringCombiner::merge;
    }
    // END combiner

    @Override
    // BEGIN finisher
    public Function<StringCombiner, String> finisher() {//收集器的最终值

        //(name) -> new StringCombiner(",""[", "]").add(name);

        return StringCombiner::toString;
    }
    // END finisher

    @Override
    public Set<Characteristics> characteristics() {// 收集器的特征
        return characteristics;
    }

}
