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

    public static <E, Status, Tran> Parsec<E, E, Status, Tran> Eq(E item) {
        return new Eq<E, Status, Tran>(item);
    }

    public static <E, Status, Tran> Parsec<E, E, Status, Tran> Ne(E item) {
        return new Ne<E, Status, Tran>(item);
    }

    public static <E, Status, Tran> Parsec<E, E, Status, Tran> OneOf(Set<E> data) {
        return new OneOf<>(data);
    }

    public static <E, Status, Tran> Parsec<E, E, Status, Tran> NoneOf(Set<E> data) {
        return new NoneOf<>(data);
    }
}
