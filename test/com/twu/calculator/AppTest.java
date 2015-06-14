package com.twu.calculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class AppTest {

    private ByteArrayOutputStream outputContent;

    @Before
    public void setUp() {
        outputContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputContent));
    }

    @Test
    public void shouldCorrectlyProcessTheGivenCommands() {
        ByteArrayInputStream inputContent = new ByteArrayInputStream("add 10\nmultiply 20\nexit".getBytes());
        View view = new View(new Scanner(inputContent));
        Model model = new Model();
        model.addObserver(view);
        Parser parser = new Parser(model);
        History history = new History(new ArrayList<Operation>());
        App app = new App(parser, history, view);

        app.start();
        String actualResult = outputContent.toString();

        assertEquals("10.0\n200.0\n", actualResult);
    }

    @After
    public void tearDown() {
        System.setOut(null);
    }
}
