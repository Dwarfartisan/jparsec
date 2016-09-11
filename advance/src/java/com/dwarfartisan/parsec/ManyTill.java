package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars Liu on 2016-01-03.
 * ManyTil 尝试匹配 parser 0 到多次,直到终结算子成功,它是饥饿模式.
 */
public class ManyTill<T, L, E, Status, Tran> implements Parsec<List<T>, E, Status, Tran> {
    private Parsec<T, E, Status, Tran> parser;
    private Parsec<L, E, Status, Tran> til;
    @Override
    public List<T> parse(State<E, Status, Tran> s) throws EOFException, ParsecException {
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

    public ManyTill(Parsec<T, E, Status, Tran> parser, Parsec<L, E, Status, Tran> til) {
        this.parser = new Try<>(parser);
        this.til = til;
    }
}
