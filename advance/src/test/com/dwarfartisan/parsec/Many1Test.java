package com.dwarfartisan.parsec;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* Many1 Tester. 
* 
* @author <Authors name> 
* @since <pre>一月 9, 2016</pre> 
* @version 1.0 
*/ 
public class Many1Test extends Base {

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: parse(State<E> s) 
* 
*/
@Test
public void TestMany1() throws Exception{
    State<Character> state = newState("ello");

    Many1<Character,Character> m = new Many1<Character,Character>(
            new Eq<Character>('h')
    );

    try {
        List<Character> a = m.parse(state);
        Assert.fail();
    }catch(ParsecException e){
        Assert.assertTrue(true);
    }
    State<Character> state1 = newState("hello");
    List<Character> b = m.parse(state1);
    Assert.assertEquals(b.size(),1);
}

} 
