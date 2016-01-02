package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.EOFException;

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
