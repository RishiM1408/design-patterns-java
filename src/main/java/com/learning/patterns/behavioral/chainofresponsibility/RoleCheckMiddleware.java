package com.learning.patterns.behavioral.chainofresponsibility;

/**
 * Concrete Handler 3: Role Authorization.
 * Checks if the user is an admin.
 */
public class RoleCheckMiddleware extends Middleware {
    @Override
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);
    }
}
