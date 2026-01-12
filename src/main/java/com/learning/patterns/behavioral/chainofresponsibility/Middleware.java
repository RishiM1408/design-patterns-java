package com.learning.patterns.behavioral.chainofresponsibility;

/**
 * Handler Abstract Base Class.
 * Defines the next handler in the chain and the abstract handle method.
 */
public abstract class Middleware {
    private Middleware next;

    /**
     * Builds the chain.
     */
    public Middleware linkWith(Middleware next) {
        this.next = next;
        return next;
    }

    /**
     * Subclasses will implement this.
     * Return true if validation passes and we should proceed.
     */
    public abstract boolean check(String email, String password);

    /**
     * Runs the check on the current object, then passes to the next.
     */
    protected boolean checkNext(String email, String password) {
        if (next == null) {
            return true;
        }
        return next.check(email, password);
    }
}
