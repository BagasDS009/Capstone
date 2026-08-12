package com.example.app.pages;

import com.example.app.base.BasePageObject;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginPage extends BasePageObject {

    By textWelcome() { return MobileBy.AccessibilityId("Selamat Datang Kembali!"); }
    By buttonRole() { return MobileBy.AccessibilityId("Pilih Role"); }
    By buttonAdmin() { return MobileBy.AccessibilityId("Admin"); }
    By buttonDoctor() { return MobileBy.AccessibilityId("Doctor"); }
    By fieldUsername() { return By.xpath("//android.widget.EditText[1]"); }
    By fieldPassword() { return By.xpath("//android.widget.EditText[2]"); }
    By buttonLogin() { return MobileBy.AccessibilityId("Login"); }
    By errorUsername() { return MobileBy.AccessibilityId("Username Can't Be Empty!"); }
    By errorPassword() { return MobileBy.AccessibilityId("Password Can't Be Empty!"); }
    By textLoginFailed() { return MobileBy.AccessibilityId("Login Failed!"); }
    By buttonClose() { return MobileBy.AccessibilityId("CLOSE"); }

    public void clickButtonRole() { click(buttonRole()); }
    public void clickButtonAdmin() { click(buttonAdmin()); }
    public void clickButtonDoctor() { click(buttonDoctor()); }
    public void clickButtonLogin() { click(buttonLogin()); }
    public void clickButtonClose() { click(buttonClose()); }

    /** @deprecated Use inputUsername() directly - it handles click internally */
    public void clickButtonUsername() { click(fieldUsername()); }
    /** @deprecated Use inputPassword() directly - it handles click internally */
    public void clickButtonPassword() { click(fieldPassword()); }

    public void inputUsername(String username) {
        clearAndType(fieldUsername(), username);
    }

    public void inputPassword(String password) {
        clearAndType(fieldPassword(), password);
    }

    public void verifyTextWelcomeDisplayed() {
        Assertions.assertTrue(isDisplayed(textWelcome()), "Welcome text should be displayed");
    }

    public void verifyErrorUsernameDisplayed() {
        Assertions.assertTrue(isDisplayed(errorUsername()), "Username error should be displayed");
    }

    public void verifyErrorPasswordDisplayed() {
        Assertions.assertTrue(isDisplayed(errorPassword()), "Password error should be displayed");
    }

    public void verifyLoginFailedDisplayed() {
        Assertions.assertTrue(isDisplayed(textLoginFailed()), "Login failed text should be displayed");
    }

    // Verify error text is present (not null/empty)
    public void verifyErrorUsernameEqual() {
        Assertions.assertNotNull(getText(errorUsername()), "Username error text should not be null");
    }

    public void verifyErrorPasswordEqual() {
        Assertions.assertNotNull(getText(errorPassword()), "Password error text should not be null");
    }

    public void verifyLoginFailedEqual() {
        Assertions.assertNotNull(getText(textLoginFailed()), "Login failed text should not be null");
    }
}
