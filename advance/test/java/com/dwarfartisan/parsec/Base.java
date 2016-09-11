package com.dwarfartisan.parsec;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Mars Liu on 2016-01-09.
 * Base 为测试类提供共用的工具函数,继承它可以减少重复的代码书写.
 */
public abstract class Base {
    State<Character, Integer, Integer> newState(String data) {
        return new BasicState<>(IntStream.range(0, data.length())
                .mapToObj(data::charAt)
                .collect(Collectors.toList()));
    }
}
