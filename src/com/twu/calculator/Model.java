package com.twu.calculator;


import java.util.Observable;

public class Model extends Observable {

    private double accumulator;

    public void add(double operand) {
        accumulator += operand;
        notifyChanges();
    }

    public void subtract(double operand) {
        accumulator -= operand;
        notifyChanges();
    }

    public void multiply(double operand) {
        accumulator *= operand;
        notifyChanges();
    }

    public void divide(double operand) {
        accumulator /= operand;
        notifyChanges();
    }

    public void absolute() {
        accumulator = Math.abs(accumulator);
        notifyChanges();
    }

    public void negate() {
        accumulator = -accumulator;
        notifyChanges();
    }

    public void square() {
        accumulator *= accumulator;
        notifyChanges();
    }

    public void squareRoot() {
        accumulator = Math.sqrt(accumulator);
        notifyChanges();
    }

    public void cube() {
        accumulator = Math.pow(accumulator, 3);
        notifyChanges();
    }

    public void cubeRoot() {
        accumulator = Math.cbrt(accumulator);
        notifyChanges();
    }

    public void cancel() {
        accumulator = 0;
        notifyChanges();
    }

    private void notifyChanges() {
        setChanged();
        notifyObservers(accumulator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        return Double.compare(model.accumulator, accumulator) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(accumulator);
        return (int) (temp ^ (temp >>> 32));
    }
}