package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-02.
 */
public interface State<E> {
    E next() throws EOFException;
    int index();
    int begin();
    void commit(int tran);
    void rollback(int tran);
}
