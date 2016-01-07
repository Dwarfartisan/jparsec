package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import sun.reflect.annotation.ExceptionProxy;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * BasicState Tester.
 *
 * @author <Authors name>
 * @since <pre>一月 2, 2016</pre>
 * @version 1.0
 */
public class BasicStateTest {

    private State<Character> newState(String data) {
        Character[] buffer   = new Character[data.length()];
        for (int i=0; i < data.length(); i++) {
            buffer[i] = data.charAt(i);
        }

        return new BasicState<>(buffer);
    }
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: next()
     *
     */
    @Test
    public void testNext() throws Exception {
//TODO: Test goes here...
    }

    @Test
    public void testOneOf()throws Exception{
        State<Character> state = newState("hello");

        OneOf<Character> oneof = new OneOf<Character>(
                new Character[]{'h'}
        );

        Object o = oneof.parse(state);
        Assert.assertNotNull(o);
    }
    @Test
    public void testReturn()throws  Exception{
        State<Character> state = newState("hello");

        Return<Character> r = new Return<Character>(
                new Character('e')
        );

        Object o = (new Choice(new OneOf(new Character[]{'h'}),r)).parse(state);
        
        Assert.assertNotNull(o);
    }

    /**
     *
     * Method: index()
     *
     */
    @Test
    public void testIndex() throws Exception {
        String data = "It is a \"string\" for this unit test";

        State<Character> state = newState(data);
        while (state.index()<data.length()){
            int index = state.index();
            Character c = state.next();
            Character chr = data.charAt(index);
            Assert.assertEquals(c, chr);
        }
        try{
            Character failed = state.next();
            Assert.fail("The state next at preview line should failed.");
        } catch (EOFException e) {
            Assert.assertTrue("the error is Eof", EOFException.class==e.getClass());
        }
    }

    /**
     *
     * Method: begin()
     *
     */
    @Test
    public void testBegin() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: rollback(int tran)
     *
     */
    @Test
    public void testRollback() throws Exception {
//TODO: Test goes here...
    }

    /**
     *
     * Method: commit(int tran)
     *
     */
    @Test
    public void testCommit() throws Exception {
//TODO: Test goes here...
    }


}
