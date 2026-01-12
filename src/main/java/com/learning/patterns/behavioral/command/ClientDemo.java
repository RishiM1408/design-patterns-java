package com.learning.patterns.behavioral.command;

/**
 * Client Demo for Command Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Command Pattern Demo ---");

        // Receivers
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        // Commands
        Command lightsOn = new TurnOnLightCommand(livingRoomLight);
        Command kitchenOff = new TurnOffLightCommand(kitchenLight);

        // Invoker
        SmartHomeRemote remote = new SmartHomeRemote();

        // Execution
        remote.submit(lightsOn);
        remote.submit(kitchenOff);

        // Encapsulation: The remote didn't know *how* to turn on the light,
        // it just executed the command object.
    }
}
