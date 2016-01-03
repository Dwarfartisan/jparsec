package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars Liu on 2016-01-03.
 */
public class SepBy1<T, S, E> implements Parsec<List<T>, E> {
    private Parsec<S, E> by;
    private Parsec<T, E> p;
    @Override
    public List<T> parse(State<E> s) throws EOFException, ParsecException {
        List<T> re = new ArrayList<T>();
        re.add(this.p.parse(s));
        try {
            while (true) {
                this.by.parse(s);
                re.add(this.p.parse(s));
            }
        } catch (Exception e) {
            return re;
        }
    }

    public SepBy1(Parsec<T, E> p, Parsec<S, E> by) {
        this.by = new Try<>(by);
        this.p = new Try<>(p);
    }
}
