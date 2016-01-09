package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Eq Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>一月 9, 2016</pre>
 */
public class EqTest extends Base {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: parse(State<T> s)
     */
    @Test
    public void testEq() throws Exception {
        State<Character> state = newState("hello");

        Eq<Character> eq = new Eq<Character>('h');
        Character c = eq.parse(state);
        Assert.assertTrue(c.equals('h'));
    }


} 
