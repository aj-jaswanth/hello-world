package com.twu.calculator.operations;

import com.twu.calculator.Model;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class SquareTest {

    private Model model;

    @Before
    public void setUp() {
        model = new Model();
    }

    @Test
    public void shouldReturnCorrectValue() {
        model.add(20);
        Square square = new Square(model);

        square.execute();
        String actualResult = model.toString();

        assertEquals("400.0", actualResult);
    }

    @Test
    public void equalityOfSquareAndNothing() {
        Square firstSquare = new Square(model);

        boolean actual = firstSquare.equals(null);

        assertThat(actual, is(false));
    }

    @Test
    public void equalityOfSquareAndOtherObject() {
        Square firstSquare = new Square(model);

        boolean actual = firstSquare.equals("OtherString");

        assertThat(actual, is(false));
    }

    @Test
    public void reflexivePropertyOfEqualsMethod() {
        Square firstSquare = new Square(model);

        boolean actual = firstSquare.equals(firstSquare);

        assertThat(actual, is(true));
    }

    @Test
    public void symmetricPropertyOfEqualsMethod() {
        Square firstSquare = new Square(model);
        Square secondSquare = new Square(model);

        boolean actual = firstSquare.equals(secondSquare) == secondSquare.equals(firstSquare);

        assertThat(actual, is(true));
    }

    @Test
    public void transitivePropertyOfEqualsMethod() {
        Square firstSquare = new Square(model);
        Square secondSquare = new Square(model);
        Square thirdSquare = new Square(model);

        boolean actual = firstSquare.equals(secondSquare) && secondSquare.equals(thirdSquare) && firstSquare.equals(thirdSquare);

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoSquaresAreEqualThenTheirHashCodesMustBeEqual() {
        Square firstSquare = new Square(model);
        Square secondSquare = new Square(model);

        boolean actual = firstSquare.equals(secondSquare) && firstSquare.hashCode() == secondSquare.hashCode();

        assertThat(actual, is(true));
    }

    @Test
    public void ifTwoSquaresAreDifferentThenTheirHashCodesMustBeDifferent() {
        Square firstSquare = new Square(model);
        Model secondModel = new Model();
        secondModel.add(20);
        Square secondSquare = new Square(secondModel);

        boolean actual = firstSquare.equals(secondSquare) && firstSquare.hashCode() == secondSquare.hashCode();

        assertThat(actual, is(false));
    }
}
