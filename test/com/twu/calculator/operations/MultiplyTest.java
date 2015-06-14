package com.twu.calculator.operations;

import com.twu.calculator.Model;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MultiplyTest {

    private Model model;

    @Before
    public void setUp() {
        model = new Model();
    }

    @Test
    public void equalityOfMultiplyAndNothing() {
        Multiply firstMultiply = new Multiply(model, 20);

        boolean actual = firstMultiply.equals(null);

        assertThat(actual, is(false));
    }

    @Test
    public void equalityOfMultiplyAndOtherObject() {
        Multiply firstMultiply = new Multiply(model, 20);

        boolean actual = firstMultiply.equals("OtherString");

        assertThat(actual, is(false));
    }

    @Test
    public void reflexivePropertyOfEqualsMethod() {
        Multiply firstMultiply = new Multiply(model, 20);

        boolean actual = firstMultiply.equals(firstMultiply);

        assertThat(actual, is(true));
    }

    @Test
    public void symmetricPropertyOfEqualsMethod() {
        Multiply firstMultiply = new Multiply(model, 20);
        Multiply secondMultiply = new Multiply(model, 20);

        boolean actual = firstMultiply.equals(secondMultiply) == secondMultiply.equals(firstMultiply);

        assertThat(actual, is(true));
    }

    @Test
    public void transitivePropertyOfEqualsMethod() {
        Multiply firstMultiply = new Multiply(model, 20);
        Multiply secondMultiply = new Multiply(model, 20);
        Multiply thirdMultiply = new Multiply(model, 20);

        boolean actual = firstMultiply.equals(secondMultiply) && secondMultiply.equals(thirdMultiply) && firstMultiply.equals(thirdMultiply);

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoMultiplysAreEqualThenTheirHashCodesMustBeEqual() {
        Multiply firstMultiply = new Multiply(model, 20);
        Multiply secondMultiply = new Multiply(model, 20);

        boolean actual = firstMultiply.equals(secondMultiply) && firstMultiply.hashCode() == secondMultiply.hashCode();

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoMultiplysAreDifferentThenTheirHashCodesMustBeDifferent() {
        Multiply firstMultiply = new Multiply(model, 20);
        Model secondModel = new Model();
        secondModel.add(20);
        Multiply secondMultiply = new Multiply(secondModel, 30);

        boolean actual = firstMultiply.equals(secondMultiply) && firstMultiply.hashCode() == secondMultiply.hashCode();

        assertThat(actual, is(false));
    }
}
