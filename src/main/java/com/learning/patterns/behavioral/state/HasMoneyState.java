package com.learning.patterns.behavioral.state;

/**
 * Concrete State: HasMoneyState.
 */
public class HasMoneyState implements State {
    VendingMachine machine;

    public HasMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted.");
    }

    @Override
    public void pressButton() {
        System.out.println("Button pressed...");
        machine.setState(machine.getDispensingState());
    }

    @Override
    public void dispense() {
        System.out.println("Press button first.");
    }
}
