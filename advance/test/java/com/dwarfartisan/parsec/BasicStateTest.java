package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.EOFException;

import com.dwarfartisan.parsec.ParsecException;
/**
 * BasicState Tester.
 *
 * @author <Authors name>
 * @since <pre>一月 1, 2016</pre>
 * @version 1.0
 */
public class BasicStateTest extends Base {


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
    public void testIndex() throws EOFException, ParsecException {
        String data = "It is a \"string\" for this unit test";
        State<Character> state = newState(data);
        while (state.index()< data.length()){
            int index = state.index();
            Character c = state.next();
            Character chr = data.charAt(index);
            Assert.assertEquals(c, chr);
        }
        try{
            Character failed = state.next();
            String message = String.format("The state next at preview line should failed but %c.", failed);
            Assert.fail(message);
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

        state.next();
        state.next();
        state.next();

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
        state.next();

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

        Assert.assertEquals(c, new Character('h'));

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
