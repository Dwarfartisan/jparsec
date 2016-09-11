package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-07.
 * Newline 尝试匹配换行.这里比 Haskell 版本更敏感, \r, \n, 或 \r\n 都可以解析成功.
 *
 * ---------------
 *
 * 这里把回车和换行分出,独立出去,用户可行自行重新命名和包装.
 * modify by zhaonf on 2016-1-10
 * -----------------
 */
public class Newline<Status, Tran> implements Parsec<Character, Character, Status, Tran> {
    private Parsec<Character, Character, Status, Tran> parser = new Ch<>('\n');
    @Override
    public Character parse(State<Character, Status, Tran> s)
            throws EOFException, ParsecException {
        parser.parse(s);
        return '\n';
    }
}
