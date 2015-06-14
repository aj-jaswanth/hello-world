package com.twu.calculator.operations;

import com.twu.calculator.Model;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CancelTest {

    private Model model;

    @Before
    public void setUp() {
        model = new Model();
    }

    @Test
    public void shouldReturnCorrectValue() {
        model.add(-10);
        Cancel cancel = new Cancel(model);

        cancel.execute();
        String actualResult = model.toString();

        assertEquals("0.0", actualResult);
    }

    @Test
    public void equalityOfCancelAndNothing() {
        Cancel firstCancel = new Cancel(model);

        boolean actual = firstCancel.equals(null);

        assertThat(actual, is(false));
    }

    @Test
    public void equalityOfCancelAndOtherObject() {
        Cancel firstCancel = new Cancel(model);

        boolean actual = firstCancel.equals("OtherString");

        assertThat(actual, is(false));
    }

    @Test
    public void reflexivePropertyOfEqualsMethod() {
        Cancel firstCancel = new Cancel(model);

        boolean actual = firstCancel.equals(firstCancel);

        assertThat(actual, is(true));
    }

    @Test
    public void symmetricPropertyOfEqualsMethod() {
        Cancel firstCancel = new Cancel(model);
        Cancel secondCancel = new Cancel(model);

        boolean actual = firstCancel.equals(secondCancel) == secondCancel.equals(firstCancel);

        assertThat(actual, is(true));
    }

    @Test
    public void transitivePropertyOfEqualsMethod() {
        Cancel firstCancel = new Cancel(model);
        Cancel secondCancel = new Cancel(model);
        Cancel thirdCancel = new Cancel(model);

        boolean actual = firstCancel.equals(secondCancel) && secondCancel.equals(thirdCancel) && firstCancel.equals(thirdCancel);

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoCancelsAreEqualThenTheirHashCodesMustBeEqual() {
        Cancel firstCancel = new Cancel(model);
        Cancel secondCancel = new Cancel(model);

        boolean actual = firstCancel.equals(secondCancel) && firstCancel.hashCode() == secondCancel.hashCode();

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoCancelsAreDifferentThenTheirHashCodesMustBeDifferent() {
        Model secondModel = new Model();
        secondModel.add(20);
        Cancel firstCancel = new Cancel(model);
        Cancel secondCancel = new Cancel(secondModel);

        boolean actual = firstCancel.equals(secondCancel) && firstCancel.hashCode() == secondCancel.hashCode();

        assertThat(actual, is(false));
    }
}
