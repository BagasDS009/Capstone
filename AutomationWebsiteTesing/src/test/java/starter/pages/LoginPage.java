package starter.pages;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    private By emailFieldLogin() {
        return By.xpath("//*[@name=\"username\"]");
    }

    private By passwordFieldLogin() {
        return By.xpath("//*[@name=\"password\"]");
    }

    private By buttonLogin() {
        return By.xpath("//*[@type=\"submit\"]");
    }

    private By kosongErrorMessage() {
        return By.xpath("//*[@class=\"style_containerForm__N7MYO\"]");
    }

    private By invalidErrorMessage() {
        return By.xpath("//*[@role=\"dialog\"]");
    }

    private By buttonOkErrorMessage() {
        return By.xpath("//*[@class=\"swal2-actions\"]/button");
    }

    @Step("Open login page")
    public void openLogin() {
        openAt("/login");
    }

    @Step("Input email: {0}")
    public void inputEmailLogin(String usernameLogin) {
        $(emailFieldLogin()).sendKeys(usernameLogin);
    }

    @Step("Input password")
    public void inputPasswordLogin(String passwordLogin) {
        $(passwordFieldLogin()).sendKeys(passwordLogin);
    }

    @Step("Click login button")
    public void clickButtonLogin() {
        $(buttonLogin()).click();
    }

    @Step("Validate empty field error is displayed")
    public boolean loginTextError() {
        return $(kosongErrorMessage()).isDisplayed();
    }

    @Step("Validate invalid credentials error is displayed")
    public boolean loginInvalidError() {
        return $(invalidErrorMessage()).isDisplayed();
    }

    @Step("Click OK on error dialog")
    public void clickButtonErrorOK() {
        $(buttonOkErrorMessage()).click();
    }
}
