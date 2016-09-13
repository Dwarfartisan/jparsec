package com.dwarfartisan.parsec;

import java.util.List;

/**
 * Created by Mars Liu on 16/9/12.
 * Text Parsec Utils
 */
public class Txt {
    public static <Status, Tran> Parsec<Character, Character, Status, Tran> ch(char value) {
        return new Ch<>(value);
    }

    public static <Status, Tran> Parsec<Character, Character, Status, Tran> chIn(String data) {
        return new ChIn<>(data);
    }

    public static <Status, Tran> Parsec<Character, Character, Status, Tran> chNone(String data) {
        return new ChNone<>(data);
    }

    public static <Status, Tran> Parsec<String, Character, Status, Tran> crlf() {
        return new Crlf<>();
    }

    public static <Status, Tran> Parsec<String, Character, Status, Tran> decimal() {
        return new Decimal<>();
    }

    public static <Status, Tran> Parsec<String, Character, Status, Tran> udecimal() {
        return new UDecimal<>();
    }

    public static <Status, Tran> Parsec<Character, Character, Status, Tran> digit() {
        return new Digit<>();
    }

    public static <Status, Tran> Parsec<String, Character, Status, Tran> integer() {
        return new Int<>();
    }

    public static <Status, Tran> Parsec<String, Character, Status, Tran> uinteger() {
        return new UInt<>();
    }

    public static <Status, Tran> Parsec<String, Character, Status, Tran> lineEnd() {
        return new EndOfLine<>();
    }

    public static <Status, Tran> Parsec<Character, Character, Status, Tran> newline() {
        return new Newline<>();
    }

    public static <Status, Tran> Parsec<Character, Character, Status, Tran> Space() {
        return new Space<>();
    }

    public static <Status, Tran> Parsec<Character, Character, Status, Tran> whitespace() {
        return new Whitespace<>();
    }

    public static <Status, Tran> Parsec<Character, Character, Status, Tran> skipSpaces() {
        return new SkipSpaces<>();
    }

    public static <Status, Tran> Parsec<Character, Character, Status, Tran> skipWhiteSpaces() {
        return new Whitespace<Status, Tran>();
    }

    public static <Status, Tran> Parsec<String, Character, Status, Tran> text(String value) {
        return new Text<Status, Tran>(value);
    }
    
    public static <E, Status, Tran> Binder<List<Character>, String, E, Status, Tran> joining() {
        return new JoinText<>();
    }
}
