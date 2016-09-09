package com.dwarfartisan.parsec;

/**
 * Created by Mars Liu on 2016-01-09.
 * Base 为测试类提供共用的工具函数,继承它可以减少重复的代码书写.
 */
public abstract class Base {
    State<Character> newState(String data) {
        Character[] buffer   = new Character[data.length()];
        for (int i=0; i < data.length(); i++) {
            buffer[i] = data.charAt(i);
        }

        return new BasicState<>(buffer);
    }
}
