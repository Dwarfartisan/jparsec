package com.dwarfartisan.parsec;

import java.io.EOFException;

/**
 * Created by Mars Liu on 2016-01-07.
 */
public class Text implements Parsec<String, Character>{
    private String text;

    @Override
    public String parse(State<Character> s) throws EOFException, ParsecException {
        int idx = 0;
        for(Character c: this.text.toCharArray()) {
            Character data = s.next();
            if(c != data){
                String message = String.format("Expect %c at %d but %c", c, idx, data);
                throw new ParsecException(s.index(), message);
            }
            idx ++;
        }
        return text;
    }
    public Text(String text){
        this.text = text;
    }
}
