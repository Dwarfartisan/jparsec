package com.dwarfartisan.parsec;

import static com.dwarfartisan.parsec.Txt.space;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mars Liu on 16/9/15.
 *
 * Tests About look behind.
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

    @Test
    public void result() throws Exception{
        State<Character, Integer, Integer> state = newState("this is a string data.");
        Parsec<String, Character, Integer, Integer> parser =
                new Text<Integer, Integer>("this").then(space()).then(new Behind<>(new Text<>("is")));

        String re = parser.parse(state);

        assertEquals(re, "is");
        assertThat("Expect status stop after this (5) but is. ", state.status(), IsEqual.equalTo(5));
    }

    @Test
    public void fail() throws Exception{
        State<Character, Integer, Integer> state = newState("this is a string.");
        Parsec<String, Character, Integer, Integer> parser =
                new Text<Integer, Integer>("this").then(space()).then(new Behind<>(new Text<>(" is")));

        try {
            String re = parser.parse(state);
        } catch (Exception e) {
            assertThat("Expect status stop after this (5) but is. ", state.status(), IsEqual.equalTo(5));
            assertThat("Expect the parser fail when try match \" is\"",
                    e, IsInstanceOf.instanceOf(ParsecException.class));
        }
    }
}
