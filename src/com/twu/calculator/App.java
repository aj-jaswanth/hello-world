package com.twu.calculator;

import java.util.Scanner;

public class App {

    private final Scanner input;
    private Parser parser;

    public App(Scanner input, Parser parser) {
        this.input = input;
        this.parser = parser;
    }

    public void start() {
        String command;
        while (true) {
            command = input.nextLine();
            if (isExit(command))
                return;
            Operation operation = parser.parse(command);
            if (operation != null) {
                operation.execute();
            }
        }
    }

    private boolean isExit(String command) {
        return command.equals("exit");
    }
}
