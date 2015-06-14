package com.twu.calculator;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class View implements Observer {
    Scanner input;

    public View(Scanner scanner) {
        this.input = scanner;
    }

    public void displayResult(double result) {
        System.out.println(result);
    }

    public String readInput() {
        return input.nextLine();
    }

    @Override
    public void update(Observable object, Object value) {
        if (object instanceof Model) {
            displayResult((Double) value);
        }
    }
}
