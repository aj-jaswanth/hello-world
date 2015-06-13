package com.twu.calculator;

import java.util.Scanner;

public class App {
    public void start() {
        Calculator calculator = new Calculator();
        Scanner input = new Scanner(System.in);
        String command;
        while (true) {
            System.out.print("> ");
            command = input.nextLine();
            System.out.println(calculator.processCommand(command));
        }
    }
}
