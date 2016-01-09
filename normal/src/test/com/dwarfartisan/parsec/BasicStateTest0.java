package com.dwarfartisan.parsec;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testOneOf()throws Exception{
        State<Character> state = newState("hello");

        OneOf<Character> oneof = new OneOf<Character>(new Character[]{'h','b'});

        Character c = oneof.parse(state);


        Assert.assertEquals(c,new Character('h'));

        try{
            Character d = oneof.parse(state);
            Assert.fail("not matched");
        }catch(Exception e){

        }
    }

    @Test
    public void testNoneOf()throws Exception{
        State<Character> state = newState("hello");

        NoneOf<Character> noneof = new NoneOf<Character>(new Character[]{'s','b'});

        Character c = noneof.parse(state);

        Assert.assertEquals(c,new Character('h'));

        try{
            State<Character> state2 = newState("sello");
            Character d = noneof.parse(state2);
            Assert.fail("not matched");
        }catch(Exception e){

        }
    }

    @Test
    public void testOne()throws Exception{
        State<Character> state = newState("hello");

        Ne<Character> ne = new Ne<Character>(new Character('h') );

        try {
            Character c = ne.parse(state);
            Assert.fail();
        }catch(Exception e){

        }
    }

    @Test
    public void testEq()throws Exception{
        State<Character> state = newState("hello");

        Eq<Character> eq = new Eq<Character>(new Character('h'));
        int a = state.begin();
        try{
            Character c = eq.parse(state);
            state.commit(a);
        }catch(Exception e){
            state.rollback(a);
            Assert.fail("failed");
        }
    }

    @Test
    public void testEof()throws Exception{
        State<Character> state = newState("hello");

        Eof<Character> eof = new Eof<Character>();

        try{
            state.next();
            state.next();
            state.next();
            state.next();
            state.next();
            Object c = eof.parse(state);
        }catch(Exception e){

            Assert.fail(e.toString());
        }
    }

    @Test
    public void TestMany()throws Exception{
        State<Character> state = newState("hhello");

        Many<Character,Character> m = new Many<Character,Character>(
                new Eq<Character>(new Character('h'))
        );

        List<Character> a = m.parse(state);
        Assert.assertEquals(a.size(),2);
    }

    @Test
    public void TestMany1() throws Exception{
        State<Character> state = newState("ello");

        Many1<Character,Character> m = new Many1<Character,Character>(
                new Eq<Character>(new Character('h'))
        );

        try {
            List<Character> a = m.parse(state);
            Assert.fail();
        }catch(Exception e){

        }
        State<Character> state1 = newState("hello");
        List<Character> b = m.parse(state1);
        Assert.assertEquals(b.size(),1);
    }

    @Test
    public void TestManyTail()throws Exception{
        State<Character> state = newState("hhhhhhlhhhll");

        ManyTil<Character,Character,Character> m = new ManyTil<Character,Character,Character>(
                new Eq<Character>(new Character('h')),
                        new Eq<Character>(new Character('l'))
        );

        List<Character> a = m.parse(state);
        Assert.assertEquals(a.size(),6);
    }

    @Test
    public void TestSepBy()throws Exception{
        State<Character> state = newState("hlhlhlhlhlhll");

        SepBy<Character,Character,Character> m = new SepBy<Character,Character,Character>(
                new Eq<Character>(new Character('h')),
                new Eq<Character>(new Character('l'))
        );

        List<Character> a = m.parse(state);
        Assert.assertEquals(a.size(),6);
    }

    @Test
    public void TestSepBy1()throws Exception{
        State<Character> state = newState("hlhlhlhlhlhll");

        SepBy1<Character,Character,Character> m = new SepBy1<Character,Character,Character>(
                new Eq<Character>(new Character('h')),
                new Eq<Character>(new Character('l'))
        );

        List<Character> a = m.parse(state);
        Assert.assertEquals(a.size(),6);

        State<Character> state1 = newState("hlh,h.hlhlhll");

        List<Character> b = m.parse(state1);
        Assert.assertEquals(b.size(),2);

        State<Character> state2 = newState("sdfsdfsdfsdf");
        try {
            List<Character> c = m.parse(state1);
            Assert.fail();
        }catch(Exception e){

        }
    }

    @Test
    public void TestBetween()throws Exception{

        State<Character> state = newState("hello");




        Between<Character,Character,Character,Character> bmw = new Between<Character,Character,Character,Character>(
                new Eq<Character>(new Character('h')),
                new Eq<Character>(new Character('l')),
                new Eq<Character>(new Character('e'))
        );

            Character c = bmw.parse(state);
            Assert.assertEquals(c,new Character('e'));

    }



} 
