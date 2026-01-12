package com.learning.patterns.behavioral.state;

/**
 * Concrete State: NoMoneyState.
 */
public class NoMoneyState implements State {
    VendingMachine machine;

    public NoMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted.");
        machine.setState(machine.getHasMoneyState());
    }

    @Override
    public void pressButton() {
        System.out.println("Insert coin first.");
    }

    @Override
    public void dispense() {
        System.out.println("Payment required.");
    }
}
