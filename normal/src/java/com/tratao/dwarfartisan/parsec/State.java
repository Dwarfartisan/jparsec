package com.tratao.dwarfartisan.parsec;

import java.lang.IndexOutOfBoundsException;
import java.io.EOFException;

/**
 * Created by Mars Liu on 16/1/1.
 */
public interface State<T> {
    T next() throws EOFException;
    int index();
    int begin();
    void commit(int tranId);
    void rollback(int tranId);
}
