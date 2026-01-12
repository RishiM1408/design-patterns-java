package com.learning.patterns.creational.singleton;

import java.util.Properties;

/**
 * Singleton Pattern Implementation.
 * <p>
 * Scenario: A Configuration Manager that loads application settings once and provides
 * a global access point to them. This prevents multiple re-reads of configuration files
 * and ensures a consistent view of settings across the application.
 * </p>
 */
public class ConfigurationManager {

    // Volatile keyword ensures that multiple threads handle the singleton instance correctly
    // when it is being initialized to the instance variable.
    private static volatile ConfigurationManager instance;

    private Properties configProps;

    /**
     * Private constructor to prevent instantiation from outside the class.
     * Simulates loading configuration from a file.
     */
    private ConfigurationManager() {
        // Find existing valid configuration or load defaults
        configProps = new Properties();
        configProps.setProperty("db.host", "localhost");
        configProps.setProperty("db.port", "5432");
        configProps.setProperty("app.name", "DesignPatternsApp");
        
        System.out.println("ConfigurationManager initialized. Config loaded.");
    }

    /**
     * Public accessor to get the single instance of the class.
     * Uses Double-Checked Locking for thread safety and performance.
     *
     * @return the singleton instance
     */
    public static ConfigurationManager getInstance() {
        // First check (no locking)
        if (instance == null) {
            // Locking
            synchronized (ConfigurationManager.class) {
                // Second check (with locking)
                if (instance == null) {
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    public String getProperty(String key) {
        return configProps.getProperty(key);
    }

    public void setProperty(String key, String value) {
        configProps.setProperty(key, value);
    }
}
