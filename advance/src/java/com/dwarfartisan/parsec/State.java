package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-02.
 * State 是 state 接口规范, parsec 用户可以定义自己的 state 实现.
 */
public interface State<E> {
    E next() throws EOFException;
    int index();
    int begin();
    void commit(int tran);
    void rollback(int tran);
}
