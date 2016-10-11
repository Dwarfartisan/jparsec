package com.dwarfartisan.parsec;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import static com.dwarfartisan.parsec.Combinator.*;

public class TryTest extends Base {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void simple() throws Exception {
        State<Character, Integer, Integer> state = newState("hello");
        Parsec<Character,Character, Integer, Integer> parser = new Try<>(new Eq<>('h'));
        Character s = parser.parse(state);
        assertEquals(s,new Character('h'));
    }
    
    @Test
    public void rollback() throws Exception {
        State<Character, Integer, Integer> state = newState("test data.");
        Parsec<String, Character, Integer, Integer> parser = attempt(new Text<>("hello"));
        Integer status = state.status();
        try{
            parser.parse(state);
            fail("Should not reach here.");
        }catch(Exception e){
        	assertEquals("State should rollback if failed.", status, state.status());
        }
    }
}
