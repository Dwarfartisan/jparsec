package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars Liu on 2016-01-03.
 * ManyTil 尝试匹配 parser 0 到多次,直到终结算子成功,它是饥饿模式.
 */
public class ManyTill<T, L, E> implements Parsec<List<T>, E> {
    private Parsec<T, E> parser;
    private Parsec<L, E> til;
    @Override
    public List<T> parse(State<E> s) throws EOFException, ParsecException {
        ArrayList<T> re = new ArrayList<>();
        while (true) {
            try {
                til.parse(s);
                return re;
            } catch (EOFException | ParsecException e) {
                re.add(parser.parse(s));
            }
        }
    }

    public ManyTill(Parsec<T, E> parser, Parsec<L, E> til) {
        this.parser = new Try<>(parser);
        this.til = til;
    }
}
