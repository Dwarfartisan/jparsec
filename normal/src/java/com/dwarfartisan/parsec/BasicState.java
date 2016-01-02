package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 16/1/1.
 */
public class BasicState<T> implements State<T> {
    private int current = 0;
    private int tran = -1;
    private T[] buffer;
    public int index(){
        return current;
    }
    public int begin() {
        if(this.tran == -1) {
            this.tran = this.current;
        }
        return this.current;
    }
    public void commit(int tran) {
        if (this.tran == tran) {
            this.tran = -1;
        }
    }
    public void rollback(int tran) {
        this.current = tran;
        if (this.tran == tran) {
            this.tran = -1;
        }
    }
    public T next() throws EOFException {
        if (current >= this.buffer.length) {
            throw new EOFException();
        }
        T re =  this.buffer[this.current];
        this.current ++;
        return re;
    }

    public BasicState(T[] buffer) {
        this.buffer = buffer;
    }
}
