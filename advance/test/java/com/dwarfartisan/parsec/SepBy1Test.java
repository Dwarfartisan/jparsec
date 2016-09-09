package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

/**
 * SepBy1 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>一月 9, 2016</pre>
 */
public class SepBy1Test extends Base {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: parse(State<E> s)
     */
    @Test
    public void TestSepBy1() throws Exception {
        State<Character> state = newState("hlhlhlhlhlhll");

        SepBy1<Character, Character, Character> m = new SepBy1<>(new Ch('h'), new Ch('l'));

        List<Character> a = m.parse(state);
        Assert.assertEquals(a.size(), 6);

        State<Character> state1 = newState("hlh,h.hlhlhll");

        List<Character> b = m.parse(state1);
        Assert.assertEquals(b.size(), 2);

        try {
            List<Character> c = m.parse(state1);
            String message = String.format("Expect a exception but %s", c);
            Assert.fail(message);
        } catch (ParsecException e) {
            Assert.assertTrue(true);
        }
    }


} 
