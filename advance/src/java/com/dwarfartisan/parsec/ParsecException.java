package com.dwarfartisan.parsec;

/**
 * Created by Mars Liu on 2016-01-02.
 * ParsecException 是 Parsec 算子的逻辑异常.
 */
public class ParsecException extends RuntimeException {
    private String message;
    private int index;
    public ParsecException(int idx, String message) {
        super(message);
        this.index = idx;
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public int getIndex() {
        return index;
    }
}
