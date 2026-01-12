package com.learning.patterns.behavioral.observer;

/**
 * Concrete Observer 1: Mobile App.
 */
public class MobileApp implements Observer {
    private String userName;

    public MobileApp(String userName) {
        this.userName = userName;
    }

    @Override
    public void update(float stockPrice) {
        System.out.println("MobileApp (" + userName + "): Stock price updated to $" + stockPrice);
    }
}
