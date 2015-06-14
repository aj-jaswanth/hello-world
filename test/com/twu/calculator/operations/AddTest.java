package com.twu.calculator.operations;

import com.twu.calculator.Model;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AddTest {

    private Model model;

    @Before
    public void setUp() {
        model = new Model();
    }

    @Test
    public void equalityOfAddAndNothing() {
        Add firstAdd = new Add(model, 20);

        boolean actual = firstAdd.equals(null);

        assertThat(actual, is(false));
    }

    @Test
    public void equalityOfAddAndOtherObject() {
        Add firstAdd = new Add(model, 20);

        boolean actual = firstAdd.equals("OtherString");

        assertThat(actual, is(false));
    }

    @Test
    public void reflexivePropertyOfEqualsMethod() {
        Add firstAdd = new Add(model, 20);

        boolean actual = firstAdd.equals(firstAdd);

        assertThat(actual, is(true));
    }

    @Test
    public void symmetricPropertyOfEqualsMethod() {
        Add firstAdd = new Add(model, 20);
        Add secondAdd = new Add(model, 20);

        boolean actual = firstAdd.equals(secondAdd) == secondAdd.equals(firstAdd);

        assertThat(actual, is(true));
    }

    @Test
    public void transitivePropertyOfEqualsMethod() {
        Add firstAdd = new Add(model, 20);
        Add secondAdd = new Add(model, 20);
        Add thirdAdd = new Add(model, 20);

        boolean actual = firstAdd.equals(secondAdd) && secondAdd.equals(thirdAdd) && firstAdd.equals(thirdAdd);

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoAddsAreEqualThenTheirHashCodesMustBeEqual() {
        Add firstAdd = new Add(model, 20);
        Add secondAdd = new Add(model, 20);

        boolean actual = firstAdd.equals(secondAdd) && firstAdd.hashCode() == secondAdd.hashCode();

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoAddsAreDifferentThenTheirHashCodesMustBeDifferent() {
        Add firstAdd = new Add(model, 20);
        Add secondAdd = new Add(model, 10);

        boolean actual = firstAdd.equals(secondAdd) && firstAdd.hashCode() == secondAdd.hashCode();

        assertThat(actual, is(false));
    }
}
