package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * NoneOf Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>一月 9, 2016</pre>
 */
public class NoneOfTest extends Base {

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
    public void testParse() throws Exception {
        State<Character> state = newState("hello");

        NoneOf<Character> noneOf = new NoneOf<>(new Character[]{'s', 'b'});

        Character c = noneOf.parse(state);

        Assert.assertEquals(c, new Character('h'));

        try {
            State<Character> state2 = newState("sello");
            Character d = noneOf.parse(state2);
            String message = String.format("Expect a char none of %s  but %c", "hello", d);
            Assert.fail(message);
        } catch (ParsecException e){
            Assert.assertTrue(true);
        }
    }


} 
