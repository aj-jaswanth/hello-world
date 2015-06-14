package com.twu.calculator.operations;

import com.twu.calculator.Model;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareRootTest {

    private Model model;

    @Before
    public void setUp() {
        model = new Model();
    }

    @Test
    public void equalityOfSquareRootAndNothing() {
        SquareRoot firstSquareRoot = new SquareRoot(model);

        boolean actual = firstSquareRoot.equals(null);

        assertThat(actual, is(false));
    }

    @Test
    public void equalityOfSquareRootAndOtherObject() {
        SquareRoot firstSquareRoot = new SquareRoot(model);

        boolean actual = firstSquareRoot.equals("OtherString");

        assertThat(actual, is(false));
    }

    @Test
    public void reflexivePropertyOfEqualsMethod() {
        SquareRoot firstSquareRoot = new SquareRoot(model);

        boolean actual = firstSquareRoot.equals(firstSquareRoot);

        assertThat(actual, is(true));
    }

    @Test
    public void symmetricPropertyOfEqualsMethod() {
        SquareRoot firstSquareRoot = new SquareRoot(model);
        SquareRoot secondSquareRoot = new SquareRoot(model);

        boolean actual = firstSquareRoot.equals(secondSquareRoot) == secondSquareRoot.equals(firstSquareRoot);

        assertThat(actual, is(true));
    }

    @Test
    public void transitivePropertyOfEqualsMethod() {
        SquareRoot firstSquareRoot = new SquareRoot(model);
        SquareRoot secondSquareRoot = new SquareRoot(model);
        SquareRoot thirdSquareRoot = new SquareRoot(model);

        boolean actual = firstSquareRoot.equals(secondSquareRoot) && secondSquareRoot.equals(thirdSquareRoot) && firstSquareRoot.equals(thirdSquareRoot);

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoSquareRootsAreEqualThenTheirHashCodesMustBeEqual() {
        SquareRoot firstSquareRoot = new SquareRoot(model);
        SquareRoot secondSquareRoot = new SquareRoot(model);

        boolean actual = firstSquareRoot.equals(secondSquareRoot) && firstSquareRoot.hashCode() == secondSquareRoot.hashCode();

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoSquareRootsAreDifferentThenTheirHashCodesMustBeDifferent() {
        SquareRoot firstSquareRoot = new SquareRoot(model);
        Model secondModel = new Model();
        secondModel.add(20);
        SquareRoot secondSquareRoot = new SquareRoot(secondModel);

        boolean actual = firstSquareRoot.equals(secondSquareRoot) && firstSquareRoot.hashCode() == secondSquareRoot.hashCode();

        assertThat(actual, is(false));
    }
}
