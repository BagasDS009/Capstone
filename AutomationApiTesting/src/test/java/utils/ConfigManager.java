package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Centralized configuration manager.
 * Reads from config.properties so no hardcoded values in test classes.
 */
public class ConfigManager {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigManager.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    public static String getAdminUsername() {
        return properties.getProperty("admin.username");
    }

    public static String getAdminPassword() {
        return properties.getProperty("admin.password");
    }

    public static String getAdminRole() {
        return properties.getProperty("admin.role");
    }

    public static String getDoctorUsername() {
        return properties.getProperty("doctor.username");
    }

    public static String getDoctorPassword() {
        return properties.getProperty("doctor.password");
    }

    public static String getDoctorRole() {
        return properties.getProperty("doctor.role");
    }
}
