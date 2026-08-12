package com.example.steps.Auth;

import com.example.app.pages.DashboardAdminPage;
import com.example.app.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginAdminStep {

    DashboardAdminPage dashboardAdminPage = new DashboardAdminPage();
    LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void iValidateLoginPage() {
        loginPage.verifyTextWelcomeDisplayed();
    }

    @And("I choose role admin")
    public void iClickButtonRoleAdmin() {
        loginPage.clickButtonRole();
        loginPage.clickButtonAdmin();
    }

    @When("I input {string} with {string}")
    public void iInputFieldUsernameAndPassword(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
    }

    @And("click login button")
    public void iClickLoginButton() {
        loginPage.clickButtonLogin();
    }

    @Then("I get the {string}")
    public void getResultLoginAdmin(String result) {
        switch (result) {
            case "Success":
                dashboardAdminPage.verifyLoginSuccessDisplayed();
                dashboardAdminPage.verifyOverviewDisplayed();
                break;
            case "Empty Username":
                loginPage.verifyErrorUsernameDisplayed();
                break;
            case "Empty Password":
                loginPage.verifyErrorPasswordDisplayed();
                break;
            case "Empty All":
                loginPage.verifyErrorUsernameDisplayed();
                loginPage.verifyErrorPasswordDisplayed();
                break;
            default:
                loginPage.verifyLoginFailedDisplayed();
                break;
        }
    }
}
