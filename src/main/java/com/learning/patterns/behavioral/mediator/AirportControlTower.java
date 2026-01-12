package com.learning.patterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Mediator.
 * Coordinates the flights.
 */
public class AirportControlTower implements AirTrafficControlTower {
    private List<Airplane> airplanes = new ArrayList<>();

    public void register(Airplane airplane) {
        airplanes.add(airplane);
    }

    @Override
    public void requestTakeoff(Airplane airplane) {
        // Simple logic: notify all others
        for (Airplane p : airplanes) {
            if (p != airplane) {
                p.notify("Flight " + airplane.getFlightNumber() + " is taking off. Please hold.");
            }
        }
        airplane.notify("Takeoff approved.");
    }

    @Override
    public void requestLanding(Airplane airplane) {
        for (Airplane p : airplanes) {
            if (p != airplane) {
                p.notify("Flight " + airplane.getFlightNumber() + " is landing. Clear the runway.");
            }
        }
        airplane.notify("Landing approved.");
    }
}
