package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * OneOf Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>一月 9, 2016</pre>
 */
public class OneOfTest extends Base{
    private String data = "It is a \"string\" for this unit test";


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

        OneOf<Character> oneOf = new OneOf<>(new Character[]{'h', 'b'});

        Character c = oneOf.parse(state);


        Assert.assertEquals(c,new Character('h'));

        try{
            Character d = oneOf.parse(state);
            String message = String.format("Expect a char in %s but %c", "hello", d);
            Assert.fail(message);
        }catch (ParsecException e){
            Assert.assertTrue(true);
        }
    }


} 
