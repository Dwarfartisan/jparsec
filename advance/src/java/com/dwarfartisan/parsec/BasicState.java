package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-02.
 * BasicState 类型提供一个基本的 state 实现,它将信息序列放到一个数组中作为缓存,不保证并发安全.
 * 如果我们要处理的数据量不至于对内存使用造成负担,也没有并发安全的需要,可以使用它.
 */
public class BasicState<E> implements State<E> {
    private E[] buffer;
    private int current=0;
    private int tran = -1;

    @Override
    public E next() throws EOFException {
        if (this.current >= this.buffer.length) {
            throw new EOFException();
        }
        E re = this.buffer[this.current];
        this.current++;
        return re;
    }

    @Override
    public int index() {
        return this.current;
    }

    @Override
    public int begin() {
        if(this.tran == -1){
            this.tran = this.current;
        }
        return this.current;
    }

    @Override
    public void rollback(int tran) {
        if(this.tran == tran) {
            this.tran = -1;
        }
        this.current = tran;
    }

    @Override
    public void commit(int tran) {
        if(this.tran == tran) {
            this.tran = -1;
        }
    }

    public BasicState(E[] buffer){
        this.buffer = buffer;
    }

}
