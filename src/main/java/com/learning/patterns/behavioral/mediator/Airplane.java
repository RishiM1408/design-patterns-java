package com.learning.patterns.behavioral.mediator;

/**
 * Colleague Abstract Class.
 */
public abstract class Airplane {
    protected AirTrafficControlTower mediator;
    protected String flightNumber;

    public Airplane(AirTrafficControlTower mediator, String flightNumber) {
        this.mediator = mediator;
        this.flightNumber = flightNumber;
    }

    public abstract void notify(String message);

    public String getFlightNumber() {
        return flightNumber;
    }
}
