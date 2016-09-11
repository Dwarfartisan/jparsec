package com.dwarfartisan.parsec;

import java.io.EOFException;
import java.util.List;
import java.util.stream.IntStream;
import static java.util.stream.Collectors.toList;

/**
 * Created by Mars Liu on 2016-01-10.
 * ChIn 即 char in ,是为 Character 特化的 one of
 */
public class ChIn<Status, Tran> implements Parsec<Character, Character, Status, Tran> {
    private OneOf<Character, Status, Tran> oneOf;

    @Override
    public Character parse(State<Character, Status, Tran> s)
            throws EOFException, ParsecException {
        return oneOf.parse(s);
    }

    public ChIn(String data){
        List<Character> dataList = IntStream.range(0, data.length())
                .mapToObj(data::charAt).collect(toList());
        this.oneOf = new OneOf<Character, Status, Tran>(dataList);
    }
}
