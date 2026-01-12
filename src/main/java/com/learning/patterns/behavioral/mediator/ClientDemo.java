package com.learning.patterns.behavioral.mediator;

/**
 * Client Demo for Mediator Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Mediator Pattern Demo ---");

        AirportControlTower tower = new AirportControlTower();

        Airplane flight1 = new CommercialAirplane(tower, "UA123");
        Airplane flight2 = new CommercialAirplane(tower, "AA456");
        Airplane flight3 = new CommercialAirplane(tower, "DL789");

        tower.register(flight1);
        tower.register(flight2);
        tower.register(flight3);

        System.out.println("\n--- Flight 1 Requesting Landing ---");
        tower.requestLanding(flight1);

        System.out.println("\n--- Flight 2 Requesting Takeoff ---");
        tower.requestTakeoff(flight2);
    }
}
