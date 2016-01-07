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
        State<Character> state = newState("hello");

        Character c = state.next();



        Assert.assertEquals(c,new Character('h'));

        int a = state.begin();

        c = state.next();
        c = state.next();
        c = state.next();

        state.rollback(a);

        Character d = state.next();

        Assert.assertEquals(d,new Character('e'));
    }

    /**
     *
     * Method: Commit(int tran)
     *
     */
    @Test
    public void testCommit() throws Exception {
        State<Character> state = newState("hello");
        int a = state.begin();
        Character c = state.next();


        Assert.assertEquals(c,new Character('h'));
        c = state.next();

        state.commit(a);

        Character d = state.next();

        Assert.assertEquals(d,new Character('l'));
    }

    /**
     *
     * Method: Rollback(int tran)
     *
     */
    @Test
    public void testRollback() throws Exception {
        State<Character> state = newState("hello");

        int a = state.begin();
        Character c = state.next();


        Assert.assertEquals(c,new Character('h'));

        state.rollback(a);

        Character d = state.next();

        Assert.assertEquals(d,new Character('h'));
    }

    /**
     *
     * Method: Next()
     *
     */
    @Test
    public void testNext() throws Exception {
        State<Character> state = newState("hello");


        Character c = state.next();

        Assert.assertEquals(c,new Character('h'));

        Character d = state.next();

        Assert.assertEquals(d,new Character('e'));
        Character e = state.next();

        Assert.assertEquals(e,new Character('l'));
        Character f = state.next();

        Assert.assertEquals(f,new Character('l'));
        Character g = state.next();

        Assert.assertEquals(g,new Character('o'));

    }


}