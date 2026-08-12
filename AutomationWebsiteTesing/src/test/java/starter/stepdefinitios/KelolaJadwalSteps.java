package starter.stepdefinitios;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.ArsipJadwalPage;
import starter.pages.DashboardPage;
import starter.pages.KelolaJadwalPage;
import starter.pages.PatientDataPage;

public class KelolaJadwalSteps {

    @Steps DashboardPage dashboardPage;
    @Steps PatientDataPage patientDataPage;
    @Steps KelolaJadwalPage kelolaJadwalPage;
    @Steps ArsipJadwalPage arsipJadwalPage;

    @When("Click button manage schedule")
    public void clickButtonManageSchedule() {
        dashboardPage.clickButtonKelolaJadwal();
    }

    @Then("View manage schedule")
    public void viewManageSchedule() {
        patientDataPage.validPagePasien();
    }

    @And("Click on the select patient action to select a patient")
    public void clickOnTheSelectPatientActionToSelectAPatient() {
        kelolaJadwalPage.buttonPilihPasien();
    }

    @And("Click on the action choose a doctor to choose a doctor")
    public void clickOnTheActionChooseADoctorToChooseADoctor() {
        kelolaJadwalPage.buttonPilihDokter();
    }

    @Then("Choose a date {string}")
    public void chooseADate(String tgl) {
        kelolaJadwalPage.inputTanggal(tgl);
    }

    @And("Choose the type of treatment")
    public void chooseTheTypeOfTreatment() {
        kelolaJadwalPage.buttonJenisPerawatan();
    }

    @And("Click simpan")
    public void clickSimpan() {
        kelolaJadwalPage.buttonSave();
    }

    @And("Validate data kelola jadwal")
    public void validateDataKelolaJadwal() {
        patientDataPage.validAddData();
        patientDataPage.buttonClickOK();
        patientDataPage.validPagePasien();
    }

    @And("Click rawat jalan")
    public void clickRawatJalan() {
        kelolaJadwalPage.buttonRawatJalan();
    }

    @And("Click rawat biasa")
    public void clickRawatBiasa() {
        kelolaJadwalPage.buttonRawatBiasa();
    }

    @And("Validate data error kelola jadwal")
    public void validateDataErrorKelolaJadwal() {
        kelolaJadwalPage.validateErrorKelolaJadwal();
    }

    @And("Click search all category manage schedule")
    public void clickSearchAllCategoryManageSchedule() {
        arsipJadwalPage.clickButtonChooseCategoryNamaOnArsip();
    }
}
