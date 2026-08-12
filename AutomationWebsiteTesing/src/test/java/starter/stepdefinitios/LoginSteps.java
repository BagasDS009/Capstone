package starter.stepdefinitios;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.pages.DashboardPage;
import starter.pages.LoginPage;
import starter.pages.PatientDataPage;

public class LoginSteps {

    @Steps LoginPage loginPage;
    @Steps DashboardPage dashboardPage;
    @Steps PatientDataPage patientDataPage;

    @Given("Open login page")
    public void openLoginPage() {
        loginPage.openLogin();
    }

    @When("I input {string} login email")
    public void iInputEmailLogin(String email) {
        loginPage.inputEmailLogin(email);
    }

    @And("I input {string} login password")
    public void iInputPasswordLogin(String password) {
        loginPage.inputPasswordLogin(password);
    }

    @Then("I click button login")
    public void iClickButtonLogin() {
        loginPage.clickButtonLogin();
    }

    @And("Login validation kosong")
    public void loginValidation() {
        loginPage.loginTextError();
    }

    @And("Login validation invalid")
    public void loginValidationInvalid() {
        loginPage.loginInvalidError();
        loginPage.clickButtonErrorOK();
    }

    @When("I input {string} login email valid")
    public void iInputLoginEmailValid(String email) {
        loginPage.inputEmailLogin(email);
    }

    @And("I input {string} login password valid")
    public void iInputLoginPasswordValid(String password) {
        loginPage.inputPasswordLogin(password);
    }

    @And("Validate on dashboard")
    public void validateOnDashboard() {
        dashboardPage.validViewDashbord();
    }

    @And("Click icon logout account")
    public void clickIconLogoutAccount() {
        dashboardPage.clickButtonLogoutAccount();
    }

    @And("Click icon yes for logout")
    public void clickIconYesForLogout() {
        dashboardPage.clickButtonLogoutAccountYes();
    }

    @And("Click icon no for logout")
    public void clickIconNoForLogout() {
        dashboardPage.clickButtonLogoutAccountNo();
    }

    @And("Validate on login page")
    public void validateOnLoginPage() {
        loginPage.loginTextError();
    }

    @And("Valid not logout")
    public void validNotLogout() {
        patientDataPage.validPagePasien();
    }
}
