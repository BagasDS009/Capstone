package starter.stepdefinitios;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.DashboardPage;
import starter.pages.DokterDataPage;
import starter.pages.PatientDataPage;

public class DokterDataSteps {

    @Steps DashboardPage dashboardPage;
    @Steps PatientDataPage patientDataPage;
    @Steps DokterDataPage dokterDataPage;

    @When("Click button data dokter")
    public void clickButtonDataDokter() {
        dashboardPage.clickButtonDataDokter();
    }

    @Then("View Dokter data")
    public void viewDokterData() {
        patientDataPage.validPagePasien();
    }

    @When("Click Detail dokter data")
    public void clickDetailDokterData() {
        patientDataPage.clickButtonDetail();
    }

    @Then("Valid data detail dokter")
    public void validDataDetailDokter() {
        patientDataPage.checkValidDataPasien();
    }

    @Then("I input {string} {string} {string} {string} {string} {string} dokter")
    public void iInputDokter(String nama, String idi, String spesialis, String username, String pass, String confirmpass) {
        dokterDataPage.inputDataDokter(nama, idi, spesialis, username, pass, confirmpass);
    }

    @Then("I input edit {string} {string} {string} {string} {string} {string} dokter")
    public void iInputEditDokter(String nama, String idi, String spesialis, String username, String pass, String confirmpass) {
        dokterDataPage.inputDataDokterEdit(nama, idi, spesialis, username, pass, confirmpass);
    }

    @And("Valid data dokter")
    public void validDataDokter() {
        patientDataPage.validAddData();
        patientDataPage.buttonClickOK();
        patientDataPage.validPagePasien();
    }

    @And("Validate add error messenger {string} dokter")
    public void validateAddErrorMessegerDokter(String text) {
        dokterDataPage.validateTextMessegerDokter(text);
    }

    @When("Click Delete dokter data")
    public void clickDeleteDokterData() {
        patientDataPage.clickButtonSampah();
    }

    @Then("Valid data delete dokter")
    public void validDataDeleteDokter() {
        patientDataPage.validPagePasien();
    }

    @And("Click search all category dokter data")
    public void clickSearchAllCategoryDokterData() {
        patientDataPage.clickButtonAllCategory();
    }

    @And("Click chose nama dokter")
    public void clickChoseNamaDokter() {
        dokterDataPage.clickNamaDokter();
    }
}
