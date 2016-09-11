package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.List;
import static java.util.stream.Collectors.joining;

/**
 * Created by Mars Liu on 2016-01-03.
 * OneOf 即 one of ,给定项中任何一个匹配成功即视为成功,否则抛出错误.
 */
public class OneOf<E, Status, Tran> implements Parsec<E, E, Status, Tran> {
    private List<E> items;

    @Override
    public E parse(State<E, Status, Tran> s)
            throws EOFException, ParsecException {
        E data = s.next();
        for (E item: this.items) {
            if (data == item){
                return data;
            }
        }
        String message = String.format("Expect %s in [%s]", data,
                this.items.stream().map(x->x.toString()).collect(joining(", ")));
        throw s.trap(message);
    }

    public OneOf(List<E> items){
        this.items = items;
    }
}
