package starter.stepdefinitions;

import starter.user.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class UserStep {

    @Steps GetAllUser getAllUser;
    @Steps GetByIdUser getByIdUser;
    @Steps UpdateUserEncryption updateUserEncryption;
    @Steps UpdateUser updateUser;
    @Steps DeleteUser deleteUser;

    @Given("I set endpoint for get list user")
    public void iSetEndpointForGetListUser() { getAllUser.getEndpointUser(); }
    @When("I request get list user")
    public void iRequestGetListUser() { getAllUser.requestGetListUser(); }
    @Then("verify status code user is {int}")
    public void verifyStatusCodeUserIs(int code) { getAllUser.verifyStatusCodeUser(code); }
    @And("I validate data detail after get user")
    public void validateTheDataDetailAfterGetUser() { getAllUser.setValidateDataDetailAfterGetUser(); }

    @Given("I set an {string} for GET user by id")
    public void iSetAnEndpointForGETUserById(String endpoint) { getByIdUser.setAnEndpointForGetUserById(endpoint); }
    @When("I request {string} for GET detail user by id")
    public void iRequestGETDetailUserById(String param) { getByIdUser.requestParamGetDetailUser(param); }
    @Then("I validate the status code for GET user by id is {int}")
    public void iValidateTheStatusCodeForGETUserByIdIsStatusCode(int statusCode) { getByIdUser.validateTheStatusCodeForGetUserById(statusCode); }
    @And("validate the data detail user and {string}")
    public void validateTheDataDetailUserById(String message) { getByIdUser.validateTheDataDetailAfterGetByIdUser(message); }

    @Given("I set an {string} for update data user")
    public void iSetAnEndpointForUpdateUser(String endpoint) { updateUser.setAnEndpointForUpdateUser(endpoint); }
    @When("I request input {string} for update data user")
    public void iRequestPutDetailUser(String field) { updateUser.requestUpdateFieldDetailUser(field); }
    @Then("I validate the status code for update user is {int}")
    public void iValidateTheStatusCodeForUpdateUserIsStatusCode(int statusCode) { updateUser.validateTheStatusCodeForUpdateDataUser(statusCode); }
    @And("validate the data detail user and {string} after update user")
    public void validateTheDataDetailAfterUpdateUser(String message) { updateUser.validateTheDataDetailAfterUpdateUser(message); }

    @Given("I set an {string} for update data user encryption")
    public void iSetAnEndpointForUpdateUserEncryption(String endpoint) { updateUserEncryption.setAnEndpointForUpdateUserEncryption(endpoint); }
    @When("I request input {string} for update data user encryption")
    public void iRequestPutDetailUserEncryption(String field) { updateUserEncryption.requestUpdateFieldDetailUserEncryption(field); }
    @Then("I validate the status code for update user encryption is {int}")
    public void iValidateTheStatusCodeForUpdateUserEncryptionIsStatusCode(int statusCode) { updateUserEncryption.validateTheStatusCodeForUpdateDataUserEncryption(statusCode); }
    @And("validate the data detail user encryption and {string} after update user encryption")
    public void validateTheDataDetailAfterUpdateUserEncryption(String message) { updateUserEncryption.validateTheDataDetailAfterUpdateUserEncryption(message); }

    @Given("I set an {string} for Delete user by id")
    public void iSetAnForDeleteUserById(String endpoint) { deleteUser.setAnEndpointForDeleteUser(endpoint); }
    @When("I request {string} for Delete detail user by id")
    public void iRequestForDeleteDetailUserById(String param) { deleteUser.requestParamDeleteDetailUser(param); }
    @Then("I validate the status code for Delete user is {int}")
    public void iValidateTheStatusCodeForDeleteUserIsStatusCode(int statusCode) { deleteUser.validateTheStatusCodeForDeleteUser(statusCode); }
    @And("validate the data detail user and {string} after delete user")
    public void validateTheDataDetailUserAndAfterDeleteUser(String message) { deleteUser.validateTheDataDetailAfterDeleteUser(message); }
}
