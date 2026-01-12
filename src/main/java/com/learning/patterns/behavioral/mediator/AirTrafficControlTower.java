package com.learning.patterns.behavioral.mediator;

/**
 * Mediator Interface.
 * Defines the method for communication between colleagues.
 */
public interface AirTrafficControlTower {
    void requestTakeoff(Airplane airplane);

    void requestLanding(Airplane airplane);
}
