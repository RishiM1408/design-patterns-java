package com.learning.patterns.creational.builder;

/**
 * The Product: A complex Database Configuration object.
 * It has many parameters, some mandatory, some optional.
 */
public class DatabaseConfig {
    private final String host;
    private final int port;
    private final String username;
    private final String password; // optional
    private final boolean isEncrypted; // optional
    private final int connectionTimeout; // optional
    private final int maxConnections; // optional

    private DatabaseConfig(Builder builder) {
        this.host = builder.host;
        this.port = builder.port;
        this.username = builder.username;
        this.password = builder.password;
        this.isEncrypted = builder.isEncrypted;
        this.connectionTimeout = builder.connectionTimeout;
        this.maxConnections = builder.maxConnections;
    }

    @Override
    public String toString() {
        return "DatabaseConfig{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", username='" + username + '\'' +
                ", isEncrypted=" + isEncrypted +
                ", connectionTimeout=" + connectionTimeout +
                ", maxConnections=" + maxConnections +
                '}';
    }

    // Static Builder Class
    public static class Builder {
        private final String host; // mandatory
        private final int port; // mandatory
        private final String username; // mandatory

        // Optional parameters - initialized to default values
        private String password = "";
        private boolean isEncrypted = false;
        private int connectionTimeout = 5000;
        private int maxConnections = 10;

        public Builder(String host, int port, String username) {
            this.host = host;
            this.port = port;
            this.username = username;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setEncrypted(boolean encrypted) {
            isEncrypted = encrypted;
            return this;
        }

        public Builder setConnectionTimeout(int connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
            return this;
        }

        public Builder setMaxConnections(int maxConnections) {
            this.maxConnections = maxConnections;
            return this;
        }

        public DatabaseConfig build() {
            return new DatabaseConfig(this);
        }
    }
}
