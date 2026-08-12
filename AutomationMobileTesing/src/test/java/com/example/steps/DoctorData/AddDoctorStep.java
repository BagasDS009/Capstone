package com.example.steps.DoctorData;

import com.example.app.pages.DashboardAdminPage;
import com.example.app.pages.DataDoctorPage;
import com.example.app.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddDoctorStep {

    DataDoctorPage dataDoctorPage = new DataDoctorPage();
    DashboardAdminPage dashboardAdminPage = new DashboardAdminPage();
    LoginPage loginPage = new LoginPage();

    @Given("I am logged account admin")
    public void iValidateLoggedAccountAdmin() {
        loginPage.verifyTextWelcomeDisplayed();
        loginPage.clickButtonRole();
        loginPage.clickButtonAdmin();
        loginPage.inputUsername("admin");
        loginPage.inputPassword("admin123");
        loginPage.clickButtonLogin();
        dashboardAdminPage.verifyLoginSuccessDisplayed();
        dashboardAdminPage.verifyButtonLogoutDisplayed();
    }

    @And("I click add data in data doctor")
    public void iClickAddDataDoctor() {
        dashboardAdminPage.clickButtonDoctor();
        dataDoctorPage.clickButtonAddDoctor();
    }

    @When("I input field {string} with field {string} and field {string}")
    public void iInputFieldFullNameWithNpaIdiAndSpesialis(String fullName, String npaIdi, String spesialis) {
        dataDoctorPage.inputFullName(fullName);
        dataDoctorPage.inputNpaIdi(npaIdi);
        dataDoctorPage.inputSpesialis(spesialis);
    }

    @And("I input field {string} and field {string} and field {string}")
    public void iInputFieldUsernameAndPasswordAndConfirmPass(String username, String password, String confirmpass) {
        dataDoctorPage.inputUsername(username);
        dataDoctorPage.inputPassword(password);
        dataDoctorPage.inputConfirmPassword(confirmpass);
    }

    @And("click save doctor button")
    public void iClickSaveDoctorButton() {
        dataDoctorPage.clickButtonSave();
    }

    @Then("I get the {string} add doctor")
    public void getResultAddDoctor(String output) {
        switch (output) {
            case "Success":
                dataDoctorPage.verifyTextAddSuccessDoctorDisplayed();
                break;
            case "Empty fullName":
                dataDoctorPage.verifyErrorFullNameDisplayed();
                break;
            case "Invalid npaIdi":
            case "Empty npaIdi":
                dataDoctorPage.verifyErrorNpaIdiDisplayed();
                break;
            case "Empty spesialis":
                dataDoctorPage.verifyErrorSpesialisDisplayed();
                break;
            case "Empty username":
                dataDoctorPage.verifyErrorUsernameDisplayed();
                break;
            case "Limit username":
                dataDoctorPage.verifyErrorLimitUsernameDisplayed();
                break;
            case "Empty password":
                dataDoctorPage.verifyErrorPasswordDisplayed();
                break;
            case "Limit password":
                dataDoctorPage.verifyErrorLimitPasswordDisplayed();
                break;
            case "not SamePass":
                dataDoctorPage.verifyErrorNotSamePassDisplayed();
                break;
            default:
                dataDoctorPage.verifyErrorFullNameDisplayed();
                dataDoctorPage.verifyErrorNpaIdiDisplayed();
                dataDoctorPage.verifyErrorSpesialisDisplayed();
                dataDoctorPage.verifyErrorUsernameDisplayed();
                dataDoctorPage.verifyErrorPasswordDisplayed();
                dataDoctorPage.verifyErrorConfirmPasswordDisplayed();
                break;
        }
    }
}
