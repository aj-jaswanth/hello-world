package com.twu.calculator;

import com.twu.calculator.operations.Add;
import com.twu.calculator.operations.Square;
import com.twu.calculator.operations.Subtract;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HistoryTest {

    private Model model;

    @Before
    public void setUp() {
        model = new Model();
    }

    @Test
    public void shouldReturnLastThreeOperations() {
        History history = new History(new ArrayList<Operation>());
        Operation firstOperation = new Add(model, 20);
        Operation secondOperation = new Square(model);
        Operation thirdOperation = new Subtract(model, 20);
        history.save(firstOperation);
        history.save(secondOperation);
        history.save(thirdOperation);

        List<Operation> actualList = history.getRecent(3);
        List<Operation> expectedList = Arrays.asList(new Operation[]{firstOperation, secondOperation, thirdOperation});

        assertEquals(expectedList, actualList);
    }
}
