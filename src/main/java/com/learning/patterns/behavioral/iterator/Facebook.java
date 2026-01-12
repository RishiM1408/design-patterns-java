package com.learning.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Concrete Collection: Facebook.
 * Stores profiles in a simple list but simulates graph connections.
 */
public class Facebook implements SocialNetwork {
    private List<Profile> profiles;

    public Facebook(List<Profile> cache) {
        if (cache != null) {
            this.profiles = cache;
        } else {
            this.profiles = new ArrayList<>();
        }
    }

    public Profile requestProfileFromFacebook(String profileEmail) {
        // Simulate network delay
        System.out.println("Facebook: Loading profile '" + profileEmail + "' over the network...");
        for (Profile profile : profiles) {
            if (profile.getEmail().equals(profileEmail))
                return profile;
        }
        return null;
    }

    public List<String> requestProfileFriendsFromFacebook(String profileEmail, String contactType) {
        // Simulate network delay
        System.out
                .println("Facebook: Loading '" + contactType + "' list of '" + profileEmail + "' over the network...");
        // Mock returning some friends if available
        return new ArrayList<>();
    }

    @Override
    public ProfileIterator createFriendsIterator(String profileEmail) {
        return new FacebookIterator(this, "friends", profileEmail);
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileEmail) {
        return new FacebookIterator(this, "coworkers", profileEmail);
    }
}
