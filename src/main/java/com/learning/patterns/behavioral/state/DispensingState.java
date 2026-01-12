package com.learning.patterns.behavioral.state;

/**
 * Concrete State: DispensingState.
 */
public class DispensingState implements State {
    VendingMachine machine;

    public DispensingState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait, dispensing...");
    }

    @Override
    public void pressButton() {
        System.out.println("Already coming out...");
    }

    @Override
    public void dispense() {
        System.out.println("Dispensing Item!");
        machine.setState(machine.getNoMoneyState());
    }
}
