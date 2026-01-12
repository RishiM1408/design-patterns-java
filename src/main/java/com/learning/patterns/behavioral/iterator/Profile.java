package com.learning.patterns.behavioral.iterator;

/**
 * A simple User Profile.
 */
public class Profile {
    private String email;
    private String name;

    public Profile(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Profile{" + "email='" + email + '\'' + ", name='" + name + '\'' + '}';
    }
}
