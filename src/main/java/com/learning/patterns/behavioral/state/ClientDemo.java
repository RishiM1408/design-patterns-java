package com.learning.patterns.behavioral.state;

/**
 * Client Demo for State Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- State Pattern Demo ---");

        VendingMachine machine = new VendingMachine();

        // 1. Transaction Success
        System.out.println("\nAction: User inserts coin");
        machine.insertCoin();

        System.out.println("Action: User presses button");
        machine.pressButton();

        // 2. Failure: No Coin
        System.out.println("\nAction: User presses button without coin");
        machine.pressButton();
    }
}
