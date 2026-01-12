package com.learning.patterns.behavioral.state;

/**
 * Context: Vending Machine.
 */
public class VendingMachine {
    private State noMoneyState;
    private State hasMoneyState;
    private State dispensingState;

    private State currentState;

    public VendingMachine() {
        noMoneyState = new NoMoneyState(this);
        hasMoneyState = new HasMoneyState(this);
        dispensingState = new DispensingState(this);

        currentState = noMoneyState;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void pressButton() {
        currentState.pressButton();
        // Automatically try to dispense after pressing button
        // In a real machine, this might be a separate hardware trigger
        if (currentState == dispensingState) {
            currentState.dispense();
        }
    }

    public State getNoMoneyState() {
        return noMoneyState;
    }

    public State getHasMoneyState() {
        return hasMoneyState;
    }

    public State getDispensingState() {
        return dispensingState;
    }
}
