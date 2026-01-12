package com.learning.patterns.behavioral.mediator;

/**
 * Concrete Colleague.
 */
public class CommercialAirplane extends Airplane {
    public CommercialAirplane(AirTrafficControlTower mediator, String flightNumber) {
        super(mediator, flightNumber);
    }

    @Override
    public void notify(String message) {
        System.out.println("Commercial Flight " + flightNumber + " received: " + message);
    }
}
