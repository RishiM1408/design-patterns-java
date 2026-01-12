package com.learning.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Client Demo for Iterator Pattern.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Iterator Pattern Demo ---");

        // Mock data
        List<Profile> data = new ArrayList<>();
        data.add(new Profile("anna.smith@bing.com", "Anna Smith"));
        data.add(new Profile("max.mustermann@yahoo.com", "Max Mustermann"));

        Facebook facebook = new Facebook(data);

        // Note: In a real implementation with valid mocked friends,
        // the iterator would return actual profiles.
        // For this demo structure, it demonstrates the connectivity.

        ProfileIterator iterator = facebook.createFriendsIterator("anna.smith@bing.com");

        System.out.println("Iterating over friends...");
        while (iterator.hasNext()) {
            Profile p = iterator.next();
            System.out.println(p);
        }
        System.out.println("Done.");
    }
}
