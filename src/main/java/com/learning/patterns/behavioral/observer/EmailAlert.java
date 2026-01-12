package com.learning.patterns.behavioral.observer;

/**
 * Concrete Observer 2: Email Alert.
 */
public class EmailAlert implements Observer {
    private String email;

    public EmailAlert(String email) {
        this.email = email;
    }

    @Override
    public void update(float stockPrice) {
        if (stockPrice > 100) {
            System.out.println("EmailAlert (" + email + "): Price is high! Sell now! ($" + stockPrice + ")");
        }
    }
}
