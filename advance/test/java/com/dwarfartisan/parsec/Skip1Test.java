package com.dwarfartisan.parsec;


import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsInstanceOf;
import org.hamcrest.core.IsNull;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static com.dwarfartisan.parsec.Combinator.skip1;
import static com.dwarfartisan.parsec.Txt.text;

/**
 * Created by Mars Liu on 16/1/10.
 *
 * Skip1 tests
 */
public class Skip1Test extends Base {
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }
    /**
     * Method: parse(State<E> s)
     */
    @Test
    public void simple() throws Exception {
        State<Character, Integer, Integer> state = newState("left right left right");
        Parsec<String, Character, Integer, Integer> parser = skip1(text("left"));
        String re = parser.parse(state);
        Assert.assertThat("Expect string \"left\".", re, IsNull.nullValue());
    }

    @Test
    public void simpleStatus() throws Exception {
        State<Character, Integer, Integer> state = newState("left right left right");
        Parsec<String, Character, Integer, Integer> parser = skip1(text("left "));
        parser.parse(state);
        Integer status = state.status();
        Assert.assertThat("Expect string \"left\".", status, IsEqual.equalTo(5));
    }

    @Test
    public void statusMore() throws Exception {
        State<Character, Integer, Integer> state = newState("left left right right");
        Parsec<String, Character, Integer, Integer> parser = skip1(text("left "));
        parser.parse(state);
        Integer status = state.status();
        Assert.assertThat("Expect string \"left\".", status, IsEqual.equalTo(10));
    }

    @Test
    public void fail() throws Exception {
        State<Character, Integer, Integer> state = newState("right right left left");
        Parsec<String, Character, Integer, Integer> parser = skip1(text("left "));
        try {
            parser.parse(state);
        } catch (Exception e) {
            Integer status = state.status();
            Assert.assertThat("Expect failed and stop at 1.", status, IsEqual.equalTo(1));

            Assert.assertThat("Expect a ParsecException", e, IsInstanceOf.instanceOf(ParsecException.class));
        }
    }
}
