package com.example.app.base;

import com.example.app.drivers.AndroidDriverInit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.example.app.drivers.AndroidDriverInit.driver;

public class BasePageObject {

    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

    public WebDriverWait onWait() {
        return new WebDriverWait(getDriver(), AndroidDriverInit.getTimeout(), AndroidDriverInit.getPollInterval());
    }

    public AndroidElement find(By locator) {
        return (AndroidElement) onWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator) {
        find(locator).click();
    }

    public void sendClear(By locator) {
        find(locator).clear();
    }

    public void sendKeys(By locator, String input) {
        find(locator).sendKeys(input);
    }

    public String getText(By locator) {
        return find(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    /**
     * Short pause for UI transitions. Use sparingly.
     * Prefer explicit waits (find/onWait) when possible.
     */
    protected void shortPause() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Clear field and type new value.
     */
    protected void clearAndType(By locator, String value) {
        click(locator);
        shortPause();
        sendClear(locator);
        shortPause();
        sendKeys(locator, value);
    }
}
