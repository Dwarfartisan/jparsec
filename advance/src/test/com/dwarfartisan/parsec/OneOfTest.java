package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.beans.Expression;
import java.io.EOFException;

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

        OneOf<Character> oneof = new OneOf<Character>(new Character[]{'h','b'});

        Character c = oneof.parse(state);


        Assert.assertEquals(c,new Character('h'));

        try{
            Character d = oneof.parse(state);
            Assert.fail("not matched");
        }catch (ParsecException e){
            Assert.assertTrue(true);
        }
    }


} 
