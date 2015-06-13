    package com.twu.calculator;

    import javax.xml.ws.soap.MTOM;

    public class Model {

        private double accumulator;

        public double processCommand(String command) {
            if (command.equals("cancel"))
                return (accumulator = 0);
            if (command.equals("exit"))
                System.exit(0);
            String[] splitCommand = command.split(" ");
            String operation = splitCommand[0];
            double operand = Double.parseDouble(splitCommand[1]);
            switch (operation) {
                case "add":
                    return add(operand);
                case "subtract":
                    return subtract(operand);
                case "multiply":
                    return multiply(operand);
                case "divide":
                    return divide(operand);
                case "abs":
                    return absolute();
                case "neg":
                    return negate();
                case "sqrt":
                    return squareRoot();
                case "sqr":
                    return square();
                case "cube":
                    return cube();
                case "cubert":
                    return cubeRoot();
            }
            return 0;
        }

        public double add(double operand) {
            accumulator += operand;
            return accumulator;
        }

        public double subtract(double operand) {
            accumulator -= operand;
            return accumulator;
        }

        public double multiply(double operand) {
            accumulator *= operand;
            return accumulator;
        }

        public double divide(double operand) {
            accumulator /= operand;
            return accumulator;
        }

        public double absolute() {
            accumulator = Math.abs(accumulator);
            return accumulator;
        }

        public double negate() {
            accumulator = -accumulator;
            return accumulator;
        }

        public double square() {
            accumulator *= accumulator;
            return accumulator;
        }

        public double squareRoot() {
            accumulator = Math.sqrt(accumulator);
            return accumulator;
        }

        public double cube() {
            accumulator = Math.pow(accumulator, 3);
            return accumulator;
        }

        public double cubeRoot() {
            accumulator = Math.cbrt(accumulator);
            return accumulator;
        }
    }
