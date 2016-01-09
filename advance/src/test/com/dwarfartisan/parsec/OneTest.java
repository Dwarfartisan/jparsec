package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * One Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>一月 9, 2016</pre>
 */
public class OneTest extends Base {

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
    public void testOne() throws Exception {
        State<Character> state = newState("hello");

        One<Character> one = new One<Character>();

        try {
            Character c = one.parse(state);
            Assert.assertTrue(c.equals('h'));
        } catch (ParsecException e) {
            Assert.assertTrue(true);
        }
    }

} 
