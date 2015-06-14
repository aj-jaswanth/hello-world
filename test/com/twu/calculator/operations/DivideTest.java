package com.twu.calculator.operations;

import com.twu.calculator.Model;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class DivideTest {

    private Model model;

    @Before
    public void setUp() {
        model = new Model();
    }

    @Test
    public void shouldReturnCorrectValue() {
        model.add(24);
        Divide divide = new Divide(model, 3);

        divide.execute();
        String actualResult = model.toString();

        assertEquals("8.0", actualResult);
    }

    @Test
    public void equalityOfDivideAndNothing() {
        Divide firstDivide = new Divide(model, 10);

        boolean actual = firstDivide.equals(null);

        assertThat(actual, is(false));
    }

    @Test
    public void equalityOfDivideAndOtherObject() {
        Divide firstDivide = new Divide(model, 10);

        boolean actual = firstDivide.equals("OtherString");

        assertThat(actual, is(false));
    }

    @Test
    public void reflexivePropertyOfEqualsMethod() {
        Divide firstDivide = new Divide(model, 10);

        boolean actual = firstDivide.equals(firstDivide);

        assertThat(actual, is(true));
    }

    @Test
    public void symmetricPropertyOfEqualsMethod() {
        Divide firstDivide = new Divide(model, 10);
        Divide secondDivide = new Divide(model, 10);

        boolean actual = firstDivide.equals(secondDivide) == secondDivide.equals(firstDivide);

        assertThat(actual, is(true));
    }

    @Test
    public void transitivePropertyOfEqualsMethod() {
        Divide firstDivide = new Divide(model, 10);
        Divide secondDivide = new Divide(model, 10);
        Divide thirdDivide = new Divide(model, 10);

        boolean actual = firstDivide.equals(secondDivide) && secondDivide.equals(thirdDivide) && firstDivide.equals(thirdDivide);

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoDividesAreEqualThenTheirHashCodesMustBeEqual() {
        Divide firstDivide = new Divide(model, 10);
        Divide secondDivide = new Divide(model, 10);

        boolean actual = firstDivide.equals(secondDivide) && firstDivide.hashCode() == secondDivide.hashCode();

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoDividesAreDifferentThenTheirHashCodesMustBeDifferent() {
        Divide firstDivide = new Divide(model, 10);
        Model secondModel = new Model();
        secondModel.add(20);
        Divide secondDivide = new Divide(secondModel, 20);

        boolean actual = firstDivide.equals(secondDivide) && firstDivide.hashCode() == secondDivide.hashCode();

        assertThat(actual, is(false));
    }
}
