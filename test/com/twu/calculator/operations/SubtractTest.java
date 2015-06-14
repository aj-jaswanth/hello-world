package com.twu.calculator.operations;

import com.twu.calculator.Model;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SubtractTest {

    private Model model;

    @Before
    public void setUp() {
        model = new Model();
    }

    @Test
    public void equalityOfSubtractAndNothing() {
        Subtract firstSubtract = new Subtract(model, 10);

        boolean actual = firstSubtract.equals(null);

        assertThat(actual, is(false));
    }

    @Test
    public void equalityOfSubtractAndOtherObject() {
        Subtract firstSubtract = new Subtract(model, 10);

        boolean actual = firstSubtract.equals("OtherString");

        assertThat(actual, is(false));
    }

    @Test
    public void reflexivePropertyOfEqualsMethod() {
        Subtract firstSubtract = new Subtract(model, 10);

        boolean actual = firstSubtract.equals(firstSubtract);

        assertThat(actual, is(true));
    }

    @Test
    public void symmetricPropertyOfEqualsMethod() {
        Subtract firstSubtract = new Subtract(model, 10);
        Subtract secondSubtract = new Subtract(model, 10);

        boolean actual = firstSubtract.equals(secondSubtract) == secondSubtract.equals(firstSubtract);

        assertThat(actual, is(true));
    }

    @Test
    public void transitivePropertyOfEqualsMethod() {
        Subtract firstSubtract = new Subtract(model, 10);
        Subtract secondSubtract = new Subtract(model, 10);
        Subtract thirdSubtract = new Subtract(model, 10);

        boolean actual = firstSubtract.equals(secondSubtract) && secondSubtract.equals(thirdSubtract) && firstSubtract.equals(thirdSubtract);

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoSubtractsAreEqualThenTheirHashCodesMustBeEqual() {
        Subtract firstSubtract = new Subtract(model, 10);
        Subtract secondSubtract = new Subtract(model, 10);

        boolean actual = firstSubtract.equals(secondSubtract) && firstSubtract.hashCode() == secondSubtract.hashCode();

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoSubtractsAreDifferentThenTheirHashCodesMustBeDifferent() {
        Subtract firstSubtract = new Subtract(model, 10);
        Model secondModel = new Model();
        secondModel.add(20);
        Subtract secondSubtract = new Subtract(secondModel, 20);

        boolean actual = firstSubtract.equals(secondSubtract) && firstSubtract.hashCode() == secondSubtract.hashCode();

        assertThat(actual, is(false));
    }
}
