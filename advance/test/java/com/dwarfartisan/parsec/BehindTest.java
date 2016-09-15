package com.dwarfartisan.parsec;

import org.hamcrest.core.IsEqual;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Mars Liu on 16/9/15.
 */
public class BehindTest extends Base {

    @Test
    public void simple() throws Exception{
        State<Character, Integer, Integer> state = newState("this is a string data.");
        Parsec<String, Character, Integer, Integer> parser =
                new Text<Integer, Integer>("this").over(new Behind<>(new Text<>(" is")));

        String re = parser.parse(state);

        assertEquals(re, "this");
        assertThat("Expect status stop after this but is. ", state.status(), IsEqual.equalTo(4));
    }
}
