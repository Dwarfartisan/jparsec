package com.dwarfartisan.parsec;

import java.util.List;
/**
 * Created by march on 16/9/12.
 * helper toolbox for combinator.
 */
public class Combinator {
    public static <T, E, Status, Tran> Parsec<T, E, Status, Tran> attempt(Parsec<T, E, Status, Tran> parser) {
        return new Try<>(parser);
    }

    public static <T, E, Status, Tran> Parsec<T, E, Status, Tran> behind(Parsec<T, E, Status, Tran> parser) {
        return new Behind<>(parser);
    }

    public static <T, E, Status, Tran> Parsec<T, E, Status, Tran> choice(Parsec<T, E, Status, Tran> ... parsers) {
        return new Choice<>(parsers);
    }

    public static <T, E, Status, Tran> Parsec<List<T>, E, Status, Tran> many(Parsec<T, E, Status, Tran> parser) {
        return new Many<>(parser);
    }

    public static <T, E, Status, Tran> Parsec<List<T>, E, Status, Tran> many1(Parsec<T, E, Status, Tran> parser) {
        return new Many1<>(parser);
    }

    public static <T, L, E, Status, Tran> Parsec<List<T>,  E, Status, Tran> manyTill(
            Parsec<T, E, Status, Tran> parser, Parsec<L, E, Status, Tran> end) {
        return new ManyTill<T, L, E, Status, Tran>(parser, end);
    }

    public static <T, E, Status, Tran> Parsec<T, E, Status, Tran> skip(Parsec<T, E, Status, Tran> parser) {
        return new Skip<>(parser);
    }

    public static <T, E, Status, Tran> Parsec<T, E, Status, Tran> skip1(Parsec<T, E, Status, Tran> parser) {
        return new Skip1<>(parser);
    }

    public static <T, S, E, Status, Tran> Parsec<List<T>, E, Status, Tran> sepBy(
            Parsec<T, E, Status, Tran> parser, Parsec<S, E, Status, Tran> by) {
        return new SepBy<>(parser, by);
    }

    public static <T, S, E, Status, Tran> Parsec<List<T>, E, Status, Tran> sepBy1(
            Parsec<T, E, Status, Tran> parser, Parsec<S, E, Status, Tran> by) {
        return new SepBy1<>(parser, by);
    }

    public static <T, E, Status, Tran> Parsec<T, E, Status, Tran> find(Parsec<T, E, Status, Tran> parser) {
        return new Find<T, E, Status, Tran>(parser);
    }

    public static <T, E, O, C, Status, Tran> Parsec<T, E, Status, Tran> between(Parsec<O, E, Status, Tran> open,
                                                                                Parsec<C, E, Status, Tran> close,
                                                                                Parsec<T, E, Status, Tran> parser){
        return new Between<>(open, close, parser);
    }
}
