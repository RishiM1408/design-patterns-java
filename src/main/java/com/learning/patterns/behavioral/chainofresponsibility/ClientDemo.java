package com.learning.patterns.behavioral.chainofresponsibility;

/**
 * Client Demo for Chain of Responsibility.
 */
public class ClientDemo {
    public static void main(String[] args) {
        System.out.println("--- Chain of Responsibility Demo ---");

        Server server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        // Build Chain: Throttling -> Auth -> Role
        Middleware middleware = new ThrottlingMiddleware(2);
        middleware.linkWith(new UserExistsMiddleware(server))
                .linkWith(new RoleCheckMiddleware());

        server.setMiddleware(middleware);

        // Test Runs
        System.out.println("\nClient: Login success");
        server.logIn("user@example.com", "user_pass");

        System.out.println("\nClient: Login failure (wrong password)");
        server.logIn("user@example.com", "wrong_pass");

        System.out.println("\nClient: Login success (admin)");
        server.logIn("admin@example.com", "admin_pass");
    }
}
