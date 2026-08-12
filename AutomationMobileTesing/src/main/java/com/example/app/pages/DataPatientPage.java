package com.example.app.pages;

import com.example.app.base.BasePageObject;
import com.example.app.utils.General;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class DataPatientPage extends BasePageObject {

    // Locators
    By textDataNotFound() { return MobileBy.AccessibilityId("1"); }
    By buttonAddPatient() { return MobileBy.AccessibilityId("Tambah Data"); }
    By fieldSearch() { return MobileBy.xpath("//android.widget.EditText"); }
    By textMessageDelete() { return MobileBy.AccessibilityId("Hapus Data Pasien"); }
    By buttonDelete() { return MobileBy.AccessibilityId("HAPUS"); }
    By buttonCancel() { return MobileBy.AccessibilityId("BATAL"); }
    By buttonSave() { return MobileBy.AccessibilityId("SIMPAN"); }
    By fieldFullName() { return By.xpath("//android.widget.EditText[1]"); }
    By fieldNumberPhone() { return By.xpath("//android.widget.EditText[2]"); }
    By fieldNik() { return By.xpath("//android.widget.EditText[3]"); }
    By fieldUsia() { return By.xpath("//android.widget.EditText[4]"); }
    By fieldAddress() { return By.xpath("//android.widget.EditText[5]"); }
    By buttonMan() { return MobileBy.xpath("//android.view.View[@content-desc=\"Laki laki\"]/android.widget.RadioButton"); }
    By buttonWomen() { return MobileBy.xpath("//android.view.View[@content-desc=\"Perempuan\"]/android.widget.RadioButton"); }
    By buttonBack() { return MobileBy.xpath("//android.view.View/android.widget.Button"); }
    By errorFullName() { return MobileBy.AccessibilityId("Nama Lengkap Tidak Boleh Kosong!"); }
    By errorNumberPhone() { return MobileBy.AccessibilityId("Nomor Handphone Tidak Boleh Kosong!"); }
    By errorNik() { return MobileBy.AccessibilityId("NIK Tidak Boleh Kosong!"); }
    By errorUsia() { return MobileBy.AccessibilityId("Usia Tidak Boleh Kosong!"); }
    By errorAddress() { return MobileBy.AccessibilityId("Alamat Rumah Tidak Boleh Kosong!"); }
    By textAddDataPatient() { return MobileBy.AccessibilityId("Tambah Data Pasien"); }
    By textSuccessAddPatient() { return MobileBy.AccessibilityId("Berhasil Menambahkan Data"); }
    By textDetailDataPatient() { return MobileBy.AccessibilityId("Detail Data Pasien"); }
    By buttonClose() { return MobileBy.AccessibilityId("CLOSE"); }
    By buttonTrash() { return MobileBy.xpath("//android.view.View[@content-desc]/android.widget.Button[2]"); }
    By buttonInformation() { return MobileBy.xpath("//android.view.View[@content-desc]/android.widget.Button[1]"); }
    By buttonEditPatient() { return MobileBy.AccessibilityId("EDIT PASIEN"); }
    By textEditDataPatient() { return MobileBy.AccessibilityId("Edit Data Pasien"); }
    By textFailedAddPatient() { return MobileBy.AccessibilityId("Tambah Pasien gagal"); }
    By textSuccessEditPatient() { return MobileBy.AccessibilityId("Berhasil Mengubah Data"); }
    By textSuccessDeletePatient() { return MobileBy.AccessibilityId("Berhasil Menghapus Data"); }
    By textListPatient() { return MobileBy.xpath("//android.view.View[@content-desc]"); }

    // Actions
    public void clickButtonAddPatient() { click(buttonAddPatient()); }
    public void clickButtonDelete() { click(buttonDelete()); }
    public void clickButtonCancel() { click(buttonCancel()); }
    public void clickButtonSave() { click(buttonSave()); }
    public void clickButtonMan() { click(buttonMan()); }
    public void clickButtonWomen() { click(buttonWomen()); }
    public void clickButtonBack() { click(buttonBack()); }
    public void clickButtonInformation() { click(buttonInformation()); }
    public void clickButtonEditPatient() { click(buttonEditPatient()); }
    public void clickButtonClose() { click(buttonClose()); }
    public void clickButtonTrash() { click(buttonTrash()); }

    // Input methods using clearAndType
    public void inputFullName(String fullName) {
        String value = fullName.equals("newPatient") ? General.randomName() : fullName;
        clearAndType(fieldFullName(), value);
    }

    public void inputNumberPhone(String numberPhone) {
        String value = numberPhone.equals("newPhone") ? General.randomPhone() : numberPhone;
        clearAndType(fieldNumberPhone(), value);
    }

    public void inputNik(String nik) {
        String value = nik.equals("newNik") ? General.randomNik() : nik;
        clearAndType(fieldNik(), value);
    }

    public void inputUsia(String usia) {
        String value = usia.equals("newUsia") ? General.randomUmur() : usia;
        clearAndType(fieldUsia(), value);
    }

    public void inputAddress(String address) {
        String value = address.equals("newAddress") ? General.randomAddress() : address;
        clearAndType(fieldAddress(), value);
    }

    public void inputSearching(String search) {
        clearAndType(fieldSearch(), search);
    }

    // Verifications
    public void verifyErrorFullNameDisplayed() { Assertions.assertTrue(isDisplayed(errorFullName())); }
    public void verifyErrorNumberPhoneDisplayed() { Assertions.assertTrue(isDisplayed(errorNumberPhone())); }
    public void verifyErrorNikDisplayed() { Assertions.assertTrue(isDisplayed(errorNik())); }
    public void verifyErrorUsiaDisplayed() { Assertions.assertTrue(isDisplayed(errorUsia())); }
    public void verifyErrorAddressDisplayed() { Assertions.assertTrue(isDisplayed(errorAddress())); }
    public void verifyTextDataNotFoundDisplayed() { Assertions.assertTrue(isDisplayed(textDataNotFound())); }
    public void verifyTextMessageDeleteDisplayed() { Assertions.assertTrue(isDisplayed(textMessageDelete())); }
    public void verifyTextAddDataPatientDisplayed() { Assertions.assertTrue(isDisplayed(textAddDataPatient())); }
    public void verifyTextAddSuccessPatientDisplayed() { Assertions.assertTrue(isDisplayed(textSuccessAddPatient())); }
    public void verifyTextEditSuccessPatientDisplayed() { Assertions.assertTrue(isDisplayed(textSuccessEditPatient())); }
    public void verifyTextDeleteSuccessPatientDisplayed() { Assertions.assertTrue(isDisplayed(textSuccessDeletePatient())); }
    public void verifyTextDetailDataPatientDisplayed() { Assertions.assertTrue(isDisplayed(textDetailDataPatient())); }
    public void verifyTextEditDataPatientDisplayed() { Assertions.assertTrue(isDisplayed(textEditDataPatient())); }
    public void verifyTextFailedAddPatientDisplayed() { Assertions.assertTrue(isDisplayed(textFailedAddPatient())); }
    public void verifyTextListPatientDisplayed() { Assertions.assertTrue(isDisplayed(textListPatient())); }

    public void verifyErrorFullNameEqual() { Assertions.assertNotNull(getText(errorFullName())); }
    public void verifyErrorNumberPhoneEqual() { Assertions.assertNotNull(getText(errorNumberPhone())); }
    public void verifyErrorNikEqual() { Assertions.assertNotNull(getText(errorNik())); }
    public void verifyErrorUsiaEqual() { Assertions.assertNotNull(getText(errorUsia())); }
    public void verifyErrorAddressEqual() { Assertions.assertNotNull(getText(errorAddress())); }
}
