package com.twu.calculator;

public class Calculator {

    private double result;

    public double processCommand(String command) {
        String[] splitCommand = command.split(" ");
        String operation = splitCommand[0];
        double operand = Double.parseDouble(splitCommand[1]);
        switch (operation) {
            case "add":
                result += operand;
                break;
            case "subtract":
                result -= operand;
                break;
        }
        return result;
    }
}
