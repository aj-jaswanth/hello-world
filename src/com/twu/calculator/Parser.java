package com.twu.calculator;


import com.twu.calculator.operations.*;

public class Parser {
    private Model model;

    public Parser(Model model) {
        this.model = model;
    }

    public Operation parse(String command) {
        String[] array = command.split(" ");
        try {
            switch (array[0]) {
                case "add":
                    return new Add(model, Double.parseDouble(array[1]));
                case "subtract":
                    return new Subtract(model, Double.parseDouble(array[1]));
                case "multiply":
                    return new Multiply(model, Double.parseDouble(array[1]));
                case "divide":
                    return new Divide(model, Double.parseDouble(array[1]));
                case "abs":
                    return new Absolute(model);
                case "neg":
                    return new Negate(model);
                case "sqr":
                    return new Square(model);
                case "sqrt":
                    return new SquareRoot(model);
                case "cube":
                    return new Cube(model);
                case "cubert":
                    return new CubeRoot(model);
                case "cancel":
                    return new Cancel(model);
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }
}
