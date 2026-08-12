package com.example.app.pages;

import com.example.app.base.BasePageObject;
import com.example.app.utils.General;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static com.example.app.drivers.AndroidDriverInit.driver;

public class ReviewDoctorPage extends BasePageObject {

    By textListReviewPatient() { return MobileBy.xpath("//android.view.View[@content-desc]"); }
    By buttonReviewPatient() { return MobileBy.xpath("(//android.widget.Button[@content-desc=\"Proses Data\"])[1]"); }
    By buttonCancel() { return MobileBy.AccessibilityId("BATAL"); }
    By buttonSave() { return MobileBy.AccessibilityId("SIMPAN"); }
    By fieldDiagnose() { return MobileBy.xpath("//android.widget.EditText[1]"); }
    By fieldNote() { return MobileBy.xpath("//android.widget.EditText[2]"); }
    By textSuccessAddReview() { return MobileBy.AccessibilityId("Berhasil Proses Data"); }
    By textNumberPhonePatient() { return MobileBy.xpath("//android.view.View[3]"); }

    public void clickButtonProcessReview() { click(buttonReviewPatient()); }
    public void clickButtonCancel() { click(buttonCancel()); }
    public void clickButtonSave() { click(buttonSave()); }

    public void inputDiagnose(String diagnose) {
        clearAndType(fieldDiagnose(), diagnose);
    }

    public void inputNote(String note) {
        String value = note.equals("newNote") ? General.randomNote() : note;
        clearAndType(fieldNote(), value);
    }

    public void verifyTextListReviewPatientDisplayed() { Assertions.assertTrue(isDisplayed(textListReviewPatient())); }
    public void verifyTextAddSuccessReviewDisplayed() { Assertions.assertTrue(isDisplayed(textSuccessAddReview())); }
    public void verifyTextNumberPhonePatientDisplayed() { Assertions.assertTrue(isDisplayed(textNumberPhonePatient())); }
    public void verifyButtonCancelDisplayed() { Assertions.assertTrue(isDisplayed(buttonCancel())); }

    public void scroll() {
        TouchAction action = new TouchAction(driver);
        Dimension sizeDevice = driver.manage().window().getSize();
        action.press(PointOption.point((int) (sizeDevice.getWidth() * 0.5), (int) (sizeDevice.getHeight() * 0.9)))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point((int) (sizeDevice.getWidth() * 0.5), (int) (sizeDevice.getHeight() * 0.1)))
                .release().perform();
    }
}
