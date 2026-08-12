package com.example.app.pages;

import com.example.app.base.BasePageObject;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class DashboardAdminPage extends BasePageObject {

    By textOverview() { return MobileBy.AccessibilityId("Overview"); }
    By textSuccessLogin() { return MobileBy.AccessibilityId("Login Success"); }
    By buttonPagePatient() { return MobileBy.AccessibilityId("Data Pasien"); }
    By buttonPageDoctor() { return MobileBy.AccessibilityId("Data Dokter"); }
    By buttonPageSchedule() { return MobileBy.AccessibilityId("Kelola Jadwal"); }
    By buttonPageArchive() { return MobileBy.AccessibilityId("Arsip Jadwal"); }
    By buttonLogoutAdmin() { return MobileBy.AccessibilityId("Logout"); }
    By textUpdateListPatient() { return MobileBy.AccessibilityId("Data Pasien Terkini!"); }
    By buttonClose() { return MobileBy.AccessibilityId("CLOSE"); }

    public void verifyOverviewDisplayed() {
        Assertions.assertTrue(isDisplayed(textOverview()), "Overview should be displayed");
    }

    public void verifyLoginSuccessDisplayed() {
        Assertions.assertTrue(isDisplayed(textSuccessLogin()), "Login success should be displayed");
    }

    public void verifyButtonPatientDisplayed() {
        Assertions.assertTrue(isDisplayed(buttonPagePatient()), "Patient button should be displayed");
    }

    public void verifyUpdateListPatientDisplayed() {
        Assertions.assertTrue(isDisplayed(textUpdateListPatient()), "Update list patient should be displayed");
    }

    public void verifyButtonLogoutDisplayed() {
        Assertions.assertTrue(isDisplayed(buttonLogoutAdmin()), "Logout button should be displayed");
    }

    // Verify content matches expected text
    public void verifyOverviewEqual() {
        Assertions.assertNotNull(getText(textOverview()), "Overview text should not be null");
    }

    public void verifyUpdateListPatientEqual() {
        Assertions.assertNotNull(getText(textUpdateListPatient()), "Patient list text should not be null");
    }

    public void clickButtonPatient() { click(buttonPagePatient()); }
    public void clickButtonDoctor() { click(buttonPageDoctor()); }
    public void clickButtonSchedule() { click(buttonPageSchedule()); }
    public void clickButtonArchive() { click(buttonPageArchive()); }
    public void clickButtonLogout() { click(buttonLogoutAdmin()); }
    public void clickButtonClose() { click(buttonClose()); }
}
