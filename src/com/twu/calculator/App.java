package com.twu.calculator;

import java.util.Scanner;

public class App {
    public void start() {
        Model model = new Model();
        Scanner input = new Scanner(System.in);
        String command;
        while (true) {
            System.out.print("> ");
            command = input.nextLine();
            System.out.println(model.processCommand(command));
        }
    }
}
