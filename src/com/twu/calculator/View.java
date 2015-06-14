package com.twu.calculator;

import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    public void displayResult(double result) {
        System.out.println(result);
    }

    @Override
    public void update(Observable object, Object value) {
        if (object instanceof Model) {
            displayResult((Double) value);
        }
    }
}
