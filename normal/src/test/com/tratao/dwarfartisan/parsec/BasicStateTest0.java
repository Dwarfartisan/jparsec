package com.tratao.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.EOFException;

/**
 * BasicState Tester.
 *
 * @author <Authors name>
 * @since <pre>一月 1, 2016</pre>
 * @version 1.0
 */
public class BasicStateTest0 {

    private String data = "It is a \"string\" for this unit test";

    private State<Character> newState(String data) {
        Character[] buffer   = new Character[data.length()];
        for (int i=0; i < data.length(); i++) {
            buffer[i] = data.charAt(i);
        }

        return new BasicState<Character>(buffer);
    }
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }
    /**
     *
     * Method: Index()
     *
     */
    @Test
    public void testIndex() throws Exception {
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
     * Method: Begin()
     *
     */
    @Test
    public void testBegin() throws Exception {
//TODO: Test goes here... 
    }

    /**
     *
     * Method: Commit(int tran)
     *
     */
    @Test
    public void testCommit() throws Exception {
//TODO: Test goes here... 
    }

    /**
     *
     * Method: Rollback(int tran)
     *
     */
    @Test
    public void testRollback() throws Exception {
//TODO: Test goes here... 
    }

    /**
     *
     * Method: Next()
     *
     */
    @Test
    public void testNext() throws Exception {
//TODO: Test goes here... 
    }


} 
