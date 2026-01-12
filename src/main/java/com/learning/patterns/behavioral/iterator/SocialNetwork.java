package com.learning.patterns.behavioral.iterator;

import java.util.List;

/**
 * Common interface for all collections.
 */
public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
