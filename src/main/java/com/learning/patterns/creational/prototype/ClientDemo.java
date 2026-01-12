package com.learning.patterns.creational.prototype;

/**
 * Client Demo for Prototype Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Prototype Pattern Demo ---");

        // 1. Create access to the "Heavy" initial objects (Registry)
        LinuxVM standardWebVm = new LinuxVM("Ubuntu 22.04", "Nginx+PHP", "sg-web");
        WindowsVM standardSqlVm = new WindowsVM("Server 2022", true);

        System.out.println("\n--- Clones are cheap ---");

        // 2. Clone them to create new instances quickly
        LinuxVM webServer1 = (LinuxVM) standardWebVm.clone();
        webServer1.start();

        LinuxVM webServer2 = (LinuxVM) standardWebVm.clone();
        webServer2.start();

        WindowsVM dbServer = (WindowsVM) standardSqlVm.clone();
        dbServer.start();

        System.out.println("Check independence:");
        System.out.println("Original: " + standardWebVm);
        System.out.println("Clone 1:  " + webServer1);
        System.out.println("Are they same object? " + (standardWebVm == webServer1));
    }
}
