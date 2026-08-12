package com.example.app.drivers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class AndroidDriverInit {

    public static AndroidDriver<AndroidElement> driver;
    private static final Properties config = new Properties();

    static {
        try (InputStream input = AndroidDriverInit.class.getClassLoader()
                .getResourceAsStream("appium.properties")) {
            if (input != null) {
                config.load(input);
            } else {
                throw new RuntimeException("appium.properties not found in classpath");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load appium.properties", e);
        }
    }

    public static void initialize() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", config.getProperty("device.platformName"));
        caps.setCapability("platformVersion", config.getProperty("device.platformVersion"));
        caps.setCapability("automationName", config.getProperty("device.automationName"));
        caps.setCapability("unicodeKeyboard", Boolean.parseBoolean(config.getProperty("device.unicodeKeyboard")));

        // Resolve app path relative to project root
        String appPath = config.getProperty("app.path");
        File appFile = new File(System.getProperty("user.dir"), appPath);
        caps.setCapability("app", appFile.getAbsolutePath());

        try {
            String appiumUrl = config.getProperty("appium.url");
            driver = new AndroidDriver<>(new URL(appiumUrl), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Appium URL: " + config.getProperty("appium.url"), e);
        }
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static int getTimeout() {
        return Integer.parseInt(config.getProperty("timeout.implicit", "30"));
    }

    public static int getPollInterval() {
        return Integer.parseInt(config.getProperty("timeout.poll", "1000"));
    }
}
