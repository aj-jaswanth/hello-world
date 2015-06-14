package com.twu.calculator.operations;

import com.twu.calculator.Model;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class NegateTest {

    private Model model;

    @Before
    public void setUp() {
        model = new Model();
    }

    @Test
    public void equalityOfNegateAndNothing() {
        Negate firstNegate = new Negate(model);

        boolean actual = firstNegate.equals(null);

        assertThat(actual, is(false));
    }

    @Test
    public void equalityOfNegateAndOtherObject() {
        Negate firstNegate = new Negate(model);

        boolean actual = firstNegate.equals("OtherString");

        assertThat(actual, is(false));
    }

    @Test
    public void reflexivePropertyOfEqualsMethod() {
        Negate firstNegate = new Negate(model);

        boolean actual = firstNegate.equals(firstNegate);

        assertThat(actual, is(true));
    }

    @Test
    public void symmetricPropertyOfEqualsMethod() {
        Negate firstNegate = new Negate(model);
        Negate secondNegate = new Negate(model);

        boolean actual = firstNegate.equals(secondNegate) == secondNegate.equals(firstNegate);

        assertThat(actual, is(true));
    }

    @Test
    public void transitivePropertyOfEqualsMethod() {
        Negate firstNegate = new Negate(model);
        Negate secondNegate = new Negate(model);
        Negate thirdNegate = new Negate(model);

        boolean actual = firstNegate.equals(secondNegate) && secondNegate.equals(thirdNegate) && firstNegate.equals(thirdNegate);

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoNegatesAreEqualThenTheirHashCodesMustBeEqual() {
        Negate firstNegate = new Negate(model);
        Negate secondNegate = new Negate(model);

        boolean actual = firstNegate.equals(secondNegate) && firstNegate.hashCode() == secondNegate.hashCode();

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoNegatesAreDifferentThenTheirHashCodesMustBeDifferent() {
        Negate firstNegate = new Negate(model);
        Model secondModel = new Model();
        secondModel.add(20);
        Negate secondNegate = new Negate(secondModel);

        boolean actual = firstNegate.equals(secondNegate) && firstNegate.hashCode() == secondNegate.hashCode();

        assertThat(actual, is(false));
    }
}
