package com.twu.calculator.operations;

import com.twu.calculator.Model;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class AbsoluteTest {

    private Model model;

    @Before
    public void setUp() {
        model = new Model();
    }

    @Test
    public void shouldReturnCorrectValue() {
        model.add(-10);
        Absolute absolute = new Absolute(model);

        absolute.execute();
        String actualResult = model.toString();

        assertEquals("10.0", actualResult);
    }

    @Test
    public void equalityOfAbsoluteAndNothing() {
        Absolute firstAbsolute = new Absolute(model);

        boolean actual = firstAbsolute.equals(null);

        assertThat(actual, is(false));
    }

    @Test
    public void equalityOfAbsoluteAndOtherObject() {
        Absolute firstAbsolute = new Absolute(model);

        boolean actual = firstAbsolute.equals("OtherString");

        assertThat(actual, is(false));
    }

    @Test
    public void reflexivePropertyOfEqualsMethod() {
        Absolute firstAbsolute = new Absolute(model);

        boolean actual = firstAbsolute.equals(firstAbsolute);

        assertThat(actual, is(true));
    }

    @Test
    public void symmetricPropertyOfEqualsMethod() {
        Absolute firstAbsolute = new Absolute(model);
        Absolute secondAbsolute = new Absolute(model);

        boolean actual = firstAbsolute.equals(secondAbsolute) == secondAbsolute.equals(firstAbsolute);

        assertThat(actual, is(true));
    }

    @Test
    public void transitivePropertyOfEqualsMethod() {
        Absolute firstAbsolute = new Absolute(model);
        Absolute secondAbsolute = new Absolute(model);
        Absolute thirdAbsolute = new Absolute(model);

        boolean actual = firstAbsolute.equals(secondAbsolute) && secondAbsolute.equals(thirdAbsolute) && firstAbsolute.equals(thirdAbsolute);

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoAbsolutesAreEqualThenTheirHashCodesMustBeEqual() {
        Absolute firstAbsolute = new Absolute(model);
        Absolute secondAbsolute = new Absolute(model);

        boolean actual = firstAbsolute.equals(secondAbsolute) && firstAbsolute.hashCode() == secondAbsolute.hashCode();

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoAbsolutesAreDifferentThenTheirHashCodesMustBeDifferent() {
        Model secondModel = new Model();
        secondModel.add(20);
        Absolute firstAbsolute = new Absolute(model);
        Absolute secondAbsolute = new Absolute(secondModel);

        boolean actual = firstAbsolute.equals(secondAbsolute) && firstAbsolute.hashCode() == secondAbsolute.hashCode();

        assertThat(actual, is(false));
    }
}
