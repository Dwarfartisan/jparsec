package com.dwarfartisan.parsec;

import java.util.Set;

/**
 * Created by march on 16/9/12.
 * static util class for atom parsers.
 */
public class Atom {
    public static <E, Status, Tran>  Parsec <E, E, Status, Tran> one()  {
        return new One<>();
    }

    public static <T, E, Status, Tran> Parsec<T, E, Status, Tran> eof() {
        return new Eof<>();
    }

    public static <T, E, Status, Tran> Parsec<T, E, Status, Tran> pack(T value) {
        return new Return<>(value);
    }

    public static <T, E, Status, Tran> Parsec<T, E, Status, Tran> fail(String message, Object...objects) {
        return new Fail<T, E, Status, Tran>(message, objects);
    }

    public static <E, Status, Tran> Parsec<E, E, Status, Tran> eq(E item) {
        return new Eq<>(item);
    }

    public static <E, Status, Tran> Parsec<E, E, Status, Tran> ne(E item) {
        return new Ne<>(item);
    }

    public static <E, Status, Tran> Parsec<E, E, Status, Tran> oneOf(Set<E> data) {
        return new OneOf<>(data);
    }

    public static <E, Status, Tran> Parsec<E, E, Status, Tran> noneOf(Set<E> data) {
        return new NoneOf<>(data);
    }
}
