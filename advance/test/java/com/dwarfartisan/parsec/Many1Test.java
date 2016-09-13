package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static com.dwarfartisan.parsec.Txt.joining;

/**
 * Many1 Tester.
 *
 * @author Mars Liu
 */
public class Many1Test extends Base {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void fail() throws Exception {
        State<Character, Integer, Integer> state = newState("ello");

        Many1<Character, Character, Integer, Integer> m = new Many1<>(
                new Eq<>('h')
        );

        try {
            m.parse(state);
            Assert.fail();
        } catch (ParsecException e) {
            Assert.assertTrue(true);
        }
    }

    @Test
    public void one() throws Exception {
        Parsec<String, Character, Integer, Integer> m =
                new Many1<>(new Eq<Character, Integer, Integer>('h')).bind(joining());
        State<Character, Integer, Integer> state1 = newState("hello");
        String re = m.parse(state1);
        Assert.assertEquals(re, "h");
    }

    @Test
    public void all() throws Exception {
        Parsec<String, Character, Integer, Integer> parser =
                new Many1<>(new One<Character, Integer, Integer>()).bind(joining());
        State<Character, Integer, Integer> state1 = newState("hello");
        String re = parser.parse(state1);
        Assert.assertEquals(re, "hello");
    }
} 
